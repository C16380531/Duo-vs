/* 
    Team Name: Duo-vs.
    Course: DT228/2.
    Module: Object Oriented Programming.
    Type: OOP assignment 2.
*/

package duo_vs.display;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Display 
{

	// use JFrame to create window and canvas to draw graphics
	private JFrame frame;
	private Canvas canvas;
	
	// variables
	private String title;
	private int width, height;
	
	//Constructor
	public Display(String title, int width, int height)
	{
		//use this. cause names are same thing
		this.title = title;
		this.width = width;
		this.height = height;
		
		createDisplay();
	}
	
	private void createDisplay()
	{
		//Initialize JFrame
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		//Initialize Canvas
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setFocusable(false);
		//canvas.setBackground(Color.black);
		
		//add canvas to frame
		frame.add(canvas);
		frame.pack();
	}

	//Use getCanvas to access canvas in other classes
	public Canvas getCanvas()
	{
		return canvas;
	}
	
	//Use getFrame to access frame in other classes
	public JFrame getFrame()
	{
		return frame;
	}
	
}
