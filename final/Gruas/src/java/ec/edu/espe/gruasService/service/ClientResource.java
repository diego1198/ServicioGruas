/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.gruasService.service;
import ec.edu.espe.gruasService.model.Client;
import ec.edu.espe.gruasService.model.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Alexis
 */
@Path("Clients")
public class ClientResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of clientByIdResource
     */
    public ClientResource() {
    }

    /**
     * Retrieves representation of an instance of
     * ec.edu.espe.gruasService.service.clientByIdResource
     *
     * @return an instance of ec.edu.espe.gruasService.model.Report
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList <Client> getJson(){
        ArrayList<Client> listClients = new ArrayList<>();
        listClients = getAll();
        return listClients;
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList <Client> getJson(@PathParam("id") String id) throws SQLException {
         ArrayList <Client> aux = new  ArrayList ();
         aux=showRegisterList(id);
         return aux;
    }
    
    @GET
    @Path("/{id}/{name}/{phone}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@PathParam("id") String id,
                          @PathParam("name") String name,
                          @PathParam("phone") int phone) {
        Client client = new Client(id,name,phone);
        DBConnect conec = new DBConnect();
        try {
            Connection con = null;
            con = conec.getConnection();
            PreparedStatement ps;
            ResultSet rs;
            ps = con.prepareStatement("INSERT INTO client values(?,?,?)");
            ps.setString(1, client.getClientId());
            ps.setString(2, client.getClientName());
            ps.setInt(3, client.getClientPhone());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        conec.finished();
        return "registered client";
    }
    
    /**
     * POST method for creating an instance of CreateCompanyVehicleResource
     * @param content representation for the resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String putJson(Client client) {
        return SetClient(new Client(client.getClientId(), 
                                             client.getClientName(),
                                             client.getClientPhone()));
    }
    
    @GET
    @Path("delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getId(@PathParam("id") String id) {
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
    
    public String SetClient(Client client) {

        DBConnect conec = new DBConnect();
        try {

            Connection con = null;
            con = conec.getConnection();
            PreparedStatement ps;
            ResultSet rs;
            ps = con.prepareStatement("INSERT INTO client values(?,?,?)");
            ps.setString(1, client.getClientId());
            ps.setString(2, client.getClientName());
            ps.setInt(3, client.getClientPhone());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

        conec.finished();
        return "registered client";
    }
    
    public ArrayList<Client> getAll(){
        ArrayList<Client> listClients = new ArrayList<>();
        DBConnect connect = new DBConnect();
        PreparedStatement state;
        Client clients;
        try {
            state = connect.getConnection().prepareStatement("SELECT * from client");
            ResultSet rs = state.executeQuery();
            while (rs.next()) {
                clients = new Client(rs.getString(1),rs.getString(2),rs.getInt(3));
                listClients.add(clients);
            }
            rs.close();
            state.close();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listClients;
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

    
    
}
