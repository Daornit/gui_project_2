package project.Controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import project.JavaFXUtil;
import project.Service.MainBoxServices;

public class MainBoxController {
    // FXMLLoaders for dynamic Side-Bar
    private FXMLLoader loaderCreateLoan = new FXMLLoader(getClass().getResource("../View/create_loan.fxml"));
    private FXMLLoader loaderHome = new FXMLLoader(getClass().getResource("../View/home.fxml"));
    private FXMLLoader loaderSearch;
    private FXMLLoader loaderReport = new FXMLLoader(getClass().getResource("../View/report/report_main.fxml"));

    // Store Current Active Item on Side-Bar
    private HBox currentActive;

    // Side-Bar item ids for change Side-Bar active status
    @FXML
    private HBox hbGoHome;
    @FXML
    private HBox hbGoCreateLoan;
    @FXML
    private HBox hbGoSearch;
    @FXML
    private HBox hbGoReport;

    // For BorderPane container for dynamic content render
    @FXML
    private BorderPane bpContent;

    // Mouse clicks for change current active item on Side-Bar and Change dynamically content of BorderPane
    @FXML
    void goHome(MouseEvent event) {
        if (MainBoxServices.changeSideBarActiveItem(currentActive, hbGoHome)) {
            JavaFXUtil.loadUI(bpContent, loaderHome);
            currentActive = hbGoHome;
        }
    }
    @FXML
    void goCreateLoan(MouseEvent event) {
        if (MainBoxServices.changeSideBarActiveItem(currentActive, hbGoCreateLoan)) {
            JavaFXUtil.loadUI(bpContent, loaderCreateLoan);
            currentActive = hbGoCreateLoan;
        }
    }
    @FXML
    void goSearch(MouseEvent event) {

    }
    @FXML
    void goReport(MouseEvent event) {
        if (MainBoxServices.changeSideBarActiveItem(currentActive, hbGoReport)) {
            JavaFXUtil.loadUI(bpContent, loaderReport);
            currentActive = hbGoReport;
        }
    }

    // exit
    @FXML
    void onClickExit(MouseEvent event) {
        // Todo ask are you sure?
        Platform.exit();
    }

    @FXML
    void initialize() {
        // When open select Home as active
        currentActive = this.hbGoHome;
        JavaFXUtil.loadUI(bpContent, loaderHome);
    }
}
