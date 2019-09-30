package ec.edu.espe.service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import ec.edu.espe.model.Conexion;
import ec.edu.espe.model.CompanyVehicle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
 * @author Alexis
 */
@Path("companyVehicleByBrand")
public class CompanyVehicleByBrandResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of OperatorByIdResource
     */
    public CompanyVehicleByBrandResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.service.OperatorByIdResource
     * @return an instance of ec.edu.espe.model.Operator
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{brand}")
    public ArrayList<CompanyVehicle> getJson(@PathParam("brand")String brand) {
        ArrayList<CompanyVehicle> listVehicles = new ArrayList<>();
        listVehicles = getVehicleBrand(brand);
        return listVehicles;
    }

    /**
     * PUT method for updating or creating an instance of OperatorByIdResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(CompanyVehicle content) {
    }
    
     public ArrayList<CompanyVehicle> getVehicleBrand(String brand){
        Conexion conec = new Conexion();
        CompanyVehicle companyVehicle = new CompanyVehicle();
        ArrayList<CompanyVehicle> lista = new ArrayList<>();
        try{
            Connection con = null;
            con = conec.getConection();
            PreparedStatement ps;
            ResultSet rs;
            ps = con.prepareStatement("SELECT * from service where cvbrand = ?");
            ps.setString(1, brand);
            rs = ps.executeQuery();
            while(rs.next()){
                companyVehicle.setVehicleId(rs.getInt(1));
                companyVehicle.setVehicleModel(rs.getString(2));
                companyVehicle.setVehicleBrand(rs.getString(3));
                companyVehicle.setVehicleColor(rs.getString(4));
                companyVehicle.setVehicleLicensePlate(rs.getString(5));
                companyVehicle.setVehicleType(rs.getString(6));
       
            lista.add(companyVehicle);
       }
       conec.desconectar();
       }catch(Exception e){
           System.out.println(e);
       }
       return lista;
     }
}
