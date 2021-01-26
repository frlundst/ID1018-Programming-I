package eu3;

public class NotValidFieldException extends Exception {
	private String exception;
	
	public NotValidFieldException(String string) {
		this.exception = string;
		System.out.println(this.exception);
	}
}
