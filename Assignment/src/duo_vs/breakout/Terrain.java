package duo_vs.breakout;

import java.awt.BasicStroke; import java.awt.Color; import java.awt.Graphics2D;

public class Terrain {
	public int map[][]; public int brickW; public int brickH;

	//brick size 
	public Terrain(int row,int col) {
		map = new int[row][col];
			for(int i=0; i<map.length; i++) {
				for(int j=0; j<map[0].length; j++) {
					map[i][j] = 1; } }
		brickW = 630/col; brickH = 60/row; }

	//drawing bricks
	public void draw(Graphics2D g) {
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[0].length; j++) {
				if(map[i][j]>0) {
					g.setColor(Color.white);
					g.fillRect(j*brickW+35, i*brickH+35, brickW, brickH);
					g.setStroke(new BasicStroke(3));
					g.setColor(Color.black);
					g.drawRect(j*brickW+35, i*brickH+35, brickW, brickH); } } } }

	//passing
	public void brickVal(int value, int row, int col) {
		map[row][col] = value; } 
}