package Swing;

public enum FieldStatus {
    X,O,EMPTY;
    public String getEmpty() {
        switch (this) {
            case EMPTY:
                return " ";
            case O:
                return "O";
            case X:
                return "X";
            default:
                throw new IllegalStateException();
        }
    }
}
