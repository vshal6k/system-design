package algomaster.problems.searchautocompletesystem.repository;

import java.util.ArrayList;
import java.util.List;

import algomaster.problems.searchautocompletesystem.entities.Word;

public class WordTrieRepository {
    private WordTrieNode root = new WordTrieNode();

    public void addWord(String word) {
        int n = word.length();
        WordTrieNode curr = root;
        for (int i = 0; i < n; i++) {
            char currChar = word.charAt(i);
            if (curr.next[currChar - 'a'] == null)
                curr.next[currChar - 'a'] = new WordTrieNode();
            curr = curr.next[currChar - 'a'];
        }
        curr.count++;
    }

    public List<Word> getWordsStartingWith(String prefix) {
        int n = prefix.length();
        WordTrieNode curr = root;
        for (int i = 0; i < n; i++) {
            char currChar = prefix.charAt(i);
            if (curr.next[currChar - 'a'] == null)
                return new ArrayList<>();
            curr = curr.next[currChar - 'a'];
        }
        List<Word> collection = new ArrayList<>();
        fillWords(curr, prefix, collection);
        return collection;
    }

    private void fillWords(WordTrieNode root, String current, List<Word> collection) {
        if (root.count != 0) {
            collection.add(new Word(root.count, current));
        }

        for (int i = 0; i < 26; i++) {
            if (root.next[i] != null) {
                fillWords(root.next[i], current + (char) ('a' + i), collection);
            }
        }
    }

    private class WordTrieNode {
        int count;
        WordTrieNode[] next = new WordTrieNode[26];
    }
}
