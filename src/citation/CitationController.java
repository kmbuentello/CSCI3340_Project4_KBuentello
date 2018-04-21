/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author Kayla
 */
public class CitationController {
    CitationModel citeModel;
    CitationView citeView;
    CitationDatabase citeDB;
    int ticketNo;
    
    /**
     * Defined constructor and sets events for buttons
     * @param citeModel
     * @param citeView 
     */
    public CitationController(CitationModel citeModel, CitationView citeView) {
        this.citeModel = citeModel;
        this.citeView = citeView;
        this.ticketNo = 0;
        attachHandlers();
    }
    
    public void attachHandlers(){
        //attach handlers for GUI
        //Print ticket on click   
        citeView.getSubmitBtn().setOnAction(
		
            new EventHandler<ActionEvent>() {
            
		@Override
		public void handle(ActionEvent event)
		{
                    
                    try {
                         String licenseNo = citeView.getLicenseTF().getText();
                         String permitNo = citeView.getPermitTF().getText();
                         String carModel = citeView.getCarModelTF().getText();
                         String carMake = citeView.getCarMakeTF().getText();
                         String violation = citeView.getViolationTF().getText();
                         String state = citeView.getStateTF().getText();
                         String color = citeView.getColorTF().getText();
                         String date = citeView.getDateTF().getText();
                         String time = citeView.getTimeTF().getText();
                         String location = citeView.getLocTF().getText();
                         String issuer = citeView.getIssuerTF().getText();
                        
                         citeView.setCurrentTicket(citeView.getCurrentTicket()+1);
                         
                         ticketNo= citeView.getCurrentTicket();
                         
                        Citations currentCitation = new Citations(ticketNo,licenseNo,permitNo,carModel,carMake,violation,state,color,date,time,location,issuer);
                        citeModel.setCurrentUser(currentCitation);
                        citeModel.addCitationDB(currentCitation);
                        citeView.printTicket(currentCitation);
                        
                    } catch (IOException ex) {
                        Logger.getLogger(CitationController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                     
		}
	});
        
                
    citeView.getBckBtn().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (citeView.getCurrentTicket() != 0)
                {
                    try {
                        citeView.setCurrentTicket(citeView.getCurrentTicket()-1);
                        Citations currentCitation = citeModel.getCitationList().get(citeView.getCurrentTicket());
                        citeView.printTicket(currentCitation);
                    } catch (IOException ex) {
                        Logger.getLogger(CitationController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
    });
    
    //
    citeView.getFwdBtn().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (citeView.getCurrentTicket() < citeModel.getCitationList().size()-1)
                {
                    try {
                        citeView.setCurrentTicket(citeView.getCurrentTicket()+1);
                        Citations currentCitation = citeModel.getCitationList().get(citeView.getCurrentTicket());
                        citeView.printTicket(currentCitation);
                    } catch (IOException ex) {
                        Logger.getLogger(CitationController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
    });
    
 
        citeView.getViewBtn().setOnAction(
                new EventHandler<ActionEvent>()
                {
                     public void handle(ActionEvent event)
                     {
                                                  
                         Citations currentCitation= citeModel.retrieveDB();
                         try {
                             citeView.printTicket(currentCitation);
                         } catch (IOException ex) {
                             Logger.getLogger(CitationController.class.getName()).log(Level.SEVERE, null, ex);
                         }
                         citeView.clearFields();
                     }
                });
        
        citeView.getReadBtn().setOnAction(
                new EventHandler<ActionEvent>()
                {
                     public void handle(ActionEvent event)
                     {
                                                  
                         Citations currentCitation= citeModel.retrieveDB();
                         try {
                             citeView.printTicket(currentCitation);
                         } catch (IOException ex) {
                             Logger.getLogger(CitationController.class.getName()).log(Level.SEVERE, null, ex);
                         }
                         citeView.clearFields();
                     }
                });
    }
    
   
}
