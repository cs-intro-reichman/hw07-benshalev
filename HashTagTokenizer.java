

public class HashTagTokenizer {

	public static void main(String[] args) {

		String hashTag = args[0];
		String []dictionary = readDictionary("dictionary.txt");
		breakHashTag(hashTag, dictionary);
	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];

		In in = new In(fileName);
	
		for(int i = 0 ; i< 3000 ; i++){
			dictionary[i] = in.readString();
		}
		// Your code here

		return dictionary;
	}

	public static boolean existInDictionary(String word, String []dictionary) {
		// Your code here
		word = word.toLowerCase();
		for(int i = 0 ; i < 3000 ; i++){
			if(dictionary[i].equals(word)){
				return true;
			}
		}
		return false;
		
	}

	public static void breakHashTag(String hashtag, String[] dictionary) {

		// Base case: do nothing (return) if hashtag is an empty string.
        if (hashtag.isEmpty()) {
            return;
        }
 
        int N = hashtag.length();
		String chekWord = "";
        for (int i = 1; i <= N; i++) {
			char ch = hashtag.charAt(i-1);
			chekWord = chekWord + ch;		
				if(existInDictionary(chekWord , dictionary)){
					System.out.println(chekWord);
					breakHashTag(hashtag.substring(i), dictionary);
					
				}
			}return;
        }
    }
