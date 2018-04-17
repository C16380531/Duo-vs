/* 
Team Name: Duo-vs.
Course: DT228/2.
Module: Object Oriented Programming.
Type: OOP assignment 2.
*/

package duo_vs.dotsandboxes;

//import java.awt.Color;
//plug ins
//import java.awt.Color;
import java.awt.Graphics;

//imported classes
//import duo_vs.state.State;
import duo_vs.Handler;


public class DotsandBoxes 
{	
	private Handler handler;
	private boolean coloredrow;
	private boolean coloredcolumn;
	private int x,y;
	public DotsandBoxes(Handler handler)
	{
		this.handler =handler;
	}

	public void tick() 
	{
		for( int i = 25; i < 750; i += 50) 
		{
			for(int j = 100; j < 750; j+= 50 ) 
			{
				if(handler.getMouseManager().isLeftPressed() && handler.getMouseManager().getMouseX() >i && handler.getMouseManager().getMouseX() < i+50 && handler.getMouseManager().getMouseY() > j && handler.getMouseManager().getMouseY() < j+17)
				{
					x=i;
					y=j;
					coloredrow=true;
					System.out.println("this is x row"+ x + " this is y " + y);	
					
				}		
				if(handler.getMouseManager().isLeftPressed() && handler.getMouseManager().getMouseX() >i && handler.getMouseManager().getMouseX() < i+17 && handler.getMouseManager().getMouseY() > j && handler.getMouseManager().getMouseY() < j+50)
				{
					x=i;
					y=j;
					coloredcolumn=true;
					System.out.println("this is x column "+ x + " this is y " + y);	
					
				}		
			}
		}
	
	}

	public void render(Graphics g)
	{
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
		
		if(coloredrow==true)
		{
			g.fillRect(x, y, 65 , 15);	 
		}
		if(coloredcolumn==true)
		{
			g.fillRect(x, y, 15, 65);
			
		}
						
						
	 }	

}

