package duo_vs.pong;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;


public class Pong extends Applet{

	final int WIDTH =700, HEIGHT = 500;
	public void init()
	{
			this.resize(WIDTH,HEIGHT);
	}
	
	public void paint(Graphics g)
	{
			g.setColor(Color.black);
			g.fillRect(0, 0, WIDTH, HEIGHT);
	}
	
	public void update(Graphics g)
	{
			paint(g);
	}
	
}
