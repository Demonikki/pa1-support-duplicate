package cse12pa1student;

import java.util.Collection;
import java.util.Arrays;

import static org.junit.Assert.*;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ShoppingBagTest {

	public static Collection<Object[]> BAGNUMS =
			Arrays.asList(new Object[][] { {0}, {1}, {2}, {3}, {4}, {5}, {6}, {7}, {8}, {9}, {10}, {11} });
	private int bagType;

	public ShoppingBagTest(int bagType) {
		super();
		this.bagType = bagType;
	}

	@Parameterized.Parameters(name = "Bag{index}")
	public static Collection<Object[]> bags() {
		return BAGNUMS;
	}
	
	private ShoppingBag makeBag() {
		switch(this.bagType) {
			case 0: return new Bag0();
			case 1: return new Bag1();
			case 2: return new Bag2();
			case 3: return new Bag3();
			case 4: return new Bag4();
			case 5: return new Bag5();
			case 6: return new Bag6();
			case 7: return new Bag7();
			case 8: return new Bag8();
			case 9: return new Bag9();
			case 10: return new Bag10();
			case 11: return new Bag11();
		}
		return null;
	}
	

	@Test
	public void testEmptyHasCount0() {	
		ShoppingBag bagToTest = makeBag();
		assertEquals(bagToTest.totalCount(), 0);
	}

	@Test
	public void addedHasCount1() {
		ShoppingBag bagToTest = makeBag();

		Item i = new Item("Shampoo", 5);
		bagToTest.add(i);
		assertEquals(bagToTest.totalCount(), 1);
	}

	@Test
	public void addDuplicateCount() {
		ShoppingBag bagToTest = makeBag();

		Item i = new Item("Shampoo", 5);
		bagToTest.add(i);
		bagToTest.add(i);
		assertEquals(bagToTest.totalCount(), 2);
		assertEquals(bagToTest.itemCount(i), 2);
	}

	@Test
	public void addEqualCount() {
		ShoppingBag bagToTest = makeBag();

		Item i = new Item("Shampoo", 5);
		Item i2 = new Item("Shampoo", 5);
		bagToTest.add(i);
		bagToTest.add(i2);
		assertEquals(bagToTest.totalCount(), 2);
		assertEquals(bagToTest.itemCount(i), 2);
	}
	
	@Test
	public void addNullCount() {
		ShoppingBag bagToTest = makeBag();
		bagToTest.add(null);
		assertEquals(bagToTest.totalCount(), 0);
	}
	
	

}
