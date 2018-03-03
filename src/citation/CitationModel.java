/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citation;

import java.util.ArrayList;

/**
 *
 * @author Kayla
 */
public class CitationModel {
    private ArrayList<Citations> citationList = new ArrayList<>();
        
    Citations currentCitation = new Citations();
    
    public void setCurrentUser(Citations current)
    {
        this.currentCitation = current;
        citationList.add(current);
    }
    /**
     * @return the citationList
     */
    public ArrayList<Citations> getCitationList() {
        return citationList;
    }

    /**
     * @param citationList the citationList to set
     */
    public void setCitationList(ArrayList<Citations> citationList) {
        this.citationList = citationList;
    }
    
   public Citations getCurrentUser() {
        return currentCitation;
    }
/*
    public ArrayList<Citations> getCurrentUsers() {
        return citationList;
    }*/
}
