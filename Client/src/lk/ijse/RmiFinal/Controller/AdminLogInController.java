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
import lk.ijse.RmiFinal.Entity.Admin;
import lk.ijse.RmiFinal.UTIL.PasswordUtil;
import lk.ijse.RmiFinal.Util.HibanateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.IOException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

public class AdminLogInController {
    @FXML
    private AnchorPane anckerLogIn;

    @FXML
    private JFXTextField txtUserName;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    private JFXButton butLogIn;

    public void logInClicked(MouseEvent mouseEvent) throws InvalidKeySpecException, IOException {

        //        ==========================================
        //              without conect database
        //        ==========================================

        String pw="oe/tBwJTDYZgVZCXtokEygXwMz4sIC+KM8L/Kca39gU=";
        String salt="e0lDSEduTNefISN2Gc6jDseJQhgl38";
        String uname="superadmin";

            boolean ifPasswordMatches= PasswordUtil.verifyUserPassword(txtPassword.getText(), pw, salt);
            if (ifPasswordMatches && txtUserName.getText().equals(uname)) {
                Parent rootPain= FXMLLoader.load(this.getClass().getResource("/lk/ijse/RmiFinal/View/Admin.fxml"));
                Scene scene = new Scene(rootPain);
                Stage stage = (Stage) this.anckerLogIn.getScene().getWindow();
                stage.setScene(scene);
                stage.centerOnScreen();

            }else {
                Alert alert=new Alert(Alert.AlertType.ERROR,"Error in user name or Password", ButtonType.OK);
                alert.show();
            }


//                       ==========================================
//                                     with callind db
//                       ==========================================


//        SessionFactory sessionFactory= HibanateUtil.getSessionFactory();
//        Session session=sessionFactory.openSession();
//        session.beginTransaction();
//
//        List admin = session.createQuery("From Admin").list();
//        for (Object aa:admin){
//            Admin admin1= (Admin) aa;
//            boolean ifPasswordMatches= PasswordUtil.verifyUserPassword(txtPassword.getText(), admin1.getPassword(), admin1.getSalt());
//            if (ifPasswordMatches && txtUserName.getText().equals(admin1.getUserName())) {
//                Parent rootPain= FXMLLoader.load(this.getClass().getResource("/lk/ijse/RmiFinal/View/Admin.fxml"));
//                Scene scene = new Scene(rootPain);
//                Stage stage = (Stage) this.anckerLogIn.getScene().getWindow();
//                stage.setScene(scene);
//                stage.centerOnScreen();
//                break;
//            }else {
//                Alert alert=new Alert(Alert.AlertType.ERROR,"Error in user name or Password", ButtonType.OK);
//                alert.show();
//            }
//        }
//        session.getTransaction().commit();
//        sessionFactory.close();
    }
}
