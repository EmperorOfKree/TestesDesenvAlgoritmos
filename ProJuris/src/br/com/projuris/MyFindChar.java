package br.com.projuris;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.Map;

public class MyFindChar implements FindCharachter {

	@Override
	public char findChar(String word) {
		//Map<Character, Integer> frequencyMap = coolWay(word);
		Map<Character, Integer> frequencyMap = commonWay(word);
		
		return getResult(word, frequencyMap);
	}
	
	private char getResult(String word, Map<Character, Integer> frequencyMap) {
		// It could be done with a .forEach() and a conditional if as well.
		for (int i = 0; i < word.length();  i++) {
	        if (frequencyMap.get(word.charAt(i)) == 1) { 
	        	return word.charAt(i);
	        }
	    }

		return ' ';
	}

	private Map<Character, Integer> coolWay(String word) {
		//return optionOne(word);
		return optionTwo(word);
	}
	
	private Map<Character, Integer> optionOne(String word) {
		return word.chars().boxed().collect(Collectors.toMap(
				key -> Character.valueOf((char) key.intValue()), // key of our MAP
                value -> 1, // Initial value for the defined key
                Integer::sum)); // counting/Adding for every matching character in the MAP
	}
	
	private Map<Character, Integer> optionTwo(String word) {
		Map<Character, Integer> frequencyMap = new HashMap<Character, Integer>();

		// Map.merge is such a handy method. Could've used the .forEachOrdered, but I'm not sure if it would be 
		// more/as efficient than/as simple indexed loop.
		for (char c : word.toCharArray()) {
			frequencyMap.merge(c, 1, Integer::sum);
		}
		
		return frequencyMap;
	}
	
	private Map<Character, Integer> commonWay(String word) {
		// No secrets here
		Map<Character, Integer> frequencyMap = new HashMap<Character, Integer>();
		char[] charArray = word.toCharArray();

		for (char c : charArray) {
			if (frequencyMap.containsKey(c)) {
				frequencyMap.put(c, frequencyMap.get(c) + 1);
			} else {
				frequencyMap.put(c, 1);
			}
		}

		return frequencyMap;
	}
}
