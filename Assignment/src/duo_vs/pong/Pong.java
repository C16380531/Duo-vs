package duo_vs.pong;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import duo_vs.Handler;

public class Pong extends Applet {

	final int WIDTH =700, HEIGHT = 550;
	Thread thread;
	private Handler handler;
	boolean gameStarted,gameOver;
	Players p1;
	Players p2;
	Ball b1;
	Scoreboard s1;
	Scoreboard s2;
	
	public Pong(Handler handler)
	{
		    this.handler =handler;
			p1= new Players(1);
			p2= new Players(2);
			b1= new Ball();
			s1= new Scoreboard(50);
			s2= new Scoreboard(650);
			gameStarted=false;
			gameOver=false;
		
	}
	
	public void render(Graphics g)
	{
		
		g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		if(b1.getX() < -10)
		{
			p1.lifeLost();
			if(p1.remainingLives()<= 0)
			{
				gameOver=true; 
				g.setColor(Color.red);
				g.drawString("Game Over, player 2 wins", 250, 250);
				g.drawString("Press enter to play again", 260, 280);
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
				g.setFont(new Font("TimesRoman", Font.PLAIN, 20)); 
				g.setColor(Color.red);
				g.drawString("Game Over, player 1 wins", 250, 250);
				g.drawString("Press enter to play again", 260, 280);
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
			p1.draw(g);
			p2.draw(g);
			b1.draw(g);
			s1.draw(g,p1.remainingLives());
			s2.draw(g,p2.remainingLives());
		}
		
		
		if(!gameStarted)
		{
			g.setFont(new Font("TimesRoman", Font.BOLD, 40));
			g.setColor(Color.white);
			g.drawString("Pong",295,100);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
			g.drawString("Press Enter to start game", 250, 150);
		}
			
	}

	public void tick()
	{
		movement();
		run();
		secondmove();
	}

	
	public void run() {
		if(gameStarted && !gameOver)
			{
			p1.move();
			p2.move();
			b1.move();
			b1.checkPaddleCollision(p1, p2);
			}
		
	}
	
	public void movement() {
		if(handler.getKeyManager().isW())
		{
			p1.setUpAccel(true);
		}
		else if(handler.getKeyManager().isS())
		{
			p1.setDownAccel(true);

		}
		
		if(handler.getKeyManager().isUP())
		{
			p2.setUpAccel(true);
		
		}
		else if(handler.getKeyManager().isDOWN())
		{
			p2.setDownAccel(true);
			
		}
		
		if(handler.getKeyManager().isENTER())
		{
			gameStarted=true;
			
			if(gameOver)
			{
				System.out.print("Hello");
				gameOver=false;
				b1.reset();
				p1.resetLives();
				p2.resetLives();
				p1.reset();
				p2.reset();
				repaint();
			}
		
		}

		

	}


	public void secondmove() 
	{

		if(handler.getKeyManager().isW())
		{
			p1.setUpAccel(false);
		}
		else if(handler.getKeyManager().isS())
		{
			p1.setDownAccel(false);

		}
		
		if(handler.getKeyManager().isUP())
		{
			p2.setUpAccel(false);
		
		}
		else if(handler.getKeyManager().isDOWN())
		{
			p2.setDownAccel(false);
			
		}
		
	}
	
}