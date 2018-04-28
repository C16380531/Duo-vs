/* 
    Team Name: Duo-vs.
    Course: DT228/2.
    Module: Object Oriented Programming.
    Type: OOP assignment 2.
*/

package duo_vs;


public class Launcher 
{

	public static void main(String[] args)
	{
		//store object in variable
		Game game = new Game("Duo-vs", 700, 600);
				
		//call start method of game
		game.start();
	}
	
}

