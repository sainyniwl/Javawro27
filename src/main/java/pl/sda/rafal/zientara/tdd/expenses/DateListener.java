package pl.sda.rafal.zientara.tdd.expenses;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateListener implements KeyListener {

    private final JTextField field;
    private static final DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private static final DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private static final DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter formatter4 = DateTimeFormatter.ofPattern("yyyy.MM.dd");

    public DateListener(JTextField field) {
        this.field = field;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        String input = field.getText();
        LocalDate date = parseDate(input);
        System.out.println(date);
        //TODO przekaz dalej
    }

    private LocalDate parseDate(String input) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
