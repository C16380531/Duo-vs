/* 
    Team Name: Duo-vs.
    Course: DT228/2.
    Module: Object Oriented Programming.
    Type: OOP assignment 2.
*/

package duo_vs.state;

import java.awt.Graphics;
import duo_vs.connect4.Design;


public class GameState extends State {
	private Design design;

	public GameState(){
		design = new Design();
	}
	
	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
	    design.render(g);
	}

}