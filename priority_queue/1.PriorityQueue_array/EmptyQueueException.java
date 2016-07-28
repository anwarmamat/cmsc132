
public class EmptyQueueException extends RuntimeException{
	private static final long serialVersionUID = 127;
   public EmptyQueueException ()
    {
        super ();

    }; // EmptyQueueException


    /*****************************************************************
     * Constructor with a message.
     * @param  message  further information
     */
    public EmptyQueueException (String message)
    {
        super (message);

    }; // EmptyQueueException 
}
