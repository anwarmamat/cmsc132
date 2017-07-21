class HelloTest{
	public static void main(String[] args){
		Runnable r1 = new HelloRunnable();
		Runnable r2 = new HelloRunnable();
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
		try{
			for(int i = 0; i <5; i++){
				System.out.println("Hello from main\n");
				Thread.sleep(400);
			}
		}catch (InterruptedException iex) {}
		try 
		    {
			t1.join();
			t2.join();
		    } 
		catch(InterruptedException e)
		    {
			// this part is executed when an exception (in this example InterruptedException) occurs
		    }

		System.out.println("Main done.");
	}
}
