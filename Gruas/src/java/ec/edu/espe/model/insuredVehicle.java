/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.model;

/**
 *
 * @author Luis
 */
public class insuredVehicle {
     private String insuredVehicleId;
    private String insuredVehicleModel;
    private String insuredVehicleBrand;
    private String insuredVehicleColor;
    private String insuredVehicle;

    public insuredVehicle(String insuredVehicleId, String insuredVehicleModel, String insuredVehicleBrand, String insuredVehicleColor, String insuredVehicle) {
        this.insuredVehicleId = insuredVehicleId;
        this.insuredVehicleModel = insuredVehicleModel;
        this.insuredVehicleBrand = insuredVehicleBrand;
        this.insuredVehicleColor = insuredVehicleColor;
        this.insuredVehicle = insuredVehicle;
    }

    
    
    public insuredVehicle() {
    }
    
    
    
    
    /**
     * @return the insuredVehicleId
     */
    public String getInsuredVehicleId() {
        return insuredVehicleId;
    }

    /**
     * @param insuredVehicleId the insuredVehicleId to set
     */
    public void setInsuredVehicleId(String insuredVehicleId) {
        this.insuredVehicleId = insuredVehicleId;
    }

    /**
     * @return the insuredVehicleModel
     */
    public String getInsuredVehicleModel(String vehicleModel) {
        return insuredVehicleModel;
    }

    /**
     * @param insuredVehicleModel the insuredVehicleModel to set
     */
    public void setInsuredVehicleModel(String insuredVehicleModel) {
        this.insuredVehicleModel = insuredVehicleModel;
    }

    /**
     * @return the insuredVehicleBrand
     */
    public String getInsuredVehicleBrand() {
        return insuredVehicleBrand;
    }

    /**
     * @param insuredVehicleBrand the insuredVehicleBrand to set
     */
    public void setInsuredVehicleBrand(String insuredVehicleBrand) {
        this.insuredVehicleBrand = insuredVehicleBrand;
    }

    /**
     * @return the insuredVehicleColor
     */
    public String getInsuredVehicleColor() {
        return insuredVehicleColor;
    }

    /**
     * @param insuredVehicleColor the insuredVehicleColor to set
     */
    public void setInsuredVehicleColor(String insuredVehicleColor) {
        this.insuredVehicleColor = insuredVehicleColor;
    }

    /**
     * @return the insuredVehicle
     */
    public String getInsuredVehicle() {
        return insuredVehicle;
    }

    /**
     * @param insuredVehicle the insuredVehicle to set
     */
    public void setInsuredVehicle(String insuredVehicle) {
        this.insuredVehicle = insuredVehicle;
    }
    

}
