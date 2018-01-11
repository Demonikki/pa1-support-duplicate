package cse12pa1student;

public interface ShoppingBag {
	/*
	 * @return the total count of all items, counting duplicates, in the bag.
	 */
	int totalCount();

	/*
	 * @param i The item to count
	 * 
	 * @return The number of the provided Item that are in the cart
	 */
	int itemCount(Item i);

	/*
	 * @return the total price of all items in the bag (counting duplicates)
	 */
	int totalPrice();

	/*
	 * @param i The item to add
	 */
	void add(Item t);

	/*
	 * Remove a single copy of an item from the bag
	 * 
	 * @param i The Item to remove
	 * 
	 * @return false if the item was not in the bag, true otherwise
	 */
	boolean removeOne(Item i);

	/*
	 * Remove all copies of an item from the bag
	 * 
	 * @param i The Item to remove
	 * 
	 * @return false if the item was not in the bag, true otherwise
	 */
	boolean removeAll(Item i);

	/*
	* Remove all items from the bag
	*/
	void empty();

}
