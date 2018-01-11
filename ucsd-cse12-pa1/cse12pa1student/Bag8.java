package cse12pa1student;

import java.util.ArrayList;

public class Bag8 implements ShoppingBag {

    /*
        implementation uses index as the count...to try to be creative
     */

    public Bag8() {
        this.items = new ArrayList<ArrayList<Item>>();
    }

    ArrayList<ArrayList<Item>> items;

    @Override
    public int totalCount() {
        int totalCount = 0;
        for (int i = 1; i < this.items.size(); i++) {
            totalCount += this.items.get(i).size() * i;
        }
        return totalCount;
    }

    @Override
    public int itemCount(Item i) {
        for (int j = 0; j < this.items.size(); j++) {
            if (this.items.get(j).contains(i))
                return j;
        }
        return 0;
    }

    @Override
    public int totalPrice() {
        int totalPrice = 0;
        for (int i = 1; i < this.items.size(); i++) {
            for (Item item : this.items.get(i)) {
                totalPrice += item.priceInCents * i;
            }
        }
        return totalPrice;
    }

    @Override
    public void add(Item i) {
        for (int j = 1; j < this.items.size(); j++) {
            if (this.items.get(j).contains(i)) {
                this.items.get(j).remove(i);
                if (j + 1 == this.items.size()) {
                    ArrayList<Item> temp = new ArrayList<Item>();
                    temp.add(i);
                    this.items.add(temp);
                } else{
                    this.items.get(j + 1).add(i);
                }
                return;
            }
        }
        while(this.items.size() <= 1)
            this.items.add(new ArrayList<Item>());
        this.items.get(1).add(i);
    }

    @Override
    public boolean removeOne(Item i) {
        for (int j = 1; j < this.items.size(); j++) {
            if (this.items.get(j).contains(i)) {
                this.items.get(j).remove(i);
                this.items.get(j - 1).add(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeAll(Item i) {
        for (int j = 1; j < this.items.size(); j++) {
            if (this.items.get(j).contains(i))
                return this.items.get(j).remove(i);
        }
        return false;
    }

    @Override
    public void empty() {
        this.items.clear();
    }
}
