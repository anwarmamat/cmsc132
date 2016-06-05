//package example;

public interface InterfaceB {
	public void fooB();
	default public void bar(){
		System.out.println("Bar in InterfaceB");
	}
}
