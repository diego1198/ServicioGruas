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
 * @author Alexis
 */
@Path("updateLicenseVehicle")
public class UpdateLicenseVehicleResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UpdateLicenseVehicleResource
     */
    public UpdateLicenseVehicleResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.gruasService.service.UpdateLicenseVehicleResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of UpdateLicenseVehicleResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String putJsonPlate(CompanyVehicle vehicle) {
        DBConnect conec = new DBConnect();
        try {
            Connection con = null;
            con = conec.getConnection();
            PreparedStatement ps;
        
            ps = con.prepareStatement("UPDATE `companyvehicle` SET `cvplate`=? WHERE cvid=?");
         
            ps.setString(1, vehicle.getVehicleLicensePlate());
            ps.setInt(2, vehicle.getVehicleId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

        conec.finished();
        return "Update plate sucessfully";
    }
}
