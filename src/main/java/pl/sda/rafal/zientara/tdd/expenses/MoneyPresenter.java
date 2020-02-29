package pl.sda.rafal.zientara.tdd.expenses;

import java.io.*;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MoneyPresenter implements MoneyContract.Presenter {

    private final MoneyContract.View view;
    private List<Cost> costs = new ArrayList<>();
    private List<Cost> lastResult = new ArrayList<>();
    private double fromPrice;
    private double toPrice;
    private String word;
    private LocalDate fromDate;
    private LocalDate toDate;

    public MoneyPresenter(MoneyContract.View view) {
        this.view = view;
    }

    @Override
    public void prepareData() {
        File file = new File("zakupy.csv");

        try {
            FileReader reader = new FileReader(file);
            BufferedReader buffer = new BufferedReader(reader);
            boolean firstIgnore = false;
            String line = buffer.readLine();
            while (line != null) {
                if(!firstIgnore){
                    firstIgnore = true;
                } else {
                    Cost cost = parseCost(line);
                    costs.add(cost);
                }
                line = buffer.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initData() {
        view.refreshList(costs);
    }

    private Cost parseCost(String line) {
        String[] split = line.split(";");
        String shopName = split[0];
        double price = Double.parseDouble(split[1]
                .replace(",", ".")
                .replace("\"", ""));

        String input = split[2];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(input, formatter);

        return new Cost(shopName, price, date);
    }

    @Override
    public void onWordChange(String word) {
        this.word = word;
        lastResult = costs.stream()
                .filter(cost -> cost.shopName.contains(word))
                .collect(Collectors.toList());
        view.refreshList(lastResult);
    }

    @Override
    public void onPriceFromChange(double fromPrice) {
        this.fromPrice = fromPrice;
        refreshAndShow();
    }

    @Override
    public void onPriceToChange(double toPrice) {
        this.toPrice = toPrice;
        refreshAndShow();
    }

    @Override
    public void onFromDateChange(LocalDate fromDate) {
        this.fromDate = fromDate;
        refreshAndShow();
    }

    @Override
    public void onToDateChange(LocalDate toDate) {
        this.toDate = toDate;
        refreshAndShow();
    }

    private void refreshAndShow() {
        refreshResults();
        view.refreshList(lastResult);
    }

    private void refreshResults() {
        Stream<Cost> stream = costs.stream();
        if(word != null) {
            stream = stream.filter(cost -> cost.shopName.contains(word));
        }
        if(fromPrice > 0) {
            stream = stream.filter(cost -> cost.price >= fromPrice);
        }
        if(toPrice > 0) {
            stream = stream.filter(cost -> cost.price <= toPrice);
        }
        if(fromDate != null) {
            stream = stream.filter(cost -> !cost.date.isBefore(fromDate));
        }
        if(toDate != null) {
            stream = stream.filter(cost -> !cost.date.isAfter(toDate));
        }
        lastResult = stream.collect(Collectors.toList());
    }

    @Override
    public List<Cost> getLastResult() {
        return lastResult;
    }
}
