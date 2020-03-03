package com.techelevator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class WordCount {

	public static void main(String[] args) {
		
		
		
		
		
		
		
		

		File myFile = new File("alices_adventures_in_wonderland.txt");
		try (Scanner myScanner = new Scanner(myFile)) {
			int wordCount = 0;
			int sentenceCount = 0;
			while (myScanner.hasNextLine()) {
				String currentLine = myScanner.nextLine();
				currentLine = currentLine.trim();
				if (currentLine.equals("")) {
					continue;
				}
				String[] wordArray = currentLine.split(" +");
				for (String word : wordArray) {
						wordCount ++;
						if (word.endsWith("!")) {
						sentenceCount++;
						} else if (word.endsWith(".")) {
							sentenceCount++;
							}
						else if (word.endsWith("?")) {
							sentenceCount++;
							}
				}

			}
			System.out.println("Word count : " + wordCount);
			System.out.println("Sentence count : " + sentenceCount);

		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}

	}			

}
