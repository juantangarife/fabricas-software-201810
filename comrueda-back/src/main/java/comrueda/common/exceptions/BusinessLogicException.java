package comrueda.common.exceptions;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class BusinessLogicException extends Exception {

	private static final long serialVersionUID = -1939293097963873889L;

	public BusinessLogicException() {
    }

    public BusinessLogicException(String message) {
        super(message);
    }

    public BusinessLogicException(Throwable cause) {
        super(cause);
    }
    
    public BusinessLogicException(String message, Throwable cause) {
        super(message, cause);
    }

}
