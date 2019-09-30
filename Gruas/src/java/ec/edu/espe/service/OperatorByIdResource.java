/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.service;

import ec.edu.espe.model.Conexion;
import ec.edu.espe.model.Operator;
import ec.edu.espe.model.Servicio;
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
@Path("operatorById")
public class OperatorByIdResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of OperatorByIdResource
     */
    public OperatorByIdResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.service.OperatorByIdResource
     * @return an instance of ec.edu.espe.model.Operator
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Operator getJson(@PathParam("id")String id) {
        Operator operator = new Operator();
        operator = getOperatorId(id);
        return operator;
    }

    /**
     * PUT method for updating or creating an instance of OperatorByIdResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(Operator content) {
    }
    
     public Operator getOperatorId(String id){
        Operator operator = new Operator();
        Conexion conec = new Conexion();
        try{
       Connection con = null;
       con = conec.getConection();
       PreparedStatement ps;
       ResultSet rs;
       ps = con.prepareStatement("SELECT * from operator where opid = ?");
       ps.setString(1, id);
       rs = ps.executeQuery();
       if(rs.next()){
       
       operator.setOperatorId(rs.getString(1));
       operator.setCraneManagerId(rs.getInt(2));
       operator.setOperatorName(rs.getString(3));
       operator.setOperatorLastName(rs.getString(4));
       operator.setOperatorLicence(rs.getString(5));
       
       
       }else{
           operator = null;
       }
       conec.desconectar();
       }catch(Exception e){
           System.out.println(e);
       }
        return operator;
    }
}
