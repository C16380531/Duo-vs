package duo_vs.checkers;

import java.awt.*;
import java.awt.image.BufferedImage;

import duo_vs.Handler;
import duo_vs.imageloader.ImageLoader;
import duo_vs.background.Background;

public class Checkers {
	public static int width = 400;
	public static final int tileSize = width/8; //8 Tiles for checkers board
	public static final int numTilesPerRow = 1+(width/tileSize);
	public static int[][] baseGameData = new int[numTilesPerRow+2][numTilesPerRow]; //Stores 8x8 board layout
	public static int[][] gameData = new int[numTilesPerRow+2][numTilesPerRow]; //Stores piece data in an 8x8
	public static final int EMPTY = 0, RED = 1, RED_KING = 2, WHITE = 3, WHITE_KING = 4; //Values for gameData
	public boolean gameInProgress = true;
	public int currentPlayer = RED;
	public boolean inPlay = false; //Is there a move function processing
	public boolean haka = false; 
	public static int[][] availablePlays = new int[numTilesPerRow+2][numTilesPerRow]; //Stores available plays in an 8x8
	public int storedRow, storedCol;
	public boolean isJump = false;
	static BufferedImage crownImage = null;
	private Handler handler;
	private Background background;
	int p1=9;
	
	public Checkers(Handler handler)
	{
		this.handler =handler;
		crownImage = ImageLoader.loadImage("/textures/crown.jpg");
		background = new Background(handler);
	}
	
	public void tick() 
	{
		if(haka ==false)
		{
		initializeBoard();
		}
		else
		{
		mousePressed();
		}
		background.tick();
	//	gameOver();
	}
	
	

			
	
	public boolean gameOver(){ 
		
		return gameOverInternal(0, 0, 0, 0);
	}
	
	public boolean gameOverInternal(int col, int row, int red, int white){ //Here I'm checking how many pieces are
		if(gameData[col][row] == RED || gameData[col][row] == RED_KING)	   //left for each colour to see if the game is over	
			red += 1;
		if(gameData[col][row] == WHITE || gameData[col][row] == WHITE_KING)
			white += 1;
		if(col == numTilesPerRow-1 && row == numTilesPerRow-1){
			if(red == 0 || white == 0)
				return true;
			else return false;
		}
		if(col == numTilesPerRow-1){
			row += 1;
			col = -1;
		}
		return gameOverInternal(col+1, row, red, white);
	}
	
	public void initializeBoard(){
		//UPDATE THE STARTING POSITIONS
				for(int col=2; col < (numTilesPerRow+1); col+=2){
					gameData[col][6] = RED;
					gameData[col][8] = RED;
				}
				for(int col=3; col < (numTilesPerRow+1); col+=2)
					gameData[col][7] = RED;
				for(int col=3; col < (numTilesPerRow+1); col+=2){
					gameData[col][1] = WHITE;
					gameData[col][3] = WHITE;
				}	
				for(int col=2; col < (numTilesPerRow+1); col+=2)
					gameData[col][2] = WHITE;
			haka=true;
	}
	
	public static void drawPiece(int col, int row, Graphics g, Color color){
		((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);//Smoothes the pieces to look more round
	    ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g.setColor(color);
		// These 2 and 4 values are arbitrary values that compensate for a smaller piece size than tileSize
		g.fillOval((col*tileSize)+2, (row*tileSize)+2, tileSize-4, tileSize-4);
	}
	
	public void render(Graphics g){ // This method paints the board
		//PRINT THE BOARD & PIECES
		for(int row = 1; row < numTilesPerRow; row++){
			for(int col = 2; col < numTilesPerRow+1; col++){
				if((row%2 == 0 && col%2 == 0) || (row%2 != 0 && col%2 != 0)){ // This assigns the checkerboard pattern
					baseGameData[col][row] = 0;
					g.setColor(Color.gray);
					g.fillRect(col*tileSize, row*tileSize, tileSize, tileSize);
				}
				else{
					baseGameData[col][row] = 1;
					g.setColor(Color.darkGray);
					g.fillRect(col*tileSize, row*tileSize, tileSize, tileSize);
				}
				if(checkTeamPiece(col, row) ==  true){			
					g.setColor(Color.gray);
					g.fillRect(col*tileSize, row*tileSize, tileSize, tileSize);
				}
				if(availablePlays[col][row] == 1){
					g.setColor(Color.CYAN.darker());
					g.fillRect(col*tileSize, row*tileSize, tileSize, tileSize);
				}
				if(gameData[col][row] == WHITE)
					drawPiece(col, row, g, Color.white);
				else if(gameData[col][row] == WHITE_KING){
					drawPiece(col, row, g, Color.white);
					g.drawImage(crownImage, (col*tileSize)+6, (row*tileSize)+6, tileSize-12, tileSize-12, null);
				}
				else if(gameData[col][row] == RED)
					drawPiece(col, row, g, Color.red);
				else if(gameData[col][row] == RED_KING){
					drawPiece(col, row, g, Color.red);
				g.drawImage(crownImage, (col*tileSize)+6, (row*tileSize)+6, tileSize-12, tileSize-12, null);
				}
			}
		}
		if(gameOver() == true)
			gameOverDisplay(g);
		
		background.render(g);
	}	
	
	public void gameOverDisplay(Graphics g) { //Displays the game over message
		 String msg = "Game Over";
	     Font small = new Font("Helvetica", Font.BOLD, 20);
	     g.setColor(Color.white);
	     g.setFont(small);
	     g.drawString(msg, (width - 10) / 2, width / 2);
	}
	
	public void resetPlay(){
		storedCol = 0;
		storedRow = 0;
		inPlay = false;
		isJump = false;
		for(int row = 0; row < numTilesPerRow; row++){
			for(int col = 0; col < numTilesPerRow; col++){
				availablePlays[col][row] = 0;
			}
		}
	}
	
	public void mousePressed()//java.awt.event.MouseEvent evt) 
	{
		int col=2;
		int row=1;
		if(handler.getMouseManager().isLeftPressed())
		{
			col = (handler.getMouseManager().getMouseX()-8) / tileSize; // 8 is left frame length
            row = (handler.getMouseManager().getMouseY()-30) / tileSize; // 30 is top frame length
		}
		if(row  != 0&& col !=0) 
		{
	        if(inPlay == false && gameData[col][row] != 0 || inPlay == true && checkTeamPiece(col, row) == true){
				resetPlay();
				storedCol = col;
				storedRow = row; // Sets the current click to instance variables to be used elsewhere
				getAvailablePlays(col, row);
			}
			else if(inPlay == true && availablePlays[col][row] == 1){
				isJump=true;
				makeMove(col, row, storedCol, storedRow);
			}
			else if(inPlay == true && availablePlays[col][row] == 0){
				resetPlay();
			}
        }
	}
	
	public void swapPlayer(){
		if(currentPlayer == RED)
			currentPlayer = WHITE;
		else currentPlayer = RED;
	}
	
	public void makeMove(int col, int row, int storedCol, int storedRow){
		int x = gameData[storedCol][storedRow]; //change the piece to new tile
		gameData[col][row] = x;
		gameData[storedCol][storedRow] = EMPTY; //change old piece location to EMPTY
		checkKing(col, row);
		if(isJump == true)
			removePiece(col, row, storedCol, storedRow);
		resetPlay();
		swapPlayer();
	}
	
	public boolean isKing(int col, int row){
		if(gameData[col][row] == RED_KING || gameData[col][row] == WHITE_KING){
			return true;
		}
		else return false;
	}
	
	public int checkOpponent(int col, int row){
		if(gameData[col][row] == RED || gameData[col][row] ==  RED_KING)
			return WHITE;
		else
			return RED;
	}
	
	public void checkExtraJumps(int col, int row){
		int opponent = checkOpponent(col, row);
		int opponentKing = checkOpponent(col, row) + 1;
		if(gameData[col-1][row-1] == opponent || gameData[col-1][row-1] == opponentKing){
			availablePlays[col-1][row-1] = 1;
		}
		else if(gameData[col+1][row-1] == opponent || gameData[col+1][row-1] == opponentKing){
			availablePlays[col+1][row-1] = 1;
		}
		else if(gameData[col-1][row+1] == opponent || gameData[col-1][row+1] == opponentKing){
			availablePlays[col-1][row+1] = 1;
		}
		else if(gameData[col+1][row+1] == opponent || gameData[col+1][row+1] == opponentKing){
			availablePlays[col+1][row+1] = 1;
		}
	}
	
	public void checkKing(int col, int row){
		if(gameData[col][row] == RED && row == 0)
			gameData[col][row] = RED_KING;
		else if(gameData[col][row] == WHITE && row == numTilesPerRow-1)
			gameData[col][row] = WHITE_KING;
		else return;
	}
	
	public void removePiece(int col, int row, int storedCol, int storedRow){ //might be a better way to do this, but detects position of opponent piece based on destination and original position
		int pieceRow = -1; 
		int pieceCol = -1;
		if(col > storedCol && row > storedRow){
			pieceRow = row-1;
			pieceCol = col-1;
		}
		if(col > storedCol && row < storedRow){
			pieceRow = row+1;
			pieceCol = col-1;
		}
		if(col < storedCol && row > storedRow){
			pieceRow = row-1;
			pieceCol = col+1;
		}
		if(col < storedCol && row < storedRow){
			pieceRow = row+1;
			pieceCol = col+1;
		}
		gameData[pieceCol][pieceRow] = EMPTY;
	}
	
	public void getAvailablePlays(int col, int row){
		inPlay = true;
		if((checkTeamPiece(col, row) == true)){ //checks if the piece is assigned to the current player
			if(gameData[col][row] == RED){  // only goes north, checks the row above it's own
				getUp(col, row);
			}
			if(gameData[col][row] == WHITE){ // only goes south, checks the row below it's own
				getDown(col, row);
			}
			if(gameData[col][row] == RED_KING || gameData[col][row] == WHITE_KING){ // Goes up OR down 1 row below it's own
				getUp(col, row);
				getDown(col, row); 
			}
		}
	}
	
	public void getUp(int col, int row){ // Get Up availability
		int rowUp = row-1;
		if(col == 0 && row != 0){ //X=0, Y is not 0
			for(int i = col; i < col+2; i++){ //check to right
				if(gameData[col][row] != 0 && gameData[i][rowUp] != 0){
					if(canJump(col, row, i, rowUp) == true){
						int jumpCol = getJumpPos(col, row, i, rowUp)[0];
						int jumpRow = getJumpPos(col, row, i, rowUp)[1];
						availablePlays[jumpCol][jumpRow] = 1;
					}
				}
				else if(baseGameData[i][rowUp] == 1 && gameData[i][rowUp] == 0)
					availablePlays[i][rowUp] = 1;
			}
		}
		else if(col == (numTilesPerRow - 1) && row != 0){ //X=max, Y is not 0
				if(gameData[col][row] != 0 && gameData[col-1][rowUp] != 0){
					if(canJump(col, row, col-1, rowUp) == true){
						int jumpCol = getJumpPos(col, row, col-1, rowUp)[0];
						int jumpRow = getJumpPos(col, row, col-1, rowUp)[1];
						availablePlays[jumpCol][jumpRow] = 1;
					}
				}
				else if(baseGameData[col-1][rowUp] == 1 && gameData[col-1][rowUp] == 0)
					availablePlays[col-1][rowUp] = 1;
		}
		else if(col != numTilesPerRow - 1 && col != 0 && row != 0){
			for(int i = col-1; i <= col+1; i++){
				if(gameData[col][row] != 0 && gameData[i][rowUp] != 0){
					if(canJump(col, row, i, rowUp) == true){
						int jumpCol = getJumpPos(col, row, i, rowUp)[0];
						int jumpRow = getJumpPos(col, row, i, rowUp)[1];
						availablePlays[jumpCol][jumpRow] = 1;
					}
				}
				else if(baseGameData[i][rowUp] == 1 && gameData[i][rowUp] == 0)
					availablePlays[i][rowUp] = 1;
			}
		}
	}
	
	public void getDown(int col, int row){
		int rowDown = row+1;
		if(col == 0 && row != numTilesPerRow-1){
				if(gameData[col][row] != 0 && gameData[col+1][rowDown] != 0){
					if(canJump(col, row, col+1, rowDown) == true){
						int jumpCol = getJumpPos(col, row, col+1, rowDown)[0];
						int jumpRow = getJumpPos(col, row, col+1, rowDown)[1];
						availablePlays[jumpCol][jumpRow] = 1;
					}
				}
				else if(baseGameData[col+1][rowDown] == 1 && gameData[col+1][rowDown] == 0)
					availablePlays[col+1][rowDown] = 1;
		}
		else if(col == numTilesPerRow - 1 && row != numTilesPerRow-1){
				if(gameData[col][row] != 0 && gameData[col-1][rowDown] != 0){
					if(canJump(col, row, col-1, rowDown) == true){
						int jumpCol = getJumpPos(col, row, col-1, rowDown)[0];
						int jumpRow = getJumpPos(col, row, col-1, rowDown)[1];
						availablePlays[jumpCol][jumpRow] = 1;
					}
				}
				else if(baseGameData[col-1][rowDown] == 1 && gameData[col-1][rowDown] == 0)
					availablePlays[col-1][rowDown] = 1;
		}
		else if(col != numTilesPerRow-1 && col != 0 && row != numTilesPerRow-1){
			for(int i = col-1; i <= col+1; i++){
				if(gameData[col][row] != 0 && gameData[i][rowDown] != 0){
					if(canJump(col, row, i, rowDown) == true){
						int jumpCol = getJumpPos(col, row, i, rowDown)[0];
						int jumpRow = getJumpPos(col, row, i, rowDown)[1];
						availablePlays[jumpCol][jumpRow] = 1;
					}
				}
				else if(baseGameData[i][rowDown] == 1 && gameData[i][rowDown] == 0)
					availablePlays[i][rowDown] = 1;
			}
		}
	}
	
	public boolean checkTeamPiece(int col, int row){
		if(currentPlayer == RED && (gameData[col][row] == RED || gameData[col][row] == RED_KING)) //bottom
			return true;
		if(currentPlayer == WHITE && (gameData[col][row] == WHITE || gameData[col][row] == WHITE_KING)) //top
			return true;
		else
			return false;
	}
	
	public boolean isLegalPos(int col, int row){
		if(row < 0 || row >= numTilesPerRow || col < 0 || col >= numTilesPerRow)
			return false;
		else return true;
	}
	
	public boolean canJump(int col, int row, int opponentCol, int opponentRow){
		//Steps for checking if canJump is true: determine piece within movement. Then check if its an opponent piece, then if the space behind it is empty
		//and in bounds
		// 4 conditions based on column and row relations to the other piece
		if(((gameData[col][row] == WHITE || gameData[col][row] == WHITE_KING) && (gameData[opponentCol][opponentRow] == RED || gameData[opponentCol][opponentRow] == RED_KING)) || (gameData[col][row] == RED || gameData[col][row] == RED_KING) && (gameData[opponentCol][opponentRow] == WHITE || gameData[opponentCol][opponentRow] == WHITE_KING)){ 
			//If the piece is white/red and opponent piece is opposite 
			if(opponentCol == 0 || opponentCol == numTilesPerRow-1 || opponentRow == 0 || opponentRow == numTilesPerRow-1)
				return false;
			int[] toData = getJumpPos(col, row, opponentCol, opponentRow);
		    if(isLegalPos(toData[0],toData[1]) == false) //check board outofbounds
		        return false;
		    if(gameData[toData[0]][toData[1]] == 0){
		    	isJump = true;
		    	return true;
		    }
		}
		return false;
	}
	
	public int[] getJumpPos(int col, int row, int opponentCol, int opponentRow){
		if(col > opponentCol && row > opponentRow && gameData[col-2][row-2] == 0)
			return new int[] {col-2, row-2};
		else if(col > opponentCol && row < opponentRow && gameData[col-2][row+2] == 0)
			return new int[] {col-2, row+2};
		else if(col < opponentCol && row > opponentRow && gameData[col+2][row-2] == 0)
			return new int[] {col+2, row-2};
		else
			return new int[] {col+2, row+2};
	}

	public int pressed5() {
		p1=background.pressed();
		return p1;
	}
	
}