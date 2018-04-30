package duo_vs.pong;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Ball {
	double xVel,yVel,x,y;
	double startSpeed=1.5;
	double min=0.3,max=0.5;
	File pong= new File("/textures/Pong.wav");
	
	public Ball() {
		x=350;
		y=275;
		xVel=startSpeed*getRandomDirection();
		yVel=startSpeed*getRandomDirection();
	}
	
	
	public double getRandomDirection()
	{
		int rand=(int) Math.random()%2;
		if(rand ==1)
		{
			System.out.print("Hello");
			return Math.random() * (max - min) + min;
		}
		else
		{
			System.out.print("test");
			return -(Math.random() * (max - min) + min);
		}
	}
	
	public void move()
	{
		x += xVel;
		y += yVel;
		
		if(y<10)
		{
			yVel=-yVel;
		}
		else if(y>510)
		{
			yVel=-yVel;
		}
	}
	
	public void checkPaddleCollision(Players p1,Players p2)
	{
		if(x<=35 && x>=32)
		{
			if(y>=p1.getY() && y<=p1.getY()+80)
			{
				if(p1.checkUpAccel())
				{
					xVel=-xVel+0.1;
				}else if(p1.checkDownAccel())
				{
					xVel=-xVel+0.1;
				}else
				{
					xVel=-xVel;
				}
				PlaySound(pong);
			}
		}
		else if(x>=650 && x<=653)
		{
			if(y>=p2.getY() && y<=p2.getY()+80)
			{
				if(p2.checkUpAccel())
				{
					xVel=-xVel-0.1;
				}else if(p2.checkDownAccel())
				{
					xVel=-xVel-0.1;
				}else
				{
					xVel=-xVel;
				}
				PlaySound(pong);
			}
		}
	}
	
	public void PlaySound(File Sound)
	{
		try
		{
			Clip clip =AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(Sound));
			clip.start();
			
			//Thread.sleep(clip.getMicrosecondLength()/1000);
		}catch(Exception e) 
		{
			
		}
	}
	
	public void draw(Graphics g)
	{
		g.setColor(Color.white);
		g.fillOval((int)x-10,(int)y-10,20,20);
	}
	
	public int getX(){
		return (int) x;
	}
	
	public int getY(){
		return (int) y;
	}
	
	public void reset()
	{
		x=350;
		y=275;
		xVel=startSpeed*getRandomDirection();
		yVel=startSpeed*getRandomDirection();
	}
}
