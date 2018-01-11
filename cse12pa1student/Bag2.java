package cse12pa1student;

public class Bag2 implements ShoppingBag {

	private Item[] items;
	
	public Bag2() {
		this.items = new Item[10];
	}
	
	@Override
	public int totalCount() {
		int count = 0;
		for(int i = 0; i < this.items.length; i += 1) {
			if(this.items[i] != null)  { count += 1; }
		}
		return count;
	}

	@Override
	public int itemCount(Item item) {
		if(item == null) { return 0; }
		int count = 0;
		for(int i = 0; i < this.items.length; i += 1) {
			if(this.items[i] == item)  { count += 1; }
		}
		return count;
	}

	@Override
	public int totalPrice() {
		int total = 0;
		for(int i = 0; i < this.items.length; i += 1) {
			total += this.items[i].priceInCents;
		}
		return total;
	}

	@Override
	public void add(Item t) {
		for(int i = 0; i < this.items.length; i += 1) {
			if(this.items[i] == null)  {
				this.items[i] = t;
				return;
			}
		}
	}

	@Override
	public boolean removeOne(Item item) {
		for(int i = 0; i < this.items.length; i += 1) {
			if(this.items[i] == item)  {
				this.items[i] = null;
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean removeAll(Item item) {
		boolean found = false;
		for(int i = 0; i < this.items.length; i += 1) {
			if(this.items[i] == item)  {
				this.items[i] = null;
				found = true;
			}
		}
		return found;
	}
	@Override
	public void empty() {
		for(int i = 0; i < this.items.length; i += 1) {
			this.items[i] = null;
		}
	}
}
