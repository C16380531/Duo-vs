package duo_vs.pong;

import java.awt.Graphics;
import java.awt.Color;

public class Players implements Paddle{

	double y,yVel;
	boolean upAcel,downAcel;
	int player,x,lives;
	final double GRAVITY= 0.9;
	
	public Players(int player) {
		upAcel=false; downAcel=false;
		lives=3;
		y=210; yVel=0;
		if(player==1)
		{
			x=20;
		}
		else
		{
			x=660;
		}
		
	}
	
	public void draw(Graphics g)
	{
		// TODO Auto-generated method stub
		g.setColor(Color.white);
		g.fillRect(x,(int)y,20,80);
	}

	
	public void move() {
		// TODO Auto-generated method stub
		if(upAcel)
		{
			yVel -=2;
		}
		else if(downAcel)
		{
			yVel +=2;
			
		}
		else if(!upAcel && !downAcel)
		{
			yVel *= GRAVITY;
		}
		
		if(y<0)
		{
			y=0;
		}
		else if(y>420)
		{
			y=420;
		}
		
		if(yVel>=5)
		{
			yVel=5;
		}
		else if(yVel<=-5)
		{
			yVel=-5;
		}
		y+=yVel;
	}
	
	public void setUpAccel(boolean input)
	{
		upAcel=input;
	}
	
	public void setDownAccel(boolean input)
	{
		downAcel=input;
	}

	
	public int getY() {
		// TODO Auto-generated method stub
		return (int)y;
	}

	public void reset()
	{
		y=210;
		yVel=0;
		upAcel=false; downAcel=false;
	}

	public int remainingLives()
	{
		System.out.printf("%d",lives);
		return lives;
	}
	
	void lifeLost()
	{
		lives-=1;
	}
	
}
