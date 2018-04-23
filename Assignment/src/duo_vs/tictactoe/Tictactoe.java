package duo_vs.tictactoe;

import java.awt.Color;
import java.awt.Graphics;

public class Tictactoe {
	
	public Tictactoe()
	{
		
		
	}
	public void tick() 
	{
	
	}

	public void render(Graphics g)
	{
		 g.setColor(Color.black);
		 g.fillRect(120, 55, 450 , 450);
		
		 g.setColor(Color.white);
		 g.fillRect(270,55,1,450);
		 g.fillRect(420, 55, 1, 450);
		 g.fillRect(120, 205, 450, 1);
		 g.fillRect(120, 355, 450, 1);
		
		
		/*
		for(int i = 120; i < 450; i+=150)
		{
			for(int j = 55; j < 450; j+=150) 
			{
				g.setColor(Color.white);
				g.drawRect(i, j, 1, 450);
				g.drawRect(i, j, 450, 1);
			
			}
		} */

	}
}
