//package example;

public interface InterfaceA {
	public void fooA();
	
	default public void sayHi(){
		System.out.println("Hi from InterfaceA");
	}
	default public void bar(){
		System.out.println("Bar in InterfaceA");
	}
}
