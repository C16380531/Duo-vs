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
	boolean count,colored,same;
	int[] b,d;
	int rows, dummy_rows;
	int l, column, y, g, h, e,m;
	
	public Connect4(Handler handler)
	{
		this.handler =handler;
		b =new int[42];
		d =new int[42];
		g=h=60;
		dummy_rows=rows=420;
		m=1;
	}
	
	public int drop_discs()
	{
		for(column = 60; column < 640; column+=85)
		{
			for(rows = 60; rows < 470; rows+=90)
			{
				while(handler.getMouseManager().isLeftPressed() && handler.getMouseManager().getMouseX() >column && handler.getMouseManager().getMouseX() < column +85 && handler.getMouseManager().getMouseY() > rows && handler.getMouseManager().getMouseY() < rows+90)
					{
						count=true;
						same=true;
						g=column;
						h=dummy_rows;
						System.out.println("");
					}
			}
		}
		if(b[0] !=0 && d[0]!=0)
		{
			for(int i=0; i<l; i++)
			{
				if(b[i] == g)
				{
					if(count)
					{
						if(d[i] != 60)
						{
							h=d[i]-90;	
							b[l]=g;
							d[l]=h;
							same=false;
						}
						else
						{
							same=false;
							count=false;
						}
				
					}
					
				}
			}
		}
		if(same)
		{
			b[l]=g;
			d[l]=h;
			same=false;
		}
		if(count)
		{
			l=l+1;
			count =false;
		}
		return l;
	}
	
	
	public void tick()
	{		
		drop_discs();
	}
	
	public void render(Graphics g)
	{
		g.setColor(Color.black);
		g.fillRect(0, 0, 700 , 550);
		//sets color of rectangle to blue
	    g.setColor(Color.blue);
		g.fillRect(30, 30, 640 , 490);
		
		//displays 7 columns and 6 rows of white circles
		for(int x = 60; x < 640; x+=85)
		{
			for(int y =60; y <470 ; y+=90)
			{	
				g.setColor(Color.white);
				g.drawOval( x, y, 75, 75);
				g.fillOval(x, y, 75, 75);
			}
		}

		for(int i=0; i<42; i+=2)
		{
			if(b[i] !=0 && d[i]!=0)
			{
				g.setColor(Color.RED);		
				g.drawOval( b[i], d[i], 75, 75);
				g.fillOval(b[i], d[i], 75, 75);
			}
		}
		for(int i=1; i<42; i+=2)
		{
			if(b[i] !=0 && d[i]!=0)
			{
				g.setColor(Color.YELLOW);
				g.drawOval( b[i], d[i], 75, 75);
				g.fillOval(b[i], d[i], 75, 75);
			}
			
			
		}
		
		
	}
}

