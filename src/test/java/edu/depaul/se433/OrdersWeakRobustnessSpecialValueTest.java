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
public class OrdersWeakRobustnessSpecialValueTest {
	private double rawTotal;
	private ShippingMethod shippingMethod;
	private String destinationState;
	
	public OrdersWeakRobustnessSpecialValueTest(
			double rawTotal,
			ShippingMethod shippingMethod,
			String destinationState
			) {
		this.rawTotal = rawTotal;
		this.shippingMethod = shippingMethod;
		this.destinationState = destinationState;
	}

	@Parameters(name = "WRSVT_{index}: no delivery to {2}")
	public static Collection<Object[]> data() {
		return (ArrayList<Object[]>) Stream.of(new Object[][] {
			{80.00, NextDay, "Puerto Rico"},
			{20.00, Standard, "Guam"},
			{80.00, NextDay, "Virgin Islands"},
			{20.00, Standard, "Northern Mariana Islands"},
			{80.00, NextDay, "American Samoa"}
		}).collect(Collectors.toList());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void calculateTotal_throws_IllegalArgumentException_for_US_territories() {
		calculateTotal(rawTotal, shippingMethod, destinationState);
	}
}
