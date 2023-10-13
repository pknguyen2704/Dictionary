package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
public class createDictionaryDatabase {
    public static void main(String[] args) {
        try {
            String path = "/Users/macbookm1/Desktop/word.txt";
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String dictionaryUrl = "";
            while((dictionaryUrl = bufferedReader.readLine()) != null) {
                Document doc = Jsoup.connect(dictionaryUrl).get();
                Elements wordTarget = doc.select(".w");
                Elements wordPronunciation = doc.select(".cB");
                System.out.println(wordTarget.size());
                FileWriter fileWriter = new FileWriter("/Users/macbookm1/Documents/dev/Dictionary/src/resources/dictionary.txt");
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                for(int i = 0; i < wordTarget.size(); i++) {
                    String text = wordPronunciation.get(i).text();
                    // System.out.println(text);
                    bufferedWriter.write(text);
                    bufferedWriter.newLine();
                }

                bufferedWriter.close();
                System.out.println("Data scraped and saved to dictionary.txt");
            }
        } catch (IOException error) {
            error.printStackTrace();
        }
    }
}
