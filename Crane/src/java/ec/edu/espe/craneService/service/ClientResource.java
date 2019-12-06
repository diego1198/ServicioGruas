/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.craneService.service;

import ec.edu.espe.craneService.model.DBConnect;
import ec.edu.espe.craneService.model.Report;
import ec.edu.espe.gruasService.model.Client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author henry
 */
@Path("Client")
public class ClientResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ClientResource
     */
    public ClientResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.craneService.service.ClientResource
     * @return an instance of ec.edu.espe.gruasService.model.Client
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList <Client> getJson(@PathParam("id") String id) throws SQLException {
        
         ArrayList <Client> aux= new  ArrayList ();
         aux=showRegisterList(id);
         return aux;
    }

    public ArrayList showRegisterList(String idClient) throws SQLException {
        DBConnect connect = new DBConnect();
        PreparedStatement state;
        state = connect.getConnection().prepareStatement("SELECT * from client where cliId=? ");
        state.setString(1, idClient);
        ResultSet rs = state.executeQuery();
        Client serviceClient;

        ArrayList<Client> client = new ArrayList();

        while (rs.next()) {
            serviceClient = new Client(rs.getString(1), rs.getString(2), rs.getInt(3));
            client.add(serviceClient);
        }
        rs.close();
        state.close();
        return client;

    }

      @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public String getJsonDelete(@PathParam("id") String id) {
        return deleteClient(id);
    }
    
    public String deleteClient(String id) {
        DBConnect conec = new DBConnect();
        String response = null;
        try {

            Connection con = null;
            con = conec.getConnection();
            PreparedStatement ps;
            ResultSet rs;
            ps = con.prepareStatement("DELETE FROM client WHERE cliId=?");
            ps.setString(1, id);

            if (!ps.execute()) {
                response = "Client successfully removed";
            } else {
                response = "Client not removed or does not exist";
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        conec.finished();
        return response;
    }
    
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteJson(@PathParam("id") String id) {
        return deleteClient(id);
    }
    
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList <Report> getJsonId(@PathParam("id") String id) throws SQLException {
        
         ArrayList <Report> aux= new  ArrayList ();
         aux=showRegisterListID(id);
         return aux;
    }

    public ArrayList showRegisterListID(String idClient) throws SQLException {
        DBConnect connect = new DBConnect();
        PreparedStatement state;
        state = connect.getConnection().prepareStatement("SELECT * from report where cliId=? ");
        state.setString(1, idClient);
        ResultSet rs = state.executeQuery();
        Report serviceClient;

        ArrayList<Report> report = new ArrayList();

        while (rs.next()) {
            serviceClient = new Report(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
            report.add(serviceClient);
        }
        rs.close();
        state.close();
        return report;

    }
}
