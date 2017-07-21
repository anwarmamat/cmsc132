public class DepositRunnable implements Runnable
{
   private static final int DELAY = 100;
   private BankAccount account;
   private double amount;
   private int count;
   public DepositRunnable(BankAccount anAccount, double anAmount,
         int aCount)
   {
      account = anAccount;
      amount = anAmount;
      count = aCount;
   }

   public void run()
   {
      try
      {
         for (int i = 1; i <= count; i++)
         {
            account.deposit(amount);
            System.out.println("Balance:" + account.getBalance());
            Thread.sleep(DELAY);
         }
      }
      catch (InterruptedException exception) {}
    }
}