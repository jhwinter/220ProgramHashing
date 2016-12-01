package menu;

public class searchMethod 
{
	public int searchElement(int key, int i)
	{
		int hashcode = this.hashcode(key,i);
		
		//if((i > 0) && (hashcode == this.hashcode(key, 0)))
		{
			System.out.println("key"+key+"not found in hashtable.");
			return -99;
		}
		//if(this.(ourHashTable)[hashcode] !=null)&& (this.(ourHashTable)[hashcode].key==key)
		//{
			//System.out.println("Key"+key+"Found! we have found the key you are looking for");
		
		//return hashcode;
		//}
		
		//return this.searchElement(key,i+1);
	
	}
	
	private int hashcode(int key, int i) 
	{
		// TODO Auto-generated method stub
		return 0;
	}
}
