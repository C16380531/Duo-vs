package duo_vs.pong;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	double xVel,yVel,x,y;
	int startSpeed=1;
	double min=-0.3,max=0.3;
	
	public Ball() {
		x=350;
		y=275;
		xVel=startSpeed*getRandomDirection();
		yVel=startSpeed*getRandomDirection();
	}
	
	
	public double getRandomDirection()
	{
		int rand=(int) Math.random()*2;
		if(rand ==1)
		{
			return Math.random() * (max - min) + min;
		}
		else
		{
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
		else if(y>540)
		{
			yVel=-yVel;
		}
	}
	
	public void checkPaddleCollision(Paddle p1,Paddle p2)
	{
		if(x<=50)
		{
			if(y>=p1.getY() && y<=p1.getY()+80)
			{
				xVel=-xVel;
			}
		}
		else if(x>=650)
		{
			if(y>=p2.getY() && y<=p2.getY()+80)
			{
				xVel=-xVel;
			}
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
