import java.util.Arrays;


public class Date  implements Comparable<Date>{
	private static final int[]
			DAYS={0,31,29,31,30,31,30,31,31,30,31,30,31};
			private int year;
			private int month;
			private int day;
	public Date(int y,int m,int d){
		if(!isValid(y,m,d)){System.out.println("Invalid date");}
		year = y;
		month = m;
		day = d;
	}
	public int getMonth(){return month;}
	public int getyear(){return year;}
	public int getDay(){return day;}
	
	private boolean isValid(int y, int m, int d){
		if(m < 1 || m > 12) {return false;}
		if( d < 1 || d > DAYS[m]) {return false;}
		if(m == 2 && d == 29 && !isLeapYear(y)) return false;
		return true;
	}
	private boolean isLeapYear(int y){
		return ( (y % 400 == 0) || (y % 4 == 0 && y % 100 != 0));
	}
	public String toString(){
		return month +"/" + day +"/" + year;
	}
	public static void main(String[] args){
		Date[] date = new Date[3];
		date[0] = new Date(2014,5,21);
		date[1] = new Date(2013,10,28);
		date[2] = new Date(2011,1,25);
		
		Arrays.sort(date);	//use default compareTo
		//Arrays.sort(date, new MonthComparator());	//compares by month
		for(Date d:date){
			System.out.println(d);
		}
		
	}
	@Override
	public int compareTo(Date other) {
		if(year < other.year) return -1;
		if(year > other.year) return 1;
		if(month < other.month) return -1;
		if(month > other.month) return 1;
		if(day < other.day) return -1;
		if(day > other.day) return 1;
		
		return 0;
	}
}
