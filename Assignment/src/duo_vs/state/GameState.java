/* 
    Team Name: Duo-vs.
    Course: DT228/2.
    Module: Object Oriented Programming.
    Type: OOP assignment 2.
*/

package duo_vs.state;

import java.awt.Graphics;
//import duo_vs.connect4.Design;
import duo_vs.dotsandboxes.DotsandBoxes;
import duo_vs.Handler;

public class GameState extends State 
{
	//private Design design;
	private DotsandBoxes dotsandboxes;
	
	public GameState(Handler handler)
	{
		//design = new Design(handler);
		dotsandboxes = new DotsandBoxes(handler);
	}
	
	@Override
	public void tick() 
	{
		//design.tick();
		dotsandboxes.tick();
	}

	@Override
	public void render(Graphics g) 
	{
	    //design.render(g);
		dotsandboxes.render(g);
	}

}