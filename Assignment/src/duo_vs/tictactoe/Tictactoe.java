package duo_vs.tictactoe;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import duo_vs.Handler;

public class Tictactoe //implements ActionListener 
{
	private Handler handler;
	//private String letter ="";
	int[] x, y, playero, playerx;
	int d;
	boolean pressed=false, gameStarted=false;
	
	public Tictactoe(Handler handler) {
		this.handler =handler;
		x= new int[10];
		y= new int[10];
		playero= new int[9];
		playerx=new int[9];
		
	}

	public void tick()
	{
		started();
		if(gameStarted)
		{
			clickable();
		}
	
	}
	public void started()
	{
		if(handler.getKeyManager().isENTER())
		{
			gameStarted=true;
		}
	}
	public void clickable()
	{
		 for(int i=120; i<450 ; i+=151 )
		 {
			 for(int j=55; j<450; j+=151)
			 {
				 while(handler.getMouseManager().isLeftPressed() && handler.getMouseManager().getMouseX() >i && handler.getMouseManager().getMouseX() < i +150 && handler.getMouseManager().getMouseY() > j && handler.getMouseManager().getMouseY() <j+150)
				 {
					 x[d]=i;
					 y[d]=j;
					 pressed=true;
					 System.out.print("");
				 }
			 }
		}
		 if(pressed)
		 {
			 d=d+1;
			 pressed=false;
		 }
	}
	
	
	
	public void render(Graphics g)
	{
		 g.setColor(Color.white);
		 g.fillRect(120, 55, 450 , 450);
		
		 g.setColor(Color.blue);
		 
		 
		 for(int i=120; i<450 ; i+=151 )
		 {
			 for(int y=55; y<450; y+=151)
			 {
				  g.fillRect(i,y,150,150);
			 }
		 }
		if(gameStarted==false)
		{
			g.setColor(Color.RED);
			g.drawString("Press Enter", 250, 250);
		}
		 color(g);

	}
	
	private void color(Graphics g)
	{
		for(int s=0; s<10; s+=2)
		{
			if(x[s] != 0 || y[s] !=0)
			{
				g.setColor(Color.BLACK);
				g.fillRect(x[s],y[s],150,150);
				g.setColor(Color.YELLOW);
				g.drawString("X", x[s] +55, y[s]+85);
				
				for(int h = 0; h<9; h++)
				{
					if(x[h] !=0)
					{
					
					}
				}
			}
		}
		for(int s=1; s<10; s+=2)
		{
			if(x[s] != 0 || y[s] !=0)
			{
				g.setColor(Color.BLACK);
				g.fillRect(x[s],y[s],150,150);
				g.setColor(Color.YELLOW);
				g.drawString("O", x[s] +55, y[s]+85);
			}
		}
	}
}
	
	
		
	
//	public void actionPerformed(ActionEvent a) {
		
		/*if(a.getSource() == btnReset) {
			window.getContentPane().removeAll();*/
			
			//count ++;
		
		//calculate whos turn it is
		/*
		if (count == 1 || count == 3 || count ==5 || count ==7 || count ==9 )
		{
			letter = "X";
			
			
		} else if (count == 2 || count ==4 || count ==6 || count== 8 || count ==10)
		{
			
			letter= "0";
			
		}
	
		//Display X's or O's on the buttons
		if (a.getSource( ) == button1) {
			button1.setText(letter);
			button1.setFont(new Font("Tahona", Font.BOLD, 96));
			
			button1.setEnabled(false);
		} else if (a.getSource() == button2) {
			button2.setText(letter);
			button2.setFont(new Font("Tahona", Font.BOLD, 96));
			
			button2.setEnabled(false);
		}else if (a.getSource() == button3) {
			button3.setText(letter);
			button3.setFont(new Font("Tahona", Font.BOLD, 96));
			
			button3.setEnabled(false);
		}else if (a.getSource() == button5) {
			button5.setText(letter);
			button5.setFont(new Font("Tahona", Font.BOLD, 96));
			
			button5.setEnabled(false);
		}else if (a.getSource() == button6) {
			button6.setText(letter);
			button6.setFont(new Font("Tahona", Font.BOLD, 96));
			
			button6.setEnabled(false);
		}else if (a.getSource() == button7) {
			button7.setText(letter);
			button7.setFont(new Font("Tahona", Font.BOLD, 96));
			
			button7.setEnabled(false);
		}else if (a.getSource() == button9) {
			button9.setText(letter);
			button9.setFont(new Font("Tahona", Font.BOLD, 96));
			
			button9.setEnabled(false);
		}else if (a.getSource() == button10) {
			button10.setText(letter);
			button10.setFont(new Font("Tahona", Font.BOLD, 96));
			
			button10.setEnabled(false);
		}else if (a.getSource() == button11) {
			button11.setText(letter);
			button11.setFont(new Font("Tahona", Font.BOLD, 96));
			
			button11.setEnabled(false);
		}
		
		
		//Determine who wins
		//horizontal win
		if(button1.getText() == button2.getText()
				&& button2.getText() == button3.getText()
				&& button1.getText() !="") {
			win = true;
		} else if (button5.getText() == button6.getText()
				&& button6.getText() == button7.getText()
				&& button5.getText() != "") {
			win = true;
		}else if (button9.getText() == button10.getText()
				&& button10.getText() == button11.getText()
				&& button9.getText() != "") {
			win = true;
		}
		
		//virticle wins
		else if (button1.getText() == button5.getText()
				&& button5.getText() == button9.getText()
				&& button9.getText() != "") {
			win = true;
		}else if (button2.getText() == button6.getText()
				&& button6.getText() == button10.getText()
				&& button2.getText() != "") {
			win = true;
		}else if (button3.getText() == button7.getText()
				&& button7.getText() == button11.getText()
				&& button3.getText() != "") {
			win = true;
		}
		
		// diagonal wins
		else if (button1.getText() == button6.getText()
				&& button6.getText() == button11.getText()
				&& button1.getText() != "") {
			win = true;
		}else if (button3.getText() == button6.getText()
				&& button6.getText() == button9.getText()
				&& button3.getText() != "") {
			win = true;
		} else {
			win = false;
		}
		
		//show a dialog if someone wins or the game is tie
		
		if (win==true) {
		
		JOptionPane.showMessageDialog(null,  letter + "WINS!");
		}else if (count == 9 && win == false ) {
			JOptionPane.showMessageDialog(null,  "Tie Game!");
		}
		
	}
	
	
	public static void main(String[] args) {
		
		new Tictactoe();
		
		
	} */

	
	
	
