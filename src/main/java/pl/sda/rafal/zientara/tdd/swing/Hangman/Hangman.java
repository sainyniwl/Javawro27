package pl.sda.rafal.zientara.tdd.swing.Hangman;

import java.util.LinkedHashSet;
import java.util.Set;

public class Hangman {
    private int hp = 7;
    private String puzzle;
    private Set<Character> guessedLetters = new LinkedHashSet<>();

    public void setPuzzle(String puzzle) {
        this.hp = 7;
        this.puzzle = puzzle;
        guessedLetters.clear();
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
        if (hp != 0) {
            char smallChar = Character.toLowerCase(c);
            guessedLetters.add(Character.toLowerCase(c));
            boolean isCorrect = puzzle.toLowerCase().contains(Character.toString(smallChar));

            if (!isCorrect){
                hp--;
            }
        }
    }

    public int getHp() {
        return hp;
    }

    public boolean isPuzzleSolved() {
        return getOutput().equals(puzzle);
    }

    public boolean isAlive(){
        return getHp() > 0;
    }

    public boolean isGameOver(){
        return isPuzzleSolved() || !isAlive();
    }

}
