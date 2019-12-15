/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.gruasService.service;

import ec.edu.espe.gruasService.model.DBConnect;
import ec.edu.espe.gruasService.model.Operator;
import ec.edu.espe.gruasService.model.Report;
import java.sql.Connection;
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
@Path("ReportByCliendId")
public class ReportResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ReportByIdResource
     */
    public ReportResource() {
    }

    /**
     * Retrieves representation of an instance of
     * ec.edu.espe.gruasService.service.ReportByIdResource
     *
     * @return an instance of ec.edu.espe.gruasService.model.Report
     */
    @GET
    @Path("{idClient}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList <Report> getJson(@PathParam("idClient") String id) throws SQLException {
        
         ArrayList <Report> aux= new  ArrayList ();
         aux=showRegisterList(id);
         return aux;
    }

    public ArrayList showRegisterList(String idClient) throws SQLException {
        DBConnect connect = new DBConnect();
        PreparedStatement state;
        state = connect.getConnection().prepareStatement("SELECT * from report where cliId=? ");
        state.setString(1, idClient);
        ResultSet rs = state.executeQuery();
        Report serviceClient;

        ArrayList<Report> report = new ArrayList();

        while (rs.next()) {
            serviceClient = new Report(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
            report.add(serviceClient);
        }
        rs.close();
        state.close();
        return report;

    }

    /**
     * PUT method for updating or creating an instance of ReportByIdResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(Report content) {
    }
}
