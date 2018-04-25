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
import duo_vs.pong.Pong;
import duo_vs.tictactoe.Tictactoe;
//import duo_vs.checkers.Checkers;
//import chris one*/

import duo_vs.Handler;

public class GameState extends State 
{
	//objects
	private Connect4 connect4;
	private DotsandBoxes dotsandboxes;
	private Pong pong;
	//private Checkers checkers;
	//chris class object*/
	
	//handler
	private Handler handler;
	
	//variable
	private String str, str1, str2, str3, str4, str5, str6;
	private int p1=0;
	private int check;
	
	public GameState(Handler handler)
	{
		this.handler = handler;
		
		connect4 = new Connect4(handler);
		dotsandboxes = new DotsandBoxes(handler);
		pong = new Pong(handler);
		//checkers = new Checkers();
		//chris class initialized here*/
		
	}
	public int menu()
	{
		//code this better
		while(handler.getMouseManager().isLeftPressed() && handler.getMouseManager().getMouseX() > 280 && handler.getMouseManager().getMouseX() < 350 && handler.getMouseManager().getMouseY()< 100 && handler.getMouseManager().getMouseY() > 80)
		{
			p1=1;
			//break;
			System.out.print("");
		}
		while(handler.getMouseManager().isLeftPressed() && handler.getMouseManager().getMouseX() > 280 && handler.getMouseManager().getMouseX() < 350 && handler.getMouseManager().getMouseY()< 150 && handler.getMouseManager().getMouseY() > 130)
		{
			p1=2;
			System.out.print("");
		}
		while(handler.getMouseManager().isLeftPressed() && handler.getMouseManager().getMouseX() > 280 && handler.getMouseManager().getMouseX() < 350 && handler.getMouseManager().getMouseY()< 200 && handler.getMouseManager().getMouseY() > 180)
		{
			p1=3;
			System.out.print("");
		}
		while(handler.getMouseManager().isLeftPressed() && handler.getMouseManager().getMouseX() > 280 && handler.getMouseManager().getMouseX() < 350 && handler.getMouseManager().getMouseY()< 250 && handler.getMouseManager().getMouseY() > 230)
		{
			p1=4;
			System.out.print("");
		}
		while(handler.getMouseManager().isLeftPressed() && handler.getMouseManager().getMouseX() > 280 && handler.getMouseManager().getMouseX() < 350 && handler.getMouseManager().getMouseY()< 300 && handler.getMouseManager().getMouseY() > 280)
		{
			p1=5;
			System.out.print("");
		}
		while(handler.getMouseManager().isLeftPressed() && handler.getMouseManager().getMouseX() > 280 && handler.getMouseManager().getMouseX() < 350 && handler.getMouseManager().getMouseY()< 350 && handler.getMouseManager().getMouseY() > 330)
		{
			p1=6;
			System.out.print("");
		}
		return p1;
	}
	
	@Override
	public void tick() 
	{
		if(p1==0)
		{
			check= menu();
		}
		else
		{
			switch(check) 
			{
				case 1 :
					connect4.tick();
					break;
				case 2 :
					dotsandboxes.tick();
					break;
				case 3 :
					pong.tick();
					break;
				case 4 :
					//tictactoe.tick();
					break;
				case 5 :
					//checkers.tick();
					break;
				case 6 :
					//chris tick called here
					break;    		
			}	
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

		if(p1==0)
		{
			check= menu();
		}
		else
		{
			switch(check) 
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
	    			pong.render(g);
	    			break;
	    		case 4 :
	    			g.clearRect(0, 0, 700, 550);
	    			//tictactoe.render(g);
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
}