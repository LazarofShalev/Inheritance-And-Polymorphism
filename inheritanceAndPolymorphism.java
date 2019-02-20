
import java.util.InputMismatchException;
import java.util.Scanner;

public class inheritanceAndPolymorphism {

	public static void printDuplicate(Customer[] customerArray) {
		System.out.printf("All Customers: \n");
		for (int i = 0; i < customerArray.length; i++) {
			System.out.printf("%s", customerArray[i].toString());
			System.out.printf("\n");
		}
	}

	public static void print(Customer[] customerArrayTemp) {
		System.out.printf("\nall Customers without duplications:\n");
		for (int i = 0; i < customerArrayTemp.length; i++) {
			if (customerArrayTemp[i] != null)
				System.out.printf("%s\n", customerArrayTemp[i].toString());

			for (int j = i + 1; j < customerArrayTemp.length; j++) {
				if (customerArrayTemp[j] != null && customerArrayTemp[i] != null) {
					if (customerArrayTemp[i].equals(customerArrayTemp[j]))
						customerArrayTemp[j] = null;
				}
			}
		}
	}

	public static void payments(Customer[] customerArrayTemp) {
		System.out.printf("\nCustomers and their payments (without duplications):\n");
		for (int i = 0; i < customerArrayTemp.length; i++) {
			if (customerArrayTemp[i] != null) {
				System.out.printf("%-70s %6d\n", customerArrayTemp[i].toString(), customerArrayTemp[i].payments());
			}
		}
	}

	public static int totalRevenues(Customer[] customerArrayTemp) {
		System.out.printf("\nTotal revenues from all customers (without duplications): ");
		int count = 0;
		for (int i = 0; i < customerArrayTemp.length; i++) {
			if (customerArrayTemp[i] != null)
				count += customerArrayTemp[i].payments();
		}
		return count;
	}

	// ---------------------------------------------------------------Main---------------------------------------------------------------//
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int CustomerID = 0;
		boolean flag = false;
		boolean flag2 = false;
		Customer[] customerArray = new Customer[11];

		try {
			customerArray[0] = new GoldCustomer("Rothschild", 1, 500000, 30);
			customerArray[1] = new GoldCustomer("Bill Gates", 2, 300000, 10);
			customerArray[2] = new Customer("Tali", 3, 20);
			customerArray[3] = new PreferredCustomer("James Bond", 4, 3000, 20);
			customerArray[4] = new Customer("Rothschild", 5, 500000);
			customerArray[5] = new PreferredCustomer("Tali", 6, 20, 20);
			customerArray[6] = new GoldCustomer("Tali", 7, 20, 20);
			customerArray[7] = new GoldCustomer("Rothschild", 8, 500000, 30);
			customerArray[8] = new PreferredCustomer("Rothschild", 9, 500000, 30);
			customerArray[9] = new Customer("Rothschild", 10, 500000);
			customerArray[10] = new PreferredCustomer("Tali", 11, 20, 20);

		} catch (Exception e) {
			System.out.printf("%s", e.getMessage());
			System.exit(0);
		}

		// --Duplicate The Main Array For The Methods, Optional, it is Possible To Work
		// With The Main Array--//
		Customer[] customerArrayTemp = new Customer[11];
		System.arraycopy(customerArray, 0, customerArrayTemp, 0, 11);

		// *//-------------------------------------------------------------------------------------------------------------//*//

		// --PrintDuplicate Method Prints The Array As is--//
		printDuplicate(customerArray);
		// --Print Method Prints The Array Without Customer Duplications--//
		print(customerArrayTemp);
		// --Payments Method Prints The Array Without Customer Duplications Plus The
		// Earning From Each Customer--//
		payments(customerArrayTemp);
		// --total Revenues Method Returns The Maximum Amount Of Earnings Of The
		// Bank--//
		System.out.printf("%d\n", totalRevenues(customerArrayTemp));

		// *//-------------------------------------------------------------------------------------------------------------//*//

		// --Receive id From The User in Order To Search For a Customer--//
		while (flag != true) {
			System.out.printf("\nPlease enter id to search for: ");
			try {
				CustomerID = s.nextInt();
				if (CustomerID < 1)
					throw new Exception();
				flag = true;
			} catch (InputMismatchException e) {
				System.out.printf("Wrong Input,Please enter a Integer bigger or equels to one\n");
				s.nextLine();
			} catch (Exception e) {
				System.out.printf("==> Id can not be less than 1\n");
			}
		}

		for (int i = 0; i < customerArray.length; i++) {
			if (customerArray[i].search(CustomerID))
				flag2 = true;
		}
		if (flag2 == false)
			System.out.printf("Not Found");
	}

}
