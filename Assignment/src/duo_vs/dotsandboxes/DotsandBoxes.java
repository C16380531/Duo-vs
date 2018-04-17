/* 
Team Name: Duo-vs.
Course: DT228/2.
Module: Object Oriented Programming.
Type: OOP assignment 2.
*/

package duo_vs.dotsandboxes;

//plug ins
//import java.awt.Color;
import java.awt.Graphics;

//imported classes
//import duo_vs.state.State;
//import duo_vs.Handler;


public class DotsandBoxes
{	
	public DotsandBoxes()
	{
		
	}

	public void tick() 
	{
	
	}

	public void render(Graphics g)
	{
		String str1 = "PLAYER 1";
		String str2 = "PLAYER 2";
		g.drawString(str1, 100, 50);
		g.drawString(str2, 500, 50 );
		// Dots
		for(int i = 25; i < 800; i+=50)
		{
			for(int j =100; j <800 ; j+=50)
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
	}
}
