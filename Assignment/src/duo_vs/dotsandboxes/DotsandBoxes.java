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
import java.util.ArrayList;
//imported classes
import duo_vs.Handler;


public class DotsandBoxes 
{	
	private Handler handler;
	
	private boolean check;
	private int next=0;
	private int currentPlayer = 0;
	
	private int P;
	//private int count=0;
	//private boolean P1 = true;
	private boolean P2 = false;
	private boolean[][] boxes = new boolean[20][10];
	private int[][] scoreBoxes = new int[10][10];
	private int[][] boxOwner = new int[10][10];
	private int scoreP0 = 0;
	private int scoreP1 = 0;
	
	ArrayList Player = new ArrayList();
	
	private int moves_count = 50;
	Layout l =  new Layout();
	
	public DotsandBoxes(Handler handler) {
		this.handler = handler;

		for(int i = 0; i < 10; i++) {
			for(int j = 0; j< 10; j++) {
				
				boxOwner[i][j] = -1;
				
			}
		}
	
	}
	public void tick() 
	{
		fillBoxes();
	}
	
	public void render(Graphics g) {
		
		g.setFont(new Font("Courier", Font.BOLD,20));
		g.setColor(Color.BLACK);
		l.drawDots(g);
		l.drawLines(g);
		l.playerText(g);
		drawClick(g);
		drawPoints(g);
		score(g);
		
	}
	
	private void fillBoxes() {
		
		for( int i = 25, x = 0; i < 500; i += 50, x += 2) 
		{
			for(int j = 25, y = 0; j < 500; j+= 50, y ++) 
			{
				//Rows
				while(handler.getMouseManager().isLeftPressed() && 
						handler.getMouseManager().getMouseX() >i && 
						handler.getMouseManager().getMouseX() < i+50 && 
						handler.getMouseManager().getMouseY() > j &&
						handler.getMouseManager().getMouseY() < j+15)
				{
					if(currentPlayer == 1) {
						boxOwner[x/2][y] = 1;

						
					}
					if(currentPlayer == 0) {
						boxOwner[x/2][y]= 0;
					}
					validInput(boxes[x][y]);
					boxes[x][y] = true;
					
					/*int num = p.getPcount();
					Player.add(num);
					System.out.print(num + "num1 ");
					int num1 = p.incrementCounter(x);
					System.out.print(num1 + "nun2 ");*/
					System.out.print("");
					

				}	
				//Cols
				while(handler.getMouseManager().isLeftPressed() &&
						handler.getMouseManager().getMouseX() >i &&
						handler.getMouseManager().getMouseX() < i+15 &&
						handler.getMouseManager().getMouseY() > j &&
						handler.getMouseManager().getMouseY() < j+50)
				{
					if(currentPlayer == 1) {
						boxOwner[x/2][y] = 1;

						
					}
					if(currentPlayer == 0) {
						boxOwner[x/2][y]= 0;
					}
					validInput(boxes[x+1][y]);
					boxes[x+1][y] = true;
					/*int num = p.getPcount();
					Player.add(num);
					int num1 = p.incrementCounter(x);*/
					System.out.print("");
				
				}
					
			}
		}
	
		
	}
	
	private void drawClick(Graphics g) {
		for(int i = 0; i <20; i += 2) {
			for(int  j = 0; j < 10; j++){
				if(boxes[i][j]) {
					g.fillRect((i/2 * 50) + 25 , (j* 50) + 25, 50, 15);
				}
				if(boxes[i+1][j]) {
					g.fillRect(((i/2) * 50) + 25 , (j* 50) + 25, 15, 50);
				}
			}
		}
		isSurrounded(g,currentPlayer);
	}
		

		
	

	
	private void isSurrounded(Graphics g,int currentPlayer){

		
		for(int i = 0; i <20; i += 2) {
			for(int  j = 0; j < 10; j++){
				if(boxes[i][j] && boxes[i+1][j] && boxes[i][j+1] && boxes[i+3][j])
				{
					//System.out.println(currentPlayer);
					scoreBoxes[i/2][j] = 1;
					
				}
			}
		}

	}
	
	private void validInput(boolean box) {
		if(!box) {
			changePlayer();
		}
	}
	
	private void changePlayer() {
		if(currentPlayer == 0) {
			currentPlayer++;
		}
		else {
			currentPlayer--;
			
		}
		System.out.println("Current Player: " + currentPlayer);
	}
		
 

	private void drawPoints(Graphics g) {
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {

				if(scoreBoxes[i][j] == 1) {
					if(boxOwner[i][j] == 1) {
						
						g.setColor(Color.BLUE);
						//g.drawRect(((i * 50) + 40), (j * 50) + 40, 35, 35);
						g.fillRect(((i * 50) + 40), (j * 50) + 40, 35, 35);
						
						
					
						
					}
					if(boxOwner[i][j] == 0){
						
						g.setColor(Color.RED);
						//g.drawRect(((i * 50) + 40), (j * 50) + 40, 35, 35);
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
	
}
