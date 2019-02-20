
public class PreferredCustomer extends Customer {

	private int discount;

	public PreferredCustomer(String name, int id, int amountPurchases, int discount) throws Exception {
		super(name, id, amountPurchases);
		this.discount = discount;
	}

	public String toString() {
		return super.toString() + "  (discount " + discount + "%) " + this.getClass().getName();
	}

	public boolean equals(Object objectToCheck) {
		if (!(objectToCheck.getClass().equals(this.getClass()))) {
			Customer temp = (Customer) objectToCheck;
			if (super.equals(temp))
				return true;
		} else if (objectToCheck.getClass().equals(this.getClass())) {
			PreferredCustomer temp1 = (PreferredCustomer) objectToCheck;
			if (super.equals(temp1))
				if (temp1.discount == this.discount)
					return true;
		}
		return false;
	}

	public int payments() {
		if (this.getClass().getName().equals("GoldCustomer")) {
			if (50000 < this.getAmountPurchases() - this.getAmountPurchases() * (double) this.discount / 100)
				return 50000;
			else
				return this.getAmountPurchases();
		} else {
			if (10000 < this.getAmountPurchases())
				return (int) (this.getAmountPurchases() - this.getAmountPurchases() * (double) this.discount / 100);
			else
				return this.getAmountPurchases();
		}
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}
}
