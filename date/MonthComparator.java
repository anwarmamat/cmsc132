import java.util.Comparator;


public class MonthComparator implements Comparator<Date>{

	@Override
	public int compare(Date o1, Date o2) {
		if(o1.getMonth() < o2.getMonth()) return -1;
		if(o1.getMonth() > o2.getMonth()) return 1;		
		return 0;
	}

}
