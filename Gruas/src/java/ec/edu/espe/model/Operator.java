/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.model;

/**
 *
 * @author henry
 */
public class Operator {
    
    private String operatorId;
    private int craneManagerId;
    private String operatorName;
    private String operatorLastName;
    private String operatorLicence;

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public int getCraneManagerId() {
        return craneManagerId;
    }

    public void setCraneManagerId(int craneManagerId) {
        this.craneManagerId = craneManagerId;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getOperatorLastName() {
        return operatorLastName;
    }

    public void setOperatorLastName(String operatorLastName) {
        this.operatorLastName = operatorLastName;
    }

    public String getOperatorLicence() {
        return operatorLicence;
    }

    public void setOperatorLicence(String operatorLicence) {
        this.operatorLicence = operatorLicence;
    }

    public Operator(String operatorId, int craneManagerId, String operatorName, String operatorLastName, String operatorLicence) {
        this.operatorId = operatorId;
        this.craneManagerId = craneManagerId;
        this.operatorName = operatorName;
        this.operatorLastName = operatorLastName;
        this.operatorLicence = operatorLicence;
    }

    public Operator() {
    }
    
    
    
}
