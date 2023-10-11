package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class DictionaryManagement {
    public static void insertFromCommandline(ArrayList<Word> dictionary) {
        // input
        Scanner sc = new Scanner(System.in);
        String wordTarget = sc.nextLine();
        String wordExplain = sc.nextLine();
        Word newWord = new Word();
        newWord.setWordTarget(wordTarget);
        newWord.setWordExplain(wordExplain);
        dictionary.add(newWord);
    }

    public void insertFromFile(ArrayList<Word> dictionary, String path) {
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Word newWord = new Word();
                String[] parts = line.split("\t");
                String wordTarget = "", wordExplain = "";
                if (parts.length == 2) {
                    wordTarget = parts[0].trim();
                    wordExplain = parts[1].trim();
                }
                newWord.setWordTarget(wordTarget);
                newWord.setWordExplain(wordExplain);
                dictionary.add(newWord);
            }
        } catch (IOException error) {
            error.printStackTrace();
        }
    }

    public void dictionaryExportToFile(ArrayList<Word> dictionary, String path) {
        try {
            FileWriter fileWriter = new FileWriter(path);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Word word : dictionary) {
                bufferedWriter.write(word.getWordTarget() + "\t" + word.getWordExplain());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (Exception error) {
            System.out.println("Error: " + error);
        }
    }

    public void dictionaryLookup(ArrayList<Word> dictionary, String word) {
        try {
            Scanner newScanner = new Scanner(System.in);
            for (int i = 0; i < dictionary.size(); i++) {
                if(Objects.equals(dictionary.get(i).getWordTarget(), word)) {
                    System.out.print(dictionary.get(i).getWord());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
