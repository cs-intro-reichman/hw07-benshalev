
public class SpellChecker {


	public static void main(String[] args) {
		String word = args[0];
		int threshold = Integer.parseInt(args[1]);
		String[] dictionary = readDictionary("dictionary.txt");
		String correction = spellChecker(word, threshold, dictionary);
		System.out.println(correction);
	}

	public static String tail(String str) {
		// Your code goes here
		str = str.substring(1);
		return str;
	}

	public static int levenshtein(String word1, String word2) {
		// Your code goes here
		if (word1.length() == 0 || word2.length() == 0){
			return(Math.max(word1.length(),word2.length()));
		}

		word1 = word1.toLowerCase();
		word2 = word2.toLowerCase();
		int dis = 0;

		if(word1.charAt(0) == word2.charAt(0)){
			levenshtein(tail(word1), tail(word2));
		}

		else{
			dis++;
			dis = dis + (int)(Math.min(levenshtein(tail(word1), tail(word2)),Math.min(levenshtein((word1), tail(word2)),levenshtein(tail(word1), tail(word2))))); 
			}
			return dis;

	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];

		In in = new In(fileName);

		// Your code here
		for(int i = 0 ; i< 3000 ; i++){
			dictionary[i] = in.readString();
		}

		return dictionary;
	}

	public static String spellChecker(String word, int threshold, String[] dictionary) {
		// Your code goes here
		String firshort = "";
		for(int i = 0 ; i < 3000 ; i++){
			if(levenshtein(word, dictionary[i]) <= threshold){
				firshort = firshort + dictionary;
			}
			
	}
		return firshort;
	}
}
