/**
* 
* 
*
*
*/

public class ClosedHashing {

	/**
	 * Size of the array
	 */
	private int max = 5;
	private hashTableNode[] hashTable = new hashTableNode[max];
	
	/**
	 * Constructor method that sets every
	 * cell in the array equal to null
	 */
	ClosedHashing() {
		for (int i = 0; i < max; i++) {
			this.hashTable[i] = null;
		}
	}
	
	/**
	* This method loops through the hashTableNode array 
	* comparing each 
	* 
	* 
	* 
	*/
	public void search() {
		
	}
	/**
	* 
	* 
	* 
	*
	*/
	public void insert() {}
	
	
	/**
	* 
	* 
	*
	*/
	public void delete() {}
	
	
	/**
	* 
	* 
	* 
	*/
	public void doubleHashing() {}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Add method.
	 *
	 * Add an element to the hash table.
	 *
	 * @param int key
	 *  Integer key.
	 * @param int i
	 *  Stepsize.
	 * @return void
	 */
	public void add(int key, int i) {

		int hashcode = this.h(key, i);

		if ((i > 0) && (hashcode == this.h(key, 0))) {

			System.out.println("It's not possible to add the key " + key + " in hash table.");
			return;
		}

		if (this.vector[hashcode] != null) {
			
			this.add(key, i + 1);
		}
		else {

			this.vector[hashcode] = new HashTableNode(key);
		}
	}

	/**
	 * Overloading of add() method.
	 *
	 * Simplifies the call of method.
	 */
	public void add(int key) {

		this.add(key, 0);
	}

	/**
	 * Search method.
	 *
	 * Search an element in hash table.
	 *
	 */
	public int search(int key, int i) {

		int hashcode = this.h(key, i);

		if ((i > 0) && (hashcode == this.h(key, 0))) {

			System.out.println("Key " + key + " not found in hash table. It was made " + i + " stepsizes.");

			return -99;
		}

		if ((this.vector[hashcode] != null) && (this.vector[hashcode].key == key)) {

			System.out.println("Key " + key + " found in hash table in " + (i + 1) + "-esim stepsize.");

			return hashcode;
		}
		
		return this.search(key, i + 1);
	}

	/**
	 * Overloading of search() method.
	 *
	 * Simplifies the call of method.
	 */
	public int search(int key) {

		return this.search(key, 0);
	}

	/**
	 * Remove method.
	 *
	 * Remove an element from the hash table.
	 */
	public void remove(int key) {

		int i = this.search(key);

		if (i != -99) {
			
			System.out.println("The key " + key + " was removed from hash table.");

			this.vector[i] = null;
		}
		else {

			System.out.println("The key " + key + " was not removed, because it does not exists in hash table.");
		}
	}

	/**
	 * Linear probing.
	 */
	public int h_linear(int key, int i) {

		return (key + i) % this.max;
	}

	/**
	 * Quadratic probing.
	 */
	public int h_quadratic(int key, int i) {

		return (key + (i * i)) % this.max;
	}

	/**
	 * Double hashing.
	 */
	public int h_double(int key, int i) {

		return (this.h_double2(key) + i) % this.max;
	}

	/**
	 * Auxiliar hash function to Double hashing made by h_double() method.
	 */
	public int h_double2(int key) {

		return (1 + key) % (this.max - 1);
	}

	/**
	 * Hash function.
	 */
	public int h(int key, int i) {

		return this.h_linear(key, i);
	}

	/**
	 * toString method.
	 *
	 * Provide some visual funcionality to see the elements inside the hash table.
	 *
	 * @return String
	 *  Representation of the hash table in the moment by a string.
	 */
	public String toString() {

		String description = "Hash table: [ ";

		for (int i = 0; i < this.max; i++) {
			
			if (this.vector[i] == null) {
				
				description += "__  ";
			}
			else {

				description += String.format("%2d  ", this.vector[i].key);
			}
		}

		description += "]";

		return description;
	}
}