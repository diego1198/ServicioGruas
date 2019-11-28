/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.gruasService.service;

import ec.edu.espe.gruasService.model.DBConnect;
import ec.edu.espe.gruasService.model.Service;
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
 * @author diego
 */
@Path("Service")
public class ServiceResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ServiceResource
     */
    public ServiceResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.gruasService.service.ServiceResource
     * @return an instance of ec.edu.espe.gruasService.model.Service
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Service> getJson() {
        ArrayList<Service> listServices = new ArrayList<>();
        listServices = getall();
        return listServices;
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Service byId(@PathParam("id") String id){
        Service service = new Service();
        service = getById(id);
        return service;
    }
    
    @GET
    @Path("maxId")
    @Produces(MediaType.TEXT_PLAIN)
    public String byId(){
        return getMaxId();
    }
    
    @GET
    @Path("total/{from}/{to}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getTotal(@PathParam("from") String from,@PathParam("to") String to){
        return String.valueOf(total(from,to));
    }
    
    

    /**
     * PUT method for updating or creating an instance of ServiceResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(Service content) {
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String postJson(Service content){
        return setService(content);
    }
    
    
    public ArrayList<Service> getall(){
        ArrayList<Service> listServices = new ArrayList<>();
        DBConnect connect = new DBConnect();
        PreparedStatement state;
        Service service;
        try {
            state = connect.getConnection().prepareStatement("SELECT * from service");
            ResultSet rs = state.executeQuery();
            while (rs.next()) {
                service = new Service(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getFloat(9),rs.getString(10));
                listServices.add(service);
            }
            rs.close();
            state.close();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listServices;
    }
    
    public Service getById(String id){
        Service service = null;
        DBConnect connect = new DBConnect();
        PreparedStatement state;
        try {
            state = connect.getConnection().prepareStatement("SELECT * from service where servid = ?");
            state.setString(1, id);
            ResultSet rs = state.executeQuery();
            while (rs.next()) {
                service = new Service(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getFloat(9),rs.getString(10));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return service;
    }
    
    public float total(String from,String to){
        float total = 0.0f;
        DBConnect connect = new DBConnect();
        PreparedStatement state;
        try {
            state = connect.getConnection().prepareStatement("select sum(servcost) from service where service_date >= ? and service_date <= ?");
            state.setString(1, from);
            state.setString(2, to);
            ResultSet rs = state.executeQuery();
            if(rs.next()){
                total = rs.getFloat(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }
    
    public String setService(Service service){
        DBConnect conec = new DBConnect();
        String response = "";
        
        try {
            Connection con = null;
            con = conec.getConnection();
            PreparedStatement ps;
            ResultSet rs;
            ps = con.prepareStatement("INSERT INTO service values(?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, getNextId());
            ps.setString(2, service.getServiceDate());
            ps.setString(3, service.getServBrand());
            ps.setString(4, service.getServModel());
            ps.setString(5, service.getServColor());
            ps.setString(6, service.getServPlate());
            ps.setString(7, service.getServOrig());
            ps.setString(8, service.getServDest());
            ps.setFloat(9, service.getServCost());
            ps.setString(10, service.getServUnity());
            ps.executeUpdate();
            response="Succesfull Save Service";
        } catch (Exception e) {
            System.out.println(e);
            response="Error Save Service";
        }
        conec.finished();
        return response;
    }
    
    public String getMaxId(){
        DBConnect conec = new DBConnect();
        String response = "";
        try {
            Connection con = null;
            con = conec.getConnection();
            PreparedStatement ps;
            ResultSet rs;
            ps = con.prepareStatement("Select max(servid) as maxId from service");
            rs = ps.executeQuery();
            if(rs.next()){
                response = rs.getString(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return response;
    }
    public String getNextId(){
        String maxId = getMaxId();
        int id = Integer.parseInt(maxId);
        id++;
        return String.valueOf(id);
    }
}
