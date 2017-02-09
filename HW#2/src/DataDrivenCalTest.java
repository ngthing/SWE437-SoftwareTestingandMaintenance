import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.*;
import java.util.*;

@RunWith (Parameterized.class)
public class DataDrivenCalTest {
	public int month1, month2, day1, day2, year, numDays;

	public DataDrivenCalTest(int m1, int m2, int d1, int d2, int year, int expectedNumDays){
		this.month1 = m1; this.month2 = m2;
		this.day1 = d1; this.day2 = d2;
		this.year = year;
		this.numDays = expectedNumDays;
	}
	
	@Parameters public static Collection<Object[]> parameters(){
		return Arrays.asList(new Object[][]{
			// Input in order: m1, m2, d1, d2, year, expectedNumDays
			// Test same month m1=m2, regular year
			{1,1,1,1,2016,0}, // d1 = d2
			{2,2,1,1,2017,0}, // d1 = d2
			{1,1,1,31,2016,30}, // d1 < d2
			{2,2,1,18,2017,17}, // d1 < d2
			
			// Test leap year
			// non-leap year: 2017
			// some leap year: 1904, 1908, 1912,2004,2008
			{1,3,31,31,2017,59},
			{2,3,1,1,1904,29},
			{2,3,1,1,1908,29},
			{2,3,1,1,1912,29},
			{1,12,1,31,2004,365},
			{2,3,28,1,2016,2},
			{2,3,1,1,2020,29}, 
			// continous month test
			{1,2,1,1,1921,31} ,
			{2,3,1,5,1921,32},
			{3,4,5,30,1923,56},
			{4,5,30,10,1973,10},
			{5,6,31,1,1991, 1},	//d1=last, d2=first DOM
			{6,7,30,31,1995,31},
			{7,8,1,1, 2001,31},	//d1 & d2=first DOM
			{8,9,20,20,2002,31},
			{9,10,30,29, 2003,29},
			{10,11,31,1, 1930,1},
			{11,12, 20, 5, 1715,15},
			//m2=m2+x where x>1	
			{1,3,1,1,1921,59},			
			{2,6,1,5,1921,124},
			{3,7,5,30,1923,147},
			{4,7,30,10,1973,71},
			{5,9,31,1,1991,93},
			{6,11,30,30,1995,153},	//both d1&d2 are last DOM
			{7,12,1,1, 2001,153},
			{8,11,20,20,2002, 92},
			{6,11,30,30,2002, 153},
			{1,12,30,29, 2003,333},
			{1,12,31,31, 1930, 334},
			{3,5,31,31, 1930, 61},
			{1,12,1,31,2001, 364},
			{3,12,31,31,2001, 275}
		});
	}

	@Test public void calHappyPathTest(){
	 assertTrue ("Calculate number of days between two dates Test", 
			 numDays == Cal.cal ( month1, day1, month2, day2, year)); 
	
	/* here is my version which display the dataset if the test is fail, 
	int retVal = Cal.cal(month1, day1, month2, day2, year);
	if (numDays != retVal) {
		String str = String.format("m1=%d, m2=%d, d1=%d, d2=%d, y=%d, expect numsday=%d, compute:%d",
				month1, month2, day1, day2, year, numDays, retVal);
		System.out.println(str);
		fail(str);
	*/
	}
}
