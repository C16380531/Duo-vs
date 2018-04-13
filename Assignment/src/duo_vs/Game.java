package duo_vs;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;


import duo_vs.display.Display;

public class Game implements Runnable {

	private Display display;
	private int width, height;
	public String title;

	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	
	public Game(String title, int width, int height)
	{
		this.width = width;
		this.height = height;
		this.title = title;
	}
	
	private void init()
	{
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
	

	public synchronized void start(){
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop(){
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}