package com.techelevator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FindAndReplace {

	private static Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.print("Please enter word to be replaced: ");
		String wordSearch = userInput.nextLine();

		System.out.print("Please enter word to replace with: ");
		String replaceWord = userInput.nextLine();

		System.out.print("Please enter source file path: ");
		File sourceFile = new File(userInput.nextLine());

		if (sourceFile.exists() && sourceFile.isFile()) {
			System.out.print("Enter the path to copy to: ");
			String destPath = userInput.nextLine();
			File destFile = new File(destPath);
			try (Scanner sourceScanner = new Scanner(sourceFile)) {
				try (PrintWriter destWriter = new PrintWriter(destFile)) {
					while (sourceScanner.hasNextLine()) {
						String line = sourceScanner.nextLine();
						line = line.replace(wordSearch, replaceWord);
						destWriter.println(line);
					}
				}
			} catch (IOException e) {
				System.out.println("Couldn't create new file!");
			}
		} else {
			System.out.println("This file does not exist");
		}

	}

}
