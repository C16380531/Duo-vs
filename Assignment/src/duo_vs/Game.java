/* 
    Team Name: Duo-vs.
    Course: DT228/2.
    Module: Object Oriented Programming.
    Type: OOP assignment 2.
*/

package duo_vs;

//plug ins
import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferStrategy;

//imported classes
import duo_vs.display.Display;
import duo_vs.state.GameState;
import duo_vs.state.State;
import duo_vs.input.KeyManager;
import duo_vs.input.MouseManager;
import duo_vs.Handler;

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
	
	//States
	public State gameState;
	
	//Input
	private KeyManager keyManager;
	private MouseManager mouseManager;

	//Handler
	private Handler handler;

	int p1=0;
	
	//Constructor
	public Game(String title, int width, int height)
	{
		this.width = width;
		this.height = height;
		this.title = title;
		
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
	}
	
	//initialize all graphics
	private void init()
	{
		display = new Display(title, width, height);
		
		display.getFrame().addKeyListener(keyManager);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		
		handler = new Handler(this);
		
		//state
		gameState = new GameState(handler);
		
		State.setState(gameState);
	}
	
	private void tick()
	{
		keyManager.tick();
		
		if(State.getState() != null)
			State.getState().tick();
	}
	
	private void render()
	{
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		//Clear Screen
		g.clearRect(0, 0, width, height);
		//Draw Here!
		g.setColor(Color.black);
		g.fillRect(0, 0, width , height);
		
		if(State.getState() != null)
			State.getState().render(g);

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
	

	public KeyManager getKeyManager(){
		return keyManager;
	}
	
	public MouseManager getMouseManager()
	{
		return mouseManager;
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