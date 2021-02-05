package edu.jespinoza.testng;

import edu.jespinoza.testng.impl.CalculatorImpl;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGTimeOutExample {
    private static final Logger logger = Logger.getLogger(TestNGTimeOutExample.class);

    private Calculator calculator;

    @BeforeClass
    public void setup() {
        logger.info("setup()");
        calculator = CalculatorImpl.getInstance();
    }

    @AfterClass
    public void tearDown() {
        logger.info("tearDown()");
        calculator = null;
    }

    @BeforeMethod
    public void beforeMethod() {
        logger.info("beforeMethod()");
    }

    @AfterMethod
    public void afterMethod() {
        logger.info("afterMethod()");
    }

    @Test
    public void testAdd() {
        logger.info("testAdd()");
        Assert.assertEquals(calculator.add(3, 4), 7.0);
    }

    @Test(timeOut = 3000)//timeout in milliseconds
    public void testSubtract() throws InterruptedException {
        logger.info("testSubtract()");
        Assert.assertEquals(calculator.subtract(5, 2), 3.0);
    }
}