package lab15;

/**
 * 
 * @author meng
 * https://cse.sc.edu/~shephejj/csce145/Labs/Lab15.html
 */
public class Diamond extends ShapeBasics implements DiamondInterface{
	private int width;
	private int offset;
	
	public Diamond() {
		this.width = 0;
	}
	
	public Diamond(int width, int offset) {
		super(offset);
		this.width = width;
	}
	
	public void setWidth(int width) {
		if (width < 0) {
			System.err.println("width cannot be negative!");
			System.exit(0);
		}
		
		this.width = width;
	}
	

	public void drawHere() {
		drawTopV();
		drawBottomV();
		
	}
	
	private void drawTopV() {
		int startpoint = 0;
		int endpoint = (int) Math.ceil((width - 1)/2);
		
		// draw the topV row by row
		for (int row = startpoint; row <= endpoint; row++) {
			drawOneRow((endpoint - row), row * 2);
			System.out.println();
		}
	}
	
	private void drawBottomV() {
		int startpoint = (int) Math.ceil(width/2);
		int endpoint = (width - 1);
		
		// for an odd-width diamond, topV and bottomV share the same largest edge
		// so rows in bottomV is less than that of the topV.
		int row = ((width % 2) == 0) ? startpoint : (startpoint + 1);
		
		// draw the bottomV row by row
		for (; row <= endpoint; row++) {
			drawOneRow((row - startpoint), (endpoint - row) * 2);
			System.out.println();
		}
	}
	
	private void drawOneRow(int skipBefore, int skipAfter) {
		if (skipAfter == 0) {
			// only one node to print
			// the topmost row and the bottom-most row
			skipSpaces(skipBefore);
			System.out.print("*");
		} else {
			// print 
			skipSpaces(skipBefore);
			System.out.print("*");
			skipSpaces(skipAfter);
			System.out.print("*");
		}
	}
	
    //Writes the indicated number of spaces.
    private static void skipSpaces(int number) {
        for (int count = 0; count < number; count++)
            System.out.print(' ');
    }
	
}
