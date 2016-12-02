//package openHashing;
//import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Tests the HashTable class
 * @author Andrew Giorgio, John Riley, Jonathan Winters
 * @date 11/27/16
 * @version 1.0
 * @email ahgiorgio@g.coastal.edu
 *
 */
public class HashTest {

	/**
	 * Entry point of the program
	 * @param args
	 * 	Command line arguments
	 * 
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input = 0;
		String response = "no response yet";
		Scanner in = new Scanner(System.in);
		HashTable hash1 = new HashTable();

		while (!response.equalsIgnoreCase("q")) {
			System.out.println("\nPlease choose an option: 'print', 'add', 'search', 'remove'");
			response = in.next();
			if (response.equalsIgnoreCase("print")) {
				// int[] inputTable= {1,2,3,8,9,47,7,35,5, 100, 21, 99, 4505};
				// hash1.loadInputTable(inputTable);
				//print(hash1);
				print(hash1);
			} else if (response.equalsIgnoreCase("add")) {
				add(hash1, in);
			} else if (response.equalsIgnoreCase("search")) {
				search(hash1, in);
			} else if (response.equalsIgnoreCase("remove")) {
				remove(hash1, in);
			}
			else {
				System.out.println("Sorry, you have entered invalid input. Please try again.");
			}
		}
		System.out.println("Thanks for using the program, GoodBye :)");

	}

	public static void print(HashTable hash1) {
		System.out.println();
		hash1.printTable();
	}

	/**
	*
	*
	*/
	public static void add(HashTable hash1, Scanner in) {
		int input = 0;
		System.out.println("Please enter the number you want to add:");
		input = in.nextInt();
		int index = 0;
		int keyAdd = 0;
		if (input > -1) {
			keyAdd = hash1.add(input, index);
			if (keyAdd == input) {
				System.out.println("\nSuccess! " + keyAdd + " was successfully added to the hash table.");
				hash1.printTable();
			}
		} else {
			System.out.println("Sorry, you have entered invalid input. Please try again.");
		}
	}

	/**
	*
	*
	*/
	public static void search(HashTable hash1, Scanner in) {
		int input = 0;
		System.out.println("Please enter the number you want to search for:");
		input = in.nextInt();
		int index = 0;
		int keyFoundHash = 0;
		if (input > -1) {
			keyFoundHash = hash1.search(input, index);
			if (keyFoundHash != -1) {
				System.out.println("\nSuccess! " + input + " was found in the hash table.");
				hash1.printTable();
			} else {
				System.out.println(input + " was not found in the hash table.");
			}
		} else {
			System.out.println("Sorry, you have entered invalid input. Please try again.");
		}
	}
	
	/**
	*
	*
	*/
	public static void remove(HashTable hash1, Scanner in) {
		int input = 0;
		System.out.println("Please enter the number you want to remove from the table:");
		input = in.nextInt();
		int index = 0;
		int keyRemove = 0;
		if (input > -1) {
			keyRemove = hash1.delete(input, index);
			if (keyRemove == input) {
				System.out.println("\nSuccess! " + keyRemove + " was removed from the hash table.");
				hash1.printTable();
			} else {
				System.out.println(input + " was not found in the hash table.");
			}
		} else {
			System.out.println("Sorry, you have entered invalid input. Please try again.");
		}
	}
}