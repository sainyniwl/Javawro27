package pl.sda.rafal.zientara.tdd.football;

public class FootballContract {

    public interface View {

    }

    public interface Presenter {
        void init();
        void moveTop();
        void moveTopRight();
        void moveRight();
        void moveBottomRight();
        void moveBottom();
        void moveBottomLeft();
        void moveLeft();
        void moveTopLeft();
    }
}
