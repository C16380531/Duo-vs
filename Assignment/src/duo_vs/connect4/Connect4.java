/* 
    Team Name: Duo-vs.
    Course: DT228/2.
    Module: Object Oriented Programming.
    Type: OOP assignment 2.
*/

package duo_vs.connect4;

//plug ins
import java.awt.Color;
import java.awt.Graphics;

//imported classes
//import duo_vs.state.State;
import duo_vs.Handler;


public class Connect4 
{	
	private Handler handler;
	boolean count, same, finished_col, hover;
	int[] b, d, finished_column; 
	int[] playerredx, playerredy, playeryellowx, playeryellowy;
	int dummy_rows, rows, circle_height, circle_width, hovered;
	int l, g, h,m;
	
	public Connect4(Handler handler)
	{
		playerredx = new int[21];
		playerredy = new int[21];
		playeryellowx = new int[22];
		playeryellowy = new int[22];
		this.handler =handler;
		b =new int[43];
		d =new int[43];
		dummy_rows=410;
		rows=60;
		finished_column = new int[8];
		circle_height = 67;
		circle_width = 70;
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
		if(count)
		{
			l=l+1;
			count =false;
		}
	}
	
	public void Winner()
	{
		for(int i=0; i<21; i++)
		{
			for(int j=0; j<21; j++)
			{
			//	if(playerredx[i] == playerredx[j])
			}
		}
		
	}
	
	public void finished_game()
	{
		
	}
	
	public void tick()
	{		
		
		pressed();
		disc_place();
		Winner();
	}
	
	public void render(Graphics g)
	{		
		g.setColor(Color.black);
		g.fillRect(0, 0, 700 , 550);
		
		//sets color of rectangle to blue
	    g.setColor(Color.blue);
		g.fillRect(30, 30, 640 , 490);
		
		hover(g);
		Drawcircles(g);			
		colour_disc(g);
	}
	
	public void hover(Graphics g)
	{
		if(hover = true)
		{
			g.setColor(Color.LIGHT_GRAY);	
			g.fillRect(hovered, 30, 70 , 490);
			hover=false;
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
		int s=0;
		for(int i=0; i<42; i+=2)
		{
			if(b[i] !=0 && d[i]!=0)
			{
				playerredx[s] = b[i];
				playerredy[s] = d[i];
				g.setColor(Color.RED);		
				g.drawOval( b[i], d[i],  circle_width, circle_height);
				g.fillOval(b[i], d[i],  circle_width, circle_height);
				s=s+1;
			}
		}
		s=0;
		for(int i=1; i<42; i+=2)
		{
			if(b[i] !=0 && d[i]!=0)
			{
				playeryellowx[s] = b[i];
				playeryellowy[s] = d[i];
				g.setColor(Color.YELLOW);
				g.drawOval( b[i], d[i],  circle_width, circle_height);
				g.fillOval(b[i], d[i],  circle_width, circle_height);
				s=s+1;
			}
		}
	}
}
