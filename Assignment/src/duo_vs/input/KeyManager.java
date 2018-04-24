package duo_vs.input;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {
	
	private boolean[] keys;
	public boolean UP, DOWN, S, W, enter;
	
	public KeyManager(){
		keys = new boolean[256];
	}

	// Getters
	
	public boolean isW()
	{
		return W;
	}
	
	public boolean isS()
	{
		return S;
	}
	
	public boolean isUP()
	{
		return UP;
	}
	
	public boolean isDOWN()
	{
		return DOWN;
	}
	
	public boolean isENTER()
	{
		return enter;
	}
	
	public void tick(){
		W = keys[KeyEvent.VK_W];
		S = keys[KeyEvent.VK_S];
		UP = keys[KeyEvent.VK_UP];
		DOWN = keys[KeyEvent.VK_DOWN];
		enter = keys[KeyEvent.VK_ENTER];
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}
