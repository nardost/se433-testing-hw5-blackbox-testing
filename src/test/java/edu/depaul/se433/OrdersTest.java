package edu.depaul.se433;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	OrdersStrongNormalTest.class,
	OrdersStrongRobustnessTest.class,
	OrdersStrongNormalBoundaryTest.class,
	OrdersStrongRobustnessBoundaryTest.class,
	OrdersStrongNormalSpecialValueTest.class,
	OrdersWeakRobustnessSpecialValueTest.class
})
public class OrdersTest {
}
