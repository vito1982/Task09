package by.tc.task01.dao;

public class DAOException extends Exception {

	private static final long serialVersionUID = -5678002723989034292L;

	public DAOException() {
		super();
	}
	
	public DAOException(String message) {
		super(message);
	}
	
	public DAOException(Exception e) {
		super(e);
	}
	
	public DAOException(String message, Exception e) {
		super(message, e);
	}
	
}
