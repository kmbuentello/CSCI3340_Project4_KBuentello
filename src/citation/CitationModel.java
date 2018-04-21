/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citation;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Kayla
 */
public class CitationModel {
    private ArrayList<Citations> citationList = new ArrayList<>();
    CitationDatabase db = CitationDatabase.getSingletonOfdatabase();
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
  
  public void addCitationDB(Citations currentCitation)
    {
        try
        {
            Connection conn = db.getConn();
            PreparedStatement prepStmnt = conn.prepareStatement("INSERT into citation VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
            prepStmnt.setInt(1, currentCitation.getTicketNo());
            prepStmnt.setString(2, currentCitation.getLicenseNo());
            prepStmnt.setString(3, currentCitation.getPermitNo());
            prepStmnt.setString(4, currentCitation.getCarModel());
            prepStmnt.setString(5, currentCitation.getCarMake());
            prepStmnt.setString(6, currentCitation.getViolationType());
            prepStmnt.setString(7, currentCitation.getState());
            prepStmnt.setString(8, currentCitation.getColor());
            prepStmnt.setString(9, currentCitation.getDate());
            prepStmnt.setString(10, currentCitation.getTime());
            prepStmnt.setString(11, currentCitation.getLocation());
            prepStmnt.setString(12, currentCitation.getIssuer());
            prepStmnt.executeUpdate();
        }
        catch (Exception e)
        {
            System.out.println("Error adding citation to db: " + e);
        }
    }
    
    public int getCitationDB(Citations currentCitation)
    {
        int i = 0;
        
        try
        {
            i = currentCitation.getTicketNo();
        }
        catch (Exception e)
        {
            System.out.println("Error retrieving citation from db: " + e);
        }
        return i;
    }
    
    public Citations retrieveDB()
    {
        Citations currentCitations = new Citations();
        try
        {
            Statement stmt = db.getStmnt();
            ResultSet rs = db.getResul();
        
            rs = stmt.executeQuery("select * from citation");
            
            while(rs.next()){
            currentCitation = new Citations(rs.getInt("ticketNo"),rs.getString("LicenseNo"),rs.getString("permitNo"),rs.getString("carModel"),rs.getString("carMake"), rs.getString("violationType"),rs.getString("state"), rs.getString("color"),rs.getString("date"),rs.getString("time"),rs.getString("location"),rs.getString("issuer"));
            setCurrentUser(currentCitation);
            }
        }
        catch (Exception e)
        {
            System.out.println("Error retrieving from db: " + e);
        }
        return currentCitation;
    }

}
