package duo_vs.pong;

import java.awt.Color;
import java.awt.Graphics;

public class Scoreboard {
	int xPos,yPos,score;
	int lives;
	
	public Scoreboard(int input) {
		yPos=20;
		xPos=input;
		lives=3;
	}
	
	void draw(Graphics g,int remainingLives)
	{
		lives = remainingLives;
		
		g.setColor(Color.white);
		g.drawString(Integer.toString(lives), xPos, yPos);
	}
}
