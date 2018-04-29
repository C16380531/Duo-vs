package duo_vs.dotsandboxes;

import java.awt.Graphics;

public class Layout {
	
	
	
	 public Layout() {
		
	}
	 
	 
	 public void drawDots(Graphics g) {
			for(int i = 25; i < 550; i+=50)
			{
				for(int j =25; j < 550; j+=50)
				{
					g.drawOval( i, j, 15, 15);
					g.fillOval(i, j, 15, 15);
				}
			}
		}
		
		public void playerText(Graphics g) {
			
			
			String str1 = "Player1: ";
			String str2 = "Player2: ";
			
			g.drawString(str1, 550, 150);
			g.drawString(str2, 550, 350);
			
			
		}
		
		public void drawLines(Graphics g) {
			
			
			for(int i = 25; i < 500; i+=50)
			{
				for(int j = 25; j < 500; j+=50) 
				{
					g.drawRect(i, j, 15, 50);
					g.drawRect(i, j, 50, 15);
					if(i > 450) {
						g.drawRect(i+50, j, 15, 50);
					}
					if(j > 450) {
						g.drawRect(i, j+50, 50, 15);
					}
				}
			}
		}

}
