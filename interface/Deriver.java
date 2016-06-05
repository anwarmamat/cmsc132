/**
 * 		Interface with default method
 */

//package example;

public class Deriver implements InterfaceA,InterfaceB{

	@Override
	public void fooA() {
		System.out.println("FooA");
		
	}

	@Override
	public void fooB() {
		System.out.println("FooB");	
	}
	
	/**
	 * 	We have to override bar because both InterfaceA and InterfaceB
	 *  have default implementation of bar
	 */
	@Override
	public void bar() {
		System.out.println("bar");
		//InterfaceB.super.bar();
	}
	
	public static void main(String[] args) {	
		Deriver m = new Deriver();
		m.fooA();	
		m.fooB();
		m.sayHi();//InterfaceA's default method
		m.bar();	//both InterfaceA and InterfaceB have default method bar. 
	}
}
