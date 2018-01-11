package cse12pa1student;

public class Bag0 implements ShoppingBag {

	@Override
	public int totalCount() {
		return 0;
	}

	@Override
	public int itemCount(Item i) {
		return 0;
	}

	@Override
	public int totalPrice() {
		return 0;
	}

	@Override
	public void add(Item t) {
	}

	@Override
	public boolean removeOne(Item i) {
		return false;
	}

	@Override
	public boolean removeAll(Item i) {
		return false;
	}
	
	@Override
	public void empty() {
		return;
	}

}
