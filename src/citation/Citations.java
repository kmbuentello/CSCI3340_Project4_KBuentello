/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citation;

/**
 *
 * @author Kayla
 */
public class Citations {
    private int ticketNo;
    private String licenseNo;
    private String permitNo;
    private String carMake;
    private String carModel;
    private String color;
    private String violationType;
    private String date;
    private String time;
    private String location;
    private String issuer;
    private String state;
  
    /**
     * 
     * Defined constructor with 12 parameters for a citation
     * @param ticketNo
     * @param licenseNo
     * @param permitNo
     * @param carMake
     * @param carModel
     * @param color
     * @param violationType
     * @param date
     * @param time
     * @param location
     * @param issuer
     * @param state 
     */
    public Citations(int ticketNo, String licenseNo, String permitNo, String carMake, String carModel, String color, String violationType, String date, String time, String location, String issuer, String state) {
        this.ticketNo = ticketNo;
        this.licenseNo = licenseNo;
        this.permitNo = permitNo;
        this.carMake = carMake;
        this.carModel = carModel;
        this.color = color;
        this.violationType = violationType;
        this.date = date;
        this.time = time;
        this.location = location;
        this.issuer = issuer;
        this.state = state;
    }
    
    /**
     * 
     * Default constructor
     */
    public Citations(){
    }
    
     
    /**
     * @return the ticketNo
     */
    public int getTicketNo() {
        return ticketNo;
    }

    /**
     * @param ticketNo the ticketNo to set
     */
    public void setTicketNo(int ticketNo) {
        this.ticketNo = ticketNo;
    }

    /**
     * @return the licenseNo
     */
    public String getLicenseNo() {
        return licenseNo;
    }

    /**
     * @param licenseNo the licenseNo to set
     */
    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    /**
     * @return the permitNo
     */
    public String getPermitNo() {
        return permitNo;
    }

    /**
     * @param permitNo the permitNo to set
     */
    public void setPermitNo(String permitNo) {
        this.permitNo = permitNo;
    }

    /**
     * @return the carMake
     */
    public String getCarMake() {
        return carMake;
    }

    /**
     * @param carMake the carMake to set
     */
    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    /**
     * @return the carModel
     */
    public String getCarModel() {
        return carModel;
    }

    /**
     * @param carModel the carModel to set
     */
    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the violationType
     */
    public String getViolationType() {
        return violationType;
    }

    /**
     * @param violationType the violationType to set
     */
    public void setViolationType(String violationType) {
        this.violationType = violationType;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

        /**
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(String time) {
        this.time = time;
    }
    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the issuer
     */
    public String getIssuer() {
        return issuer;
    }

    /**
     * @param issuer the issuer to set
     */
    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

        /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }
}
