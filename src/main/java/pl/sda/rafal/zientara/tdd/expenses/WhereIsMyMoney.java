package pl.sda.rafal.zientara.tdd.expenses;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDate;
import java.util.List;

public class WhereIsMyMoney implements MoneyContract.View {

    private static final int FIELD_WIDTH = 400;
    private static final int FIELD_HEIGHT = 50;
    private static final int PADDING = 50;
    private JFrame frame;
    private JTextField shopInput;
    private JTextField dateFrom;
    private JTextField dateTo;
    private JTextField costTo;
    private JTextField costFrom;
    private JList result;
    private MoneyContract.Presenter presenter = new MoneyPresenter(this);

    @Override
    public void refreshList(List<Cost> data) {
        DefaultListModel<String> list = new DefaultListModel<>();
        for(Cost cost : data) {
            list.addElement(cost.toString());
        }

        result.setModel(list);
    }

    public WhereIsMyMoney() {
        frame = new JFrame("WTF");
        frame.setSize(FIELD_WIDTH + 2 * PADDING, 600);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JLabel names = new JLabel("Filter by name");
        names.setBounds(PADDING, 0, FIELD_WIDTH, FIELD_HEIGHT);
        frame.add(names);
        shopInput = new JTextField();
        shopInput.setBounds(PADDING, PADDING, FIELD_WIDTH, FIELD_HEIGHT);
        shopInput.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {
                presenter.onWordChange(shopInput.getText());
            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {

            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {

            }
        });
        frame.add(shopInput);
        JLabel fromToDate = new JLabel("Filter by date from to");
        fromToDate.setBounds(PADDING, 100, FIELD_WIDTH, FIELD_HEIGHT);
        frame.add(fromToDate);
        dateFrom = new JTextField();
        dateFrom.setBounds(PADDING, 150, 150, FIELD_HEIGHT);
        dateFrom.addKeyListener(new DateListener(dateFrom) {
            @Override
            public void onDateUpdate(LocalDate newDate) {
                presenter.onFromDateChange(newDate);
            }
        });
        frame.add(dateFrom);
        dateTo = new JTextField();
        dateTo.setBounds(250, 150, 150, FIELD_HEIGHT);
        dateTo.addKeyListener(new DateListener(dateTo) {
            @Override
            public void onDateUpdate(LocalDate newDate) {
                presenter.onToDateChange(newDate);
            }
        });
        frame.add(dateTo);
        JLabel fromToCost = new JLabel("Filter by price from to");
        fromToCost.setBounds(PADDING, 200, FIELD_WIDTH, FIELD_HEIGHT);
        frame.add(fromToCost);
        costFrom = new JTextField();
        costFrom.setBounds(PADDING, 250, 75, FIELD_HEIGHT);
        costFrom.addKeyListener(new DoubleListener(costFrom) {
            @Override
            public void onValueUpdate(Double newValue) {
                if(newValue != null) {
                    presenter.onPriceFromChange(newValue);
                } else {
                    presenter.onPriceFromChange(-1);
                }
            }
        });
        frame.add(costFrom);
        costTo = new JTextField();
        costTo.setBounds(175, 250, 75, FIELD_HEIGHT);
        costTo.addKeyListener(new DoubleListener(costTo) {
            @Override
            public void onValueUpdate(Double newValue) {
                if(newValue != null) {
                    presenter.onPriceToChange(newValue);
                } else {
                    presenter.onPriceToChange(-1);
                }
            }
        });
        frame.add(costTo);
        result = new JList<>();
        result.setBounds(PADDING, 350, FIELD_WIDTH, FIELD_HEIGHT*4);
        frame.add(result);
        frame.setVisible(true);
        presenter.prepareData();
        presenter.initData();
    }
}
