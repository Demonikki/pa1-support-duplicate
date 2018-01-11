package cse12pa1student;

import java.util.ArrayList;

public class Bag10 implements ShoppingBag {

	public Bag10() {
		this.items = new ArrayList<Item>();
	}

	ArrayList<Item> items;

	@Override
	public int totalCount() {
		return this.items.size();
	}

	@Override
	public int itemCount(Item i) {
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
		this.items.add(i);
	}

	@Override
	public boolean removeOne(Item i) {
		return this.items.remove(i);
	}

	@Override
	public boolean removeAll(Item i) {
		this.items.removeAll(this.items);
		return this.items.remove(i);
	}
	
	@Override
	public void empty() {
		this.items.clear();
	}

}
