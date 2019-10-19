package co.grandcircus;

import java.util.Scanner;

public class PigLatinTranslator {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		String response = "";
		String responseLetter = "";
		
		do {
			
			System.out.println("Welcome the the Pig Latin Translator!");
			System.out.println("Enter a line to be translated: ");
			String userInput = scnr.nextLine();
			String[] sentence = userInput.split(" ");
			if (sentence.length >= 1) {
				System.out.println("\n\n#################################################################");
				for (String word : sentence) {
					System.out.print(translateText(word) + " ");
				}
				System.out.println("\n#################################################################");
			} else {
				System.out.println(translateText(userInput));
			}
			System.out.println("\n\nTranslate another line? (y/n)");
			response = scnr.nextLine().toLowerCase();
			responseLetter = Character.toString(response.charAt(0));
			
		} while(responseLetter.equalsIgnoreCase("y"));
		 
		 scnr.close();

	}
	
	public static String translateText(String input) {
		String output = input;
		String regExp = ".*[\\p{Punct}&&[^']]+.*"; // . means matches any character, * means 0 or more, \\p{Punct} refers to within the Pattern
		//class that includes all of the punctuation !"#$%&'()*+,-./:;<=>?@[\]^_`{|}~, '&&' means 'and', in brackets [], ^ means not including,
		// ' is apostrophe, + means 1 or more times
		String firstLetter = String.valueOf(output.charAt(0));
		
		if (output.matches(".*[0-9].*")) {  //. means matches any character, * means 0 or more, in the brackets [], 0-9 means any digit between 0 and 9 
			output = "\nInvalid input. Please avoid using numbers and special characters\n";
		} else if (output.matches(regExp)) {
			output = "\nnInvalid input. Please avoid using numbers and special characters\n";
		}
		
		else if (firstLetter.matches("[AEIOUaeiou]")) {
			output = output + "way";
		} else if (firstLetter.matches("[BCDFGHJKLMNPQRSTVWXYZbcdfghjklmnpqrstvwxyz]")) {
			output = output.substring(1, output.length()) + firstLetter + "ay";
		} 
		
		return output;
		
		
		
	}

}
