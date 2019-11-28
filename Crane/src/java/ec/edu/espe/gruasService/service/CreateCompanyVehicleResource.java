/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.gruasService.service;

import ec.edu.espe.gruasService.model.CompanyVehicle;
import ec.edu.espe.gruasService.model.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
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
 * @author Alexis
 */
@Path("CreateCompanyVehicle")
public class CreateCompanyVehicleResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CreateCompanyVehicleResource
     */
    public CreateCompanyVehicleResource() {
    }

    @GET
    @Path("{id}/{model}/{brand}/{color}/{plate}/{type}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@PathParam("id") int id,@PathParam("model") String model,@PathParam("brand") String brand,@PathParam("color") String color,@PathParam("plate")String plate,@PathParam("type") String type) {
        CompanyVehicle vehicle = new CompanyVehicle(id,model,brand,color,plate,type);
        DBConnect conec = new DBConnect();
        try {
            Connection con = null;
            con = conec.getConnection();
            PreparedStatement ps;
            ResultSet rs;
            ps = con.prepareStatement("INSERT INTO companyvehicle values(?,?,?,?,?,?)");
            ps.setInt(1, vehicle.getVehicleId());
            ps.setString(2, vehicle.getVehicleModel());
            ps.setString(3, vehicle.getVehicleBrand());
            ps.setString(4, vehicle.getVehicleColor());
            ps.setString(5, vehicle.getVehicleLicensePlate());
            ps.setString(6, vehicle.getVehicleType());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        conec.finished();
        return "registered company vehicle";
    }
    
    /**
     * POST method for creating an instance of CreateCompanyVehicleResource
     * @param content representation for the resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String putJson(CompanyVehicle vehicle) {
        return SetVehicle(new CompanyVehicle(vehicle.getVehicleId(), vehicle.getVehicleModel(),vehicle.getVehicleBrand(),vehicle.getVehicleColor(),vehicle.getVehicleLicensePlate(),vehicle.getVehicleType()));
    }
    
    public String SetVehicle(CompanyVehicle vehicle) {

        DBConnect conec = new DBConnect();
        try {

            Connection con = null;
            con = conec.getConnection();
            PreparedStatement ps;
            ResultSet rs;
            ps = con.prepareStatement("INSERT INTO companyvehicle values(?,?,?,?,?,?)");
            ps.setInt(1, vehicle.getVehicleId());
            ps.setString(2, vehicle.getVehicleModel());
            ps.setString(3, vehicle.getVehicleBrand());
            ps.setString(4, vehicle.getVehicleColor());
            ps.setString(5, vehicle.getVehicleLicensePlate());
            ps.setString(6, vehicle.getVehicleType());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

        conec.finished();
        return "registered company vehicle";
    }
}
