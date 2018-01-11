package cse12pa1student;

import java.util.ArrayList;

public class Bag9 implements ShoppingBag {

	public Bag9() {
		this.items = new ArrayList<Item>();
	}

	ArrayList<Item> items;

	@Override
	public int totalCount() {
		return this.items.size();
	}

	@Override
	public int itemCount(Item i) {
		if(i == null) { return 0; }
		int itemCount = 0;
		for (int j = 0; j < this.items.size(); j += 1) {
			if (this.items.get(j) == i) {
				itemCount += 1;
			}
		}
		return itemCount;
	}

	@Override
	public int totalPrice() {
		int price = 0;
		for (int j = 0; j < this.items.size(); j += 1) {
			price += this.items.get(j).priceInCents;
		}
		return price;
	}

	@Override
	public void add(Item i) {
		if(i == null) { return; }
		this.items.add(i);
	}

	@Override
	public boolean removeOne(Item i) {
		if(i == null) { return false; }
		return this.items.remove(i);
	}

	@Override
	public boolean removeAll(Item i) {
		if(i == null) { return false; }
		boolean removed = false;
		while (this.items.contains(i)) {
			removed = true;
			this.items.remove(i);
		}
		return removed;
	}
	
	@Override
	public void empty() {
		this.items.clear();
	}

}
