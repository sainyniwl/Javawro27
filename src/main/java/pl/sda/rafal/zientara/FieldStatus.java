package pl.sda.rafal.zientara;

public enum FieldStatus {
    EMPTY,
    X,
    O;

    public String getText(){
        switch (this){
            case EMPTY:
                return " ";
            case X:
                return "X";
            case O:
                return "O";
            default:
                throw new IllegalStateException ("Nope");
        }
    }
}
