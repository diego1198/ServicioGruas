/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.gruasService.service;

import ec.edu.espe.gruasService.model.CraneManager;
import ec.edu.espe.gruasService.model.DBConnect;
import ec.edu.espe.gruasService.model.Operator;
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
 * @author henry
 */
@Path("CraneManager")
public class CraneManagerResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AllCraneManagerResource
     */
    public CraneManagerResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.gruasService.service.CraneManagerResource
     * @return an instance of ec.edu.espe.gruasService.model.CraneManager
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<CraneManager> getJson() throws SQLException {
        ArrayList <CraneManager> aux= new  ArrayList ();
         aux=allCraneManager();
         return aux;
    }

    public ArrayList allCraneManager() throws SQLException {
        DBConnect connect = new DBConnect();
        PreparedStatement state;
        state = connect.getConnection().prepareStatement("SELECT * from cranemanager");
        ResultSet rs = state.executeQuery();
        CraneManager cManager;
        ArrayList<CraneManager> manager = new ArrayList();
        while (rs.next()) {
            cManager = new CraneManager(rs.getString(1), rs.getString(2), rs.getString(3));
            manager.add(cManager);
        }
        rs.close();
        state.close();
        return manager;

    }
    /**
     * PUT method for updating or creating an instance of CraneManagerResource
     * @param content representation for the resource
     */
    
    @GET
    @Path("{idCraneManager}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Operator> getJson(@PathParam("idCraneManager") int id) throws SQLException {
        ArrayList<Operator> aux = new ArrayList();
        aux = getOperator(id);
        return aux;
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(CraneManager content) {
    }
    /*Funciones*/
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
}
