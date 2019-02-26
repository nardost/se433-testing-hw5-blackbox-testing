package edu.depaul.se433;

import static edu.depaul.se433.StringUtil.pluralize;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class StringUtilSpecialValueTest {
	private String word;
	private String firstPluralForm;
	private String secondPluralForm;
	
	public StringUtilSpecialValueTest(String word, String firstPluralForm, String secondPluralForm) {
		this.word = word;
		this.firstPluralForm = firstPluralForm;
		this.secondPluralForm = secondPluralForm;
	}

	@Parameters(name = "SVT_{index}: {0} -> {1}, {2}")
	public static Collection<String[]> data() {
		return (ArrayList<String[]>) Stream.of(new String[][] {
			{"Die", "Dice", "Dies"},
			{"Medium", "Media", "Mediums"},
			{"Staff", "Staves", "Staffs"},
			{"Referendum", "Referenda", "Referendums"},
			{"Syllabus", "Syllabuses", "Syllabi"},
			{"Gymnasium", "Gymnasiums", "Gymnasia"},
			{"Memorandum", "Memorandums", "Memoranda"},
			{"Appendix", "Appendixes", "Appendices"},
			{"Terminus", "Termini", "Terminuses"}
		}).collect(Collectors.toList());
	}

	@Test
	public void pluralize_returns_multiple_plural_forms() {
		String actual = pluralize(word).toLowerCase();
		String first = firstPluralForm.toLowerCase();
		String second = secondPluralForm.toLowerCase();
		assertThat(actual, allOf(containsString(first), containsString(second)));
	}
}
