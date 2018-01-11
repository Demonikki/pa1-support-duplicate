package cse12pa1grading;

import org.junit.runner.notification.Failure;

import com.google.gson.Gson;

import cse12pa1student.ShoppingBagTest;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

/*
 * The autograder format for Gradescope is specified at
 * https://gradescope-autograders.readthedocs.io/en/latest/specs/
 * 
 * Here we only use a few required fields for the score and custom output on a per-test basis
 */
class GradePart {

	public GradePart(String name, int score, int max, String output) {
		super();
		this.name = name;
		this.score = score;
		this.max = max;
		this.output = output;
	}

	String name;
	int score;
	int max;
	String output;
}

class Grade {
	public Grade(String output, List<GradePart> tests, int total) {
		super();
		this.output = output;
		this.tests = tests;
		this.total = total;
	}

	String output;
	List<GradePart> tests;
	int total;
}

/*
 * The grader runs the (parameterized) test from the user, and then checks that
 * for each bag, some test failed only on that bag. The failures will start with
 * 
 * testName[BagN]
 * 
 * so we use that to bin the failures by bag implementation
 */
public class Grader {
	static final int BAG_COUNT = ShoppingBagTest.BAGNUMS.size();

	static String getTestName(String header) {
		return header.substring(0, header.indexOf("["));
	}

	static String getTestBagName(String header) {
		return header.substring(header.indexOf("[") + 1, header.indexOf("]"));
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("Args: " + Arrays.toString(args));

		JUnitCore jc = new JUnitCore();
		Class<?> test = ShoppingBagTest.class;
		Result result = jc.run(test);
		List<Failure> fails = result.getFailures();
		Map<String, Set<String>> bagToFailures = new HashMap<String, Set<String>>();

		for (int i = 0; i < BAG_COUNT; i += 1) {
			bagToFailures.put("Bag" + i, new HashSet<String>());
		}

		for (Failure f : fails) {
			String header = f.getTestHeader();
			String testName = getTestName(header);
			String bagName = getTestBagName(header);

			bagToFailures.get(bagName).add(testName);
		}

		List<GradePart> gps = new ArrayList<GradePart>();

		// To grade, check that each bag has a _unique_ failure "vector". Just do the
		// simple quadratic approach.
		
		int total = 0;
		
		for (Entry<String, Set<String>> bagMapping : bagToFailures.entrySet()) {
			List<String> matchedBags = new ArrayList<String>();

			for (Entry<String, Set<String>> otherBagMapping : bagToFailures.entrySet()) {
				if (bagMapping.getKey().equals(otherBagMapping.getKey())) {
					continue; // skip BagN compared to BagN
				}
				if (bagMapping.getValue().equals(otherBagMapping.getValue())) {
					// If some other bag failed exactly the same tests, we didn't distinguish it
					matchedBags.add(otherBagMapping.getKey());
				}
			}

			String bagName = bagMapping.getKey();
			if (matchedBags.size() == 0) {
				total += 1;
				gps.add(new GradePart(bagName, 1, 1,
						"Nice job! This set of failures was unique for " + bagName + ": " + bagMapping.getValue().toString()));
			} else {
				matchedBags.add(bagName);
				gps.add(new GradePart(bagName, 0, 1, "Not quite there yet - refine your tests some more. The set of test failures was shared between several bags. "
						+ matchedBags.toString() + " all failed on exactly these tests: " + bagMapping.getValue().toString()));
			}
		}

		Grade g = new Grade("", gps, total);
		Gson gs = new Gson();
		String output = gs.toJson(g);

		String file = "results.json";
		if (args.length > 0) {
			file = args[0];
		}

		PrintWriter out = new PrintWriter(file);
		out.write(output);
		out.close();
		System.out.println(output);

	}
}
