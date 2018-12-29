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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.RmiFinal.DB.DbConnection;
import lk.ijse.RmiFinal.DTO.*;
import lk.ijse.RmiFinal.Observer.Observer;
import lk.ijse.RmiFinal.Ploxy.PloxyHandeler;
import lk.ijse.RmiFinal.Service.Custom.CustomerService;
import lk.ijse.RmiFinal.Service.Custom.ShaduleService;
import lk.ijse.RmiFinal.Service.Custom.SheetService;
import lk.ijse.RmiFinal.Service.Custom.TicketService;
import lk.ijse.RmiFinal.Service.ServiceFactory;
import lk.ijse.RmiFinal.Validation.Validater;
import net.sf.jasperreports.engine.*;
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

public class BookingController implements Observer, Remote, Initializable {
    @FXML
    private AnchorPane bookAncker;

    @FXML
    private JFXTextField txtCustId;

    @FXML
    private JFXTextField txtCustName;

    @FXML
    private JFXTextField txtCustAdress;

    @FXML
    private JFXTextField txtCustTp;

    @FXML
    private DatePicker datePicker;

    @FXML
    private JFXButton butSearch;

    @FXML
    private TableView<ShaduleDTO> tableShadule;

    @FXML
    private JFXComboBox<String> combSheets;

    @FXML
    private Label lblPayment;

    @FXML
    private JFXButton butSubmit;

    @FXML
    private JFXButton butoldCus;

    @FXML
    private JFXButton butReport;


    @FXML
    private Label txtShaID;

    private static ShaduleService shaduleService;
    private static SheetService sheetService;
    private static TicketService ticketService;
    private static CustomerService customerService;

    public BookingController() {
        try {
            UnicastRemoteObject.exportObject(this,0);
            ticketService.register(this);

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
            ticketService=PloxyHandeler.getInstance().getSuperService(ServiceFactory.ServiceTypes.TICKET);
            customerService=PloxyHandeler.getInstance().getSuperService(ServiceFactory.ServiceTypes.CUSTOMER);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void logOutClicked(MouseEvent mouseEvent) throws IOException {
        Parent rootPain= FXMLLoader.load(this.getClass().getResource("/lk/ijse/RmiFinal/View/Dashbord.fxml"));
        Scene scene = new Scene(rootPain);
        Stage stage = (Stage) this.bookAncker.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
    }


    public void searchClick(MouseEvent mouseEvent) throws Exception {
        tableShadule.getItems().clear();
        String value = datePicker.getValue().toString();

        List<ShaduleDTO> allShadule = shaduleService.getAllShadule();
        for (ShaduleDTO a:allShadule){
            String date = a.getDate().toString();
            List<ShaduleDTO>newSha=new ArrayList<>();
            newSha.add(a);
            if (date.equalsIgnoreCase(value)){
                tableShadule.getItems().addAll(a);

                tableShadule.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("shaID"));
                tableShadule.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("date"));
                tableShadule.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("startStation"));
                tableShadule.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("endStation"));
                tableShadule.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("name"));
                tableShadule.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("arival"));
                tableShadule.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("deputure"));
                tableShadule.getColumns().get(7).setCellValueFactory(new PropertyValueFactory<>("price"));

            }

        }


    }



    public void tableClicked(MouseEvent mouseEvent) throws Exception {
        if (tableShadule.getSelectionModel().getFocusedIndex()!=-1){
            ShaduleDTO selectedItem = tableShadule.getSelectionModel().getSelectedItem();

            loadCombo(selectedItem);
            String shaID = String.valueOf(selectedItem.getShaID());
//            StaticDTO.setIds(shaID);
            txtShaID.setText(shaID);

            String price = String.valueOf(selectedItem.getPrice());
            lblPayment.setText(price);



        }
    }
    void loadCombo(ShaduleDTO selectedItem) throws Exception {
        int shaID = selectedItem.getShaID();
        List<SheetDTO> allSheet = sheetService.getAllSheet();
        combSheets.getItems().clear();
        for (SheetDTO a:allSheet){
            String state = a.getState();
            String mys="avable";
            if (a.getShaID()==shaID && mys.equalsIgnoreCase(state)){
                combSheets.getItems().add(a.getSheetID());
            }
        }
    }

    public void submitClicked(MouseEvent mouseEvent) throws Exception {


        String custID = txtCustId.getText();
        String custName = txtCustName.getText();
        String custAdress = txtCustAdress.getText();
        int custTp = Integer.parseInt(txtCustTp.getText());
        CustomerDTO customerDTO=new CustomerDTO(custID,custName,custAdress,custTp);
        String shadID = txtShaID.getText();

        double text = Double.parseDouble(lblPayment.getText());
        String sheet = combSheets.getValue();
        LocalDate value = datePicker.getValue();
        Date date = Date.from(value.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date today = new Date();


        TicatDTO ticatDTO=new TicatDTO(0,date,text,sheet,custID);

        BookingDTO bookingDTO=new BookingDTO(customerDTO,ticatDTO,shadID);

        boolean b = ticketService.addTicket(bookingDTO);
        if (b){
//            Alert alert=new Alert(Alert.AlertType.INFORMATION,"Add", ButtonType.OK);
//            alert.show();
            try {
                InputStream inputStream = getClass().getResourceAsStream("/lk/ijse/RmiFinal/Report/Blank_A4.jasper");
                HashMap map = new HashMap();
                JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, map, DbConnection.getInstance().getConnection());
                JasperViewer.viewReport(jasperPrint, false);

            } catch (JRException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


        }else {
            Alert alert=new Alert(Alert.AlertType.WARNING,"Not Add", ButtonType.OK);
            alert.show();
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
                                ShaduleDTO selectedItem = tableShadule.getSelectionModel().getSelectedItem();
                                loadCombo(selectedItem);

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        });
                    }
                }
        ).start();
    }

    public void custNicClicked(ActionEvent actionEvent) throws Exception {
            CustomerDTO customerDTO = customerService.searchCustomer(txtCustId.getText());
            txtCustAdress.setText(customerDTO.getCusAdress());
            txtCustName.setText(customerDTO.getCusName());

            int cusTP = customerDTO.getCusTP();
            String tp = String.valueOf(cusTP);
            txtCustTp.setText(tp);
        if (Validater.nicValidation(txtCustId.getText())) {
            txtCustName.requestFocus();
        } else {
            txtCustId.requestFocus();
        }
    }

    public void nameClicked(ActionEvent actionEvent) {
        if (Validater.nameValidation(txtCustName.getText())) {
            txtCustAdress.requestFocus();
        } else {
            txtCustName.requestFocus();
        }
    }

    public void adressClicked(ActionEvent actionEvent) {
        if (Validater.addressValidation(txtCustAdress.getText())) {
            txtCustTp.requestFocus();
        } else {
            txtCustAdress.requestFocus();
        }
    }

    public void tpClicked(ActionEvent actionEvent) {
        if (Validater.intValueValidation(txtCustTp.getText())) {
            datePicker.requestFocus();
        } else {
            txtCustTp.requestFocus();
        }
    }

    public void oldCustClicked(MouseEvent mouseEvent) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        butoldCus.setVisible(false);
        butReport.setVisible(false);
    }

    public void reportClick(MouseEvent mouseEvent)  {


        try {
            InputStream inputStream = getClass().getResourceAsStream("/lk/ijse/RmiFinal/Report/customer.jasper");
            HashMap map = new HashMap();
            JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, map, DbConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint, false);

        } catch (JRException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }




    }
}
