package exception;


//Thrown when an input is found to be invalid, 
//due to the context's constraints
public class InputException extends Exception{
	
	private String message;
	
	public InputException(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}
