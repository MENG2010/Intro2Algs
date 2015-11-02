package lab16;

public class Square {
	private int length;
	
	public Square() {
		this.length = 1;
	}
	
	public void setLength(int length) throws DimensionException {
		if (length < 0 || length > Math.sqrt(Integer.MAX_VALUE)) {
			throw new DimensionException("Invalid length!");
		}
		this.length = length;
		
	}

	public void draw() {
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}

	public int getArea() {
		return (length*length);
	}

	public int getPerimeter() {
		return (length*4);
	}

}
