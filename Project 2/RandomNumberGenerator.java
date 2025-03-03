import java.util.ArrayList;
import java.util.Random;

public class RandomNumberGenerator {
//	Initialize variables
	private int indexInput;
	private int randomNumber;
	static int returnedIndexInput;
	
//	Initialize constructor 
	public RandomNumberGenerator(int Index){
		this.indexInput = Index;
	}
	
//	create an array list and a an exception to catch IndexOutOfBoundsException
	public int randomNumGen()throws IndexOutOfBoundsException{
		ArrayList arrayOfIntegers = new ArrayList();
		Random randomInt = new Random();
		
//		Creating an array of 100 with an array list
		for (int i = 0; i < 101; i++) {
			randomNumber = 1 + randomInt.nextInt(100);
			arrayOfIntegers.add(randomNumber);		
		}
//		System.out.println(arrayOfIntegers.size());
		if ((indexInput < 1) || (indexInput > 100)){
			throw new IndexOutOfBoundsException("Out of Bound");
		}
		else {
			returnedIndexInput = (Integer) arrayOfIntegers.get(indexInput);
			return returnedIndexInput;
		}
	}
}
