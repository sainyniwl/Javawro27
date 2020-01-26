package pl.sda.rafal.zientara.hangman;

public class Hangman {


    private String puzzle;

    public void setPuzzle(String puzzle) {
        this.puzzle = puzzle;
    }

    public String getOutput() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < puzzle.length(); i++) {
            char c = puzzle.charAt(i);
                if(Character.isWhitespace(c)){
                    output.append(" ");
                } else{
                    output.append(".");
                }
        }
        return output.toString();
    }
}
