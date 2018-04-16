package duo_vs.connect4;

import java.awt.Color;
import java.awt.Graphics;

public class Design 
{	
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
	}
}

