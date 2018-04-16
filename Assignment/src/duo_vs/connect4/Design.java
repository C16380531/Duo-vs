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
import duo_vs.state.State;
import duo_vs.Handler;


public class Design 
{	
	private Handler handler;
	public Design(Handler handler)
	{
		this.handler =handler;
	}
	public void tick()
	{
		
		if(handler.getMouseManager().isLeftPressed() && handler.getMouseManager().isRightPressed())
			State.setState(handler.getGame().gameState);
	}
	
	public void render(Graphics g)
	{
		//sets color of rectangle to blue
	    g.setColor(Color.blue);
		g.fillRect(30, 30, 640 , 490);
		
		//displays 7 columns and 6 rows of white cirlces
		for(int x = 60; x < 640; x+=85)
		{
			for(int y =60; y <470 ; y+=90)
			{	
				g.setColor(Color.white);
				g.drawOval( x, y, 75, 75);
				g.fillOval(x, y, 75, 75);
			}
		}
		
		
			g.setColor(Color.RED);
			g.fillRect(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY(), 8, 8);
			
	}
}
