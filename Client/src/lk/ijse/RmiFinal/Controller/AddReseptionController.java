package lk.ijse.RmiFinal.Controller;

import com.jfoenix.controls.JFXButton;
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

import java.io.IOException;
import java.security.spec.InvalidKeySpecException;

public class AddReseptionController {
    @FXML
    private JFXTextField txtUSERNAME;

    @FXML
    private JFXButton butADD;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    private JFXTextField txtNIC;

    private static ReseptionService reseptionService;

    @FXML
    private AnchorPane ancker;


    static {
        try {
            reseptionService = PloxyHandeler.getInstance().getSuperService(ServiceFactory.ServiceTypes.RESEPTION);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void addClicked(MouseEvent mouseEvent) throws Exception {
        String uName = txtUSERNAME.getText();
        String pw = txtPassword.getText();
        String salt = PasswordUtil.getSalt(30);
        String secPw=PasswordUtil.generateSecurePassword(pw, salt);
        String nic = txtNIC.getText();

        ReseptionDTO reseptionDTO=new ReseptionDTO(nic,uName,secPw,salt);
        boolean b = reseptionService.addReseption(reseptionDTO);
        if (b){
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"Add", ButtonType.OK);
            alert.show();
        }else {
            Alert alert=new Alert(Alert.AlertType.ERROR,"Not Add", ButtonType.OK);
            alert.show();
        }
    }

    public void backclicked(MouseEvent mouseEvent) throws IOException {
        Parent rootPain= FXMLLoader.load(this.getClass().getResource("/lk/ijse/RmiFinal/View/Admin.fxml"));
        Scene scene = new Scene(rootPain);
        Stage stage = (Stage) this.ancker.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
    }
}
