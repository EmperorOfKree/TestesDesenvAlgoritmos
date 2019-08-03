package br.com.projuris;

import java.util.Arrays;
import java.util.Collections;

public class MyFindArray implements FindArray {

	@Override
	public int findArray(int[] array, int[] subArray) {
		return hardWorkWay(array, subArray);
		//return coolWay(array, subArray);
	}
	
	private int coolWay(int[] array, int[] subArray) {
		Integer iArray[] = toInteger(array);
		Integer iSubArray[] = toInteger(subArray); 
		return Collections.lastIndexOfSubList(Arrays.asList(iArray), Arrays.asList(iSubArray));
	}
	
	private int hardWorkWay(int[] array, int[] subArray) {
		// From what I know, this solution is better in terms of complexity, since the normal solution would involve a nested 'for' inside 
		// the first one and, depending on the size of both arrays, the complexity would scale drastically
		int checked = 1;
		
		if (invalidArrays(array, subArray)) {
			return -1;
		}
		
		for (int i = array.length-1; i >= 0; i--) {
			// checks if the number is equals equals to the number into position-checked. First loop will be the last ones.
			if (array[i] == subArray[subArray.length-checked]) { // if they are equals, increase the checked.
				checked++;
			
			} else if (array[i] == subArray[subArray.length-1]) { // if they're not equals, then, it might be equal to the last one of the subArray .
				checked = 2;
				
			} else { // if not equals to any of them, reset the process.
				checked = 1;
			}
			
			if (checked-1 == subArray.length) { // whenever checked-1 is equals to the length of subArray, then it means that all numbers were found and wanted index is returned.
				return i;
			}
		}
		
		return -1;
	}
	
	private Integer[] toInteger(int[] array) {
		// A quick fix just to do the coolest way. The right thing would be to the arrays already be a non-primitive.
		// Gotta love stream library.
		return Arrays.stream(array).boxed().toArray(Integer[]::new);
	}
	
	private boolean invalidArrays(int[] array, int[] subArray) {
		return array.length == 0 || subArray.length == 0 || array.length < subArray.length;
	}
}
