package pl.sda.rafal.zientara.swing;

import java.util.LinkedHashSet;
import java.util.Set;

public class Hangman {
    private String puzzle;
    private Set<Character> guessedLetters = new LinkedHashSet<>();
    private int hp;

    public void setPuzzle(String puzzle) {
        this.puzzle = puzzle;
        this.hp=7;
        guessedLetters.clear();
    }

    public String getOutput() {
        String output = "";
        for (int i = 0; i < puzzle.length(); i++) {
            char c =puzzle.charAt(i);
            if (Character.isWhitespace(c)){
                output += " ";
            } else {
                if(guessedLetters.contains(Character.toLowerCase(c))){
                    output+=c;
                } else {
                    output += ".";
                }
            }
        }
        return output;
    }

    public void guessLetter(char m) {
        if(hp!=0) {
            char smallChar = Character.toLowerCase(m);
            guessedLetters.add(Character.toLowerCase(m));
            boolean isCorrect = puzzle.toLowerCase().contains(Character.toString(smallChar));
            if (!isCorrect) {
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
        return getHp()>0;
    }
    public boolean isGameOver(){
        return isPuzzleSolved() || !isAlive();
    }
}
