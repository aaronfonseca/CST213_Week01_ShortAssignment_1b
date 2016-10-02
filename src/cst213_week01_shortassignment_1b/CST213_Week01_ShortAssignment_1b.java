/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cst213_week01_shortassignment_1b;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author aaron.fonseca
 */
public class CST213_Week01_ShortAssignment_1b implements java.io.Serializable {

    		private static int totalWords = 0;
		private static int totalCharacters = 0;
                private static int totalNumber = 0;
                private static String numbers = "";
		private static String textFile;

    public static void readFileAndPrintCounts(String myFile) throws FileNotFoundException {
 
		// Read file contents
                
		try (BufferedReader textBuffer = new BufferedReader(new FileReader(myFile))) {
			printLog("========== File Content ==========");
 
			// read each line one by one
			while ((textFile = textBuffer.readLine()) != null) {
				printLog(textFile);
 
				// ignore multiple white spaces
				String[] myWords = textFile.replaceAll("\\s+", " ").split(" ");
 
				for (String word : myWords) {
					totalCharacters += word.length();
				}
                                
				totalWords += myWords.length;
                                numbers += textFile.replaceAll("[^0-9]+", "");
                                
			}
                        for (int i = 0; i < numbers.length(); i++){
                                    int add = Character.getNumericValue(numbers.charAt(i));
                                    totalNumber = totalNumber + add;
                                }
		} catch (IOException e) {
			e.printStackTrace();
		}
		printLog("\n========== Result ==========");
 
		printLog("* Total Characters: " + totalCharacters);
		printLog("* Total Words: " + totalWords);
                printLog("* Sum of all Numers: " + totalNumber);
	}
    
    public void setTotalWords(int totalWords){
        this.totalWords = totalWords;
    }                  

    public void setTotalCharacters(int totalCharacters){
        this.totalCharacters = totalCharacters;
    }

    public void setNumbers(String numbers){
        this.numbers = numbers;
    }

    public void setTextFile(String textFile){
        this.textFile = textFile;
    }
    
    public int getTotalWords(){
        return this.totalWords;
    }             

    public int getTotalCharacters(){
        return this.totalCharacters;
    }

    public String getNumbers(){
        return this.numbers;
    }

    public String getTextFile(){
        return this.textFile;
    }
    
    private static void printLog(String string) {
            System.out.println(string);
    }
    
    public static void main(String[] args) {
        try {
                String myFile = "alice.txt";
                readFileAndPrintCounts(myFile);
        } catch (FileNotFoundException e) {
                e.printStackTrace();
        }
    }
    
}
