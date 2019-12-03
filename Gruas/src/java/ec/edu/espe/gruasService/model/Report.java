/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.gruasService.model;

/**
 *
 * @author henry
 */
public class Report {
    
    private int reportId;
    private String clientId;
    private String serviceId;
    private String operatorId;

    public Report(int reportId, String clientId, String serviceId, String operatorId) {
        this.reportId = reportId;
        this.clientId = clientId;
        this.serviceId = serviceId;
        this.operatorId = operatorId;
    }

    public Report() {
    }

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }
    
    

}
