class HelloThread extends Thread{
	int id;
	HelloThread(int id){this.id = id;}
	
	@Override 
	public void run() {
    	try{
    		for(int i=0; i < 5; i++){
     			System.out.println( "Hello from thread " + id);
     			sleep(200);
     		}
     	}catch (InterruptedException iex) {}
    }
}