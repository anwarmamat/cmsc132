public class BankTest {
     public static void main(String[] args){
        BankAccount account = new BankAccount();
        DepositRunnable d = new DepositRunnable(account, 100, 10);
        for (int i = 1; i <= 10; i++){
         	Thread dt = new Thread(d);
         	dt.start();
        }
   }
}