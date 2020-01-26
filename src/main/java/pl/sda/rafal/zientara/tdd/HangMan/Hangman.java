package pl.sda.rafal.zientara.tdd.HangMan;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

public class Hangman {
private String puzzle;
private Set<Character> guessedLetters = new LinkedHashSet<>();
private int hpLeft;

    public void setPuzzle(String puzzle) {
       hpLeft=7;
       guessedLetters.clear();
        this.puzzle = puzzle;
    }

    public String getOutput() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i <puzzle.length(); i++) {
            char c = puzzle.charAt(i);
            if (Character.isWhitespace(c)) output.append(" ");
            else {
                if (guessedLetters.contains(Character.toLowerCase(c))) {
                    output.append(c);
                }
                else {
                    output.append(".");
                }
            }
        }
        return output.toString();
    }

    public void guessLetter(char c) {
if (hpLeft !=0) {
    char smallChar = Character.toLowerCase(c);
    guessedLetters.add(smallChar);
    boolean isCorrect = puzzle.toLowerCase()
            .contains(Character.toString(smallChar));
    if (!isCorrect) hpLeft--;
}
else System.out.println("You lost");
        }

    public int getHp() {
        return hpLeft;
    }

    public boolean isPuzzleSolved() {
        return getOutput().equals(puzzle);
    }
    public boolean noHp(){
        return hpLeft==0;
    }
    public boolean gameOver() {
        return isPuzzleSolved() || noHp();
    }
}
