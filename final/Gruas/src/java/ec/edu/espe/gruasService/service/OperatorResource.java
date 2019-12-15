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
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author henry
 */
@Path("Operator")
public class OperatorResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of OperatorResource
     */
    public OperatorResource() {
    }

    /**
     * Retrieves representation of an instance of
     * ec.edu.espe.gruasService.service.OperatorResource
     *
     * @return an instance of ec.edu.espe.gruasService.model.Operator
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Operator getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of OperatorResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(Operator content) {
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String postJson(Operator operator) {
        return SetOperatorId(new Operator(operator.getOperatorId(), operator.getCraneManagerId(), operator.getOperatorName(), operator.getOperatorLastName(), operator.getOperatorLicense()));
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("{idOperator}")
    public String deleteOperatorText(@PathParam("idOperator") String op) {

        return deleteOperatorId(op);
    }

    /*FUNCIONES*/
    public String SetOperatorId(Operator operator) {

        DBConnect conec = new DBConnect();
        try {

            Connection con = null;
            con = conec.getConnection();
            PreparedStatement ps;
            ResultSet rs;
            ps = con.prepareStatement("INSERT INTO operator values(?,?,?,?,?)");

            ps.setString(1, operator.getOperatorId());
            ps.setInt(2, operator.getCraneManagerId());
            ps.setString(3, operator.getOperatorName());
            ps.setString(4, operator.getOperatorLastName());
            ps.setString(5, operator.getOperatorLicense());
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }

        conec.finished();
        return "registered operator";
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
}
