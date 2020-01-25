package pl.sda.rafal.zientara;

public enum FieldStatus {
    EMPTY,
    X,
    O;

    public String getText(){

        switch (this){
            case EMPTY:
                return " ";
            case O:
                return "O";
            case X:
                return "X";
            default:
                throw new IllegalStateException("Nope");
        }
    }
}
