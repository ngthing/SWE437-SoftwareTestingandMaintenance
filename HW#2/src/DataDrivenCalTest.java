import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.*;
import java.util.*;

@RunWith (Parameterized.class)
public class DataDrivenCalTest {
	public int month1, month2, day1, day2, year, numDays;

	public DataDrivenCalTest(int m1, int d1, int m2, int d2, int year, int expectedNumDays){
		this.month1 = m1; this.day1 = d1;
		this.month2 = m2; this.day2 = d2;
		this.year = year;
		this.numDays = expectedNumDays;
	}
	
	@Parameters public static Collection<Object[]> parameters(){
		return Arrays.asList(new Object[][]{
			{2,1,4,2,2016,61}, // Leap year 2016, m1=2, d1=1, m2=4, d2=2, expected = 60
			{2,1,4,2,2016,60},
		});
	}

//	Test is numDays returned correctly with input is leap year
	@Test public void leapYearTest(){
		
	}
	
	@Test public void day2GreaterThanOrEqualDay1Test(){
		
	}
}
