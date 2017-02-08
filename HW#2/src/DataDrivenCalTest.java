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
			// Input in order: m1, d1, m2, d2, year, expectedNumDays
			{1,1,1,31,2016,30}, // Test same month, numDays = d2-d1
			{2,1,3,1,2020,29},  // Leap year
			{3,1,2,1,2016,}, // Test the precondition invalid when input m2<m1 ? what happen to output?
		});
	}

	@Test public void calTest(){
		
	}
	
	@Test public void day2GreaterThanOrEqualDay1Test(){
		
	}
}
