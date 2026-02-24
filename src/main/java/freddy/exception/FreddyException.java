package freddy.exception;

/**
 * Exception class to handle error for program
 */
public class FreddyException extends Exception{

    /**
     * create a normal exception
     */
    public FreddyException(){
        super();
    }

    /**
     * Create an exception with desciption
     * @param s, error description
     */
    public FreddyException(String s){
        super(s);
    }

}
