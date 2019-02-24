package edu.depaul.se433;

import static edu.depaul.se433.Orders.calculateTotal;
import static edu.depaul.se433.Orders.ShippingMethod.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OrdersWeakNormalSpecialValueTest {
	
	@Test
	public void calculateTotal_computes_shipping_cost_with_an_accuracy_of_point_01_for_DC() {
		assertEquals(30.00, calculateTotal(20.00, Standard, "DC"), 0.01);
	}
}
