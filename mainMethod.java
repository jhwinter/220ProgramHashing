package menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Andrew Giorgio
 *
 */
public class mainMethod {

	/**
	 * @param args
	 * @param hash1
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input = 0;
		String response = "";
		Scanner in = new Scanner(System.in);
		hashTable hash1 = new hashTable();

		while (!response.equalsIgnoreCase("q")) {
			System.out.println("\nPlease choose an option: 'print', 'add', 'search'");
			response = in.next();
			if (response.equalsIgnoreCase("print")) {
				// int[] inputTable= {1,2,3,8,9,47,7,35,5, 100, 21, 99, 4505};
				// hash1.loadInputTable(inputTable);
				print(hash1);
			}
			if (response.equalsIgnoreCase("add")) {
				add(hash1, input, in);
			} else if (response.equalsIgnoreCase("search")) {
				search(hash1, input, in);
			} else {
				System.out.println("Sorry You have entered in a invalid input");
			}
		}
		System.out.println("Thanks for using the program, GoodBye :)");

	}

	public static void print(hashTable hash1) {
		hash1.printTable();
	}

	public static void add(hashTable hash1, int input, Scanner in) {
		System.out.println("Please enter in the number you want to add");
		input = in.nextInt();
		hash1.addFunction(input);
		System.out.println("Success! added the input to the hashtable");
	}

	public static void search(hashTable hash1, Integer input, Scanner in) {
		System.out.println("Please enter in the number you want to search for");
		input = in.nextInt();
		if (input == null) {
			System.out.println("Sorry, you have entered in an invalid input.");
		}
		hash1.searchFunction(input);
	}
}
