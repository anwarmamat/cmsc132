package bag;

public class Student implements Comparable<Student>{
	public String name;
	private double gpa;
	public Student(String name, double gpa){
		this.name = name;
		this.gpa = gpa;
	}
	
	@Override
	public int compareTo(Student o) {
		//return name.compareTo(o.name);
		if (gpa == o.gpa) return 0;
		else if (gpa < o.gpa) return 1;
		else return -1;
	}
	
}
