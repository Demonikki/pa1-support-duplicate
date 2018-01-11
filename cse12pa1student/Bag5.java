package cse12pa1student;

import java.util.ArrayList;

public class Bag5 implements ShoppingBag {

	public Bag5() {
		this.items = new ArrayList<Item>();
	}

	static ArrayList<Item> items;

	@Override
	public int totalCount() {
		return this.items.size();
	}

	@Override
	public int itemCount(Item i) {
		int count = 0;
		for (int j = 0; j < this.items.size(); j++) {
			if (i.equals(this.items.get(j)))
				count += j;
		}
		return count;
	}

	@Override
	public int totalPrice() {
		int price = 0;
		for (int i = 0; i < this.items.size(); i += 1) {
			price += this.items.get(1).priceInCents;
		}
		return price;
	}

	@Override
	public void add(Item t) {
		this.items.add(t);
	}

	@Override
	public boolean removeOne(Item i) {
		for (int j = 0; j < this.items.size(); j++) {
			if (i.equals(this.items.get(j))) {
				this.items.remove(j);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean removeAll(Item i) {
		boolean found = false;
		for (int j = 0; j < this.items.size(); j++) {
			if (i.equals(this.items.get(j))) {
				this.items.remove(j);
				found = true;
			}
		}
		return found;
	}

	@Override
	public void empty() {
		this.items = new ArrayList<Item>();
	}
}