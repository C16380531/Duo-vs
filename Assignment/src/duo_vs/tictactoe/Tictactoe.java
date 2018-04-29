package duo_vs.tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//import duo_vs.Game;
//import java.awt.Color;
//import java.awt.Graphics;

public class Tictactoe implements ActionListener 
{
	
	// Instance Variables
	//private Game game;
	
	///private JFrame window = new JFrame ("TIC-TAC-TOE");
	
	private JButton button1 = new JButton("");
	private JButton button2 = new JButton("");
	private JButton button3 = new JButton("");
	private JButton button4 = new JButton("");
	private JButton button5 = new JButton("");
	private JButton button6 = new JButton("");
	private JButton button7 = new JButton("");
	private JButton button8 = new JButton("");
	private JButton button9 = new JButton("");
	private JButton button10 = new JButton("");
	private JButton button11 = new JButton("");
//	private JButton btnReset = new JButton("Reset");
	private String letter ="";
	private int count = 0;
	private boolean win = false;

	public Tictactoe() {

	}
	public void draw()
	{
		//create window

		//	window.setSize(300, 300);
		//	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setLayout(new GridLayout(3,3));
			
			// Add buttons to window
			
			add(button1);
			add(button2);
			add(button3);
			add(button4);
			add(button5);
			add(button6);
			add(button7);
			add(button8);
			add(button9);
			
			//add action to button
			
			button1.addActionListener(this);
			button2.addActionListener(this);
			button3.addActionListener(this);
			button4.addActionListener(this);
			button5.addActionListener(this);
			button6.addActionListener(this);
			button7.addActionListener(this);
			button8.addActionListener(this);
			button9.addActionListener(this);
	}
	public void setLayout(GridLayout gridLayout) {
		// TODO Auto-generated method stub
		
	}
	public void add(JButton button92) {
		// TODO Auto-generated method stub

		
	}
	public void tick()
	{
		draw();
	}
	public void render(Graphics g)
	{
	//	g.draw3DRect(60, 60, 79, 79, true);
	}
	public void actionPerformed(ActionEvent a) 
	{
		
		/*if(a.getSource() == btnReset) {
			window.getContentPane().removeAll();*/
			
			count ++;
		
		//calculate whos turn it is
		
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
		//Vertical wins
		else if (button1.getText() == button4.getText()
				&& button4.getText() == button7.getText()
				&& button1.getText() != "") {}
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
			JOptionPane.showMessageDialog(null,  "Tie Game!");}
		
	
	}

	/*

	public static void main(String[] args) {
		
		new Tictactoe();
		
		
	}

	*/
	
}
	
