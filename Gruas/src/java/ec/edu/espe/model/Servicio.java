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
    private String expediente;
    private String ciOperador;
    private String id_administrador;
    private String placaVehiculo;

    public Servicio(String expediente, String ciOperador, String id_administrador, String placaVehiculo) {
        this.expediente = expediente;
        this.ciOperador = ciOperador;
        this.id_administrador = id_administrador;
        this.placaVehiculo = placaVehiculo;
    }

    /**
     * @return the expediente
     */
    public String getExpediente() {
        return expediente;
    }

    /**
     * @param expediente the expediente to set
     */
    public void setExpediente(String expediente) {
        this.expediente = expediente;
    }

    /**
     * @return the ciOperador
     */
    public String getCiOperador() {
        return ciOperador;
    }

    /**
     * @param ciOperador the ciOperador to set
     */
    public void setCiOperador(String ciOperador) {
        this.ciOperador = ciOperador;
    }

    /**
     * @return the id_administrador
     */
    public String getId_administrador() {
        return id_administrador;
    }

    /**
     * @param id_administrador the id_administrador to set
     */
    public void setId_administrador(String id_administrador) {
        this.id_administrador = id_administrador;
    }

    /**
     * @return the placaVehiculo
     */
    public String getPlacaVehiculo() {
        return placaVehiculo;
    }

    /**
     * @param placaVehiculo the placaVehiculo to set
     */
    public void setPlacaVehiculo(String placaVehiculo) {
        this.placaVehiculo = placaVehiculo;
    }
    
    
    
}
