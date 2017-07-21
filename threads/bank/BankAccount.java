public class BankAccount
{
   private double balance;
   public BankAccount()
   {
      balance = 0;
   }
   // not synchronized
   public  void deposit(double amount)
   {
   	//here
   	//	synchronized(this){
        	balance = balance + amount;    
    //    	}
        //here
   }
   public double getBalance()
   {
      return balance;
   }
}