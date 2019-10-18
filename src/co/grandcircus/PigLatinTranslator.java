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
				for (String word : sentence) {
					System.out.print(translateText(word) + " ");
				}
			} else {
				System.out.println(translateText(userInput));
			}
			System.out.println("\nTranslate another line? (y/n)");
			response = scnr.nextLine().toLowerCase();
			responseLetter = Character.toString(response.charAt(0));
			
			
			
		} while(responseLetter.equalsIgnoreCase("y"));
		 
		 scnr.close();

	}
	
	public static String translateText(String input) {
		String output = input;
		String regExp = ".*[\\p{Punct}&&[^']]+.*";
		String firstLetter = String.valueOf(output.charAt(0));
		
		if (output.matches(".*[0-9].*")) {
			output = "\nInvalid input. Please avoid using numbers and special characters\n";
		} else if (output.matches(regExp)) {
			output = "\nInvalid input. Please avoid using numbers and special characters\n";
		}
		
		else if (firstLetter.matches("[AEIOUaeiou]")) {
			output = output + "way";
		} else if (firstLetter.matches("[BCDFGHJKLMNPQRSTVWXYZbcdfghjklmnpqrstvwxyz]")) {
			output = output.substring(1, output.length()) + firstLetter + "ay";
		} 
		
		return output;
		
		
		
	}

}
