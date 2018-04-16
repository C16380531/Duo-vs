package duo_vs.connect4;

import java.awt.Color;
import java.awt.Graphics;

public class Design 
{	
	public void render(Graphics g)
	{

	    g.setColor(Color.blue);
		g.fillRect(30, 30, 640 , 490);
		
		for(int i = 60; i < 640; i+=85)
		{
			for(int j =60; j <470 ; j+=90)
			{
				g.setColor(Color.white);
				g.drawOval( i, j, 75, 75);
				g.fillOval(i, j, 75, 75);
			}
		}
	}
}

