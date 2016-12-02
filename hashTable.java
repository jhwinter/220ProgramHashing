//package openHashing;
//import java.util.ArrayList;
import java.util.Arrays;
/**
 * the hash table class that defines the methods and functions 
 * of the has table
 * @author Andrew Giorgio, John Riley, Jonathan Winters
 * @date 11/27/16
 * @version 1.0
 * @email ahgiorgio@g.coastal.edu
 *
 */

public class HashTable {
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

	/**
	* This is the value we are modding by
	*/
	private final static int MOD = 25; 

	/*
	 * default constructor
	 */
	public HashTable(){
		//makes sure -1, which is the null value, and prints the table.
		resetTable();
		printTable();
	}

	/**
	 * the overloaded constructor
	 * @param aInputTable 
	 * 	the unordered array inputed
	 */
	public HashTable(int[] aInputTable){
		resetTable();
		loadInputTable(aInputTable);
		loadHashTable();
	}

	/**
	 * loads the user inputs into our member variable input table,
	 * prints the input table, and loads the hash table
	 * @param aInputTable 
	 * 	the inputs that that was stored in an array
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
		//int answer = 0;
		int hashCode = -1;
		int index = 0;
		for(int i = 0; i < inputTable.length ;i++){
			//mods the key by 10
			//hashCode = inputTable[i] % 10;
			hashCode = getHashCode(inputTable[i], index);
			if(this.table[hashCode]== -1){
				// this means that the first spot checked was open
				this.table[hashCode]= inputTable[i];
			}else{
				while(this.table[hashCode]!= -1){
					//answer = answer+1;
					index++;
					hashCode = getHashCode(hashCode, index);
				}
				this.table[hashCode] = inputTable[i];
			}
		}
		printTable();
	}

	/**
	 * prints the hash table
	 */
	public void printTable(){
		System.out.println("HashTable");
		for(int i = 0; i < this.table.length; i++){
			System.out.println(i +". " + this.table[i]);
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

	/**
	* Sets all values in the Hash Table equal to -1
	* 
	*/
	public void resetTable(){
		// empties the table
		for(int i = 0; i< table.length; i++){
		//negative one represents null in this example
			table[i] = -1;
		}
	}
	/**
	 * Adds a value to the Hash Table
	 *
	 * @param key 
	 *		value to be searched
	 * @param index
	 * 		index for generating a new hash code
	 */
	public int add(int key, int index){
		//int answer = 0;
		//answer = key % 10;
		int hashCode = -1;
		hashCode = getHashCode(key, index);

		/*
		* If this spot in the table does not equal to -1,
		* continue to generate a new hash code until a spot is found
		* that does equal to -1. Once found, add the key to the hash table.
		*/
		if (this.table[hashCode] != -1) {
			while (this.table[hashCode] != -1 && index < this.table.length) {
				index++;
				hashCode = getHashCode(key, index);
			}
		} 
		if (this.table[hashCode] == -1) {
			this.table[hashCode] = key;
			return key;
		} else {
			//System.out.println(key + " was successfully added to the hash table.");
			return -1;
		}
		//return -1;
		//printTable();
	}

	/**
	* Gets what the hash code for the key should be, 
	* compares the key in this.table[hashCode] to the key from the user.
	* If they are equal, the key has been found in the hash table.
	* Otherwise, it continues to generate a new hash code and goes
	* through the same process until the key is found in the 
	* hash table.
	*
	* @param key
	*		the integer value to be located
	* @param index
	*		index for generating a new hash code
	* 
	*/
	public int search(int key, int index){
		//int answer = 0;
		//answer = key % 10;
		int hashCode = -1;
		hashCode = getHashCode(key, index);
		/*
		* If the value in this.table[hashCode] does not equal to the key,
		* then continue to generate a new hash code until
		* the key is found in the hash table.
		*
		*/
		if (this.table[hashCode] != key) {
			while (this.table[hashCode] != key && index < this.table.length) {
				index++;
				hashCode = getHashCode(key, index);
			}
		}
		if (this.table[hashCode] == key) {
			//System.out.println("The value was found in position " + hashCode + " in the hash table.");
			return hashCode;
		} else {
			return -1;
		}
		//return -1;
			//System.out.println(key + " does not exist in the hash table.")
		//printTable();
		//System.out.println("The value was found in position: " + answer);
	}

	/**
	* This method starts at the spot in the table where the key was deleted
	* and continues to increment the index until it finds the last element
	* in the table that has the same hashcode (when the index is set to 0) 
	* as the original hash code.
	* 
	* @param keyDelete
	* 		key that was deleted from the table
	* @param index
	* 		
	* 
	*/
	public int searchReplace(int keyDelete, int index) {
		int origHashCode = -1;
		int searchHashCode = -1;
		int keyReplace = -1;
		//int index1 = 0;
		//int searchIndex = 0;
		origHashCode = getHashCode(keyDelete, 0);
		searchHashCode = getHashCode(this.table[origHashCode+1], 0);

		if (searchHashCode != origHashCode) {
			return -1;
		} else {
			index++;
			for (int i = index; i < this.table.length && searchHashCode == origHashCode; i++) {
				searchHashCode = getHashCode(this.table[index], 0);
			}
			if (searchHashCode != -1) {
				keyReplace = this.table[searchHashCode];
				this.table[searchHashCode] = -1;
				return keyReplace;
			} else {
				return -1;
			}
		}

		/*for (int i = index; i < this.table.length; i++) {
			// compare the hash codes of the original and table[i]
			searchHashCode = getHashCode(this.table[i], searchIndex);
			if (origHashCode != searchHashCode) {
				return -1;
			} else if (origHashCode == searchHashCode) {
				searchHashCode2 = getHashCode(this.table[i++], searchIndex)
				if (searchHashCode2 != origHashCode) {
					return searchHashCode;
				} else {

				}
				while(searchHashCode == origHashCode) {
				searchHashCode = getHashCode(this.table[searchHashCode + 1], 0);
			}
			}
		} */



	}

	/**
	* This method calls the search method to find the key in the hash table,
	* then it sets that spot in the hash table equal to null. Then, it calls
	* another method to push everything down in the array.
	* 
	* @param key
	* 		the integer value to be deleted
	* @param index
	* 		index for generating a new hash code
	* 
	*/
	public int delete(int key, int index) {
		//int hashCode = -1;
		int hashCode = -1;
		int keyDelete = -1;
		int keyReplace = -1;
		int aKeyReplace = -1;
		hashCode = search(key, index);

		/*
		* if the spot in the table does not equal to the key,
		* return -1
		* else find another element in the table with the same hash code
		* to replace the key to be deleted,
		* if one is not found
		*
		*/
		if (hashCode == -1) {
			return -1;
		} else {
			keyDelete = this.table[hashCode];
			this.table[hashCode] = -1;
			/*aKeyReplace = searchReplace(keyDelete, index);
			if (aKeyReplace != -1) {
				keyReplace = aKeyReplace;
				this.table[hashCode] = keyReplace;
				return keyDelete;
			} else {
				return keyDelete;
			}*/
			return keyDelete;
		}
	}

	/**
	* This method sends the key and index to another 
	* that then calculuates the hash code
	* 
	* @param key
	* 		
	* @param index
	* 		the index for the 
	* @return returns the hashCode
	*/
	public int getHashCode(int key, int index) {
		int hashCode = -1;
		hashCode = linearProbing(key, index);
		return hashCode;
	}

	/**
	*
	*
	*/
	public int linearProbing(int key, int index) {
		int hashCode = -1;
		int key1 = key % MOD;
		hashCode = (key1 + index) % MOD;
		return hashCode;
	}

	/**
	*
	*
	*/
	public int quadraticProbing(int key, int index) {
		int hashCode = -1;
		int c1 = 0;
		int c2 = 1;
		int key1 = key % MOD;
		hashCode = (key1 + c1*(index) + c2*(index * index)) % MOD;
		return hashCode;
	}

	/**
	*
	*
	*/
	public int doubleHashing(int key, int index) {
		int hashCode = -1;
		final int MOD2 = 7;
		int key1 = key % MOD;
		int key2 = (1 + (key % MOD2)) % MOD2;
		hashCode = (key1 + index*key2) % MOD;
		return hashCode;
	}
}