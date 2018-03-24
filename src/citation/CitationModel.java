/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citation;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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
  

    /*public void fileIO(ArrayList<Citations> citationList, Citations current) throws IOException {

        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("inFile.txt");
            out = new FileOutputStream("outFile.txt");
            int c;
            String temp = citationList.toString();

            while ((c = in.read()) != -1) {
                
                out.write(temp.getBytes(), c, citationList.size());
            }
        }catch(IOException io)
        {
            System.out.println("IO ");
        }finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }*/

}
