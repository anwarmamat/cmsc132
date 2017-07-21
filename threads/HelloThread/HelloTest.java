class HelloTest{
	public static void main(String[] args){
		Thread t1 = new HelloThread(1);
		Thread t2 = new HelloThread(2);
		t1.start();
		t2.start();
		try{
			for(int i = 0; i <5; i++){
				System.out.println("Hello from main\n");
				Thread.sleep(500);
			}
		}catch (InterruptedException iex) {}
	}
}