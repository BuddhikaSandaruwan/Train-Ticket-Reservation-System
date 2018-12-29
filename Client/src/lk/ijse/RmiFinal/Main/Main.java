package lk.ijse.RmiFinal.Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
            Parent root = FXMLLoader.load(getClass().getResource("/lk/ijse/RmiFinal/View/Dashbord.fxml"));
            primaryStage.setTitle("Train Bookin System");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
    }

}
