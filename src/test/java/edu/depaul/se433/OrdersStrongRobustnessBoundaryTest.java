package edu.depaul.se433;

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

@RunWith(Parameterized.class)
public class OrdersStrongRobustnessBoundaryTest {
	
	private double rawTotal;
	private ShippingMethod shippingMethod;
	private String destinationState;
	
	public OrdersStrongRobustnessBoundaryTest(
			double rawTotal,
			ShippingMethod shippingMethod,
			String destinationState
			) {
		this.rawTotal = rawTotal;
		this.shippingMethod = shippingMethod;
		this.destinationState = destinationState;
	}

	@Parameters(name = "SRBT_{index}: ({0},{1},{2}) -> IllegalArgumentException")
	public static Collection<Object[]> data() {
		return (ArrayList<Object[]>) Stream.of(new Object[][] {
			{-0.01, Standard, "IL"},
			{-0.01, Standard, "VA"},
			{-0.01, NextDay, "IL"},
			{-0.01, NextDay, "VA"}
		}).collect(Collectors.toList());
	}

	@Test(expected = IllegalArgumentException.class)
	public void calculateTotal_throws_IllegalArgumentException_for_invalid_boundary_values() {
		calculateTotal(rawTotal, shippingMethod, destinationState);
	}
}
