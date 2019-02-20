
public class Customer {
	private int id;
	private String name;
	private int amountPurchases;

	public Customer(String name, int id, int amountPurchases) throws Exception {
		setId(id);
		setName(name);
		setAmountPurchases(amountPurchases);
	}

	public String toString() {
		return String.format("%2d %-13s %12d", id, " - " + name, amountPurchases);
	}

	public boolean search(int CustomerIDToSearch) {
		if (this.id == CustomerIDToSearch) {
			System.out.printf("%s\n", this.toString());
			return true;
		}
		return false;
	}

	public boolean equals(Object objectToCheck) {
		Customer temp = (Customer) objectToCheck;
		// --Not The Same Type--//
		if (!(objectToCheck.getClass().equals(this.getClass()))) {
			if (temp.id == this.id)
				return true;
		}
		// --The Same Type--//
		else if ((objectToCheck.getClass().equals(this.getClass()))) {
			if (temp.id == this.id)
				return true;
			else if (temp.name.equals(this.name) && temp.amountPurchases == this.amountPurchases && this.id != temp.id)
				return true;
		}
		return false;
	}

	public int payments() {
		return this.getAmountPurchases();
	}

	public void setId(int id) throws Exception {
		try {
			if (id < 1) {
				throw new Exception("==> Id can not be less than 1\n");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());

		}
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAmountPurchases(int amountPurchases) {
		this.amountPurchases = amountPurchases;
	}

	public int getAmountPurchases() {
		return amountPurchases;
	}
}