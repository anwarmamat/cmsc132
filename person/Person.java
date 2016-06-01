

public class Person {
	private String name; 
	
	public Person(){
		name = "noname"; 
	}
	public Person(String name){
		this.name = name;
	}
	public void setName(String newName) {
		name = newName;
	}
	
	public String getName(){
		return name;
	}
	
	@Override
	public String toString(){
		return "Name:"+name;
	}
}
