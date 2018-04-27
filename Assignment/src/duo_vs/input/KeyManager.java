package duo_vs.input;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {
	
	private boolean[] keys;
	public boolean UP, DOWN, S, W, A, D, RIGHT, LEFT, enter;
	
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
	
	public boolean isA()
	{
		return A;
	}
	
	public boolean isD()
	{
		return D;
	}
	
	public boolean isUP()
	{
		return UP;
	}
	
	public boolean isDOWN()
	{
		return DOWN;
	}
	
	public boolean isLEFT()
	{
		return LEFT;
	}
	
	public boolean isRIGHT()
	{
		return RIGHT;
	}
	
	public boolean isENTER()
	{
		return enter;
	}
	
	public void tick(){
		W = keys[KeyEvent.VK_W];
		S = keys[KeyEvent.VK_S];
		A = keys[KeyEvent.VK_A];
		D = keys[KeyEvent.VK_D];
		UP = keys[KeyEvent.VK_UP];
		DOWN = keys[KeyEvent.VK_DOWN];
		LEFT = keys[KeyEvent.VK_LEFT];
		RIGHT = keys[KeyEvent.VK_RIGHT];
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
