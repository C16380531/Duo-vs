/* 
    Team Name: Duo-vs.
    Course: DT228/2.
    Module: Object Oriented Programming.
    Type: OOP assignment 2.
*/

package duo_vs;

//import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;


import duo_vs.display.Display;

//implements runnable allows to run on thread
public class Game implements Runnable 
{
	//objects
	private Display display;
	
	//variables
	private int width, height;
	public String title;
	private boolean running = false;
	
	private BufferStrategy bs;
	private Graphics g;
	private Thread thread;
	

	//Constructor
	public Game(String title, int width, int height)
	{
		this.width = width;
		this.height = height;
		this.title = title;
	}
	
	//initialize all graphics
	private void init()
	{
		//Initialize display
		display = new Display(title, width, height);
	
	}
	
	private void tick()
	{
		
	}
	
	private void render(){
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		//Clear Screen
		g.clearRect(0, 0, width, height);
		//Draw Here!

		//End Drawing!
		bs.show();
		g.dispose();
	}
	
	public void run()
	{
		
		init();

	    while(running)
		{
				render();
				tick();
		}
			
		stop();
		
	}
	
	//checks to make sure its running when start() called
	public synchronized void start()
	{
		if(running)
			return;
		running = true;
		//initialize thread
		thread = new Thread(this);
		thread.start();
	}
	
	//checks to make sure stopped when stop() called
	public synchronized void stop()
	{
		if(!running)
			return;
		running = false;
		try 
		{
			thread.join();
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
	
}