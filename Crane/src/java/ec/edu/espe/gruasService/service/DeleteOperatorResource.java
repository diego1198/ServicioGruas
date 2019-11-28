/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.gruasService.service;

import ec.edu.espe.gruasService.model.DBConnect;
import ec.edu.espe.gruasService.model.Operator;
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
 * @author henry
 */
@Path("DeleteOperator")
public class DeleteOperatorResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of DeleteOperatorResource
     */
    public DeleteOperatorResource() {
    }

    /**
     * Retrieves representation of an instance of
     * ec.edu.espe.gruasService.service.DeleteOperatorResource
     *
     * @return an instance of ec.edu.espe.gruasService.model.Operator
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("{idOperator}")
    public String deleteText(@PathParam("idOperator") String op) {

        return deleteOperatorId(op);
    }

    public String deleteOperatorId(String id) {
        DBConnect conec = new DBConnect();
        String response = null;
        try {

            Connection con = null;
            con = conec.getConnection();
            PreparedStatement ps;
            ResultSet rs;
            ps = con.prepareStatement("DELETE FROM `operator` WHERE opid=?");
            ps.setString(1, id);

            if (!ps.execute()) {
                response = "operator successfully removed";
            } else {
                response = "operator not removed or does not exist";
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        conec.finished();
        return response;
    }

    @DELETE
    @Path("{idOperator}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteOperatorText(@PathParam("idOperator") String op) {

        return deleteOperatorId(op);
    }

    /**
     * PUT method for updating or creating an instance of DeleteOperatorResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    public void putText(Operator content) {
    }
}
