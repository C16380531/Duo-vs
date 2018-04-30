/* 
Team Name: Duo-vs.
Course: DT228/2.
Module: Object Oriented Programming.
Type: OOP assignment 2.
*/

package duo_vs.dotsandboxes;

//plug ins
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;


//imported classes
import duo_vs.Handler;
import duo_vs.background.Background;
import duo_vs.imageloader.ImageLoader;

public class DotsandBoxes 
{	
	private Handler handler;
	private Background background;
	static BufferedImage dots = null;
	
	
	//Initializing variables
	
	private int currentPlayer = 0;
	private boolean[][] boxes = new boolean[20][10];
	private int[][] scoreBoxes = new int[10][10];
	private int[][] boxOwner = new int[10][10];
	private int scoreP0 = 0;
	private int scoreP1 = 0, p1=9;
	private boolean gameStarted;

	Layout l =  new Layout();
	
	//Constructor
	public DotsandBoxes(Handler handler) {
		this.handler = handler;
		background = new Background(handler);
		dots = ImageLoader.loadImage("/textures/dots.png");
		
		//initializing the 2D array boxOwner with -1
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j< 10; j++) {
				
				boxOwner[i][j] = -1;
				
			}
		}
	
	}
	
	public void tick() 
	{
		if(gameStarted!=true)
		{
			started();
		}
		else
		{
			fillBoxes();
		}
		background.tick();
		if(p1==0)
		{
			gameStarted=false;
			reset();
		}
	}
	
	private void started()
	{
		if(handler.getKeyManager().isENTER())
		{
			gameStarted=true;
		}
	}
	
	private void reset()
	{
		for(int i = 0; i < 10; i++) 
		{
			for(int j = 0; j< 10; j++) 
			{
				scoreBoxes[i][j] = 0;
				boxOwner[i][j] = -1;
			}
		}
		for(int i = 0; i < 20; i++) 
		{
			for(int j = 0; j< 10; j++) 
			{
				boxes[i][j] = false;
			}
		}
		currentPlayer=0;
		scoreP0 = 0;
		scoreP1 = 0;
	}
	
	public int pressed2()
	{
		p1=background.pressed();
		return p1;
	}
	
	//render method will be called every time 
	public void render(Graphics g) 
	{
		if(gameStarted!= true)
		{
			g.setColor(Color.black);
			g.fillRect(0, 0, 700 , 550);
			g.drawImage(dots, 140, 80, 420 , 380, null);
		}
		else
		{
			g.setColor(Color.BLACK);
			g.setFont(new Font("Courier", Font.BOLD,20));
			l.drawDots(g);
			l.drawLines(g);
			l.playerText(g);
			
			drawClick(g);
			drawPoints(g);
			score(g);
			endGame(g);
			background.render(g);
		}

	}
	
	//method is used to get click of the user
	private void fillBoxes() {
		
		for( int i = 25, x = 0; i <= 500; i += 50, x += 2) 
		{
			for(int j = 25, y = 0; j <= 500; j+= 50, y ++) 
			{
				//Rows
				while(handler.getMouseManager().isLeftPressed() && 
						handler.getMouseManager().getMouseX() >i && 
						handler.getMouseManager().getMouseX() <= i+50 && 
						handler.getMouseManager().getMouseY() > j &&
						handler.getMouseManager().getMouseY() <= j+15)
				{
					
					//checks who's turn it is
					if(currentPlayer == 1) {
						boxOwner[x/2][y] = 1;

						
					}
					if(currentPlayer == 0) {
						boxOwner[x/2][y]= 0;
					}
					
					
					validInput(boxes[x][y]);
					//will add in true to boolean array that box has been clicked by user
					boxes[x][y] = true;
					
					
					System.out.print("");
					

				}	
				//Columns
				while(handler.getMouseManager().isLeftPressed() &&
						handler.getMouseManager().getMouseX() >i &&
						handler.getMouseManager().getMouseX() <= i+15 &&
						handler.getMouseManager().getMouseY() > j &&
						handler.getMouseManager().getMouseY() <= j+50)
				{
					if(currentPlayer == 1) {
						boxOwner[x/2][y] = 1;

						
					}
					if(currentPlayer == 0) {
						boxOwner[x/2][y]= 0;
					}
					
					validInput(boxes[x+1][y]);
					boxes[x+1][y] = true;
					
					System.out.print("");
				
				}
					
			}
		}
	
		
	}
	
	//method to fill in the clicked rectangles
	private void drawClick(Graphics g) {
		for(int i = 0; i <20; i += 2) {
			for(int  j = 0; j < 10; j++){
				
				//if true, will fill the rectangle black
				if(boxes[i][j]) {
					g.fillRect((i/2 * 50) + 25 , (j* 50) + 25, 50, 15);
				}
				if(boxes[i+1][j]) {
					g.fillRect(((i/2) * 50) + 25 , (j* 50) + 25, 15, 50);
				}
			}
		}
		//each time a rectangle is filled, it will call isSurrounded method to check
		//if 4 rectangles in square form have been filled
		isSurrounded(g,currentPlayer);
	}
		

	//method to check whether square of rectangles has been filled
	private void isSurrounded(Graphics g,int currentPlayer){

		for(int i = 0; i <20; i += 2) {
			for(int  j = 0; j < 10; j++){
				//sequence of a square to check
				if(boxes[i][j] && boxes[i+1][j] && boxes[i][j+1] && boxes[i+3][j])
				{
					//if a box has been filled then the scoreBoxes array [i][j] will become 1
					scoreBoxes[i/2][j] = 1;
					
				}
			}
		}

	}
	
	
	//method to check whether or not the click was in rectangle or not. Is called from filBoxes method
	private void validInput(boolean box) {
		//will only change player when a rectangle has been clicked, stopping the player from changing each click 
		//no matter where on the screen they click
		if(!box) {
			changePlayer();
		}
	}
	
	//method to change player
	private void changePlayer() {
		if(currentPlayer == 0) {
			currentPlayer++;
		}
		else {
			currentPlayer--;
			
		}
		System.out.println("Current Player: " + currentPlayer);
	}
		
 
//method to fill the squares in color depending on what player closed the box
	private void drawPoints(Graphics g) {
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {

				//if scoreBoxes is 1 that means that means that a square has been formed and needs to be coloured in
				if(scoreBoxes[i][j] == 1) {
					//boxOwner was initialised in fillBoxes depending on what player had clicked
					if(boxOwner[i][j] == 1) {
						
						g.setColor(Color.BLUE);
						g.fillRect(((i * 50) + 40), (j * 50) + 40, 35, 35);
					
					}
					if(boxOwner[i][j] == 0){
						
						g.setColor(Color.RED);
						g.fillRect(((i * 50) + 40), (j * 50) + 40, 35, 35);
						
					}
				}
			}
		}
		
		
	}
	
	private void score(Graphics g) {
		int s0 = 0;
		int s1 = 0;
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j< 10; j++) {
				
				if(scoreBoxes[i][j] == 1) {
				
					if(boxOwner[i][j] == 1) {
						s0++;
					}
					if(boxOwner[i][j] == 0) {
						s1++;
					}
				}
			}
		}
		
		scoreP0 = s0;
		scoreP1 = s1;
		
		String str1 = Integer.toString(scoreP0);
		String str2 = Integer.toString(scoreP1);
		
		g.setColor(Color.BLACK);
		g.setFont(new Font("Courier", Font.BOLD,20));
		
		g.drawString(str1, 650, 150);
		g.drawString(str2, 650, 350);
	}
	
	private void endGame(Graphics g) {
		
		g.setFont(new Font("Courier", Font.BOLD,70));
		
		
		if(scoreP0 == 10) {
			g.setColor(Color.WHITE);
			g.fillRect(75, 200,	545, 70);
			g.drawRect(75, 200,	545, 70);
			g.setColor(Color.BLUE);
			g.drawString("Player 1 Wins", 75, 250);
			
		}
		if(scoreP1 == 10) {
			g.setColor(Color.WHITE);
			g.fillRect(75, 200,	545, 70);
			g.drawRect(75, 200,	545, 70);
			g.setColor(Color.RED);
			g.drawString("Player 2 Wins", 75, 250);
		}
	}
	
}


