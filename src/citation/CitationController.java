/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citation;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author Kayla
 */
public class CitationController {
    CitationModel citeModel;
    CitationView citeView;
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
			
                    ticketNo += 1;
                    Citations currentCitation = new Citations(ticketNo,citeView.getLicenseTF().getText(),citeView.getPermitTF().getText(),citeView.getCarModelTF().getText(),citeView.getCarMakeTF().getText(),citeView.getViolationTF().getText(),citeView.getStateTF().getText(),citeView.getColorTF().getText(),citeView.getDateTF().getText(),citeView.getTimeTF().getText(),citeView.getLocTF().getText(),citeView.getIssuerTF().getText());
                    citeModel.getCitationList().add(currentCitation);
                    citeView.printTicket(currentCitation);
                    
                     
		}
	});
        
                
    citeView.getBckBtn().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (citeView.getCurrentTicket() != 0)
                {
                    citeView.setCurrentTicket(citeView.getCurrentTicket()-1);
                    Citations currentCitation = citeModel.getCitationList().get(citeView.getCurrentTicket());
                    citeView.printTicket(currentCitation);
                }
            }
    });
    
    //
    citeView.getFwdBtn().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (citeView.getCurrentTicket() < citeModel.getCitationList().size()-1)
                {
                    citeView.setCurrentTicket(citeView.getCurrentTicket()+1);
                    Citations currentCitation = citeModel.getCitationList().get(citeView.getCurrentTicket());
                    citeView.printTicket(currentCitation);
                }
            }
    });
    
    
   
    }
    
   
}
