package cse12pa1student;

import java.util.ArrayList;

public class Bag11 implements ShoppingBag {

	public Bag11() {
		this.items = new ArrayList<Item>();
		this.counts = new ArrayList<Integer>();
	}

	ArrayList<Item> items;
	ArrayList<Integer> counts;

	@Override
	public int totalCount() {
		int count = 0;
		for (Integer i : this.counts) {
			count += i;
		}
		return count;
	}

	@Override
	public int itemCount(Item i) {
		int index = 0;
		for (Item check : this.items) {
			if (check == i) {
				return this.counts.get(index);
			}
			index += 1;
		}
		return index;
	}

	@Override
	public int totalPrice() {
		int price = 0;
		for (Item check : this.items) {
			price += check.priceInCents;
		}
		return price;
	}

	@Override
	public void add(Item i) {
		int index = this.items.indexOf(i);
		if (index == -1) {
			this.items.add(i);
			this.counts.add(1);
		} else {
			this.counts.set(index, this.counts.get(index) + 1);
		}
	}

	@Override
	public boolean removeOne(Item i) {
		int index = this.items.indexOf(i);
		if (index == -1) {
			return false;
		} else {
			this.counts.set(index, this.counts.get(index) - 1);
			return true;
		}
	}

	@Override
	public boolean removeAll(Item i) {
		int index = this.items.indexOf(i);
		if (index == -1) {
			return false;
		} else {
			this.counts.set(index, 0);
			return true;
		}
	}
	
	@Override
	public void empty() {
		this.items.clear();
		this.counts.clear();
	}

}
