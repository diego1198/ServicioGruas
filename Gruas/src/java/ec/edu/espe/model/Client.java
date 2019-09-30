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
public class Client {
    private String clientId;
    private String clientName;
    private int clientPhone;

    public Client(String clientId, String clientName, int clientPhone) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.clientPhone = clientPhone;
    }
    
    public Client() {
    }


    /**
     * @return the clientId
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * @param clientId the clientId to set
     */
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    /**
     * @return the clientName
     */
    public String getClientName() {
        return clientName;
    }

    /**
     * @param clientName the clientName to set
     */
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    /**
     * @return the clientPhone
     */
    public int getClientPhone() {
        return clientPhone;
    }

    /**
     * @param clientPhone the clientPhone to set
     */
    public void setClientPhone(int clientPhone) {
        this.clientPhone = clientPhone;
    }   
    
}
