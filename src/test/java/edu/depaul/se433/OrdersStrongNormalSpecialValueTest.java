package edu.depaul.se433;

import static edu.depaul.se433.Orders.calculateTotal;
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

import edu.depaul.se433.Orders.ShippingMethod;

@RunWith(Parameterized.class)
public class OrdersStrongNormalSpecialValueTest {

	private double rawTotal;
	private ShippingMethod shippingMethod;
	private double expectedShippingCost;

	public OrdersStrongNormalSpecialValueTest(
			double rawTotal,
			ShippingMethod shippingMethod,
			double expectedShippingCost
			) {
		this.rawTotal = rawTotal;
		this.shippingMethod = shippingMethod;
		this.expectedShippingCost = expectedShippingCost;
	}

	@Parameters(name = "SNSVT_{index}: ({0}, {1}, \"DC\") -> {2}")
	public static Collection<Object[]> data() {
		return (ArrayList<Object[]>) Stream.of(new Object[][] {
			{20.00, Standard, 30.00},
			{20.00, NextDay, 45.00},
			{80.00, Standard, 80.00},
			{80.00, NextDay, 105.00}
		}).collect(Collectors.toList());
	}

	@Test
	public void calculateTotal_computes_shipping_cost_for_DC_with_an_accuracy_of_point_01() {
		assertEquals(expectedShippingCost, calculateTotal(rawTotal, shippingMethod, "DC"), 0.01);
	}
}
