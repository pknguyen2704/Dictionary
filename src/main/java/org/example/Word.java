package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Word {
    private String wordTarget;
    private String wordExplain;

    public Word() {
        this.wordTarget = "";
        this.wordExplain = "";
    }
    public String getWordExplain() {
        return wordExplain;
    }

    public void setWordExplain(String wordExplain) {
        this.wordExplain = wordExplain;
    }

    public String getWordTarget() {
        return wordTarget;
    }

    public void setWordTarget(String wordTarget) {
        this.wordTarget = wordTarget;
    }
    public String getWord() {
        return (this.getWordTarget() + "\t" + this.getWordExplain());
    }
}