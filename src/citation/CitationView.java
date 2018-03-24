/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citation;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.in;
import static java.lang.System.out;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;


/**
 *
 * @author Kayla
 */
public class CitationView extends BorderPane{

         
        private Label ticketLabel = new Label("Register New Vehicle");
        
        private Label licenseLabel = new Label("License No:");
	private TextField licenseTF = new TextField ();
        
        private Label permitLabel = new Label("Permit No:");
	private TextField permitTF= new TextField();
	
	private Label carModelLabel = new Label("Car Model:");
	private TextField carModelTF= new TextField();
        
        private Label carMakeLabel = new Label("Car Make:");
	private TextField carMakeTF = new TextField ();
	
	private Label violationLabel = new Label("Violation Type:");
	private TextField violationTF= new TextField();
        	
	private Label stateLabel = new Label("State:");
	private TextField stateTF = new TextField ();	
	
	private Label colorLabel = new Label("Color:");
	private TextField colorTF = new TextField ();
	
	private Label dateLabel = new Label("Date:");
	private TextField dateTF = new TextField ();
        	
	private Label timeLabel = new Label("Time:");
	private TextField timeTF = new TextField ();
        	
	private Label locLabel = new Label("Location:");
	private TextField locTF = new TextField ();
        	
	private Label issuerLabel = new Label("Issued By:");
	private TextField issuerTF = new TextField ();
        
        private GridPane form1 = new GridPane();
        
        private Button submitBtn = new Button();
        Button readBtn = new Button();//Read  all tickets
        Button viewBtn = new Button();//View all tickets
      
        
        //TextArea textBox = new TextArea();
        
        Label paymentLabel = new Label("Payments can be made at the following office:\n\n"
        +"Business Office, \nTandy 107\nMonday thru Friday: 8:00 am-5:00 pm\n\n"
        + "$25 per citation, other fees may apply\n$100 for boot removal\n\n"
        + "Payments can be mailed to the following address:\nTSC\nC/O Finance Dept\n"
        + "Attn: Parking Enforcement\n80 Fort Brown\nBrownsville, TX 78520\n"
        + "DO NOT MAIL IN CASH!\n\nFor more info please visit www.tsc.edu/parking\n\n");
        
        private Button bckBtn = new Button("<<");
        private Button fwdBtn = new Button(">>");
        
        VBox vbox1 = new VBox(); //Registration box
        VBox vbox2 = new VBox();//Payment Info box
        VBox vbox3 = new VBox();//Print Ticket box
        VBox vbox4 = new VBox();//forward/back buttons
        HBox hbox1 = new HBox();//Buttons box
       
        
        TextArea thisText = new TextArea();
        
        private int currentTicket;
   
    public CitationView() {        
    //Initialize Variables
        currentTicket = 0;
    
    //Form Layout    
        form1.setPadding(new Insets(10, 10, 10, 10));
        form1.setVgap(10);
	form1.setHgap(50);
        form1.setAlignment(Pos.CENTER);
        this.setCenter(form1);
    
    //Register a new vehicle vbox
        ticketLabel.setFont(Font.font("Times New Roman",FontWeight.BOLD, FontPosture.ITALIC, 40));
	vbox1.getChildren().addAll(ticketLabel,licenseLabel, licenseTF,permitLabel, permitTF,carModelLabel, carModelTF,
                carMakeLabel, carMakeTF,violationLabel, violationTF,stateLabel, stateTF,colorLabel, colorTF,                
                dateLabel, dateTF, timeLabel, timeTF, locLabel, locTF, issuerLabel, issuerTF);
    //Tickets
       vbox3.getChildren().add(thisText);
       
    
    
    //Button setup   
	hbox1.getChildren().addAll(bckBtn, submitBtn, readBtn, viewBtn,fwdBtn);
        hbox1.setAlignment(Pos.CENTER);
        submitBtn.setText("Add new citation");
        readBtn.setText("Get citations");
        viewBtn.setText("View citations");
        
   /* //Back and forward buttons
        vbox4.getChildren().addAll(bckBtn, fwdBtn);
        vbox4.setAlignment(Pos.BASELINE_LEFT);*/
        
    //Place boxes in rows	
        form1.add(vbox1, 1,0);
        form1.add(hbox1, 1,1);
        form1.add(vbox4,0,1);
        form1.add(vbox3,1,2);

 

        
        //Payment Info VBox        
        vbox2.setAlignment(Pos.CENTER_RIGHT);
        vbox2.getChildren().add(paymentLabel);
        
        form1. add(vbox2, 3, 0);
    } 
    
/*    public void updateMailView(Citations currentUser){
        String licenseNo = currentUser.getLicenseNo();
        String permitNo = currentUser.getPermitNo();
        String carMake = currentUser.getCarMake();
        String carModel = currentUser.getCarModel();
        String violationType = currentUser.getViolationType();
        String color = currentUser.getColor();
        String date = currentUser.getDate();
        String time = currentUser.getTime();
        String location = currentUser.getLocation();
        String issuer = currentUser.getIssuer();
        String state = currentUser.getState() ;
    }*/
    
    
    public void printTicket(Citations Current) throws IOException {
        
        String data = "Ticket No: " + Current.getTicketNo() + "\nLicense No: " + Current.getLicenseNo() + "\nPermit No: " + Current.getPermitNo()
                    + "\nCar Make: " + Current.getCarMake() + "\nCar Model " + Current.getCarModel() 
                    + "\nViolation Type: " + Current.getViolationType() + "\nState: " + Current.getState()
                    + "\nColor: " + Current.getColor() + "\nDate: " + Current.getDate()
                    + "\nTime: " + Current.getTime() + "\nLocation: " + Current.getLocation()
                    + "\nIssued By: " + Current.getIssuer() + "\n\n";
        int c = 0;
        
        try (PrintWriter out = new PrintWriter("outFile.txt")){
           out.append(data, c, data.length());
            
        }catch(IOException io)
        {
            System.out.println("IO Exception");
        }finally {

            if (out != null) {
                out.close();
            }
        }
           
        
        thisText.clear();
        thisText.appendText(data);
        //clearFields();
    }
    
 /*   public void clearFields()
    {
        licenseTF.clear();
        permitTF.clear();
        carMakeTF.clear();
        carModelTF.clear();
        colorTF.clear();
        violationTF.clear();
        dateTF.clear();
        timeTF.clear();
        locTF.clear();
        issuerTF.clear();
        stateTF.clear();
    }*/
    

    /**
     * @return the ticketLabel
     */
    public Label getTicketLabel() {
        return ticketLabel;
    }

    /**
     * @param ticketLabel the ticketLabel to set
     */
    public void setTicketLabel(Label ticketLabel) {
        this.ticketLabel = ticketLabel;
    }

    /**
     * @return the licenseLabel
     */
    public Label getLicenseLabel() {
        return licenseLabel;
    }

    /**
     * @param licenseLabel the licenseLabel to set
     */
    public void setLicenseLabel(Label licenseLabel) {
        this.licenseLabel = licenseLabel;
    }

    /**
     * @return the licenseTF
     */
    public TextField getLicenseTF() {
        return licenseTF;
    }

    /**
     * @param licenseTF the licenseTF to set
     */
    public void setLicenseTF(TextField licenseTF) {
        this.licenseTF = licenseTF;
    }

    /**
     * @return the permitLabel
     */
    public Label getPermitLabel() {
        return permitLabel;
    }

    /**
     * @param permitLabel the permitLabel to set
     */
    public void setPermitLabel(Label permitLabel) {
        this.permitLabel = permitLabel;
    }

    /**
     * @return the permitTF
     */
    public TextField getPermitTF() {
        return permitTF;
    }

    /**
     * @param permitTF the permitTF to set
     */
    public void setPermitTF(TextField permitTF) {
        this.permitTF = permitTF;
    }

    /**
     * @return the carModelLabel
     */
    public Label getCarModelLabel() {
        return carModelLabel;
    }

    /**
     * @param carModelLabel the carModelLabel to set
     */
    public void setCarModelLabel(Label carModelLabel) {
        this.carModelLabel = carModelLabel;
    }

    /**
     * @return the carModelTF
     */
    public TextField getCarModelTF() {
        return carModelTF;
    }

    /**
     * @param carModelTF the carModelTF to set
     */
    public void setCarModelTF(TextField carModelTF) {
        this.carModelTF = carModelTF;
    }

    /**
     * @return the carMakeLabel
     */
    public Label getCarMakeLabel() {
        return carMakeLabel;
    }

    /**
     * @param carMakeLabel the carMakeLabel to set
     */
    public void setCarMakeLabel(Label carMakeLabel) {
        this.carMakeLabel = carMakeLabel;
    }

    /**
     * @return the carMakeTF
     */
    public TextField getCarMakeTF() {
        return carMakeTF;
    }

    /**
     * @param carMakeTF the carMakeTF to set
     */
    public void setCarMakeTF(TextField carMakeTF) {
        this.carMakeTF = carMakeTF;
    }

    /**
     * @return the violationLabel
     */
    public Label getViolationLabel() {
        return violationLabel;
    }

    /**
     * @param violationLabel the violationLabel to set
     */
    public void setViolationLabel(Label violationLabel) {
        this.violationLabel = violationLabel;
    }

    /**
     * @return the violationTF
     */
    public TextField getViolationTF() {
        return violationTF;
    }

    /**
     * @param violationTF the violationTF to set
     */
    public void setViolationTF(TextField violationTF) {
        this.violationTF = violationTF;
    }

    /**
     * @return the stateLabel
     */
    public Label getStateLabel() {
        return stateLabel;
    }

    /**
     * @param stateLabel the stateLabel to set
     */
    public void setStateLabel(Label stateLabel) {
        this.stateLabel = stateLabel;
    }

    /**
     * @return the stateTF
     */
    public TextField getStateTF() {
        return stateTF;
    }

    /**
     * @param stateTF the stateTF to set
     */
    public void setStateTF(TextField stateTF) {
        this.stateTF = stateTF;
    }

    /**
     * @return the colorLabel
     */
    public Label getColorLabel() {
        return colorLabel;
    }

    /**
     * @param colorLabel the colorLabel to set
     */
    public void setColorLabel(Label colorLabel) {
        this.colorLabel = colorLabel;
    }

    /**
     * @return the colorTF
     */
    public TextField getColorTF() {
        return colorTF;
    }

    /**
     * @param colorTF the colorTF to set
     */
    public void setColorTF(TextField colorTF) {
        this.colorTF = colorTF;
    }

    /**
     * @return the dateLabel
     */
    public Label getDateLabel() {
        return dateLabel;
    }

    /**
     * @param dateLabel the dateLabel to set
     */
    public void setDateLabel(Label dateLabel) {
        this.dateLabel = dateLabel;
    }

    /**
     * @return the dateTF
     */
    public TextField getDateTF() {
        return dateTF;
    }

    /**
     * @param dateTF the dateTF to set
     */
    public void setDateTF(TextField dateTF) {
        this.dateTF = dateTF;
    }

    /**
     * @return the timeLabel
     */
    public Label getTimeLabel() {
        return timeLabel;
    }

    /**
     * @param timeLabel the timeLabel to set
     */
    public void setTimeLabel(Label timeLabel) {
        this.timeLabel = timeLabel;
    }

    /**
     * @return the timeTF
     */
    public TextField getTimeTF() {
        return timeTF;
    }

    /**
     * @param timeTF the timeTF to set
     */
    public void setTimeTF(TextField timeTF) {
        this.timeTF = timeTF;
    }

    /**
     * @return the locLabel
     */
    public Label getLocLabel() {
        return locLabel;
    }

    /**
     * @param locLabel the locLabel to set
     */
    public void setLocLabel(Label locLabel) {
        this.locLabel = locLabel;
    }

    /**
     * @return the locTF
     */
    public TextField getLocTF() {
        return locTF;
    }

    /**
     * @param locTF the locTF to set
     */
    public void setLocTF(TextField locTF) {
        this.locTF = locTF;
    }

    /**
     * @return the issuerLabel
     */
    public Label getIssuerLabel() {
        return issuerLabel;
    }

    /**
     * @param issuerLabel the issuerLabel to set
     */
    public void setIssuerLabel(Label issuerLabel) {
        this.issuerLabel = issuerLabel;
    }

    /**
     * @return the issuerTF
     */
    public TextField getIssuerTF() {
        return issuerTF;
    }

    /**
     * @param issuerTF the issuerTF to set
     */
    public void setIssuerTF(TextField issuerTF) {
        this.issuerTF = issuerTF;
    }
    
        /**
     * @return the form1
     */
    public GridPane getForm1() {
        return form1;
    }

    /**
     * @param form1 the form1 to set
     */
    public void setForm1(GridPane form1) {
        this.form1 = form1;
    }
    
        /**
     * @return the submitBtn
     */
    public Button getSubmitBtn() {
        return submitBtn;
    }

    /**
     * @param submitBtn the submitBtn to set
     */
    public void setSubmitBtn(Button submitBtn) {
        this.submitBtn = submitBtn;
    }
    
    /**
     * @return the bckBtn
     */
    public Button getBckBtn() {
        return bckBtn;
    }

    /**
     * @param bckBtn the bckBtn to set
     */
    public void setBckBtn(Button bckBtn) {
        this.bckBtn = bckBtn;
    }

    /**
     * @return the fwdBtn
     */
    public Button getFwdBtn() {
        return fwdBtn;
    }

    /**
     * @param fwdBtn the fwdBtn to set
     */
    public void setFwdBtn(Button fwdBtn) {
        this.fwdBtn = fwdBtn;
    }
    
        /**
     * @return the currentTicket
     */
    public int getCurrentTicket() {
        return currentTicket;
    }

    /**
     * @param currentTicket the currentTicket to set
     */
    public void setCurrentTicket(int currentTicket) {
        this.currentTicket = currentTicket;
    }

    
}
