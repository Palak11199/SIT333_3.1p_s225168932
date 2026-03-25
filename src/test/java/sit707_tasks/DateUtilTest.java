package sit707_tasks;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;


/**
 * @author Ahsan Habib
 */
public class DateUtilTest {
	
	@Test
	public void testStudentIdentity() {
		String studentId = "225168932";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Palak Rani";
		Assert.assertNotNull("Student name is null", studentName);
	}

	@Test
	public void testMaxJanuary31ShouldIncrementToFebruary1() {
		// January max boundary area: max+1
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldIncrementToFebruary1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(1, date.getDay());
	}
	
	@Test
	public void testMaxJanuary31ShouldDecrementToJanuary30() {
		// January max boundary area: max-1
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldDecrementToJanuary30 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(1, date.getMonth());
	}
	
	@Test
	public void testNominalJanuary() {
		int rand_day_1_to_31 = 1 + new Random().nextInt(31);
        DateUtil date = new DateUtil(rand_day_1_to_31, 1, 2024);
        System.out.println("testJanuaryNominal > " + date);
        date.increment();
        System.out.println(date);
	}
	
	/*
	 * Complete below test cases.
	 */
	
	@Test
	public void testMinJanuary1ShouldIncrementToJanuary2() {
	    DateUtil date = new DateUtil(1, 1, 2024);
	    date.increment();
	    Assert.assertEquals(2, date.getDay());
	    Assert.assertEquals(1, date.getMonth());

	}
	
	@Test
	public void testMinJanuary1ShouldDecrementToDecember31() {
		 DateUtil date = new DateUtil(1, 1, 2024);
		    date.decrement();
		    Assert.assertEquals(31, date.getDay());
		    Assert.assertEquals(12, date.getMonth());
		    Assert.assertEquals(2023, date.getYear());
	}
	
	@Test
	public void testFeb28ShouldIncrementToFeb29_LeapYear() {
	    DateUtil date = new DateUtil(28, 2, 2024);
	    date.increment();
	    Assert.assertEquals(29, date.getDay());
	    Assert.assertEquals(2, date.getMonth());
	}

	@Test
	public void testFeb29ShouldIncrementToMarch1() {
	    DateUtil date = new DateUtil(29, 2, 2024);
	    date.increment();
	    Assert.assertEquals(1, date.getDay());
	    Assert.assertEquals(3, date.getMonth());
	}
	
	@Test
	public void testApril30ShouldIncrementToMay1() {
	    DateUtil date = new DateUtil(30, 4, 2024);
	    date.increment();
	    Assert.assertEquals(1, date.getDay());
	    Assert.assertEquals(5, date.getMonth());
	}
	
	@Test
	public void testDec31ShouldIncrementToJan1NextYear() {
	    DateUtil date = new DateUtil(31, 12, 2024);
	    date.increment();
	    Assert.assertEquals(1, date.getDay());
	    Assert.assertEquals(1, date.getMonth());
	    Assert.assertEquals(2025, date.getYear());
	}
	
	@Test(expected = RuntimeException.class)
	public void testInvalidDateShouldThrowException() {
	    new DateUtil(31, 4, 2024); // April has 30 days
	}
}
