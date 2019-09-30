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
@Path("ServicioporPlaca")
public class ServicioporPlacaResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ServicioporPlacaResource
     */
    public ServicioporPlacaResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.service.ServicioporPlacaResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("picoplaca/{placa}")
    public String getText(@PathParam("placa") String placa) {
        String dia = "";
        Servicio service = new Servicio();
        
            service = getServicioPlaca(placa);
        if(service != null){
            dia = getDia(service);
        }else{
            dia="No existe esa placa";
        }
        
        return dia;
    }

    /**
     * PUT method for updating or creating an instance of ServicioporPlacaResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    public void putText(String content) {
    }
    
    
    public Servicio getServicioPlaca(String placa){
        Servicio serv = new Servicio();
        Conexion conec = new Conexion();
        try{
       Connection con = null;
       con = conec.getConection();
       PreparedStatement ps;
       ResultSet rs;
       ps = con.prepareStatement("SELECT * from service where servplate = ?");
       ps.setString(1, placa);
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
       }else{
           serv = null;
       }
       conec.desconectar();
       }catch(Exception e){
           System.out.println(e);
       }
        return serv;
    }
    
    
    public String getDia(Servicio serv){
        String dia = "";
        String placa;
        char ultimo=' ';
        placa = serv.getServPlate();
        int cantidad = placa.length();
        char[] charArray = placa.toCharArray();
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
