/* 
    Team Name: Duo-vs.
    Course: DT228/2.
    Module: Object Oriented Programming.
    Type: OOP assignment 2.
*/

package duo_vs.state;

import java.awt.Graphics;

public abstract class State 
{

		//object
		private static State currentState = null;
		
		public static void setState(State state)
		{
			currentState = state;
		}
		
		public static State getState()
		{
			return currentState;
		}
		
	//render and tick class that applies to every method
	public abstract void tick();
		
	//taking in graphics object g so state can draw to screen directly
	public abstract void render(Graphics g);
		
}

