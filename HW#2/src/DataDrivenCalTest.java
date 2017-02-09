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
			{1,3,31,31,2017,59},
			// Test leap year
			// The following are some leap year: 1904, 1908, 1912,2004,2008
			{2,3,1,1,1904,29},
			{2,3,1,1,1908,29},
			{2,3,1,1,1912,29},
			{1,12,1,31,2004,365},
			{2,3,28,1,2008,2},
			{2,3,1,1,2020,29}, 
		});
	}

	@Test public void calHappyPathTest(){
	 assertTrue ("Calculate number of days between two dates Test", 
			 numDays == Cal.cal ( month1, day1, month2, day2, year)); 
	}
	
}
