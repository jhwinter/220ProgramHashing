import java.util.Arrays;

/**
 * The hash table class that defines the methods and functions 
 * of the hash table
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
	private int size = 20; 
	/**
	* This is the value we are modding by
	*/
	private final static int MOD = 20; 
	/**
	 * the finished hash table
	 */
	private int[] table = new int[size];

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
		loadHashTable(aInputTable);
	}

	/**
	* Hashes the values from the example run into a hash table
	*
	* @param aInputTable
	* 		a unhashed array of inputs
	 */
	public void loadHashTable(int[] aInputTable){
		int hashCode = -1;
		int index = 0;
		for(int i = 0; i < aInputTable.length; i++){
			hashCode = getHashCode(aInputTable[i], index);
			if(this.table[hashCode]== -1){
				// this means that the first spot checked was open
				this.table[hashCode] = aInputTable[i];
			}else{
				while(this.table[hashCode]!= -1){
					index++;
					hashCode = getHashCode(hashCode, index);
				}
				this.table[hashCode] = aInputTable[i];
			}
		}
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
	 *		value to be added to the hash table
	 * @param index
	 * 		index for generating a new hash code
	 * @return returns the key or -1 if there were
	 * no spots available in the hash table
	 */
	public int add(int key, int index){
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
			return -1;
		}
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
	*		the value to be located
	* @param index
	*		index for generating a new hash code
	* @return returns hash code or returns -1 if key was not found
	*/
	public int search(int key, int index){
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
			return hashCode;
		} else {
			return -1;
		}
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
	* @return returns the key to be deleted if found or
	* returns -1 if the key was not found
	* 
	*/
	public int delete(int key, int index) {
		int hashCode = -1;
		int keyDelete = -1;
		hashCode = search(key, index);
		if (hashCode == -1) {
			return -1;
		} else {
			keyDelete = this.table[hashCode];
			this.table[hashCode] = -1;
			return keyDelete;
		}
	}

	/**
	* This method sends the key and index to another
	* method that then calculates the hash code.
	* 
	* @param key
	* 		the value to be hashed 
	* @param index
	* 		the index used for generating a new hash code 
	* @return returns the hash code 
	*/
	public int getHashCode(int key, int index) {
		int hashCode = -1;
		hashCode = linearProbing(key, index);
		return hashCode;
	}

	/**
	* This method produces a hash code using 
	* linear probing.
	*
	* @param key
	* 		the value to be hashed
	* @param index
	* 		index for generating a new hash code
	* @return returns the hash code
	*/
	public int linearProbing(int key, int index) {
		int hashCode = -1;
		int key1 = key % MOD;
		hashCode = (key1 + index) % MOD;
		return hashCode;
	}

	/**
	* This method produces a hash code using 
	* quadratic probing.
	*
	* @param key
	* 		the value to be hashed
	* @param index
	* 		index for generating a new hash code
	* @return returns the hash code
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
	* This method produces a hash code using 
	* double hashing.
	*
	* @param key
	* 		the value to be hashed
	* @param index
	* 		index for generating a new hash code
	* @return returns the hash code
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
