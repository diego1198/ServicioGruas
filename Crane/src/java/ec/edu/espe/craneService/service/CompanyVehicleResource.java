/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.craneService.service;

import ec.edu.espe.craneService.model.CompanyVehicle;
import ec.edu.espe.craneService.model.DBConnect;
import java.sql.Connection;
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
     * Retrieves representation of an instance of ec.edu.espe.craneService.service.CompanyVehicleResource
     * @return an instance of ec.edu.espe.craneService.model.CompanyVehicle
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
