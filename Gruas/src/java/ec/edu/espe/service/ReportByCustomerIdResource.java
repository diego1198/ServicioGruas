/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.service;

import ec.edu.espe.model.Conexion;
import ec.edu.espe.model.Operator;
import ec.edu.espe.model.Report;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
@Path("ReportByCustomerId")
public class ReportByCustomerIdResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ReportByCustomerIdResource
     */
    public ReportByCustomerIdResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.service.ReportByCustomerIdResource
     * @return an instance of ec.edu.espe.model.Report
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
     @Path("{customerId}")
    public Report getJson(@PathParam("customerId")String id) {
        Report report = new Report();
        report = getReportId(id);
        return report;
    }

    /**
     * PUT method for updating or creating an instance of ReportByCustomerIdResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(Report content) {
    }
    
    
    public Report getReportId(String id) {
        Report report = new Report();
        Conexion conec = new Conexion();
        try {
            Connection con = null;
            con = conec.getConection();
            PreparedStatement ps;
            ResultSet rs;
            ps = con.prepareStatement("SELECT * from report where cliId = ?");
            ps.setString(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {

                report.setReportId(rs.getInt(1));
                report.setClientId(rs.getString(2));
                report.setServiceId(rs.getString(3));
                report.setOperatorId(rs.getString(4));
            

            } else {
                report = null;
            }
            conec.desconectar();
        } catch (Exception e) {
            System.out.println(e);
        }
        return report;
    }
}
