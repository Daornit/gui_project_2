package project.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import project.TextFieldUtils;

import java.time.LocalDate;

public class CreateLoanController {

    // Update every render Loan Id
    @FXML
    private Label lblLoanId;

    @FXML
    private GridPane add_picture;

    @FXML
    private TextField tfRegister;

    @FXML
    private TextField tfLast_name;

    @FXML
    private TextField tfFirst_name;

    @FXML
    private TextField tfPhone;

    @FXML
    private TextField tfPhone_add;

    @FXML
    private TextField tfAddress;

    @FXML
    private ComboBox<?> cbCategory;

    @FXML
    private TextField tfDescription;

    @FXML
    private TextField tfGram;

    @FXML
    private TextField tfPurity;

    @FXML
    private TextField tfQuantity;

    @FXML
    private DatePicker dpStart_date;

    @FXML
    private ComboBox<?> cbDay;

    @FXML
    private TextField tfInterest_rate;

    @FXML
    private TextField tfAmount;

    @FXML
    private Button btnAdd_loan;

    @FXML
    private TextField tfInterest_amount;

    @FXML
    private ImageView picture_one;

    @FXML
    private ImageView picture_two;

    @FXML
    private HBox LoadId;


    @FXML
    private Button confirm;

    @FXML
    void isAdd_loan(ActionEvent event) {

    }

    @FXML
    void isConfirm(ActionEvent event) {

    }

    @FXML
    void initialize() {
        lblLoanId.setText("0");
        tfRegister.textProperty().addListener((obs, oldValue, newvalue) -> {
            tfRegister.setText(TextFieldUtils.checkRegister(newvalue) ? oldValue : newvalue.toUpperCase());
        });
        tfFirst_name.textProperty().addListener((obs, oldvalue, newvalue) -> {
            if (TextFieldUtils.checkName(newvalue)) tfFirst_name.setText(oldvalue);
        });
        tfLast_name.textProperty().addListener((obs, oldvalue, newvalue) -> {
            if (TextFieldUtils.checkName(newvalue)) tfLast_name.setText(oldvalue);

        });
        tfPhone.textProperty().addListener((obs, oldvalue, newvalue) -> {
            if (TextFieldUtils.checkPhone(newvalue)) tfPhone.setText(oldvalue);
        });
        tfPhone_add.textProperty().addListener((obs, oldvalue, newvalue) -> {
            if (TextFieldUtils.checkPhone(newvalue)) tfPhone_add.setText(oldvalue);
        });
        dpStart_date.setValue(LocalDate.now());


    }
}
