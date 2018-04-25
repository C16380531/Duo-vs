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
	//private int count=0;
	private boolean P1 = true;
	private boolean P2 = false;
	private boolean[][] boxes = new boolean[20][10];
	
	ArrayList Player = new ArrayList();
	//Player p = new Player();

	
	public DotsandBoxes(Handler handler) {
		this.handler = handler;
	}
	public void tick() 
	{
		fillBoxes();
	}
	
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		drawDots(g);
		drawLines(g);
		playerText(g);
		updateFrame(g);
		
	}
	
	private void drawDots(Graphics g) {
		for(int i = 25; i < 550; i+=50)
		{
			for(int j =25; j < 550; j+=50)
			{
				g.drawOval( i, j, 15, 15);
				g.fillOval(i, j, 15, 15);
			}
		}
	}
	
	private void playerText(Graphics g) {
		
		
		String str1 = "Player 1";
		String str2 = "Player 2";
		
		g.drawString(str1, 600, 150);
		g.drawString(str2, 600, 350);
		
		
	}
	
	private void drawLines(Graphics g) {
		
		
		for(int i = 25; i < 500; i+=50)
		{
			for(int j = 25; j < 500; j+=50) 
			{
				g.drawRect(i, j, 15, 50);
				g.drawRect(i, j, 50, 15);
				if(i > 450) {
					g.drawRect(i+50, j, 15, 50);
				}
				if(j > 450) {
					g.drawRect(i, j+50, 50, 15);
				}
			}
		}
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
	private void updateFrame(Graphics g) {
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
		
		isSurrounded(g);
	}

	
	private void isSurrounded(Graphics g){
		
		for(int i = 0; i <20; i += 2) {
			for(int  j = 0; j < 10; j++){
				if(boxes[i][j] && boxes[i+1][j] && boxes[i][j+1] && boxes[i+3][j])
				{
					//System.out.println(p.getPcount());
					//if(p.OddEven(p.getPlayerCountNum()))
							if(currentPlayer == 0) {
							g.setColor(Color.BLUE);
							g.drawRect(((i/2 * 50) + 40), (j * 50) + 40, 35, 35);
							g.fillRect(((i/2 * 50) + 40), (j * 50) + 40, 35, 35);
							}
							else{
								g.setColor(Color.RED);
								g.drawRect(((i/2 * 50) + 40), (j * 50) + 40, 35, 35);
								g.fillRect(((i/2 * 50) + 40), (j * 50) + 40, 35, 35);
							}
								
							
							//System.out.println(turn);
					//}
					/*if(p.OddEven(p.getPlayerCountNum())== false) {
						g.setColor(Color.RED);
						g.drawRect(((i/2 * 50) + 40), (j * 50) + 40, 35, 35);
						g.fillRect(((i/2 * 50) + 40), (j * 50) + 40, 35, 35);*/
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
		
} 
	
	
	
	







