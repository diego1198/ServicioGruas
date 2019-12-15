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
import java.util.ArrayList;
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
    @Path("{idCraneManager}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Operator> getJson(@PathParam("idCraneManager") int id) throws SQLException {
        ArrayList<Operator> aux = new ArrayList();
        aux = getOperator(id);
        return aux;
    }
   
    @GET
    @Path("{typeLicense}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getLicenseNumber(@PathParam("typeLicense") String license) throws SQLException {

        ArrayList<Operator> op = new ArrayList();
        op = getNumberOperatorLicense(license);
        String tamanio = String.valueOf(op.size());

        return tamanio;
    }

    /**
     * PUT method for updating or creating an instance of OperatorResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String putJson(Operator content) {
        return updateOperator(content);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String postJson(Operator operator) {
        return SetOperatorId(new Operator(operator.getOperatorId(), operator.getCraneManagerId(), operator.getOperatorName(), operator.getOperatorLastName(), operator.getOperatorLicense()));
    }

    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    @Path("{idOperator}")
    public String deleteOperatorText(@PathParam("idOperator") String op) {

        return deleteOperatorId(op);
    }

   
    /*FUNCIONES*/
    public String SetOperatorId(Operator operator) {

        String mensaje="";
        DBConnect conec = new DBConnect();
        try {

            Connection con = null;
            con = conec.getConnection();
            PreparedStatement ps;
            ResultSet rs;
            ps = con.prepareStatement("INSERT INTO operator(opid,cmid,opname,oplastname,oplicense) values(?,?,?,?,?)");

            ps.setString(1, operator.getOperatorId());
            ps.setInt(2, operator.getCraneManagerId());
            ps.setString(3, operator.getOperatorName());
            ps.setString(4, operator.getOperatorLastName());
            ps.setString(5, operator.getOperatorLicense());
          int n = ps.executeUpdate();
            if (n > 0) {//comprueba que realmente se haya registrado en la base de datos
                mensaje = "successful license update";
            }

        } catch (Exception e) {
            mensaje = e.toString();
        }

        conec.finished();
        return mensaje;
    }

    public String deleteOperatorId(String id) {
        DBConnect conec = new DBConnect();
        String response = null;
        try {

            Connection con = null;
            con = conec.getConnection();
            PreparedStatement ps;
            ResultSet rs;
            ps = con.prepareStatement("DELETE FROM `gruas`.`operator` WHERE opid=?");
            ps.setString(1, id);

           
            if (!ps.execute()) {
                response = "operator successfully removed";
            } else {
                response = "operator not removed or does not exist";
            }

        } catch (SQLException e) {
            response=e.toString();
        }

        conec.finished();
        return response;
    }

    public String updateOperator(Operator operator) {

        String mensaje = "";
        DBConnect conec = new DBConnect();
        try {

            Connection con = null;
            con = conec.getConnection();
            PreparedStatement ps;

            ps = con.prepareStatement("UPDATE `gruas`.`operator` "
                    + "SET `opid` = ?,"
                    + "`cmid` = ?,"
                    + "`opname` = ?,"
                    + "`oplastname` = ?,"
                    + "`oplicense` = ?"
                    + " WHERE `opid` = ?");

            ps.setString(1, operator.getOperatorId());
            ps.setInt(2, operator.getCraneManagerId());
            ps.setString(3, operator.getOperatorName());
            ps.setString(4, operator.getOperatorLastName());
            ps.setString(5, operator.getOperatorLicense());
            ps.setString(6, operator.getOperatorId());
            int n = ps.executeUpdate();
            if (n > 0) {//comprueba que realmente se haya registrado en la base de datos
                mensaje = "successful license update";
            }

        } catch (Exception e) {
            mensaje = e.toString();
        }
        conec.finished();
        return mensaje;

    }

    public ArrayList getOperator(int cmid) throws SQLException {
        DBConnect connect = new DBConnect();
        PreparedStatement state;
        state = connect.getConnection().prepareStatement("SELECT * from operator where cmid=? ");
        state.setInt(1, cmid);
        ResultSet rs = state.executeQuery();
        

        Operator operator;
        ArrayList<Operator> operatorList = new ArrayList();

        while (rs.next()) {
            operator = new Operator(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5));
            operatorList.add(operator);
        }
        rs.close();
        state.close();
        return operatorList;

    }
    
    public ArrayList getOperatorId(String id) throws SQLException {
        DBConnect connect = new DBConnect();
        PreparedStatement state;
        state = connect.getConnection().prepareStatement("SELECT * from operator where opid=? ");
        state.setString(1, id);
        ResultSet rs = state.executeQuery();
        

        Operator operator;
        ArrayList<Operator> operatorList = new ArrayList();

        while (rs.next()) {
            operator = new Operator(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5));
            operatorList.add(operator);
        }
        rs.close();
        state.close();
        return operatorList;

    }

    public ArrayList getNumberOperatorLicense(String license) throws SQLException {
        DBConnect connect = new DBConnect();
        PreparedStatement state;
        state = connect.getConnection().prepareStatement("SELECT * from operator where oplicense=? ");
        state.setString(1, license);
        ResultSet rs = state.executeQuery();
        Operator serviceClient;

        ArrayList<Operator> operator = new ArrayList();

        while (rs.next()) {
            serviceClient = new Operator(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5));
            operator.add(serviceClient);
        }
        rs.close();
        state.close();
        return operator;

    }
}
