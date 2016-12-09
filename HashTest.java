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
	 * 		Command line arguments
	 * 
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input = 0;
		String response = "no response yet";
		Scanner in = new Scanner(System.in);
		HashTable hash1 = new HashTable();

		while (!response.equalsIgnoreCase("q")) {
			System.out.println("\nPlease choose an option: 'p' to print, 'a' to add an element, 's' to search for an element, 'r' to remove an element, 'ex' to run an example, or 'q' to exit the program");
			response = in.next();
			if (response.equalsIgnoreCase("p")) {
				print(hash1);
			} else if (response.equalsIgnoreCase("a")) {
				add(hash1, in);
			} else if (response.equalsIgnoreCase("s")) {
				search(hash1, in);
			} else if (response.equalsIgnoreCase("r")) {
				remove(hash1, in);
			} else if (response.equalsIgnoreCase("ex")) {
				exampleRun(hash1);
			} else if (response.equalsIgnoreCase("q")) {
				System.out.println("Thanks for using the program. GoodBye! :)");
				in.close();
				return;
			} else {
				System.out.println("Sorry, you have entered invalid input. Please try again.");
			}
		}
	}

	/**
	* prints the contents of the hash table
	*
	*/
	public static void print(HashTable hash1) {
		System.out.println();
		hash1.printTable();
	}

	/**
	* sends the value to be added to the hash 
	* table to the Hash Table object 
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
			} else {
				System.out.println("\nWe're sorry, it seems as though the hash table is currently full. Please remove an element and try again.");
			}
		} else {
			System.out.println("Sorry, you have entered invalid input. Please try again.");
		}
	}

	/**
	* sends the value to be searched to the HashTable object and 
	* prints whether or not the integer was found in the hash table
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
	* sends the value to removed to the HashTable object
	* and prints whether or not the value was successfully removed
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

	public static void exampleRun(HashTable hash1) {
		int[] inputTable = {12,23,34,46,2445,12,124,34,64,656,3,248,86,3,15,68,52,1,78,90};
		hash1.loadHashTable(inputTable);
		hash1.printTable();
	}
}