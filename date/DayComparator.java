import java.util.Comparator;


public class DayComparator implements Comparator<Date>{

	@Override
	public int compare(Date o1, Date o2) {
		if(o1.getDay() < o2.getDay()) return -1;
		if(o1.getDay() > o2.getDay()) return 1;		
		return 0;
	}

}
