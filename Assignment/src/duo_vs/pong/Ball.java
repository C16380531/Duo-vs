package duo_vs.pong;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	double xVel,yVel,x,y;
	
	public Ball() {
		x=350;
		y=250;
		xVel=-2;
		yVel=1;
	}
	
	public void move()
	{
		x += xVel;
		y += yVel;
		
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
}
