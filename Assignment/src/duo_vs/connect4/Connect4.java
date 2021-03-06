/* 
    Team Name: Duo-vs.
    Course: DT228/2.
    Module: Object Oriented Programming.
    Type: OOP assignment 2.
*/

package duo_vs.connect4;

//plug ins
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

//imported classes
import duo_vs.Handler;
import duo_vs.background.Background;
import duo_vs.connect4.Winner;
import duo_vs.imageloader.ImageLoader;

public class Connect4 
{	
	private Handler handler;
	private Winner winner;
	private Background background;
	static BufferedImage connect = null;
	
	boolean count, same, yellowpressed, redwon, yellowwon, finished_col, hover, hoverre;
	boolean gameover, gameStarted=false;
	int[] b, d, finished_column; 
	int[] playerredx, playerredy, playeryellowx, playeryellowy;
	int dummy_rows, rows, circle_height, circle_width, hovered;
	int l, g, h,m, p1=9, a=0;
	
	public Connect4(Handler handler)
	{
		this.handler =handler;
		winner = new Winner();
		playerredx = new int[21];
		playerredy = new int[21];
		playeryellowx = new int[22];
		playeryellowy = new int[22];
		background = new Background(handler);
		b =new int[43];
		d =new int[43];
		dummy_rows=410;
		rows=60;
		finished_column = new int[8];
		circle_height = 67;
		circle_width = 70;
		connect = ImageLoader.loadImage("/textures/connect4.png");
	}
	public int pressed1()
	{
		p1=background.pressed();
		return p1;
	}
	
	public void tick()
	{		
		
		if(gameStarted!=true)
		{
			started();
		}
		else
		{
			if(!finished_game())
			{
				pressed();
				disc_place();
				redplayer();
				yellowplayer();
			}
			resetfun();
		}
		background.tick();
		if(p1==0)
		{
			gameStarted=false;
			reset();
		}
	}
	
	private void reset()
	{
		for(int i=0; i<21; i++)
		{
			playerredx[i] = a;
			playerredy[i] = a;
			System.out.print(playerredx[i] + "\n");
		}
		for(int j=0; j<22; j++)
		{
			playeryellowx[j] = a;
			playeryellowy[j] = a;
		}
		for(int i=0; i<43; i++)
		{
			b[i]=a;
			d[i]=a;
		}
		for(int i=0; i<8; i++)
		{
			finished_column[i]=a;
		}
		yellowwon=false;
		l=a;
		redwon=false;
		g=0;
	}
	
	public void started()
	{
		if(handler.getKeyManager().isENTER())
		{
			gameStarted=true;
		}
	}
	public void pressed()
	{
		for(int column = 60; column < 640; column+=85)
		{
			//user clicked a column
			while(handler.getMouseManager().isLeftPressed() && handler.getMouseManager().getMouseX() >column && handler.getMouseManager().getMouseX() < column +85 && handler.getMouseManager().getMouseY() > rows && handler.getMouseManager().getMouseY() < rows+360)
			{
				count=true;
				same=true;
				g=column;
				System.out.print("");
			}
			//user is hovering over a column
			if(handler.getMouseManager().getMouseX() >column && handler.getMouseManager().getMouseX() < column +85 && handler.getMouseManager().getMouseY() > rows && handler.getMouseManager().getMouseY() < rows+360)
			{
				hover=true;
				hovered=column;
			}			
		}
	}
	
	private void resetfun()
	{

		//user is hovering over reset button
		if(handler.getMouseManager().getMouseX() >40 && handler.getMouseManager().getMouseX() < 190 && handler.getMouseManager().getMouseY() > 530 && handler.getMouseManager().getMouseY() < 590)
		{
			hoverre=true;
		}
	
		//user clicked on reset button
		if(handler.getMouseManager().isLeftPressed() && handler.getMouseManager().getMouseX() >40 && handler.getMouseManager().getMouseX() < 190 && handler.getMouseManager().getMouseY() > 530 && handler.getMouseManager().getMouseY() < 590)
		{
			reset();
		}
	}
	
	public void disc_place()
	{
		//this loop will check if the column the user clicked on has a disc in it already if it does it will change the rows placement
		for(int i=0; i<l; i++)
		{
			if(b[i] == g)
			{
				if(count)
				{
					if(d[i] != 60)
					{
						h=d[i]-70;	
						b[l]=g;
						d[l]=h;
						same=false;
					}
				}
			}
		}
		//this will check if the column is finished and if that column is already in the finished_column array
		if(h==60)
		{
			for(int w=0; w<m+1; w++)
			{
				if(finished_column[w]!=b[l] )
				{
					finished_col=true;
					h=0;
				}
				else
				{
					w=8;
					finished_column[m]=0;
					finished_col=false;
				}
			}							
		}
		//if its already in the finished column array it changes the variables to 0 and doesn't allow the counter to go up
		for(int w=0; w<m+1; w++)
		{
			if(finished_column[w] != 0)
			{

					if(b[l] == finished_column[w])
					{
						b[l]=0;
						d[l]=0;
						g=0;
						h=0;
						same=false;
						count=false;
					}

			}
		}
		//takes not of the column that is finished
		if(finished_col)
		{
			finished_column[m] = b[l];
			m=m+1;
			finished_col=false;
		}
		//when the bottom row is being filled this is used
		if(same)
		{
			b[l]=g;
			d[l]=dummy_rows;
			same=false;
		}
		//counter to update change the array position every time mouse pressed a column
		if(count)
		{
			l=l+1;
			count =false;
		}
	}
	
	//sets red disc co-ords to red player
	public void redplayer()
	{
		int s=0;
		//adds 2 cause we skip every second disc as the second discs are yellow
		for(int i=0; i<42; i+=2)
		{
			if(b[i] !=0 && d[i]!=0)
			{
				playerredx[s] = b[i];
				playerredy[s] = d[i];
				s=s+1;
				//calls RedWin method in winner class to check if the reds disc have connected 4 it returns true if they have
				redwon =winner.RedWin(playerredx, playerredy, l);
			}
		}
	}
	
	//sets yellow disc co-ords to yellow player
	public void yellowplayer()
	{
		int s=0;
		/*Starts at 1 as that is when the first yellow disc drops 
		adds 2 cause we skip every second disc as the second discs are red*/
		for(int i=1; i<42; i+=2)
		{
			if(b[i] !=0 && d[i]!=0)
			{
				playeryellowx[s] = b[i];
				playeryellowy[s] = d[i];
				s=s+1;
				//calls YellowWin method in winner class to check if the reds disc have connected 4 it returns true if they have
				yellowwon =winner.YellowWin(playeryellowx, playeryellowy);
			}
		}
	}
	
	public boolean finished_game()
	{
		//if red won or yellow won or the user filled up the whole column then it will return true
		if(redwon ==false && yellowwon==false && finished_column[6]==0)
		{
			return false;
		}
		else
		{
			return true;
		}
		
	}
	
	//drawing classes below
	
	public void render(Graphics g)
	{	
		g.setColor(Color.black);
		g.fillRect(0, 0, 700 , 550);
		if(gameStarted!= true)
		{
			g.drawImage(connect, 140, 80, 420 , 380, null);
		}
		else
		{
			g.setColor(Color.WHITE);
			g.fillRect(20, 20, 660 , 490);
			background.render(g);
			//sets color of rectangle to blue
			g.setColor(Color.BLACK);
			g.fillRect(30, 30, 640 , 470);
			
			hover(g);
			Drawcircles(g);			
			colour_disc(g);
			resetbtn(g);
		}
		
		if(finished_game())
		{
			if(redwon==true)
			{
				
				g.setFont(new Font("AR DARLING", Font.PLAIN, 40)); 
				g.setColor(Color.RED);
				g.fillRect(225, 160, 250, 200);
				g.setColor(Color.BLACK);
				g.drawString("Red Won", 270, 265);
			}
			else if(yellowwon==true)
			{
				g.setFont(new Font("AR DARLING", Font.PLAIN, 40)); 
				g.setColor(Color.YELLOW);
				g.fillRect(225, 160, 250, 200);
				g.setColor(Color.BLACK);
				g.drawString("Yellow Won", 240, 265);
			}
			else
			{
				g.setFont(new Font("AR DARLING", Font.PLAIN, 40)); 
				g.setColor(Color.CYAN);
				g.fillRect(225, 160, 250, 200);
				g.setColor(Color.BLACK);
				g.drawString("Draw", 280, 265);
			}
		}

	}
	
	public void resetbtn(Graphics g)
	{		
		if(hoverre == true)
		{
			g.setFont(new Font("AR DARLING", Font.PLAIN, 40)); 
			g.setColor(Color.BLACK);
			g.fillRect(40, 530, 150, 60);
			g.setColor(Color.RED);
			g.drawRect(40, 530, 150, 60);
			g.drawString("RESET", 50, 570);
			hoverre =false;
		}
		else
		{
			g.setFont(new Font("AR DARLING", Font.PLAIN, 40)); 
			g.setColor(Color.RED);
			g.fillRect(40, 530, 150, 60);
			g.setColor(Color.BLACK);
			g.drawString("RESET", 50, 570);
		}
	}
	
	public void hover(Graphics g)
	{
		if(hovered != 0)
		{
			if(hover = true)
			{
				g.setColor(Color.LIGHT_GRAY);	
				g.fillRect(hovered, 30, 70 , 470);
				hover=false;
			}
		}
	}
	
	public void Drawcircles(Graphics g)
	{

		//displays 7 columns and 6 rows of white circles
		for(int x = 60; x < 640; x+=85)
		{
			for(int y =60; y <470 ; y+=70)
			{	
				g.setColor(Color.white);
				g.drawOval( x, y, circle_width, circle_height);
				g.fillOval(x, y, circle_width, circle_height);
			}
		}
	}
	
	public void colour_disc(Graphics g)
	{
		for(int i=0; i<21; i++)
		{
			if(playerredx[i] !=0 && playerredy[i]!=0)
			{
				g.setColor(Color.RED);		
				g.drawOval( playerredx[i], playerredy[i],  circle_width, circle_height);
				g.fillOval(playerredx[i], playerredy[i],  circle_width, circle_height);
			}
		}
		for(int i=0; i<21; i++)
		{
			if(playeryellowx[i] !=0 && playeryellowy[i]!=0)
			{
				g.setColor(Color.YELLOW);
				g.drawOval( playeryellowx[i], playeryellowy[i],  circle_width, circle_height);
				g.fillOval(playeryellowx[i], playeryellowy[i],  circle_width, circle_height);
			}
		}
	}
}