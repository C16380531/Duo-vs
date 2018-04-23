/* 
Team Name: Duo-vs.
Course: DT228/2.
Module: Object Oriented Programming.
Type: OOP assignment 2.
*/

package duo_vs.dotsandboxes;

//plug ins
import java.awt.Color;
import java.awt.Graphics;

//imported classes
import duo_vs.Handler;


public class DotsandBoxes 
{	
	private Handler handler;
	private int[] savedXrow,savedYrow,savedXcol,savedYcol;
	int iRow, jRow, iCol, jCol;
	int l,s ;
	boolean count, colcount;
	int jRow1 =  jRow-1;
	int jRow2 = jRow + 1;
	int jCol1 = jCol -1;
	int check;
	
	
	
	public DotsandBoxes(Handler handler)
	{
		savedXrow =new int[100];
		savedYrow =new int[100];
		savedXcol= new int[100];
		savedYcol= new int[100];
		this.handler =handler;
		
		
	}
	
	
	public void fill_lines() {
		
		for( int i = 25; i < 750; i += 50) 
		{
			for(int j = 100; j < 750; j+= 50 ) 
			{
				while(handler.getMouseManager().isLeftPressed() && handler.getMouseManager().getMouseX() >i && handler.getMouseManager().getMouseX() < i+50 && handler.getMouseManager().getMouseY() > j && handler.getMouseManager().getMouseY() < j+17)
				{
			
						count = true;
						iRow = i;
						jRow = j;
						System.out.print("");
					
				}
	
				
				while(handler.getMouseManager().isLeftPressed() && handler.getMouseManager().getMouseX() >i && handler.getMouseManager().getMouseX() < i+17 && handler.getMouseManager().getMouseY() > j && handler.getMouseManager().getMouseY() < j+50)
				{
					
					colcount = true;
					iCol = i;
					jCol = j;
					System.out.print("");
				}
				
			}
		}
		
		if(count)
		{
			savedXrow[l]= iRow;
			savedYrow[l]= jRow;
			l = l +1;
			count = false;
		}
		
		if(colcount)
		{
			savedXcol[s]= iCol;
			savedYcol[s]= jCol;
			s =s +1;
			colcount = false;
		}
	}

	
	
	public void tick() 
	{
		fill_lines();
	}
	
	

		
	
	

	public void render(Graphics g)
	{
		
		g.setColor(Color.BLACK);
		String str1 = "PLAYER 1";
		String str2 = "PLAYER 2";
		g.drawString(str1, 100, 50);
		g.drawString(str2, 500, 50 );
		
		
		
		
		// Dots
		for(int i = 25; i < 750; i+=50)
		{
			for(int j =100; j <750 ; j+=50)
			{
				g.drawOval( i, j, 15, 15);
				g.fillOval(i, j, 15, 15);
			}
		}
		
		// Lines
		for(int i = 25; i < 750; i+=50)
		{
			for(int j = 100; j < 750; j+=50) 
			{
				g.drawRect(i, j, 15, 50);
				g.drawRect(i, j, 50, 15);
			
			}
		}
		
		
			for(int i=0; i<100; i++)
			{
				if(savedXrow[i]!=0 && savedYrow[i]!=0)
				{		
					g.fillRect(savedXrow[i], savedYrow[i], 65, 15);
					
					
				}
			}
			
			
			
			for(int i=0; i<100; i++)
			{
				if(savedXcol[i]!=0 && savedYcol[i]!=0)
				{
					g.fillRect(savedXcol[i], savedYcol[i], 15, 65);
				}	
			}	
			
		
			
			
		}
						
						
 }	



