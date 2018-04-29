package duo_vs.background;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import duo_vs.Handler;

public class Background 
{

	static BufferedImage nav = null;
	private Handler handler;
	boolean hover;
	int p1, pressed;
	
	public Background(Handler handler)
	{
		this.handler=handler;
	}
	public void tick()
	{
		pressed=0;
		if(handler.getMouseManager().isLeftPressed() && handler.getMouseManager().getMouseX() >510 && handler.getMouseManager().getMouseX() < 660 && handler.getMouseManager().getMouseY() > 530 && handler.getMouseManager().getMouseY() < 590 )
		{	
			pressed=1;
			pressed();
			System.out.print("");
		}
		//user is hovering over a back button
		if(handler.getMouseManager().getMouseX() >510 && handler.getMouseManager().getMouseX() < 660 && handler.getMouseManager().getMouseY() > 530 && handler.getMouseManager().getMouseY() < 590)
		{
			hover=true;
		}
	}
	
	public int pressed()
	{
		if(pressed==1)
	    {
			return p1=0; 
	    }
		else
		{
			return p1=3;
		}
	}
	
	public void render(Graphics g)
	{
        
        g.setColor(Color.BLACK);
        g.fillRect(0, 510, 700 , 550);
        g.setColor(Color.YELLOW);
        g.drawRect(5, 510, 690 , 550);
        
		g.setFont(new Font("AR DARLING", Font.PLAIN, 40)); 
		g.setColor(Color.RED);
		g.fillRect(510, 530, 150, 60);
		g.setColor(Color.BLACK);
		g.drawString("BACK", 530, 570);
        
		if(hover)
        {
			g.setFont(new Font("AR DARLING", Font.PLAIN, 40)); 
			g.setColor(Color.BLACK);
			g.fillRect(510, 530, 150, 60);
			g.setColor(Color.RED);
			g.drawRect(510, 530, 150, 60);
			g.setColor(Color.RED);
			g.drawString("BACK", 530, 570);
        	hover=false;
        }
	}

}
