package lab16;

public class DimensionException extends Exception {
	public DimensionException() {
		super("DimensionException! Invalid value of dimension!");
	}
	
	public DimensionException(String message) {
		super(message);
	}
	
	public DimensionException(Throwable cause) {
		super(cause);
	}
	
	public DimensionException(String message, Throwable cause) {
		super(message, cause);
	}
	
	@Override
	public String getMessage() {
		return "DimensionException! " + super.getMessage();
		
	}
}
