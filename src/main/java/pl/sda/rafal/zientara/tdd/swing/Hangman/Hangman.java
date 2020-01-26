package pl.sda.rafal.zientara.tdd.swing.Hangman;

import java.util.LinkedHashSet;
import java.util.Set;

public class Hangman {
    private String puzzle;
    private Set<Character> guessedLetters = new LinkedHashSet<>();

    public void setPuzzle(String puzzle) {
        this.puzzle = puzzle;
    }

    public String getOutput() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < puzzle.length(); i++) {
            char c = puzzle.charAt(i);
            if(Character.isWhitespace(c)){
                output.append(" ");
            } else {
                if (guessedLetters.contains(Character.toLowerCase(c))){
                    output.append(c);
                } else {
                    output.append(".");
                }
            }
        }
        return output.toString();
    }

    public void guessLetter(char c) {
        guessedLetters.add(Character.toLowerCase(c));
    }
}
