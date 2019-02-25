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

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class StringUtilStrongNormalTest {

	private String word;
	private String expectedPlural;

	public StringUtilStrongNormalTest(String word, String expectedPlural) {
		this.word = word;
		this.expectedPlural = expectedPlural;
	}

	@Parameters(name = "SNT_{index}: plural of {0} should be {1}")
	public static Collection<String[]> data() {
		return (ArrayList<String[]>) Stream.of(new String[][] {
			{"Ox", "Oxen"},
			{"Fox", "Foxes"},
			{"Wolf", "Wolves"},
			{"Fly", "Flies"},
			{"Monkey", "Monkeys"},
			{"Potato", "Potatoes"},
			{"Locus", "Loci"},
			{"Crisis", "Crises"},
			{"Automaton", "Automata"},
			{"Cats", "Cats"},
			{"Cow", "Cows"},
		}).collect(Collectors.toList());
	}

	@Test
	public void pluralize_returns_plural_form_of_word() {
		assertEquals(expectedPlural.toLowerCase(), pluralize(word).toLowerCase());
	}
}
