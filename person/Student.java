
public class Student extends Person{
	private int id; 
	public Student() {
		id = 0; 
	}
	public Student(String stdName, int idNumber) {
		super(stdName);
		setID(idNumber);
	}
	public void setID(int idNumber) {
		id = idNumber;
	}
	
	public int getID(){
		return id; 
	}
	
	@Override
	public String toString(){
		return "Id:"+ id +"\tName:" + getName();
	}

}
