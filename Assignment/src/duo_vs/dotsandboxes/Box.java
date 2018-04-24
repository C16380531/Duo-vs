package duo_vs.dotsandboxes;

public class Box {

	int x, y;
	boolean full = false;
	
	public Box(int x, int y) {
		this.x = x;
		this.y = y;
		
	}
	
	public String toString() {
		return "x value: " + x + ". Y value: " + y + " Is filled in: " + full;
	}
	
	
}
