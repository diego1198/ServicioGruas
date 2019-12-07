/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.craneService.service;

import ec.edu.espe.craneService.model.DBConnect;
import ec.edu.espe.craneService.model.Operator;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
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
     * Retrieves representation of an instance of ec.edu.espe.craneService.service.OperatorResource
     * @return an instance of ec.edu.espe.craneService.model.Operator
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
    
     @GET
    @Path("{typeLicense}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getText(@PathParam("typeLicense") String license) throws SQLException {
        
        ArrayList<Operator> op= new ArrayList();
        op=showRegisterList(license);
        String  tamanio =String.valueOf(op.size());
        
        return tamanio;
    }
    
    
        public ArrayList showRegisterList(String license) throws SQLException {
        DBConnect connect = new DBConnect();
        PreparedStatement state;
        state = connect.getConnection().prepareStatement("SELECT * from operator where oplicense=? ");
        state.setString(1, license);
        ResultSet rs = state.executeQuery();
        Operator serviceClient;

        ArrayList<Operator> operator = new ArrayList();

        while (rs.next()) {
            serviceClient = new Operator(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4),rs.getString(5));
            operator.add(serviceClient);
        }
        rs.close();
        state.close();
        return operator;

    }
        
          @GET
    @Path("{id}")
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public Operator getJson(@PathParam("id") String id) {
        Operator operator = new Operator();
        operator = getOperatorId(id);
        return operator;
    }

    public Operator getOperatorId(String id) {
        
        Operator operator = new Operator();
        DBConnect conec = new DBConnect();
        try {

            Connection con = null;
            con = conec.getConnection();
            PreparedStatement ps;
            ResultSet rs;
            ps = con.prepareStatement("SELECT * from operator where opid = ?");
            ps.setString(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {

                operator.setOperatorId(rs.getString(1));
                operator.setCraneManagerId(rs.getInt(2));
                operator.setOperatorName(rs.getString(3));
                operator.setOperatorLastName(rs.getString(4));
                operator.setOperatorLicense(rs.getString(5));

            } else {
                operator = null;
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        conec.finished();
        return operator;
    }
    
     /**
     * PUT method for updating or creating an instance of UpdateLicenseByIdResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String putTextLicense(Operator content) {
        return updateLicenseId(content);
    }
    
     public String updateLicenseId(Operator operator) {

        DBConnect conec = new DBConnect();
        try {

            Connection con = null;
            con = conec.getConnection();
            PreparedStatement ps;
        
            ps = con.prepareStatement("UPDATE `operator` SET `oplicense`=? WHERE opid=?");
         
            ps.setString(1, operator.getOperatorLicense());
            ps.setString(2, operator.getOperatorId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

        conec.finished();
        return "successful license update";
    }
}
