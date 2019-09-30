package ec.edu.espe.service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import ec.edu.espe.model.Conexion;
import ec.edu.espe.model.Client;
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
 * @author Alexis
 */
@Path("insuredById")
public class ClientByIdResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of OperatorByIdResource
     */
    public ClientByIdResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.service.OperatorByIdResource
     * @return an instance of ec.edu.espe.model.Operator
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Client getJson(@PathParam("id")String id) {
        Client client = new Client();
        client = getClientId(id);
        return client;
    }

    /**
     * PUT method for updating or creating an instance of OperatorByIdResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(Client content) {
    }
    
     public Client getClientId(String id){
        Client client = new Client();
        Conexion conec = new Conexion();
        try{
            Connection con = null;
            con = conec.getConection();
            PreparedStatement ps;
            ResultSet rs;
            ps = con.prepareStatement("SELECT * from client where cliId = ?");
            ps.setString(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                client.setClientId(rs.getString(1));
                client.setClientName(rs.getString(2));
                client.setClientPhone(rs.getString(3));
            }
            conec.desconectar();
       }catch(Exception e){
           System.out.println(e);
       }
        return client;
    }
}
