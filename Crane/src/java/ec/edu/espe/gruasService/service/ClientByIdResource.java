/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.gruasService.service;
import ec.edu.espe.gruasService.model.Client;
import ec.edu.espe.gruasService.model.DBConnect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Alexis
 */
@Path("Client")
public class ClientByIdResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of clientByIdResource
     */
    public ClientByIdResource() {
    }

    /**
     * Retrieves representation of an instance of
     * ec.edu.espe.gruasService.service.clientByIdResource
     *
     * @return an instance of ec.edu.espe.gruasService.model.Report
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

    /**
     * PUT method for updating or creating an instance of clientByIdResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(Client content) {
    }
}
