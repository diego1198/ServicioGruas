/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.craneService.service;

import ec.edu.espe.craneService.model.CraneManager;
import ec.edu.espe.craneService.model.DBConnect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author henry
 */
@Path("Manager")
public class ManagerResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ManagerResource
     */
    public ManagerResource() {
    }

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

}
