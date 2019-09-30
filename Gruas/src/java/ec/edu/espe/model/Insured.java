/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.model;

/**
 *
 * @author Alexis
 */
public class Insured {
    private String insuredId;
    private String insuredName;
    private String insuredLastName;

    public Insured(String insuredId, String insuredName, String insuredLastName) {
        this.insuredId = insuredId;
        this.insuredName = insuredName;
        this.insuredLastName = insuredLastName;
    }

    public Insured() {
    }
    
    public String getInsuredId() {
        return insuredId;
    }

    public void setInsuredId(String insuredId) {
        this.insuredId = insuredId;
    }

    public String getInsuredName() {
        return insuredName;
    }

    public void setInsuredName(String insuredName) {
        this.insuredName = insuredName;
    }

    public String getInsuredLastName() {
        return insuredLastName;
    }

    public void setInsuredLastName(String insuredLastName) {
        this.insuredLastName = insuredLastName;
    }
    
    
}
