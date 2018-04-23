package duo_vs.pong;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Pong extends Applet implements Runnable, KeyListener{

	final int WIDTH =700, HEIGHT = 500;
	Thread thread;
	
	
	public void init()
	{
			this.resize(WIDTH,HEIGHT);
			thread = new Thread(this);
			thread.start();
			this.addKeyListener(this);
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

	
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			repaint();
		Thread.sleep(10);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		}

	
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_UP )
		{
			
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN )
		{
			
		}

	}


	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_UP )
		{
			
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN )
		{
			
		}
	}

	
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}