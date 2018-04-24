/* 
    Team Name: Duo-vs.
    Course: DT228/2.
    Module: Object Oriented Programming.
    Type: OOP assignment 2.
*/

package duo_vs;

import duo_vs.input.KeyManager;
import duo_vs.input.MouseManager;


public class Handler 
{
	
	private Game game;
	
	public Handler(Game game)
	{
		this.game = game;
	}
	
	public KeyManager getKeyManager(){
		return game.getKeyManager();
	}
	
	public MouseManager getMouseManager()
	{
		return game.getMouseManager();
	}
	
	public Game getGame() 
	{
		return game;
	}

	public void setGame(Game game) 
	{
		this.game = game;
	}

}

