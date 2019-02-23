package edu.depaul.se433;

/**
 * Class: SE433 - Software Testing & QA
 * Author: Nardos Tessema
 */

import static edu.depaul.se433.Orders.calculateTotal;
import edu.depaul.se433.Orders.ShippingMethod;
import static edu.depaul.se433.Orders.ShippingMethod.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class OrdersTest {

	private double rawTotal;
	private ShippingMethod shippingMethod;
	private String destinationState;
	private double expectedShippingCost;

	public OrdersTest(
			double rawTotal,
			ShippingMethod shippingMethod,
			String destinationState,
			double expectedShippingCost
			) {
		this.rawTotal = rawTotal;
		this.shippingMethod = shippingMethod;
		this.destinationState = destinationState;
		this.expectedShippingCost = expectedShippingCost;
	}

	@Parameters(name = "SNT_{index}: input = ({0}, {1}, {2}), expected = {3}")
	public static Collection<Object[]> data() {
		return (ArrayList<Object[]>) Stream.of(new Object[][] {
			{20.00, Standard, "IL", 31.20},
			{20.00, Standard, "VA", 30.00},
			{20.00, NextDay, "IL", 46.20},
			{20.0, NextDay, "VA", 45.00},
			{80.00, Standard, "IL", 84.80},
			{80.00, Standard, "VA", 80.00},
			{80.00, NextDay, "IL", 109.80},
			{80.0, NextDay, "VA", 105.00}
		}).collect(Collectors.toList());
	}

	@Test
	public void strong_normal_test__calculateTotal_computes_shipping_cost_to_within_a_delta_of_1e_4() {
		assertEquals(expectedShippingCost, calculateTotal(rawTotal, shippingMethod, destinationState), 1e-4);
	}
}
