package duo_vs.breakout;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		JFrame obj = new JFrame();
		Game game = new Game();
			obj.setBounds(10,10,700,550); obj.setTitle("Breakout!");
			obj.setResizable(false); obj.setVisible(true); obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			obj.add(game); }
}