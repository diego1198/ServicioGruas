/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.gruasService.service;

import ec.edu.espe.gruasService.model.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
 * @author Alexis
 */
@Path("DeleteClient")
public class DeleteClientResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of DeleteClientResource
     */
    public DeleteClientResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.gruasService.service.DeleteClientResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public String getJson(@PathParam("id") String id) {
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
    /**
     * PUT method for updating or creating an instance of DeleteClientResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
