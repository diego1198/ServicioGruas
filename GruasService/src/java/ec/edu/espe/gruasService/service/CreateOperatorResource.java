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
 * @author henry
 */
@Path("CreateOperator")
public class CreateOperatorResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CreateOperatorResource
     */
    public CreateOperatorResource() {
    }

    /**
     * Retrieves representation of an instance of
     * ec.edu.espe.gruasService.service.CreateOperatorResource
     *
     * @return an instance of ec.edu.espe.gruasService.model.Operator
     */
  

    @GET
    @Path("{operatorId}/{craneManager}/{operatorName}/{operatorLastName}/{operatorLicense}")
    @Produces(MediaType.TEXT_PLAIN)

    public String setOperator(@PathParam("operatorId") String id, @PathParam("craneManager") int cmanager,
            @PathParam("operatorName") String name, @PathParam("operatorLastName") String lastName,
            @PathParam("operatorLicense") String license) {

        return SetOperatorId(new Operator(id, cmanager, name, lastName, license));
    }

    
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

    /**
     * PUT method for updating or creating an instance of CreateOperatorResource
     *
     * @param content representation for the resource
     */
   @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String putText(Operator operator) {
        return SetOperatorId(new Operator(operator.getOperatorId(), operator.getCraneManagerId(), operator.getOperatorName(),operator.getOperatorLastName(),operator.getOperatorLicense()));
    }
}
