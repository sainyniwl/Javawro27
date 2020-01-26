package pl.sda.rafal.zientara.swing;

public class Hangman {
    private String puzzle;
    public void setPuzzle(String puzzle) {
        this.puzzle = puzzle;
    }

    public String getOutput() {
        String output = "";
        for (int i = 0; i < puzzle.length(); i++) {
            char c =puzzle.charAt(i);
            if (Character.isWhitespace(c)){
                output += " ";
            } else {
                output+=".";
            }
        }
        return output;
    }
}
