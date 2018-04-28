package duo_vs.breakout;

import java.awt.Color; import java.awt.Font; import java.awt.Graphics; import java.awt.Graphics2D;
import java.awt.Rectangle; import java.awt.event.ActionEvent; import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JPanel; import javax.swing.Timer;

import duo_vs.breakout.Terrain;
import duo_vs.Handler;
import duo_vs.background.Background;

public class Game extends JPanel implements ActionListener {
	private boolean play = false;
	private Handler handler;
	private Background background;

		/*players*/		private int p1Xpos = 200; private int p1Ypos = 500;
						private int p2Xpos = 400; private int p2Ypos = 500;
		/*balls*/		private int b1Xpos = 240; private int b1Ypos = 400;
						private int b2Xpos = 440; private int b2Ypos = 400;
						private int b1Xdir = 1; private int b1Ydir = -2;
						private int b2Xdir = 1; private int b2Ydir = -2;
		/*vars*/		private int speed = 5; private int bricks = 75;
						private int score1, score2 = 0;
		/*globals*/		private Timer timer; private Terrain terrain;

	public Game(Handler handler) {
		terrain = new Terrain(3,25);
		this.handler =handler;
		background = new Background(handler);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(speed, this); timer.start(); 
		}

	public void render(Graphics g) {
		/*background*/	g.setColor(Color.black); g.fillRect(1,1,700,550);
		/*drawing map*/	terrain.draw((Graphics2D)g);
		/*border*/		g.setColor(Color.yellow);
						g.fillRect(0,0,3,550); g.fillRect(691,0,3,550);
						g.fillRect(0,0,700,3); g.fillRect(0,518,700,3);
		/*players*/		g.setColor(Color.red); g.fillRect(p1Xpos,p1Ypos,80,2);
						g.setColor(Color.blue); g.fillRect(p2Xpos,p2Ypos,80,2);
		/*ball1*/		g.setColor(Color.red); g.fillOval(b1Xpos, b1Ypos,15,15);
		/*score1*/		g.drawString(""+score1, 10, 20);
		/*ball2*/		g.setColor(Color.blue); g.fillOval(b2Xpos,b2Ypos,15,15);
		/*score2*/		g.drawString(""+score2, 675, 20);
		background.render(g);
						

		if(bricks<=0) {
			play = false;
			b1Xdir = 0; b1Ydir = 0; b2Xdir = 0; b2Ydir = 0;
			g.setColor(Color.white); g.setFont(new Font("serif",Font.BOLD, 30));
				if(score1 > score2) {
					g.drawString("Red player wins!", 160, 300); g.drawString("Press Enter to Restart", 260, 350); } 
				else {
					g.drawString("Blue player wins!", 160, 300); g.drawString("Press Enter to Restart", 260, 350); } }
			
		if(b1Ypos > 550) {
			play = false;
			b1Xdir = 0; b1Ydir = 0; b2Xdir = 0; b2Ydir = 0;
			g.setColor(Color.white); g.setFont(new Font("serif",Font.BOLD, 30));
			g.drawString("Blue player wins!", 160, 300); g.drawString("Press Enter to Restart", 260, 350); }
		if(b2Ypos > 550) {
			play = false;
			b1Xdir = 0; b1Ydir = 0;b2Xdir = 0; b2Ydir = 0;
			g.setColor(Color.white); g.setFont(new Font("serif",Font.BOLD, 30));
			g.drawString("Red player wins!", 160, 300); g.drawString("Press Enter to Restart", 260, 350); }
		
		g.dispose(); 
		}
	
	public void tick()
	{
		background.tick();
		movement();
	}
	public int pressed6()
	{
		int p1;
		p1=background.pressed();
		return p1;
	}
	public void actionPerformed(ActionEvent arg0) {
		timer.start();
		if(play) {
			if(new Rectangle(b1Xpos,b1Ypos,15,15).intersects(new Rectangle(p1Xpos,p1Ypos,80,2))) {
				b1Ydir = -b1Ydir; }
			if(new Rectangle(b2Xpos,b2Ypos,15,15).intersects(new Rectangle(p2Xpos,p2Ypos,80,2))) {
				b2Ydir = -b2Ydir; }

			A: for(int i = 0; i<terrain.map.length; i++) {
				for(int j = 0; j<terrain.map[0].length; j++) {
					if(terrain.map[i][j] > 0) {
			/*hitboxes*/int brickX = j * terrain.brickW + 35; int brickY = i * terrain.brickH + 30;
						int brickWidth = terrain.brickW; int brickHeight = terrain.brickH;
						
						Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
						Rectangle ballRect = new Rectangle(b1Xpos, b1Ypos, 15, 15); Rectangle brickRect = rect;
						Rectangle rect2 = new Rectangle(brickX, brickY, brickWidth, brickHeight);
						Rectangle ballRect2 = new Rectangle(b2Xpos, b2Ypos, 15, 15); Rectangle brickRect2 = rect2;
						
						if(ballRect.intersects(brickRect)) {
							terrain.brickVal(0, i, j); bricks--; score1 += 1;
							
							if(b1Xpos + 19 <= brickRect.x || b1Xpos + 1 >= brickRect.x + brickRect.width) {
								b1Xdir = -b1Xdir; } else { b1Ydir = -b1Ydir; }
			break A; }
						if(ballRect2.intersects(brickRect2)) {
							terrain.brickVal(0, i, j); bricks--; score2 += 1;
							
							if(b2Xpos + 19 <= brickRect2.x || b2Xpos + 1 >= brickRect2.x + brickRect2.width) {
								b2Xdir = -b2Xdir; } else { b2Ydir = -b2Ydir; }
			break A; } } } }

		/*change dir*/	b1Xpos += b1Xdir; b1Ypos += b1Ydir;
						if(b1Xpos<5) { b1Xdir = -b1Xdir; }
						if(b1Xpos>680) { b1Xdir = -b1Xdir; }
						if(b1Ypos<0) { b1Ydir = - b1Ydir; }

						b2Xpos += b2Xdir; b2Ypos += b2Ydir;
						if(b2Xpos<5) { b2Xdir = -b2Xdir; }
						if(b2Xpos>680) { b2Xdir = -b2Xdir; }
						if(b2Ypos<0) { b2Ydir = - b2Ydir; } }
					repaint(); }
	
	

	/*movement*/	public void moveRight1() {
							play = true; p1Xpos += 5; }
					public void moveLeft1() {
							play = true; p1Xpos -= 5; }
					public void moveRight2() {
							play = true; p2Xpos += 5; }
					public void moveLeft2() {
							play = true; p2Xpos -= 5; }
					
					
					
					
		public void movement() {
			if(handler.getKeyManager().isD())
			{
				if(p1Xpos>=610) { p1Xpos=610; } else { moveRight1(); }
			}
			else if(handler.getKeyManager().isA())
			{
				if(p1Xpos<=10) { p1Xpos=10; } else { moveLeft1(); }

			}
			
			if(handler.getKeyManager().isRIGHT())
			{
				if(p2Xpos>=610) { p2Xpos=610; } else { moveRight2(); }
			
			}
			else if(handler.getKeyManager().isLEFT())
			{
				if(p2Xpos<=10) { p2Xpos=10; } else { moveLeft2(); }
				
			}
			
			if(handler.getKeyManager().isENTER())
			{
				if(!play) { 
					Random rand = new Random();
					int randomNum1 = rand.nextInt((600 - 50) + 1) + 50;
					int randomNum2 = rand.nextInt((600 - 50) + 1) + 50;
					int randomNum3 = rand.nextInt((2 - 1) + 1) + 1;
					int randomNum4 = rand.nextInt((2 - 1) + 1) + 1;
					play = true;
					p1Xpos = 200; p1Ypos = 500; p2Xpos = 400; p2Ypos = 500;
					b1Xpos = randomNum1; b1Ypos = 400; b2Xpos = randomNum2; b2Ypos = 400;
					b1Xdir = randomNum3; b1Ydir = -2; b2Xdir = randomNum4; b2Ydir = -2;
					score1 = 0; score2 = 0; bricks = 75;
					terrain = new Terrain(3,25); repaint(); 
					} 
			
			}

			

		}

		
		
		
		
		
}