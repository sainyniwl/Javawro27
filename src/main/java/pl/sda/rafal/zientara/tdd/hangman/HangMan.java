package pl.sda.rafal.zientara.tdd.hangman;

import java.util.LinkedHashSet;
import java.util.Set;

public class HangMan {

    private String puzzle;
    private Set<Character> guessedLetters;
    private int hp;

    public HangMan() {
    }

    public String getOutput() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < puzzle.length(); i++){
            char c = puzzle.charAt(i);
            if(Character.isWhitespace(c)) {
                output.append(" ");
            }else {
                if(guessedLetters.contains(Character.toLowerCase(c))){
                    output.append(c);
                }else output.append("*");
            }
        }
        return output.toString();
    }

    public void setPuzzle(String text) {
        this.puzzle = text;
        hp = 7;
        guessedLetters = new LinkedHashSet<>();

    }

    public String getPuzzle() {
        return puzzle;
    }

    public void guessLetters(char n) {
        if (hp != 0) {
            char letter = Character.toLowerCase(n);
            guessedLetters.add(letter);
            boolean isCorrect = puzzle.toLowerCase()
                    .contains(Character.toString(letter));
            if(isCorrect) {
                if(!isOver()) System.out.println("DOBRY STRZAŁ\n");
                else if(isOver()) System.out.println("BRAWO, ZGADŁEŚ !!!!!!");
            }
            if (!isCorrect && !getOutput().equals(puzzle)) {
                hp--;
                if(!isOver())System.out.println("ŹLE - ZAWIŚNIESZ !!!\n");
                else if(isOver() && hp <=0 ) System.out.println("ZAWISŁEŚ - WISIELCU !!!!!!!!!!");
            }
        }
    }


        public int getHp () {
            return hp;
        }

    public boolean isOver() {
        return hp<=0 || getOutput().equals(puzzle);
    }
}


