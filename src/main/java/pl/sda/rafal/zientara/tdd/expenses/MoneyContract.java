package pl.sda.rafal.zientara.tdd.expenses;

import java.util.List;

public class MoneyContract {

    public interface View {
        void refreshList(List<Cost> data);
    }

    public interface Presenter {
        void prepareData();
        void initData();
        void onWordChange(String word);
        void onPriceFromChange(double fromPrice);

        List<Cost> getLastResult();
    }
}