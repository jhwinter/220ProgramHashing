import java.util.ArrayList;
import java.util.Arrays;
/**
 * 
 */

/**
 * the hash table class that defines the methods and functions 
 * of the has table
 * @author Andrew Giorgio
 * @date 11/27/16
 * @version 1.0
 * @email ahgiorgio@g.coastal.edu
 *
 */

public class hashTable {
	/**
	 * the size of the array
	 */
	private int size = 25; 
	/**
	 * the finished hash table
	 */
	private int[] table = new int[size];
	/**
	 * the user input table
	 */
	private int[] inputTable = new int[size];
	/*
	 * default constructor
	 */
	public hashTable(){
		//makes sure -1, which is the null value, and prints the table.
		resetTable();
		printTable();
	}
	/**
	 * the overloaded constructor
	 * @param aInputTable the unordered array inputed
	 */
	public hashTable(int[] aInputTable){
		resetTable();
		loadInputTable(aInputTable);
		loadHashTable();
	}
	/**
	 * loads the user inputs into our member variable input table
	 * @param aInputTable the inputs that that was stored in an array
	 */
	public void loadInputTable(int[] aInputTable){
		for(int i = 0;i< aInputTable.length; i++){
			inputTable[i] = aInputTable[i];
		}
		printInputTable();
		loadHashTable();
	}
	/**
	 * hashes the users inputs into an array
	 */
	public void loadHashTable(){
		int answer = 0;
		for(int i = 0; i < table.length ;i++){
			//mods the key by 10
			answer = inputTable[i] % 10;
			if(table[answer]== -1){
				// this means that the first spot checked was open
				table[answer]= inputTable[i];
			}else{
			while(table[answer]!= -1){
				answer = answer+1;	
			}
			table[answer] = inputTable[i];
			}
			
		}
		printTable();
	}
	/**
	 * prints the hash table
	 */
	public void printTable(){
		System.out.println("HashTable");
		for(int i = 0; i < table.length; i++){
			
			System.out.println(i +". " + table[i]);
		}
	}
	/**
	 * prints the input table
	 */
	public void printInputTable(){
		System.out.println("Input Table");
		for(int i = 0; i < inputTable.length; i++){
			
			System.out.println(i +". " + inputTable[i]);
		}
	}
		
	public void resetTable(){
		// empties the table
				for(int i = 0; i< table.length; i++){
					//negative one represents null in this example
					table[i] = -1;
				}
	}
	public void add(int key){
		int answer = 0;
		answer = key % 10;
		if(table[answer] != 0){
			while(table[answer]!= 0){
				answer +=1;
			}
			table[answer]= key;
		}
		else{
			table[answer]= key;
		}
		printTable();
	}
		
	}
	


