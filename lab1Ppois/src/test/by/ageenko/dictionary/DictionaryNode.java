package by.ageenko.dictionary;

public class DictionaryNode {
    private String englishWord;
    private String russianTranslation;
    private DictionaryNode left, right;

    public DictionaryNode(String englishWord, String russianTranslation) {
        this.englishWord = englishWord;
        this.russianTranslation = russianTranslation;
        this.left = null;
        this.right = null;
    }

    public String getEnglishWord() {
        return englishWord;
    }

    public void setEnglishWord(String newEngWord) {
        englishWord = newEngWord;
    }

    public String getRussianWord() {
        return russianTranslation; // Исправлено
    }

    public void setRussianWord(String newTranslation) {
        this.russianTranslation = newTranslation; // Исправлено
    }

    public DictionaryNode getLeft() {
        return left;
    }

    public void setLeft(DictionaryNode left) {
        this.left = left;
    }

    public DictionaryNode getRight() {
        return right;
    }

    public void setRight(DictionaryNode right) {
        this.right = right;
    }
}