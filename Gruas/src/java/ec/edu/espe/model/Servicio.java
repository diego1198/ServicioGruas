/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.model;

/**
 *
 * @author diego
 */
public class Servicio {
    private String servId;
    private String servBrand;
    private String servModel;
    private String servColor;
    private String servPlate;
    private String servOrigen;
    private String servDest;
    private String servCost;
    private String servUnity;

    public Servicio(String servId, String servBrand, String servModel, String servColor, String servPlate, String servOrigen, String servDest, String servCost, String servUnity) {
        this.servId = servId;
        this.servBrand = servBrand;
        this.servModel = servModel;
        this.servColor = servColor;
        this.servPlate = servPlate;
        this.servOrigen = servOrigen;
        this.servDest = servDest;
        this.servCost = servCost;
        this.servUnity = servUnity;
    }

    public Servicio() {
    }
    
    

    /**
     * @return the servId
     */
    public String getServId() {
        return servId;
    }

    /**
     * @param servId the servId to set
     */
    public void setServId(String servId) {
        this.servId = servId;
    }

    /**
     * @return the servBrand
     */
    public String getServBrand() {
        return servBrand;
    }

    /**
     * @param servBrand the servBrand to set
     */
    public void setServBrand(String servBrand) {
        this.servBrand = servBrand;
    }

    /**
     * @return the servModel
     */
    public String getServModel() {
        return servModel;
    }

    /**
     * @param servModel the servModel to set
     */
    public void setServModel(String servModel) {
        this.servModel = servModel;
    }

    /**
     * @return the servColor
     */
    public String getServColor() {
        return servColor;
    }

    /**
     * @param servColor the servColor to set
     */
    public void setServColor(String servColor) {
        this.servColor = servColor;
    }

    /**
     * @return the servPlate
     */
    public String getServPlate() {
        return servPlate;
    }

    /**
     * @param servPlate the servPlate to set
     */
    public void setServPlate(String servPlate) {
        this.servPlate = servPlate;
    }

    /**
     * @return the servOrigen
     */
    public String getServOrigen() {
        return servOrigen;
    }

    /**
     * @param servOrigen the servOrigen to set
     */
    public void setServOrigen(String servOrigen) {
        this.servOrigen = servOrigen;
    }

    /**
     * @return the servDest
     */
    public String getServDest() {
        return servDest;
    }

    /**
     * @param servDest the servDest to set
     */
    public void setServDest(String servDest) {
        this.servDest = servDest;
    }

    /**
     * @return the servCost
     */
    public String getServCost() {
        return servCost;
    }

    /**
     * @param servCost the servCost to set
     */
    public void setServCost(String servCost) {
        this.servCost = servCost;
    }

    /**
     * @return the servUnity
     */
    public String getServUnity() {
        return servUnity;
    }

    /**
     * @param servUnity the servUnity to set
     */
    public void setServUnity(String servUnity) {
        this.servUnity = servUnity;
    }
    
    
}
