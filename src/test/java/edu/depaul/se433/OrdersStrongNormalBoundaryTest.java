package edu.depaul.se433;

import static edu.depaul.se433.Orders.calculateTotal;
import edu.depaul.se433.Orders.ShippingMethod;
import static edu.depaul.se433.Orders.ShippingMethod.*;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class OrdersStrongNormalBoundaryTest {

	private double rawTotal;
	private ShippingMethod shippingMethod;
	private String destinationState;
	private double expectedShippingCost;

	public OrdersStrongNormalBoundaryTest(
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

	@Parameters(name = "SNBT_{index}: ({0},{1},{2}) -> {3}")
	public static Collection<Object[]> data() {
		return (ArrayList<Object[]>) Stream.of(new Object[][] {
			{0.00, Standard, "IL", 0.0},
			{0.00, Standard, "VA", 0.0},
			{0.00, NextDay, "IL", 0.0},
			{0.00, NextDay, "VA", 0.0},
			{0.01, Standard, "IL", 10.01},
			{0.01, Standard, "VA", 10.01},
			{0.01, NextDay, "IL", 25.01},
			{0.01, NextDay, "VA", 25.01},
			{20.00, Standard, "IL", 31.20},
			{20.00, Standard, "VA", 30.00},
			{20.00, NextDay, "IL", 46.20},
			{20.00, NextDay, "VA", 45.00},
			{49.99, Standard, "IL", 62.99},
			{49.99, Standard, "VA", 59.99},
			{49.99, NextDay, "IL", 77.99},
			{49.99, NextDay, "VA", 74.99},
			{50.00, Standard, "IL", 63.00},
			{50.00, Standard, "VA", 60.00},
			{50.00, NextDay, "IL", 78.00},
			{50.00, NextDay, "VA", 75.00},
			{50.01, Standard, "IL", 53.01},
			{50.01, Standard, "VA", 50.01},
			{50.01, NextDay, "IL", 78.01},
			{50.01, NextDay, "VA", 75.01},
			{80.00, Standard, "IL", 84.80},
			{80.00, Standard, "VA", 80.00},
			{80.00, NextDay, "IL", 109.80},
			{80.00, NextDay, "VA", 105.00},
			{160.00e+9, Standard, "IL", 169.60e+9},
			{160.00e+9, Standard, "VA", 160.00e+9},
			{160.00e+9, NextDay, "IL", 25.00 + 169.60e+9},
			{160.00e+9, NextDay, "VA", 25.00 + 160.00e+9}
		}).collect(Collectors.toList());
	}

	@Test
	public void calculateTotal_computes_shipping_cost_with_an_accuracy_of_point_01_for_boundary_values() {
		assertEquals(expectedShippingCost, calculateTotal(rawTotal, shippingMethod, destinationState), 0.01);
	}
}
