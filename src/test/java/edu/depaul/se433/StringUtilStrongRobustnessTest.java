package edu.depaul.se433;

import static edu.depaul.se433.StringUtil.pluralize;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class StringUtilStrongRobustnessTest {

	private String word;
	
	public StringUtilStrongRobustnessTest(String word) {
		this.word = word;
	}

	@Parameters(name = "SRT_{index}: ({0}) should cause IllegalArgumentException")
	public static Collection<String[]> data() {
		return (ArrayList<String[]>) Stream.of(new String[][] {
			{"Come"},
			{"አማርኛ"},
			{""},
			{null}
		}).collect(Collectors.toList());
	}

	@Test(expected = IllegalArgumentException.class)
	public void pluralize_throws_IllegalArgumentException_on_invalid_input() {
		pluralize(word);
	}
}
