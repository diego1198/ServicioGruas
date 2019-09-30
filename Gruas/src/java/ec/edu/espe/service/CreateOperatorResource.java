/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.service;

import ec.edu.espe.model.Conexion;
import ec.edu.espe.model.Operator;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
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
@Path("createOperator")
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
     * ec.edu.espe.service.CreateOperatorResource
     *
     * @return an instance of ec.edu.espe.model.Operator
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)

    @Path("{operatorId}/{craneManagerId}/{operatorName}/{operatorLastName}/{operatorLicence}")
    public String getText(@PathParam("operatorId") String id,@PathParam("craneManagerId") int craneManagerId,
            @PathParam("operatorName") String operatorName,@PathParam("operatorLastName") String operatorLastName,
            @PathParam("operatorLicence") String operatorLicence) {

        String respuesta = setOperatorId(id, craneManagerId, operatorName, operatorLastName, operatorLicence);
        return respuesta;
    }

    /**
     * PUT method for updating or creating an instance of CreateOperatorResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    public void putText(Operator content) {
    }

    public String setOperatorId(String id, int craneManagerId, String operatorName,
            String operatorLastName, String operatorLicence) {
        

        Conexion conec = new Conexion();
        try {
            Connection con = null;
            con = conec.getConection();
            PreparedStatement ps;
            ResultSet rs;

            try {

                ps = con.prepareStatement("INSERT INTO operator(opid,cmid,opname,oplastname,oplicence)\n" + "values(?,?,?,?,?)");
                ps.setString(1, id);
                ps.setInt(2, craneManagerId);
                ps.setString(3, operatorName);
                ps.setString(4, operatorLastName);
                ps.setString(5, operatorLicence);
                rs = ps.executeQuery();
                ps.execute();
                 
                 //JOptionPane.showMessageDialog(null, "Persona Registrada");
            } catch (SQLException e) {
                // JOptionPane.showMessageDialog(null, "Error al hacer la query" + e);
            }

            conec.desconectar();
        } catch (Exception e) {
            System.out.println(e);
        }
       return "successful registered operator";
       
    }
}
