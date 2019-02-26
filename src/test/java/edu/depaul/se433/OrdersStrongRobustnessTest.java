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
public class OrdersStrongRobustnessTest {

	private double rawTotal;
	private ShippingMethod shippingMethod;
	private String destinationState;
	
	public OrdersStrongRobustnessTest(
			double rawTotal,
			ShippingMethod shippingMethod,
			String destinationState) {
		this.rawTotal = rawTotal;
		this.shippingMethod = shippingMethod;
		this.destinationState = destinationState;
	}

	@Parameters(name = "SRT_{index}: ({0}, {1}, {2}) -> IllegalArgumentException")
	public static Collection<Object[]> data() {
		return (ArrayList<Object[]>) Stream.of(new Object[][] {
			{Double.NaN, NextDay, "IL"},
			{Double.NaN, NextDay, "VA"},
			{Double.NaN, Standard, "IL"},
			{Double.NaN, Standard, "VA"},
			{-30.00, NextDay, "IL"},
			{-30.00, NextDay, "VA"},
			{-30.00, Standard, "IL"},
			{-30.00, Standard, "VA"},
			{20.00, null, "IL"},
			{20.00, null, "VA"},
			{80.00, null, "IL"},
			{80.00, null, "VA"},
			{20.00, Standard, "Ethiopia"},
			{20.00, Standard, null},
			{20.00, NextDay, "Ethiopia"},
			{20.00, NextDay, null},
			{80.00, Standard, "Ethiopia"},
			{80.00, Standard, null},
			{80.00, NextDay, "Ethiopia"},
			{80.00, NextDay, null}
		}).collect(Collectors.toList());
	}

	@Test(expected = IllegalArgumentException.class)
	public void calculateTotal_throws_IllegalArgumentException_on_invalid_input() {
		calculateTotal(rawTotal, shippingMethod, destinationState);
	}
}