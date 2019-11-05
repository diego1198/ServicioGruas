/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.gruasService.model;

/**
 *
 * @author Alexis
 */
public class CompanyVehicle {
    
    private int vehicleId;
    private String vehicleModel;
    private String vehicleBrand;
    private String vehicleColor;
    private String vehicleLicensePlate;
    private String vehicleType;
    
    public CompanyVehicle(int vehicleId, String vehicleModel, String vehicleBrand, String vehicleColor,String vehicleLicensePlate, String vehicleType) {
        this.vehicleId = vehicleId;
        this.vehicleModel = vehicleModel;
        this.vehicleBrand = vehicleBrand;
        this.vehicleColor = vehicleColor;
        this.vehicleLicensePlate = vehicleLicensePlate;
        this.vehicleType = vehicleType;
    }

    public CompanyVehicle() {
    }
    
    /**
     * @return the vehicleLicensePlate
     */
    public String getVehicleLicensePlate() {
        return vehicleLicensePlate;
    }

    /**
     * @param vehicleLicensePlate the vehicleLicensePlate to set
     */
    public void setVehicleLicensePlate(String vehicleLicensePlate) {
        this.vehicleLicensePlate = vehicleLicensePlate;
    }

    /**
     * @return the vehicleId
     */
    public int getVehicleId() {
        return vehicleId;
    }

    /**
     * @param vehicleId the vehicleId to set
     */
    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    /**
     * @return the vehicleModel
     */
    public String getVehicleModel() {
        return vehicleModel;
    }

    /**
     * @param vehicleModel the vehicleModel to set
     */
    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    /**
     * @return the vehicleBrand
     */
    public String getVehicleBrand() {
        return vehicleBrand;
    }

    /**
     * @param vehicleBrand the vehicleBrand to set
     */
    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }

    /**
     * @return the vehicleColor
     */
    public String getVehicleColor() {
        return vehicleColor;
    }

    /**
     * @param vehicleColor the vehicleColor to set
     */
    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    /**
     * @return the vehicleType
     */
    public String getVehicleType() {
        return vehicleType;
    }

    /**
     * @param vehicleType the vehicleType to set
     */
    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
    
    
}
