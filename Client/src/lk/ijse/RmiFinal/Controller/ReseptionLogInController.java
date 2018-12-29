package lk.ijse.RmiFinal.Controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.RmiFinal.DTO.ReseptionDTO;
import lk.ijse.RmiFinal.Ploxy.PloxyHandeler;
import lk.ijse.RmiFinal.Service.Custom.ReseptionService;
import lk.ijse.RmiFinal.Service.ServiceFactory;
import lk.ijse.RmiFinal.UTIL.PasswordUtil;

import java.util.List;

public class ReseptionLogInController {


    private static ReseptionService reseptionService;


    static {
        try {
            reseptionService = PloxyHandeler.getInstance().getSuperService(ServiceFactory.ServiceTypes.RESEPTION);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    private AnchorPane anckerLogIn;

    @FXML
    private JFXTextField txtUName;

    @FXML
    private JFXPasswordField txtpw;

    public void logInClicked(MouseEvent mouseEvent) throws Exception {
        String uname = txtUName.getText();
        String pw = txtpw.getText();

        List<ReseptionDTO> allReseption = reseptionService.getAllReseption();
        for (ReseptionDTO aa:allReseption){
            boolean ifPasswordMatches = PasswordUtil.verifyUserPassword(pw, aa.getPassword(), aa.getSalt());
            if (ifPasswordMatches && uname.equals(aa.getuName())) {

                Parent rootPain= FXMLLoader.load(this.getClass().getResource("/lk/ijse/RmiFinal/View/Booking.fxml"));
                Scene scene = new Scene(rootPain);
                Stage stage = (Stage) this.anckerLogIn.getScene().getWindow();
                stage.setScene(scene);
                stage.centerOnScreen();
                break;

            }else {
                Alert alert=new Alert(Alert.AlertType.ERROR,"Error in username or Passsword", ButtonType.OK);
                alert.show();
            }
        }
    }
}
