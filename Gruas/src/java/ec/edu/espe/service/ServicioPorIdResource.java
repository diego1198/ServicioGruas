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
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author diego
 */
@Path("ServicioPorId")
public class ServicioPorIdResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ServicioPorIdResource
     */
    public ServicioPorIdResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.service.ServicioPorIdResource
     * @return an instance of ec.edu.espe.model.Servicio
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Servicio getJson(@PathParam("id")String id) {
        Servicio service = new Servicio();
        service = getServicioId(id);
        return service;
    }
    
    @GET
    @Path("{desde}/{hasta}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Servicio> getDesde(@PathParam("desde")String id1,@PathParam("hasta")String id2) {
        ArrayList<Servicio> listaServicios = new ArrayList<>();
        listaServicios = getServicioDesdeHasta(id1, id2);
        return listaServicios;
    }

    /**
     * PUT method for updating or creating an instance of ServicioPorIdResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(Servicio content) {
    }
    
    public Servicio getServicioId(String id){
        Servicio serv = new Servicio();
        Conexion conec = new Conexion();
        try{
       Connection con = null;
       con = conec.getConection();
       PreparedStatement ps;
       ResultSet rs;
       ps = con.prepareStatement("SELECT * from service where servid = ?");
       ps.setString(1, id);
       rs = ps.executeQuery();
       if(rs.next()){
       
       serv.setServId(rs.getString(1));
       serv.setServBrand(rs.getString(2));
       serv.setServModel(rs.getString(3));
       serv.setServCost(rs.getString(4));
       serv.setServPlate(rs.getString(5));
       serv.setServOrigen(rs.getString(6));
       serv.setServDest(rs.getString(7));
       serv.setServCost(rs.getString(8));
       serv.setServUnity(rs.getString(9));
       }
       conec.desconectar();
       }catch(Exception e){
           System.out.println(e);
       }
        return serv;
    }
    
    public ArrayList<Servicio> getServicioDesdeHasta(String desde, String hasta){
        Conexion conec = new Conexion();
        ArrayList<Servicio> lista = new ArrayList<>();
        try{
        Connection con = null;
        con = conec.getConection();
        PreparedStatement ps;
        ResultSet rs;
        ps = con.prepareStatement("SELECT * from service where servid >= ? and servid <= ?");
        ps.setString(1, desde);
        ps.setString(2, hasta);
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
