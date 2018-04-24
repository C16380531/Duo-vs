package brickbreaker_2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import com.sun.javafx.collections.MappingChange.Map;

public class Game extends JPanel implements KeyListener, ActionListener {
	private boolean play = false;
	
	private int score = 0;
	private int score2 = 0;
	
	private int totalBricks = 56;
	private int totalBricks2 = 56;
	
	private Timer timer;
	private int speed = 5;
	
	private int playerX = 275;
	private int player2X = 965;
	
	private int ballposX = 120;
	private int ballposY = 350;
	private int ball2posX = 800;
	private int ball2posY = 350;
	
	private int ballXdir = -1;
	private int ballYdir = -2;
	private int ball2Xdir = -1;
	private int ball2Ydir = -2;
	
	private Terrain terrain;
	
	public Game() {
		terrain = new Terrain(4, 14);
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(speed, this);
		timer.start();}
	
	public void paint(Graphics g) {
		//background
		g.setColor(Color.black);
		g.fillRect(1,  1, 1350, 675);
		//drawing map
		terrain.draw((Graphics2D)g);
		//borders
		g.setColor(Color.red);
		g.fillRect(0, 0, 5, 675);
		g.fillRect(0, 0, 675, 5);
		g.fillRect(0, 641, 675, 5);
		g.setColor(Color.white);
		g.fillRect(675, 0, 5, 675);
		g.setColor(Color.blue);
		g.fillRect(1339, 0, 5, 675);
		g.fillRect(680, 0, 675, 5);
		g.fillRect(680, 641, 675, 5);
		//scores
		g.setColor(Color.white);
		g.setFont(new Font("serif", Font.BOLD, 25));
		g.drawString(""+score, 635, 30);
		g.drawString(""+score2, 1300, 30);
		//the paddles
		g.setColor(Color.red);
		g.fillRect(playerX, 600, 100, 2);
		g.setColor(Color.blue);
		g.fillRect(player2X, 600, 100, 2);
		//the ball
		g.setColor(Color.yellow);
		g.fillOval(ballposX, ballposY, 20, 20);
		g.setColor(Color.MAGENTA);
		g.fillOval(ball2posX,  ball2posY, 20, 20);
		
		if(totalBricks <= 0) {
			play = false;
			ballXdir = 0;
			ballYdir = 0;
			ball2Ydir = 0;
			ball2Ydir = 0;
			g.setColor(Color.RED);
			g.setFont(new Font("serif", Font.BOLD, 30));
			g.setFont(new Font("serif", Font.BOLD, 20));
			g.drawString("You Won", 260, 300);
			g.drawString("Press Enter to Restart", 230, 350); }
		
		if(totalBricks2 <= 0) {
			play = false;
			ballXdir = 0;
			ballYdir = 0;
			ball2Ydir = 0;
			ball2Ydir = 0;
			g.setColor(Color.RED);
			g.setFont(new Font("serif", Font.BOLD, 30));
			g.setFont(new Font("serif", Font.BOLD, 20));
			g.drawString("You Won", 900, 300);
			g.drawString("Press Enter to Restart", 900, 350); }
		
		if(ballposY > 610) {
			play = false;
			ballXdir = 0;
			ballYdir = 0;
			ball2Xdir = 0;
			ball2Ydir = 0;
			g.setColor(Color.RED);
			g.setFont(new Font("serif", Font.BOLD, 30));
			g.drawString("GameOver, Score: ", 190, 300);
			g.setFont(new Font("serif", Font.BOLD, 20));
			g.drawString("Press Enter to Restart", 230, 350); }
		
		if(ball2posY > 610) {
			play = false;
			ballXdir = 0;
			ballYdir = 0;
			ball2Xdir = 0;
			ball2Ydir = 0;
			g.setColor(Color.RED);
			g.setFont(new Font("serif", Font.BOLD, 30));
			g.drawString("GameOver, Score: ", 900, 300);
			g.setFont(new Font("serif", Font.BOLD, 20));
			g.drawString("Press Enter to Restart", 900, 350); }
		
		g.dispose(); }
	
	
	@Override
	public void keyReleased(KeyEvent e) {}
	@Override
	public void keyTyped(KeyEvent e) {}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		timer.start();
		
		if(play) {
			if(new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(playerX, 600, 100, 8))) {
				ballYdir = -ballYdir; }
			
			A: for(int i = 0; i<terrain.map.length; i++) {
				for(int j = 0; j<terrain.map[0].length; j++) {
					if(terrain.map[i][j] > 0) {
						int brickX = j * terrain.brickWidth + 80;
						int brickY = i * terrain.brickHeight + 50;
						int brickWidth = terrain.brickWidth;
						int brickHeight = terrain.brickHeight;
						
						Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
						Rectangle ballRect = new Rectangle(ballposX, ballposY, 20, 20);
						Rectangle brickRect = rect;
						
						if(ballRect.intersects(brickRect)) {
							terrain.setBrickValue(0, i, j);
							totalBricks--;
							score += 5;
							
							if(ballposX + 19 <= brickRect.x || ballposX + 1 >= brickRect.x + brickRect.width) {
								ballXdir = -ballXdir;
							} else {
								ballYdir = -ballYdir;
							}
							
							break A;
						}
					}
				}
			}
			
			ballposX += ballXdir;
			ballposY += ballYdir;
			if(ballposX < 0) {
				ballXdir = -ballXdir;
			}
			if(ballposY < 0) {
				ballYdir = -ballYdir;
			}
			if(ballposX > 660) {
				ballXdir = -ballXdir;
			}
			
			if(new Rectangle(ball2posX, ball2posY, 20, 20).intersects(new Rectangle(player2X, 600, 100, 8))) {
				ball2Ydir = -ball2Ydir; }
			
			A: for(int i = 0; i<terrain.map.length; i++) {
				for(int j = 0; j<terrain.map[0].length; j++) {
					if(terrain.map[i][j] > 0) {
						int brickX = j * terrain.brickWidth + 80;
						int brickY = i * terrain.brickHeight + 50;
						int brickWidth = terrain.brickWidth;
						int brickHeight = terrain.brickHeight;
						
						Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
						Rectangle ballRect = new Rectangle(ball2posX, ball2posY, 20, 20);
						Rectangle brickRect = rect;
						
						if(ballRect.intersects(brickRect)) {
							terrain.setBrickValue(0, i, j);
							totalBricks--;
							score2 += 5;
							
							if(ball2posX + 19 <= brickRect.x || ball2posX + 1 >= brickRect.x + brickRect.width) {
								ball2Xdir = -ball2Xdir;
							} else {
								ball2Ydir = -ball2Ydir;
							}
							
							break A;
						}
					}
				}
			}
			
			ball2posX += ball2Xdir;
			ball2posY += ball2Ydir;
			if(ball2posX < 0) {
				ball2Xdir = -ball2Xdir;
			}
			if(ball2posY < 0) {
				ball2Ydir = -ball2Ydir;
			}
			if(ball2posX > 660) {
				ball2Xdir = -ball2Xdir;
			}
			
			
		}
		
		repaint();
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_D) {
			if(playerX >= 570) {
				playerX = 570;
			} else {
				moveRight();
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_A) {
			if(playerX <= 10) {
				playerX = 10;
			} else {
				moveLeft();
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if(player2X >= 1230) {
				player2X = 1230;
			} else {
				moveRight2();
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			if(player2X <= 685) {
				player2X = 685;
			} else {
				moveLeft2();
			}
		}
		
		
		
		
		if(e.getKeyCode() == KeyEvent.VK_ENTER ) {
			if(!play) {
				play = true;
				ballposX = 120;
				ballposY = 350;
				ball2posX = 800;
				ball2posY = 350;
				ballXdir = -1;
				ballYdir = -2;
				ball2Xdir = -1;
				ball2Ydir = -2;
				playerX = 310;
				player2X = 965;
				score = 0;
				totalBricks = 56;
				totalBricks2 = 56;
				terrain = new Terrain(3, 7);
				
				repaint();
			}
		}
	}
	
	public void moveRight() {
		play = true;
		playerX += 50; }
	public void moveLeft() {
		play = true;
		playerX -= 50; }
	public void moveRight2() {
		play = true;
		player2X += 50; }
	public void moveLeft2() {
		play = true;
		player2X -= 50; }
}