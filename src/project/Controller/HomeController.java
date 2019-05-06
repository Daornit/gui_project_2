package project.Controller;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import project.Enums.HistoryStatus;
import project.Enums.LoanStatus;
import project.Service.HomeService;

import java.time.LocalDate;

public class HomeController {
    @FXML
    private AnchorPane conActiveLoan;

    @FXML
    private Label lblActiveLoan;

    @FXML
    private AnchorPane conExpiredLoan;

    @FXML
    private Label lblExpiredLoan;

    @FXML
    private AnchorPane conLendLoan;

    @FXML
    private Label lblLendLoan;

    @FXML
    private AnchorPane conPaidLoan;

    @FXML
    private Label lblPaidLoan;

    // Graph Axis
    @FXML
    private CategoryAxis xAxis;

    @FXML
    private NumberAxis yAxis;

    @FXML
    private BarChart<String, Number> bcGraph;

    // Graph-d ashiglah togtomoluud
    private final static String paid = "PAID";
    private final static String lend = "LEND";

    // Darsan ued nerii daguu hail hiine
    @FXML
    void searchActiveLoan(MouseEvent event) {

    }

    @FXML
    void searchExpiredLoan(MouseEvent event) {

    }

    @FXML
    void searchLendLoan(MouseEvent event) {

    }

    @FXML
    void searchPaidLoan(MouseEvent event) {

    }

    @FXML
    void initialize() {
        // Graph uusgsene
        graphInitializer();

        // Card-d baigaa zeeluudiin medeeleliig n shinechleh
        updateLoanInformation();

        // TODO: Zeeliin status iig n update hiih scheduled work heregtei!
    }

    private void graphInitializer() {
        yAxis.setLabel("Давтамж");
        yAxis.setAutoRanging(false);
        yAxis.setLowerBound(0);
        yAxis.setTickUnit(1);
        yAxis.setMinorTickVisible(false);
        xAxis.setLabel("Өдөр");

        try {
            yAxis.setUpperBound(HomeService.getMaxCountHistoryThisWeek());
            bcGraph.getData().addAll(HomeService.chartInfo());
        } catch (Exception e) {
            System.out.println("Graph ruu ym nemhed aldaa garsan!");
            e.printStackTrace();
        }
    }

    private void updateLoanInformation() {
        String today = LocalDate.now().toString();
        try {
            lblActiveLoan.setText(HomeService.countLoansByByStatusAndDate(LoanStatus.ACTIVE) + "");
            lblExpiredLoan.setText(HomeService.countLoansByByStatusAndDate(LoanStatus.LATE) + "");
            lblLendLoan.setText(HomeService.countHistoryByStatusAndDate(HistoryStatus.LEND, today) + "");
            lblPaidLoan.setText(HomeService.countHistoryByStatusAndDate(HistoryStatus.PAID, today) + "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

