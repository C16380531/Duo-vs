/* 
    Team Name: Duo-vs.
    Course: DT228/2.
    Module: Object Oriented Programming.
    Type: OOP assignment 2.
*/

package duo_vs.state;

import java.awt.Color;
import java.awt.Graphics;

import duo_vs.connect4.Connect4;
import duo_vs.dotsandboxes.DotsandBoxes;
import duo_vs.Handler;

public class GameState extends State 
{
	private Connect4 connect4;
	private DotsandBoxes dotsandboxes;
	private String str, str1, str2, str3, str4, str5, str6;
	private Handler handler;
	private int p1=0;
	
	public GameState(Handler handler)
	{
		this.handler = handler;
		
		connect4 = new Connect4(handler);
		dotsandboxes = new DotsandBoxes(handler);
	}
	
	@Override
	public void tick() 
	{
		connect4.tick();
		dotsandboxes.tick();
		
		if(handler.getMouseManager().isLeftPressed() && handler.getMouseManager().getMouseX() > 280 && handler.getMouseManager().getMouseX() < 350 && handler.getMouseManager().getMouseY()< 100 && handler.getMouseManager().getMouseY() > 80)
		{
			p1=1;
		}
	}
	
	/*
	only a menu template don't freak
	not the real thing 
	This will be changed later better code and look 
	 */
	
	@Override
	public void render(Graphics g) 
	{
	    //design.render(g);
		//dotsandboxes.render(g);
	
		//make code better use array or something and loop
		str = "Duo_vs";				
		str1 = "Sharon's Game";
		str2 = "Lauren's Game";
		str3 = "Gary's Game";
		str4 = "Davis's Game";
		str5 = "Paul's Game";
		str6 = "Chris's Game";
		
		g.setColor(Color.red);
		g.drawString(str, 300, 50);
		g.drawString(str1, 280, 100);
		g.drawString(str2, 280, 150);
		g.drawString(str3, 280, 200);
		g.drawString(str4, 280, 250);
		g.drawString(str5, 280, 300);
		g.drawString(str6, 280, 350);	

		switch(p1) 
		{
    		case 1 :
    			connect4.render(g); 
    		case 2 :
    		
    		case 3 :
    		
    		case 4 :
    		
    		case 5 :
    		
    		case 6 :
    		
    		default :
    		
		}	
	}
}