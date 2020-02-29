package pl.sda.rafal.zientara.tdd.expenses;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class MoneyPresenterTest {

    private MoneyContract.Presenter presenter;
    private MoneyContract.View view;

    @BeforeEach
    public void setup(){
        view = mock(MoneyContract.View.class);
        presenter = new MoneyPresenter(view);
        presenter.prepareData();
    }

    @Test
    public void initPresenter(){
        presenter.initData();
        verify(view).refreshList(any());
    }

    @Test
    public void whenQueryChangedRefreshResult(){
        List<Cost> expected = Arrays.asList(
                new Cost("test", 1, LocalDate.of(2020, 1, 1)));
        presenter.onWordChange("test");
        verify(view, times(1)).refreshList(expected);
    }

    @Test
    public void findAllZabka(){
        List<Cost> expected = Arrays.asList(
                new Cost("zabka", 12, LocalDate.of(2020, 1, 16)),
                new Cost("zabka", 53.23, LocalDate.of(2020, 1, 23)),
                new Cost("zabka", 12, LocalDate.of(2020, 1, 16)),
                new Cost("zabka", 700.01, LocalDate.of(2020, 1, 23)));
        presenter.onWordChange("zab");
        verify(view, times(1)).refreshList(expected);
    }

    @Test
    public void findCostByNameAndPrice() {
        presenter.onWordChange("zabka");
        presenter.onPriceFromChange(500.);
        verify(view, times(2)).refreshList(any());
        List<Cost> lastResult = presenter.getLastResult();
        assertEquals(1, lastResult.size());
    }

    @Test
    public void filterByToPrice() {
        presenter.onPriceToChange(15);
        verify(view, times(1)).refreshList(any());
        List<Cost> lastResult = presenter.getLastResult();
        assertEquals(3, lastResult.size());
    }

    @Test
    public void filterByFromDate() {
        presenter.onFromDateChange(LocalDate.of(2020, 1, 20));
        verify(view, times(1)).refreshList(any());
        List<Cost> lastResult = presenter.getLastResult();
        assertEquals(6, lastResult.size());
    }

    @Test
    public void filterByToDate() {
        presenter.onToDateChange(LocalDate.of(2020, 1, 31));
        verify(view, times(1)).refreshList(any());
        List<Cost> lastResult = presenter.getLastResult();
        assertEquals(17, lastResult.size());
    }

}