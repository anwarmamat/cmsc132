
package Fraction;
public class UnitTest {
    public static void main(String[] args) {
        
    		Fraction f1 = new Fraction(2,10);
        Fraction f2 = new MixedFraction(1,2,10);
        System.out.println("f1=" + f1);
        System.out.println("f2 = " + f2);
        MixedFraction f3 = new MixedFraction(f2.add(f1));
        System.out.println(f1 + "+" +  f2 +  "=" + f3);
        Fraction f4 = f2.sub(f1);
        System.out.println(f2 + "-" +  f1 +  "=" + f4);   
        Fraction f5 = f1.mul(f2);
        System.out.println(f1 + "*" +  f2 +  "=" + f5);
        Fraction f6 = f1.div(f2);
        System.out.println(f1 + " / " +  f2 +  "=" + f6);
        
        Fraction f10 = new Fraction(50,100);
        Fraction f11 = new Fraction(5,10);
        if(f10.equals(f11)){
        	System.out.println("euqal");
        }else{
        	System.out.println("NOT euqal");
        }
        
        //try {
            Fraction f12 = new Fraction(10, 0);
        //}
        //catch (IllegalArgumentException e) {
        //        System.out.println(e);
       // }
        
    	System.out.println("Done");
    }
}
