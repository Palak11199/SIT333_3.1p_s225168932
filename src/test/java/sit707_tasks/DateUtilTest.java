package sit707_tasks;

import java.util.Random;
import org.junit.Assert;
import org.junit.Test;

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
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldIncrementToFebruary1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(1, date.getDay());
	}
	
	@Test
	public void testMaxJanuary31ShouldDecrementToJanuary30() {
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

	@Test
	public void testMinJanuary1ShouldIncrementToJanuary2() {
	    DateUtil date = new DateUtil(1, 1, 2024);
	    System.out.println("testMinJanuary1ShouldIncrementToJanuary2 > " + date);
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(2, date.getDay());
	    Assert.assertEquals(1, date.getMonth());
	}
	
	@Test
	public void testMinJanuary1ShouldDecrementToDecember31() {
		DateUtil date = new DateUtil(1, 1, 2024);
		System.out.println("testMinJanuary1ShouldDecrementToDecember31 > " + date);
		date.decrement();
		System.out.println(date);
		Assert.assertEquals(31, date.getDay());
		Assert.assertEquals(12, date.getMonth());
		Assert.assertEquals(2023, date.getYear());
	}
	
	@Test
	public void testFeb28ShouldIncrementToFeb29_LeapYear() {
	    DateUtil date = new DateUtil(28, 2, 2024);
	    System.out.println("testFeb28ShouldIncrementToFeb29_LeapYear > " + date);
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(29, date.getDay());
	    Assert.assertEquals(2, date.getMonth());
	}

	@Test
	public void testFeb29ShouldIncrementToMarch1() {
	    DateUtil date = new DateUtil(29, 2, 2024);
	    System.out.println("testFeb29ShouldIncrementToMarch1 > " + date);
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(1, date.getDay());
	    Assert.assertEquals(3, date.getMonth());
	}
	
	@Test
	public void testApril30ShouldIncrementToMay1() {
	    DateUtil date = new DateUtil(30, 4, 2024);
	    System.out.println("testApril30ShouldIncrementToMay1 > " + date);
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(1, date.getDay());
	    Assert.assertEquals(5, date.getMonth());
	}
	
	@Test
	public void testDec31ShouldIncrementToJan1NextYear() {
	    DateUtil date = new DateUtil(31, 12, 2024);
	    System.out.println("testDec31ShouldIncrementToJan1NextYear > " + date);
	    date.increment();
	    System.out.println(date);
	    Assert.assertEquals(1, date.getDay());
	    Assert.assertEquals(1, date.getMonth());
	    Assert.assertEquals(2025, date.getYear());
	}
	
	@Test(expected = RuntimeException.class)
	public void testInvalidDateShouldThrowException() {
	    System.out.println("testInvalidDateShouldThrowException");
	    new DateUtil(31, 4, 2024);
	}
	// ================= EQUIVALENCE CLASS TESTING =================

	// Valid normal case
	@Test
	public void testECT_ValidNormalDate() {
	    DateUtil date = new DateUtil(15, 6, 2024);
	    System.out.println("testECT_ValidNormalDate > Before: " + date);
	    date.increment();
	    System.out.println("After Increment: " + date);
	    Assert.assertEquals(16, date.getDay());
	}

	// 30-day month class
	@Test
	public void testECT_30DayMonth() {
	    DateUtil date = new DateUtil(30, 4, 2024);
	    System.out.println("testECT_30DayMonth > Before: " + date);
	    date.increment();
	    System.out.println("After Increment: " + date);
	    Assert.assertEquals(1, date.getDay());
	    Assert.assertEquals(5, date.getMonth());
	}

	// 31-day month class
	@Test
	public void testECT_31DayMonth() {
	    DateUtil date = new DateUtil(31, 1, 2024);
	    System.out.println("testECT_31DayMonth > Before: " + date);
	    date.increment();
	    System.out.println("After Increment: " + date);
	    Assert.assertEquals(1, date.getDay());
	    Assert.assertEquals(2, date.getMonth());
	}

	// February class (leap year)
	@Test
	public void testECT_FebruaryLeapYear() {
	    DateUtil date = new DateUtil(29, 2, 2024);
	    System.out.println("testECT_FebruaryLeapYear > Before: " + date);
	    date.increment();
	    System.out.println("After Increment: " + date);
	    Assert.assertEquals(1, date.getDay());
	    Assert.assertEquals(3, date.getMonth());
	}

	// Invalid Day (low)
	@Test(expected = RuntimeException.class)
	public void testECT_InvalidDayLow() {
	    System.out.println("testECT_InvalidDayLow > Trying day = 0");
	    new DateUtil(0, 5, 2024);
	}

	// Invalid Day (high)
	@Test(expected = RuntimeException.class)
	public void testECT_InvalidDayHigh() {
	    System.out.println("testECT_InvalidDayHigh > Trying day = 32");
	    new DateUtil(32, 5, 2024);
	}

	// Invalid Month
	@Test(expected = RuntimeException.class)
	public void testECT_InvalidMonthHigh() {
	    System.out.println("testECT_InvalidMonthHigh > Trying month = 13");
	    new DateUtil(10, 13, 2024);
	}

	// Invalid Year
	@Test(expected = RuntimeException.class)
	public void testECT_InvalidYearLow() {
	    System.out.println("testECT_InvalidYearLow > Trying year = 1600");
	    new DateUtil(10, 5, 1600);
	}
}