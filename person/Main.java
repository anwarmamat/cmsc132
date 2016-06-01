

public class Main {
	public static void main(String[] args){
		Person p = new Person();
		Student s = new Student("Alice",1);
		
		Person p2 = new Student("Bob",2); //This is ok because Student is-a Person.
		
		//Student s2 = new Person("Cathy"); //This is NOT ok because Person may not be Student.

		
		System.out.println("Peron:\t" + p);
		System.out.println("Student:\t" + s);
		
	}

}
