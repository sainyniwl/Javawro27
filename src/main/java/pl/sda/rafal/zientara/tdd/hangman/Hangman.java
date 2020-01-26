package pl.sda.rafal.zientara.tdd.hangman;

import java.util.LinkedHashSet;
import java.util.Set;

public class Hangman {

    private String puzzle;
    private Set<Character> guessedLetters;
    private int hp;

    public void setPuzzle(String puzzle) {
        this.puzzle = puzzle;
        hp = 7;
        guessedLetters = new LinkedHashSet<>();
    }

    public String getOutput() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < puzzle.length(); i++) {
            char c = puzzle.charAt(i);
            if (Character.isWhitespace(c)) {
                output.append(" ");
            } else {
                if (guessedLetters.contains(Character.toLowerCase(c))) {
                    output.append(c);
                } else {
                    output.append(".");
                }
            }
        }
        return output.toString();
    }

    public void guessLetter(char c) {
        char smallChar = Character.toLowerCase(c);
        guessedLetters.add(smallChar);
        boolean isCorrect = puzzle.toLowerCase()
                .contains(Character.toString(smallChar));

        if (!isCorrect) {
            hp--;
        }
    }

    public int getHp() {
        return hp;
    }

}
