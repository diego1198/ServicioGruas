/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.service;

import ec.edu.espe.model.Conexion;
import ec.edu.espe.model.Servicio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;

/**
 * REST Web Service
 *
 * @author diego
 */
@Path("servicio")
public class ServicioResource {

    @Context
    private UriInfo context;
    

    /**
     * Creates a new instance of ServicioResource
     */
    public ServicioResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.service.ServicioResource
     * @return an instance of ec.edu.espe.model.Servicio
     */
    @GET
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public ArrayList<Servicio> getJson() {
        ArrayList<Servicio> listaServicios = new ArrayList<>();
        listaServicios = getAll();
        return listaServicios;
    }

    /**
     * PUT method for updating or creating an instance of ServicioResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public void putJson(Servicio content) {
        
    }
    
    public ArrayList<Servicio> getAll(){
        Conexion conec = new Conexion();
       ArrayList<Servicio> lista = new ArrayList<>();
       try{
       Connection con = null;
       con = conec.getConection();
       PreparedStatement ps;
       ResultSet rs;
       ps = con.prepareStatement("SELECT * from service");
       rs = ps.executeQuery();
       while(rs.next()){
       Servicio serv = new Servicio();
       serv.setServId(rs.getString(1));
       serv.setServBrand(rs.getString(2));
       serv.setServModel(rs.getString(3));
       serv.setServCost(rs.getString(4));
       serv.setServPlate(rs.getString(5));
       serv.setServOrigen(rs.getString(6));
       serv.setServDest(rs.getString(7));
       serv.setServCost(rs.getString(8));
       serv.setServUnity(rs.getString(9));
       
       lista.add(serv);
       }
       conec.desconectar();
       }catch(Exception e){
           System.out.println(e);
       }
       
       return lista;
    }
}
