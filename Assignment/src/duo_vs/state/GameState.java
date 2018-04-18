/* 
    Team Name: Duo-vs.
    Course: DT228/2.
    Module: Object Oriented Programming.
    Type: OOP assignment 2.
*/

package duo_vs.state;

//plug ins
import java.awt.Color;
import java.awt.Graphics;

//imported classes
import duo_vs.connect4.Connect4;
import duo_vs.dotsandboxes.DotsandBoxes;
//import garys one
import duo_vs.tictactoe.Tictactoe;
//import duo_vs.checkers.Checkers;
//import chris one*/

import duo_vs.Handler;

public class GameState extends State 
{
	//objects
	private Connect4 connect4;
	private DotsandBoxes dotsandboxes;
	private Tictactoe tictactoe;
	/*garys class object
	private Checkers checkers;
	chris class object*/
	
	//handler
	private Handler handler;
	
	//variable
	private String str, str1, str2, str3, str4, str5, str6;
	private int p1=0;
	
	public GameState(Handler handler)
	{
		this.handler = handler;
		
		connect4 = new Connect4(handler);
		dotsandboxes = new DotsandBoxes(handler);
		tictactoe = new Tictactoe();
		/*garys class initialized here
		checkers = new Checkers();
		chris class initialized here*/
		
	}
	
	@Override
	public void tick() 
	{
		connect4.tick();
		dotsandboxes.tick();
		tictactoe.tick();
		/*garys tick called here
		checkers.tick();
		chris tick called here*/
		
		//code this better
		if(handler.getMouseManager().isLeftPressed() && handler.getMouseManager().getMouseX() > 280 && handler.getMouseManager().getMouseX() < 350 && handler.getMouseManager().getMouseY()< 100 && handler.getMouseManager().getMouseY() > 80)
		{
			p1=1;
		}
		if(handler.getMouseManager().isLeftPressed() && handler.getMouseManager().getMouseX() > 280 && handler.getMouseManager().getMouseX() < 350 && handler.getMouseManager().getMouseY()< 150 && handler.getMouseManager().getMouseY() > 130)
		{
			p1=2;
		}
		if(handler.getMouseManager().isLeftPressed() && handler.getMouseManager().getMouseX() > 280 && handler.getMouseManager().getMouseX() < 350 && handler.getMouseManager().getMouseY()< 200 && handler.getMouseManager().getMouseY() > 180)
		{
			p1=3;
		}
		if(handler.getMouseManager().isLeftPressed() && handler.getMouseManager().getMouseX() > 280 && handler.getMouseManager().getMouseX() < 350 && handler.getMouseManager().getMouseY()< 250 && handler.getMouseManager().getMouseY() > 230)
		{
			p1=4;
		}
		if(handler.getMouseManager().isLeftPressed() && handler.getMouseManager().getMouseX() > 280 && handler.getMouseManager().getMouseX() < 350 && handler.getMouseManager().getMouseY()< 300 && handler.getMouseManager().getMouseY() > 280)
		{
			p1=5;
		}
		if(handler.getMouseManager().isLeftPressed() && handler.getMouseManager().getMouseX() > 280 && handler.getMouseManager().getMouseX() < 350 && handler.getMouseManager().getMouseY()< 350 && handler.getMouseManager().getMouseY() > 330)
		{
			p1=6;
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
    			g.clearRect(0, 0, 700, 550);
    			connect4.render(g); 
    			break;
    		case 2 :
    			g.clearRect(0, 0, 700, 550);
    			dotsandboxes.render(g);
    			break;
    		case 3 :
    			g.clearRect(0, 0, 700, 550);
    			//garys called here
    			g.drawString("WOW GARY YOU HAVE DONE SOOOOOO MUCH", 200, 240);
    			break;
    		case 4 :
    			g.clearRect(0, 0, 700, 550);
    		    tictactoe.render(g);
    			g.drawString("WOW DAVIS YOU HAVE DONE SOOOOOO MUCH", 200, 240);
    			break;
    		case 5 :
    			g.clearRect(0, 0, 700, 550);
    			//checkers.render(g);
    			g.drawString("WOW PAUL YOU HAVE DONE SOOOOOO MUCH", 200, 240);
    			break;
    		case 6 :
    			g.clearRect(0, 0, 700, 550);
    			//chris called here
    			g.drawString("WOW CHRIS YOU HAVE DONE SOOOOOO MUCH", 200, 240);
    			break;    		
		}	
	}
}