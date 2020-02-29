package pl.sda.rafal.zientara.tdd.expenses;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class DoubleListener implements KeyListener {

    private final JTextField field;

    protected DoubleListener(JTextField field) {
        this.field = field;
    }

    private Double parseDouble(String input) {
        try {
            return Double.parseDouble(input);
        } catch (Exception ignored) {
        }
        return null;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        String input = field.getText();
        Double value = parseDouble(input);
        System.out.println(value);
        onValueUpdate(value);
    }

    public abstract void onValueUpdate(Double newValue);
}
