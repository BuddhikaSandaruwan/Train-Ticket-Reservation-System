package lk.ijse.RmiFinal.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.RmiFinal.DB.DbConnection;
import lk.ijse.RmiFinal.DTO.ShaduleDTO;
import lk.ijse.RmiFinal.DTO.SheetDTO;
import lk.ijse.RmiFinal.Observer.Observer;
import lk.ijse.RmiFinal.Ploxy.PloxyHandeler;
import lk.ijse.RmiFinal.Service.Custom.ShaduleService;
import lk.ijse.RmiFinal.Service.Custom.SheetService;
import lk.ijse.RmiFinal.Service.ServiceFactory;
import lk.ijse.RmiFinal.Validation.Validater;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class AdminController implements Initializable, Observer, Remote {

    @FXML
    private AnchorPane adminAncker;

    @FXML
    private JFXTextField txtShaID;

    @FXML
    private JFXTextField txtEndStation;

    @FXML
    private JFXTextField txtStartStation;

    @FXML
    private DatePicker dateShadule;

    @FXML
    private JFXTextField txtTrainName;

    @FXML
    private JFXTextField txtArivalTime;

    @FXML
    private JFXTextField txtDeputureTime;

    @FXML
    private JFXButton butSubmit;

    @FXML
    private JFXTextField txtSheetID;

    @FXML
    private JFXComboBox<String> combShadule;

    @FXML
    private TableView<ShaduleDTO> tableShadule;

    private static ShaduleService shaduleService;
    private static SheetService sheetService;

    public AdminController() {
        try {
            UnicastRemoteObject.exportObject(this,0);
            sheetService.register(this);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static {
        try {
            shaduleService= PloxyHandeler.getInstance().getSuperService(ServiceFactory.ServiceTypes.SHADULE);
            sheetService=PloxyHandeler.getInstance().getSuperService(ServiceFactory.ServiceTypes.SHEET);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void logOutCllicked(MouseEvent mouseEvent) throws IOException {
            Parent rootPain= FXMLLoader.load(this.getClass().getResource("/lk/ijse/RmiFinal/View/Dashbord.fxml"));
            Scene scene = new Scene(rootPain);
            Stage stage = (Stage) this.adminAncker.getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
    }

    public void submitClicked(MouseEvent mouseEvent) throws Exception {



        double price = Double.parseDouble(txtShaID.getText());
        int shaID=1;
        LocalDate date = dateShadule.getValue();

        Date date1 = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());


        String startStation = txtStartStation.getText();
        String endStation = txtEndStation.getText();
        String name = txtTrainName.getText();
        String arival = txtArivalTime.getText();
        String deputure = txtDeputureTime.getText();

        ShaduleDTO shaduleDTO=new ShaduleDTO(shaID,date1,startStation,endStation,name,arival,deputure,price);

        boolean rst = shaduleService.addShadule(shaduleDTO);
        if (rst){
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"New Shadule is Add", ButtonType.OK);
            alert.show();
            lordtable();
            lordItemComb();
        }else {
            Alert alert=new Alert(Alert.AlertType.WARNING,"Not Add", ButtonType.OK);
            alert.show();
        }
    }

    public void lordItemComb() throws Exception {
        List<ShaduleDTO> all = getAll();
        combShadule.getItems().clear();
        for (ShaduleDTO ab : all) {
            boolean add = combShadule.getItems().add(ab.getShaID() + "");
        }
    }


    public List<ShaduleDTO> getAll() throws Exception {
        List<ShaduleDTO> allShadule = shaduleService.getAllShadule();
        for (ShaduleDTO a:allShadule){
        }
        return allShadule;
    }

    public  void lordtable() throws Exception {
        List<ShaduleDTO> all = getAll();
        tableShadule.setItems(FXCollections.observableArrayList(all));

        tableShadule.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("shaID"));
        tableShadule.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("date"));
        tableShadule.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("startStation"));
        tableShadule.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("endStation"));
        tableShadule.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("name"));
        tableShadule.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("arival"));
        tableShadule.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("deputure"));
        tableShadule.getColumns().get(7).setCellValueFactory(new PropertyValueFactory<>("price"));

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            lordItemComb();
            lordtable();
               } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public void sheetClicked(MouseEvent mouseEvent) throws Exception {
        if (combShadule.getItems().isEmpty()){
            int shaID = Integer.parseInt(combShadule.getValue());
            String sheetID = txtSheetID.getText();
            SheetDTO sheetDTO=new SheetDTO(sheetID,"avable",shaID);
            boolean b = sheetService.addSheet(sheetDTO);
            if (b){
                Alert alert=new Alert(Alert.AlertType.INFORMATION,"New Sheet is Add", ButtonType.OK);
                alert.show();
                lordItemComb();
                lordtable();
            }else {
                Alert alert=new Alert(Alert.AlertType.WARNING,"Not Add", ButtonType.OK);
                alert.show();
            }

        }else {
            Alert alert=new Alert(Alert.AlertType.WARNING,"Fist check Shadule ID and Try Again", ButtonType.OK);
            alert.show();
        }

    }

    public void priceClicked(ActionEvent actionEvent) {
        if (Validater.doubleValueValidation(txtShaID.getText())) {
            butSubmit.requestFocus();
        } else {
            txtShaID.requestFocus();
        }
    }

    public void endStationClicked(ActionEvent actionEvent) {
        if (Validater.nameValidation(txtEndStation.getText())) {
            txtTrainName.requestFocus();
        } else {
            txtEndStation.requestFocus();
        }
    }

    public void startStationClicked(ActionEvent actionEvent) {
        if (Validater.nameValidation(txtStartStation.getText())) {
            txtEndStation.requestFocus();
        } else {
            txtStartStation.requestFocus();
        }
    }

    public void trainNameClicked(ActionEvent actionEvent) {
        if (Validater.nameValidation(txtTrainName.getText())) {
            txtArivalTime.requestFocus();
        } else {
            txtTrainName.requestFocus();
        }
    }

    public void arivalTimeClicked(ActionEvent actionEvent) {
        if (Validater.isNotEmptyValidation(txtArivalTime.getText())) {
            txtDeputureTime.requestFocus();
        } else {
            txtArivalTime.requestFocus();
        }
    }

    public void deputureTimeClicked(ActionEvent actionEvent) {
        if (Validater.isNotEmptyValidation(txtDeputureTime.getText())) {
            txtShaID.requestFocus();
        } else {
            txtDeputureTime.requestFocus();
        }
    }


    @Override
    public void update() throws Exception {
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        Platform.runLater(()->
                        {

                            try {
//                                List<SheetDTO> allSheet = sheetService.getAllSheet();
//                                for (SheetDTO sheet:allSheet){
//                                    if (txtSheetID.getText().equals(sheet.getSheetID())){
//                                        Alert alert=new Alert(Alert.AlertType.ERROR,"Error Sheet ID ",ButtonType.OK);
//                                        alert.show();
//                                        break;
//                                    }
//                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        });
                    }
                }
        ).start();
    }

    public void addReseptionClicked(MouseEvent mouseEvent) throws IOException {
        Parent rootPain= FXMLLoader.load(this.getClass().getResource("/lk/ijse/RmiFinal/View/AddReseption.fxml"));
        Scene scene = new Scene(rootPain);
        Stage stage = (Stage) this.adminAncker.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
    }

    public void butCustomerclicked(MouseEvent mouseEvent) {

        try {
            InputStream inputStream = getClass().getResourceAsStream("/lk/ijse/RmiFinal/Report/customer.jasper");
            HashMap map = new HashMap();
            JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, map, DbConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint, false);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
