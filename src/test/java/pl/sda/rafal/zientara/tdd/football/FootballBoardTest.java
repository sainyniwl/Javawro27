package pl.sda.rafal.zientara.tdd.football;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FootballBoardTest {

    private FootballBoard board;

    @BeforeEach
    public void setup() {
        board = new FootballBoard(6, 8);
    }

    @Test
    public void insertedLineCanBeChecked() {
        Line line = new Line(new Point(1, 1), new Point(2, 2), LineType.SIDE);

        board.addLine(line);

        boolean exists = board.lineExists(line.start, line.end);

        assertTrue(exists);
    }

    @Test
    public void insertedLineCanBeCheckedNewInstance() {
        Line line = new Line(new Point(1, 1), new Point(2, 2), LineType.SIDE);

        board.addLine(line);

        boolean exists = board.lineExists(new Point(1, 1), new Point(2, 2));

        assertTrue(exists);
    }

    @Test
    public void insertedLineCanBeCheckedNewInstanceInverted() {
        Line line = new Line(new Point(1, 1), new Point(2, 2), LineType.SIDE);

        board.addLine(line);

        boolean exists = board.lineExists(new Point(2, 2), new Point(1, 1));

        assertTrue(exists);
    }
}