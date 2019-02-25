package edu.depaul.se433;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	StringUtilStrongNormalTest.class,
	StringUtilStrongRobustnessTest.class
})
public class StringUtilTest {
}
