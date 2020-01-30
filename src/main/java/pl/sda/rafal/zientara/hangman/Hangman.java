package pl.sda.rafal.zientara.hangman;

import java.util.LinkedHashSet;
import java.util.Set;

public class Hangman {

    private String puzzle;
    private int hp = 7;
    private Set<Character> guessedLetters = new LinkedHashSet<>();

    public void setPuzzle(String puzzle) {
        this.puzzle = puzzle;
        hp = 7;
        guessedLetters.clear();
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
        if (hp != 0) {
            char smallChar = Character.toLowerCase(c);
            guessedLetters.add(smallChar);
            boolean isCorrect = puzzle.toLowerCase().
                    contains(Character.toString(smallChar));
            if (!isCorrect) {
                hp--;
            }
        }
    }

    public void guessLetter(String c) {
        if (hp != 0) {
            boolean isCorrectWholePassword = c.equalsIgnoreCase(puzzle);
            if (isCorrectWholePassword)
                for (int i = 0; i < c.length(); i++)
                    guessedLetters.add(Character.toLowerCase(c.charAt(i)));
            else
                hp--;
        }
    }

    public int getHp() {
        return hp;
    }

    public boolean isPuzzleSolved() {
        return getOutput().equals(puzzle);
    }

    public boolean isDeath(){
        return getHp() == 0;
    }
    public boolean isGameOver(){
        return isPuzzleSolved() || isDeath();
    }
}
