package utilities;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author juand
 *
 */
public class RandomUT {

	
	/**
	 * @param pArray
	 * @return
	 */
	public Object randomArrayItem(ArrayList<?> pArray) {
		Random r = new Random();
		int index = r.nextInt(pArray.size());
		return pArray.get(index);
	}
	

	
	public int randomNumber(Integer low, Integer high) {
		Random r = new Random();
		return r.nextInt(high-low) + low;
	}
}
