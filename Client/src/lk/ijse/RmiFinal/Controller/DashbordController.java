package lk.ijse.RmiFinal.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DashbordController {

    @FXML
    private AnchorPane DashAncker;
    public void adminClicked(MouseEvent mouseEvent) throws IOException {
        Parent rootPain= FXMLLoader.load(this.getClass().getResource("/lk/ijse/RmiFinal/View/AdminLogIn.fxml"));
        Scene scene = new Scene(rootPain);
        Stage stage = (Stage) this.DashAncker.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
    }

    public void ReseptionClicked(MouseEvent mouseEvent) throws IOException {
        Parent rootPain= FXMLLoader.load(this.getClass().getResource("/lk/ijse/RmiFinal/View/ReseptionLogIn.fxml"));
        Scene scene = new Scene(rootPain);
        Stage stage = (Stage) this.DashAncker.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
    }
}
