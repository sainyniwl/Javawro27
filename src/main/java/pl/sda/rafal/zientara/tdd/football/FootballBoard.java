package pl.sda.rafal.zientara.tdd.football;

import java.util.ArrayList;
import java.util.List;

public class FootballBoard {

    private final int width;
    private final int height;

    private List<Line> lines;

    public FootballBoard(int width, int height) {
        this.width = width;
        this.height = height;
        lines = new ArrayList<>();
    }

    public void addLine(Line line) {
        lines.add(line);
    }

    public boolean lineExists(Point start, Point end) {
        for (Line line : lines) {
            if(line.start.equals(start) && line.end.equals(end)) {
                return true;
            }
            if(line.start.equals(end) && line.end.equals(start)) {
                return true;
            }
        }
        return false;
    }
}
