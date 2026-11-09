package co.edu.unillanos.msg.infrastructure.ui;

import co.edu.unillanos.msg.application.EstimateFundsForWeek;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

public class FundsController {

    @FXML
    private Label totalLabel;

    private final EstimateFundsForWeek estimateFunds;

    public FundsController(EstimateFundsForWeek estimateFunds) {
        this.estimateFunds = estimateFunds;
    }
    

}