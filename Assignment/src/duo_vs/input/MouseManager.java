package duo_vs.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseManager implements MouseListener, MouseMotionListener 
{

	private boolean leftPressed, rightPressed, clicked;
	private int mouseX, mouseY;
	
	public MouseManager()
	{
		
	}
	
	// Getters
	
	public boolean isLeftPressed()
	{
		return leftPressed;
	}
	
	public boolean isRightPressed()
	{
		return rightPressed;
	}
	
	public int getMouseX()
	{
		return mouseX;
	}
	
	public int getMouseY()
	{
		return mouseY;
	}
	
	public boolean isClicked()
	{
		return clicked;
		
	}
	// Implemented methods
	
	@Override
	public void mousePressed(MouseEvent e) 
	{
		if(e.getButton() == MouseEvent.BUTTON1)
			leftPressed = true;
		    clicked = true;
	    if(e.getButton() == MouseEvent.BUTTON3)
			rightPressed = true;
	}

	@Override
	public void mouseReleased(MouseEvent e) 
	{
		if(e.getButton() == MouseEvent.BUTTON1)
			leftPressed = false;
		    clicked = true;
		    mouseX = 0;
		    mouseY = 0;
		    
	    if(e.getButton() == MouseEvent.BUTTON3)
			rightPressed = false;
	}

	@Override
	public void mouseMoved(MouseEvent e) 
	{
		mouseX = e.getX();
		mouseY = e.getY();
	}

	@Override
	public void mouseDragged(MouseEvent arg0) 
	{
		// TODO Auto-generated method stub
		
	}

	public void mouseClicked(MouseEvent e)
	{
		
		//clicked = true;
		// TODO Auto-generated method stub
		mouseX = e.getX();
		mouseY = e.getY();
		System.out.println(mouseX + " " + mouseY);
		//onClick();
		clicked =  false;
		
	
		
	}
	
	
	/*
	public void onClick() 
	{
		
		for( int i = 25; i < 750; i += 50) 
		{
			for(int j = 100; j < 750; j+= 50 ) 
			{
				if( mouseX >i && mouseX < i+50 && mouseY > j && mouseY < j+50)
				{
					
					Game.fillLine(i,j);
					System.out.println("hello1");
					
				}
					
			}
		}
		
	}*/

	@Override
	public void mouseEntered(MouseEvent arg0) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) 
	{
		// TODO Auto-generated method stub
		
	}
}