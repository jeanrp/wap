package com.dictionary.model;

import java.util.List;
import java.util.Objects;

public class Entry
{
    private String word;
    private List<String> wordTypeList;
    private List<String> definitionList;

    public Entry(String word, List<String> wordTypeList, List<String> definitionList) {
        this.word = word;
        this.wordTypeList = wordTypeList;
        this.definitionList = definitionList;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public List<String> getWordTypeList() {
        return wordTypeList;
    }

    public void setWordTypeList(List<String> wordTypeList) {
        this.wordTypeList = wordTypeList;
    }

    public List<String> getDefinitionList() {
        return definitionList;
    }

    public void setDefinitionList(List<String> definitionList) {
        this.definitionList = definitionList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry entry = (Entry) o;
        return Objects.equals(word, entry.word) &&
                Objects.equals(wordTypeList, entry.wordTypeList) &&
                Objects.equals(definitionList, entry.definitionList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word, wordTypeList, definitionList);
    }

    @Override
    public String toString() {
        return "Entry{" +
                "word='" + word + '\'' +
                ", wordTypeList=" + wordTypeList.toString() +
                ", definitionList=" + definitionList.toString() +
                '}';
    }
}
