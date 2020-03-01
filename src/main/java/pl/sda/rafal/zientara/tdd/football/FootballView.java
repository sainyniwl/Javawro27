package pl.sda.rafal.zientara.tdd.football;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class FootballView extends JComponent {

    private FootballBoard board;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(5));
        g.setColor(Color.LIGHT_GRAY);

        int cellW = getWidth() / board.width;
        int cellH = getHeight() / board.height;

        for (int i = 0; i < board.height; i++) {
            int y = i * cellH;
            int x1 = 0;
            int x2 = getWidth();
            g.drawLine(x1, y, x2, y);
        }

        for (int i = 0; i < board.width; i++) {
            int x = i * cellW;
            int y1 = 0;
            int y2 = getHeight();
            g.drawLine(x, y1, x, y2);
        }

        g.drawLine(0, 0, getWidth(), getHeight());
        g.setColor(Color.black);

        List<Line> lines = board.getLines();

        for (Line line : lines) {
            g.drawLine(line.start.x * cellW, line.start.y * cellH,
                    line.end.x * cellW, line.end.y * cellH);
        }
    }

    public void setBoard(FootballBoard board) {
        this.board = board;
    }
}
