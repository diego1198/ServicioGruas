/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.gruasService.service;

import ec.edu.espe.gruasService.model.CompanyVehicle;
import ec.edu.espe.gruasService.model.DBConnect;
import ec.edu.espe.gruasService.model.Service;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * @author diego
 */
@Path("CompanyVehicle")
public class CompanyVehicleResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CompanyVehicleResource
     */
    public CompanyVehicleResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.gruasService.service.CompanyVehicleResource
     * @return an instance of ec.edu.espe.gruasService.model.CompanyVehicle
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<CompanyVehicle> getJson() {
        return getAll();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/plate/{plate}")
    public CompanyVehicle getOneByPlate(@PathParam("plate") String plate){
        return getByPlate(plate);
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/plate/picoplaca/{plate}")
    public String getPicoPlaca(@PathParam("plate") String plate){
        return getDia(plate);
    }

    /**
     * PUT method for updating or creating an instance of CompanyVehicleResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(CompanyVehicle content) {
    }
    
    public ArrayList<CompanyVehicle> getAll(){
        ArrayList<CompanyVehicle> listCompVehi = new ArrayList<>();
        DBConnect connect = new DBConnect();
        PreparedStatement state;
        CompanyVehicle compVehi;
        try {
            state = connect.getConnection().prepareStatement("SELECT * from companyvehicle");
            ResultSet rs = state.executeQuery();
            while (rs.next()) {
                compVehi = new CompanyVehicle(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
                listCompVehi.add(compVehi);
            }
            rs.close();
            state.close();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listCompVehi;
    }
    
    public CompanyVehicle getByPlate(String plate){
        CompanyVehicle vehicle = null;
        DBConnect connect = new DBConnect();
        PreparedStatement state;
        try {
            state = connect.getConnection().prepareStatement("SELECT * from companyvehicle where cvplate = ?");
            state.setString(1, plate);
            ResultSet rs = state.executeQuery();
            while (rs.next()) {
                vehicle = new CompanyVehicle(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CompanyVehicleResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vehicle;
    }
    
    public String getDia(String placa){
        CompanyVehicle vehicle = getByPlate(placa);
        
        String dia = "";
        char ultimo=' ';
        int cantidad = 0;
        char[] charArray;
        if(vehicle != null){
            String plate = vehicle.getVehicleLicensePlate();
             cantidad = plate.length();
              charArray = plate.toCharArray();
        }else{
            return "Vehicle Company don`t exists";
        }
        
        if(cantidad == 8){
            ultimo = charArray[7];
        }else if(cantidad == 7){
            ultimo = charArray[6];
        }
        int ult = Integer.parseInt(String.valueOf(ultimo));
        switch(ult){
            case 1:
                dia="LUNES";
            break;
            case 2:
                dia="LUNES";
            break;
            case 3:
                dia="MARTES";
            break;
            case 4:
                dia="MARTES";
            break;
            case 5:
                dia="MIERCOLES";
            break;
            case 6:
                dia="MIERCOLES";
            break;
            case 7:
                dia="JUEVES";
            break;
            case 8:
                dia="JUEVES";
            break;
            case 9:
                dia="VIERNES";
            break;
            case 0:
                dia="VIERNES";
            break;            
        }
        
        return dia;
    }
}
