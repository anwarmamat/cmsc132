
public class EmptyQueueException extends RuntimeException{
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
