/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.gruasService.service;

import ec.edu.espe.gruasService.model.DBConnect;
import ec.edu.espe.gruasService.model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
 * @author Henry
 */
@Path("User")
public class UserResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UserResource
     */
    public UserResource() {
    }

    @GET
  
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<User> getJson() throws SQLException {
        ArrayList<User> aux = new ArrayList();
        aux = getUser();
        return aux;
    }

    public ArrayList getUser() throws SQLException {
        DBConnect connect = new DBConnect();
        PreparedStatement state;
        state = connect.getConnection().prepareStatement("SELECT * from user");
      
        ResultSet rs = state.executeQuery();
        User user;
        ArrayList<User> userList = new ArrayList();
        while (rs.next()) {
            user = new User(rs.getString(2), rs.getString(3));
            userList.add(user);
        }
        rs.close();
        state.close();
        return userList;

    }
}
