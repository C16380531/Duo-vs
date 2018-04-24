package duo_vs.pong;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Pong extends Applet implements Runnable, KeyListener{

	final int WIDTH =700, HEIGHT = 500;
	Thread thread;
	
	boolean gameStarted,gameOver;
	Graphics gfx;
	Image img;
	
	Players p1;
	Players p2;
	Ball b1;
	Scoreboard s1;
	Scoreboard s2;
	
	public void init()
	{
			this.resize(WIDTH,HEIGHT);
			this.addKeyListener(this);
			p1= new Players(1);
			p2= new Players(2);
			b1= new Ball();
			s1= new Scoreboard(50);
			s2= new Scoreboard(650);
			img = createImage(WIDTH,HEIGHT);
			gfx=img.getGraphics();
			thread = new Thread(this);
			gameStarted=false;
			gameOver=false;
			thread.start();
			
		
	}
	
	public void render(Graphics g)
	{
			gfx.setColor(Color.black);
			gfx.fillRect(0, 0, WIDTH, HEIGHT);
			if(b1.getX() < -10)
			{
				p1.lifeLost();
				if(p1.remainingLives()<= 0)
				{
					gameOver=true;
					gfx.setColor(Color.red);
					gfx.drawString("Game Over, player 2 wins", 350, 250);
				}
				else
				{
					b1.reset();
					p1.reset();
					p2.reset();
				}
			}else if(b1.getX() > 710)
			{
				p2.lifeLost();
				if(p2.remainingLives()<= 0)
				{
					gameOver=true;
					gfx.setColor(Color.red);
					gfx.drawString("Game Over, player 1 wins", 350, 250);
				}
				else
				{
					b1.reset();
					p1.reset();
					p2.reset();
				}
			}
			
			else
			{
				p1.draw(gfx);
				p2.draw(gfx);
				b1.draw(gfx);
				s1.draw(gfx,p1.remainingLives());
				s2.draw(gfx,p2.remainingLives());
			}
			
			if(!gameStarted)
			{
				gfx.setColor(Color.white);
				gfx.drawString("Pong",340,100);
				gfx.drawString("Press Enter to start game", 310, 130);
			}
			
				g.drawImage(img, 0, 0, this);
			
	}
	
	public void update(Graphics g)
	{
			render(g);
	}
	
	public void tick()
	{
		run();
	}

	
	public void run() {
		
		for(;;)
		{
			if(gameStarted && !gameOver)
			{
			p1.move();
			p2.move();
			b1.move();
			b1.checkPaddleCollision(p1, p2);
			}
			
			repaint();
			try {
			Thread.sleep(10);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		
	}
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_W )
		{
			p1.setUpAccel(true);
		
		}
		else if(e.getKeyCode() == KeyEvent.VK_S )
		{
			p1.setDownAccel(true);
			
		}
		
		if(e.getKeyCode() == KeyEvent.VK_UP )
		{
			p2.setUpAccel(true);
		
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN )
		{
			p2.setDownAccel(true);
			
		}
		
		if(e.getKeyCode() == KeyEvent.VK_ENTER )
		{
			gameStarted=true;
		
		}

	}


	public void keyReleased(KeyEvent e) {

		if(e.getKeyCode() == KeyEvent.VK_W )
		{
			p1.setUpAccel(false);
		}
		else if(e.getKeyCode() == KeyEvent.VK_S )
		{
			p1.setDownAccel(false);
		}
		
		if(e.getKeyCode() == KeyEvent.VK_UP )
		{
			p2.setUpAccel(false);
		
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN )
		{
			p2.setDownAccel(false);
			
		}
	}

	
	public void keyTyped(KeyEvent arg0) {

	}
	
}