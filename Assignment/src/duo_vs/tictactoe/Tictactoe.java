package duo_vs.tictactoe;

import java.awt.Color;
//import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import duo_vs.Handler;
import duo_vs.background.Background;
import duo_vs.imageloader.ImageLoader;

public class Tictactoe //implements ActionListener 
{
	private Handler handler;
	private Background Background;
	private int[][] Boxes = new int[3][3];
	static BufferedImage tictactoe = null;
	//private String letter ="";
	int[] x, y, playerovalue, playerxyvalue, playerxvalue, playeryvalue;
	int d, p1=9;
	boolean pressed=false, gameStarted=false, xwon, winner;
	
	public Tictactoe(Handler handler) {
		this.handler =handler;
		Background =new Background(handler);
		tictactoe = ImageLoader.loadImage("/textures/tictactoe.png");
		x= new int[10];
		y= new int[10];
		playerovalue= new int[9];
		playerxyvalue= new int[9];
		
		playerxvalue=new int[9];
		playeryvalue=new int[9];
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j< 3; j++) {
				
				Boxes[i][j] = -1;
			}
		}
	}

	public int pressed4()
	{
		p1=Background.pressed();
		return p1;
	}
	
	public void tick()
	{
		started();
		if(gameStarted)
		{
			clickable();
			xWin();
		}
		Background.tick();
	}
	public void started()
	{
		if(handler.getKeyManager().isENTER())
		{
			gameStarted=true;
		}
	}
	public void clickable()
	{
		 for(int i=120; i<450 ; i+=151 )
		 {
			 for(int j=35; j<450; j+=151)
			 {
				 
				 
				 
				 while(handler.getMouseManager().isLeftPressed() && handler.getMouseManager().getMouseX() >i && handler.getMouseManager().getMouseX() < i +150 && handler.getMouseManager().getMouseY() > j && handler.getMouseManager().getMouseY() <j+150)
				 {
					 x[d]=i;
					 y[d]=j;
					 pressed=true;
					 System.out.print("");
				 }
			 }
		}/*
		 for(int i=0; i<d; i++) 
		 { 
			 if(x[i]==x[d])
			 {
				 x[d]=0;
				 y[d]=0;
				 pressed=false;
			 }
		 }*/
		 if(pressed)
		 {
			 d=d+1;
			 pressed=false;
		 }
	}
	
	public boolean xWin()
	{
		
		//count=l;
		//int check;
		boolean	winner=false;
		//check=0;
		//check red player going up column 
		 
		
		//	check=0;
			//going down
				for(int i=0; i<3; i++)
				{
					for(int j=0; j<3; j++)
					{
					if(Boxes[0][0] == Boxes[0][1] && Boxes[0][1] == Boxes[0][2] && Boxes[0][0] != -1)
					{
					
							System.out.print("win");
							winner=true;
							
					}
					else if(Boxes[1][0] == Boxes[1][1] && Boxes[1][1]==Boxes[1][2] && Boxes[1][0] != -1)
					{
						System.out.print("win");
						winner=true;
						
					}else if(Boxes[2][0] == Boxes[2][1] && Boxes[2][1]==Boxes[2][2] && Boxes[2][0] != -1)
					{
						System.out.print("win");
						winner=true;
					}
						
				//across win
					
					if(Boxes[0][0] == Boxes[1][0] && Boxes[1][0] == Boxes[2][0] && Boxes[0][0] != -1)
					{
					
							System.out.print("win");
							winner=true;
							
					}
					else if(Boxes[0][1] == Boxes[1][1] && Boxes[1][1]==Boxes[2][1] && Boxes[0][1] != -1)
					{
						System.out.print("win");
						winner=true;
						
					}else if(Boxes[0][2] == Boxes[1][2] && Boxes[1][2]==Boxes[2][2] && Boxes[0][2] != -1)
					{
						System.out.print("win");
						winner=true;
					}
					
					}
					
				//diagonal win
					
					if(Boxes[0][0] == Boxes[1][1] && Boxes[1][1] == Boxes[2][2] && Boxes[0][0] != -1)
					{
					
							System.out.print("win");
							winner=true;
							
					}
					else if(Boxes[2][0] == Boxes[1][1] && Boxes[1][1]==Boxes[0][2] && Boxes[2][0] != -1)
					{
						System.out.print("win");
						winner=true;
					}
				
			
				}
			return winner;
	}
	
	public void render(Graphics g)
	{
		 g.setColor(Color.BLACK);
		 g.fillRect(0, 0, 750 , 550);
		
		 g.setColor(Color.WHITE);
		 
		 
		 for(int i=120; i<450 ; i+=151 )
		 {
			 for(int y=35; y<450; y+=151)
			 {
				  g.fillRect(i,y,150,150);
			 }
		 }
		if(gameStarted==false)
		{
			g.drawImage(tictactoe, 120, 35, 460 , 460, null);
		}
		 color(g);
		
		Background.render(g);
		
		if(xWin())
		{
			if(winner==false )
			{
			
				g.setColor(Color.ORANGE);
				g.drawString(" Winner Winner", 165, 285);
				
			}
			else
			{
				g.setColor(Color.ORANGE);
				g.drawString(" Tie", 165, 285);
			}
		
		}
	}
	
	private void color(Graphics g)
	{
		int i,j;
		for(int s=0; s<9; s+=2)
		{
			if(x[s] != 0 || y[s] !=0)
			{
				
				g.setColor(Color.WHITE);
				g.fillRect(x[s],y[s],150,150);
				g.setColor(Color.RED);
				g.drawString("X", x[s] +55, y[s]+85);
				
				for(int h = 0; h<9; h++)
				{
					if(x[h] !=0)
					{
						playerxvalue[h] = x[s];
						playeryvalue[h] = y[s];
						i = (playerxvalue[h]/151);
						j = (playeryvalue[h]/151);
						Boxes[i][j]= 1; //is x; i=0->3 x=0->3
					}
				}
			}
			
		}
		for(int s=1; s<9; s+=2)
		{
			if(x[s] != 0 || y[s] !=0)
			{
				g.setColor(Color.WHITE);
				g.fillRect(x[s],y[s],150,150);
				g.setColor(Color.BLUE);
				g.drawString("O", x[s] +55, y[s]+85);
			
				for(int h = 0; h<9; h++)
				{
					if(x[h] !=0)
					{
						playerovalue[h] = x[s];
						playerxyvalue[h] = y[s];
						i = (playerovalue[h]/151);
						j = (playerxyvalue[h]/151);
						Boxes[i][j]= 0; 
					}
				}
			}
			
		}
	}
}
