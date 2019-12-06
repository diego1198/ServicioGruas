/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.craneService.model;

/**
 *
 * @author diego
 */
public class Service {
    private String servid;
    private String serviceDate;
    private String servBrand;
    private String servModel;
    private String servColor;
    private String servPlate;
    private String servOrig;
    private String servDest;
    private float servCost;
    private String servUnity;

    public Service(String servid, String serviceDate, String servBrand, String servModel, String servColor, String servPlate, String servOrig, String servDest, float servCost, String servUnity) {
        this.servid = servid;
        this.serviceDate = serviceDate;
        this.servBrand = servBrand;
        this.servModel = servModel;
        this.servColor = servColor;
        this.servPlate = servPlate;
        this.servOrig = servOrig;
        this.servDest = servDest;
        this.servCost = servCost;
        this.servUnity = servUnity;
    }

    public Service() {
    }

    /**
     * @return the servid
     */
    public String getServid() {
        return servid;
    }

    /**
     * @param servid the servid to set
     */
    public void setServid(String servid) {
        this.servid = servid;
    }

    /**
     * @return the serviceDate
     */
    public String getServiceDate() {
        return serviceDate;
    }

    /**
     * @param serviceDate the serviceDate to set
     */
    public void setServiceDate(String serviceDate) {
        this.serviceDate = serviceDate;
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
     * @return the servOrig
     */
    public String getServOrig() {
        return servOrig;
    }

    /**
     * @param servOrig the servOrig to set
     */
    public void setServOrig(String servOrig) {
        this.servOrig = servOrig;
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
    public float getServCost() {
        return servCost;
    }

    /**
     * @param servCost the servCost to set
     */
    public void setServCost(float servCost) {
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
