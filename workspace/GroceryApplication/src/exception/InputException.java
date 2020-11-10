package exception;


//Thrown when an error occurs during an input operation
public class InputException extends Exception{
	
	private String message;
	
	public InputException(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}
