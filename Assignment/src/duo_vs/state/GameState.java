/* 
    Team Name: Duo-vs.
    Course: DT228/2.
    Module: Object Oriented Programming.
    Type: OOP assignment 2.
*/

package duo_vs.state;

//plug ins
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

//imported classes
import duo_vs.connect4.Connect4;
import duo_vs.imageloader.ImageLoader;
//import duo_vs.dotsandboxes.DotsandBoxes;
import duo_vs.pong.Pong;
//import duo_vs.tictactoe.Tictactoe;
import duo_vs.checkers.Checkers;
import duo_vs.breakout.Game;
import duo_vs.background.Background;

import duo_vs.Handler;

public class GameState extends State 
{
	
	//objects
	private Connect4 connect4;
//	private DotsandBoxes dotsandboxes;
	private Pong pong;
	private Checkers checkers;
	private Game breakout;
	
	//handler
	private Handler handler;
	
	//variable
	private String str, str1, str2, str3, str4, str5, str6;
	public int p1=0;
	private int counter=1;
	private int check;
	private boolean right,left;
	static BufferedImage arrowLeft = null;
	static BufferedImage arrowRight = null;
	static BufferedImage Pong = null;
	static BufferedImage Breakout = null;
	static BufferedImage connect_4 = null;
	static BufferedImage CHECKERS = null;
	
	public GameState(Handler handler)
	{
		this.handler = handler;
		left=right=false;
		connect4 = new Connect4(handler);
	//	dotsandboxes = new DotsandBoxes(handler);
		pong = new Pong(handler);
		checkers = new Checkers(handler);
		breakout = new Game(handler);
		

			arrowLeft = ImageLoader.loadImage("/textures/arrow_left.png");
			arrowRight = ImageLoader.loadImage("/textures/arrow_right.png");
			Pong =  ImageLoader.loadImage("/textures/Pong.JPG");
			Breakout =  ImageLoader.loadImage("/textures/Breakout.png");
		    connect_4 = ImageLoader.loadImage("/textures/connectmenu.PNG");
		    CHECKERS = ImageLoader.loadImage("/textures/checkers.PNG");
	}
	public int menu()
	{
		//code this better
		//change x and y
		if(handler.getMouseManager().isLeftPressed() && handler.getMouseManager().getMouseX() > 150 && handler.getMouseManager().getMouseX() < 550 && handler.getMouseManager().getMouseY()< 400 && handler.getMouseManager().getMouseY() > 150)
		{
			p1=counter;
			
		}
		while(handler.getMouseManager().isLeftPressed() && handler.getMouseManager().getMouseX() > 25 && handler.getMouseManager().getMouseX() < 125 && handler.getMouseManager().getMouseY()< 325 && handler.getMouseManager().getMouseY() > 225 && counter>=2)
		{
			left=true;		
			System.out.print("");
		}
		while(handler.getMouseManager().isLeftPressed() && handler.getMouseManager().getMouseX() > 575 && handler.getMouseManager().getMouseX() < 675 && handler.getMouseManager().getMouseY()< 325 && handler.getMouseManager().getMouseY() > 225 && counter<=5)
		{
			right=true;
			System.out.print("");
		}
		if(left)
		{
			counter-=1;
			
			left=false;
		}
		if(right)
		{
			counter+=1;
			
			right=false;
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
					p1=connect4.pressed1();
					//check=p1;
					break;
				case 2 :
	//				dotsandboxes.tick(p1);
					break;
				case 3 :
					pong.tick();
					p1=pong.pressed3();
					break;
				case 4 :
					//tictactoe.tick(p1);
					break;
				case 5 :
					checkers.tick();
					break;
				case 6 :
					breakout.tick();
					p1=breakout.pressed6();
					break;    		
			}	
		}
	}
	
	@Override
	public void render(Graphics g) 
	{
		//g.clearRect(0, 0, 700, 600);
		//make code better use array or something and loop
		str = "Duo_vs";				
		str1 = "Sharon's Game";
		str2 = "Lauren's Game";
		str3 = "Gary's Game";
		str4 = "Davis's Game";
		str5 = "Paul's Game";
		str6 = "Chris's Game";
		g.setColor(Color.red);
		g.setFont(new Font("TimesRoman", Font.BOLD, 32));
		g.drawString(str, 280, 65);
		if(p1==0)
		{
			if(counter>=1 && counter <6)
			{	
				g.fillRect(575, 225, 100, 100);
				g.drawImage(arrowRight, 575, 225, 100, 100, null);
			}
			if(counter>1)
			{
				g.fillRect(25, 225, 100, 100);
				g.drawImage(arrowLeft, 25, 225, 100, 100, null);
			}
			int game=counter;
			g.setFont(new Font("TimesRoman", Font.PLAIN, 18));
				switch(game) 
				{
					case 1 :
						g.drawString(str1, 276, 100);
						g.drawImage(connect_4, 150, 150, 400, 250, null);
						break;
					case 2 :
						g.drawString(str2, 276, 100);
		    			break;
		    		case 3 :
		    			g.drawString(str3, 284, 100);
		    			g.drawImage(Pong, 150, 150, 400, 250, null);
		    			break;
		    		case 4 :
		    			g.drawString(str4, 280, 100);
		    			break;
		    		case 5 :
		    			g.drawString(str5, 284, 100);
		    			g.drawImage(CHECKERS, 150, 150, 400, 400, null);
		    			break;
		    		case 6 :
		    			g.drawString(str6, 280, 100);
		    			g.drawImage(Breakout, 150, 150, 400, 250, null);
				}
		}
		

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
//	    			dotsandboxes.render(g);
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
	    			checkers.render(g);
	    			break;
	    		case 6 :
	    			g.clearRect(0, 0, 700, 550);
	    			breakout.render(g);
	    			break;    		
			}
		}
	}
}