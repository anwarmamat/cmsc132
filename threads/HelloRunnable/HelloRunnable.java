class HelloRunnable implements Runnable{
	@Override 
	public void run() {
    	try{
    		for(int i=0; i < 5; i++){
     			System.out.println( "Hello from thread 1");
     			Thread.sleep(500);
     		}
     	}catch (InterruptedException iex) {}
    }
}