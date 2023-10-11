package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryCommandline {
    private DictionaryCommandline commandLine;
    private static final DictionaryManagement management = new DictionaryManagement();

    public static void showAllWord() {
        System.out.println("No | English | Vietnamese");
        for(int i = 0; i < Dictionary.dictionary.size(); i++) {
            System.out.println(i + " | " + Dictionary.dictionary.get(i).getWordTarget() + " | " + Dictionary.dictionary.get(i).getWordExplain());
        }
    }
    public static void dictionaryAdvanced(ArrayList<Word> dictionary) {
        final String path = "C:\\Users\\Andrew\\Desktop\\Dictionary_Database.txt";
        while(true) {
            System.out.println("Welcome to My Application!");
            final int numberFunction = 10;
            for (int i = 0; i < numberFunction; i++) {
                System.out.print("[" + i + "] ");
                switch (i) {
                    case 0:
                        System.out.println("Exit");
                        break;
                    case 1:
                        System.out.println("Add");
                        break;
                    case 2:
                        System.out.println("Remove");
                        break;
                    case 3:
                        System.out.println("Update");
                        break;
                    case 4:
                        System.out.println("Display");
                        break;
                    case 5:
                        System.out.println("Lookup");
                        break;
                    case 6:
                        System.out.println("Search");
                        break;
                    case 7:
                        System.out.println("Game");
                        break;
                    case 8:
                        System.out.println("Import from file");
                        System.out.println();
                        System.out.println();
                        break;
                    case 9:
                        System.out.println("Export to file");
                    default:
                        System.out.println("Action not supported");
                        break;
                }
            }
            System.out.println("Your action: ");
            Scanner newScanner = new Scanner(System.in);
            int selection = newScanner.nextInt();
            if(selection == 0) {
                System.out.println("Bye, bye. See you again!");
                break;
            }
            switch (selection) {
                case 1:
                    return;
                case 2:
                case 3:
                    DictionaryManagement.insertFromCommandline(Dictionary.dictionary);
                    break;
                case 4:
                    showAllWord();
                    break;
                case 5:
                    management.dictionaryLookup(Dictionary.dictionary, path);
                    break;
                case 6:
                    System.out.println("Search");
                    break;
                case 7:
                case 8:
                    management.insertFromFile(Dictionary.dictionary, path);
                    break;
                case 9:
                    management.dictionaryExportToFile(Dictionary.dictionary, path);
                    break;
            }
        }

    }
    public void dictionaryBasic(Dictionary dictionary) {
        DictionaryManagement dictionaryManagement;
    }

    public static void main(String[] args) {
        dictionaryAdvanced(Dictionary.dictionary);
    }
}
