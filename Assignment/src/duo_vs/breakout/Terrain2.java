package brickbreaker_2;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class Terrain2 {
	public int map2[][];
	public int brickWidth2;
	public int brickHeight2;
	public Terrain2(int row, int col) {
		map2 = new int[row][col];
		for(int i = 0; i < map2.length; i++) {
			for(int j = 0; j < map2[0].length; j++) {
				map2[i][j] = 1;
			}
		}
		
		brickWidth2 = 540/col;
		brickHeight2 = 150/row;

	}
	public void draw(Graphics2D g) {
		for(int i = 0; i < map2.length; i++) {
			for(int j = 0; j < map2[0].length; j++) {
				if(map2[i][j] > 0) {
					g.setColor(Color.white);
					g.fillRect(j * brickWidth2 + 80, i * brickHeight2 + 50, brickWidth2, brickHeight2);
					
					g.setStroke(new BasicStroke(3));
					g.setColor(Color.black);
					g.drawRect(j * brickWidth2 + 80, i * brickHeight2 + 50, brickWidth2, brickHeight2);
				}
				
			}
		}
	}
	
	public void setBrickValue(int value, int row, int col) {
		map2[row][col] = value;
	}
	
}