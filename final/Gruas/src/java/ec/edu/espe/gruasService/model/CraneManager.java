/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.gruasService.model;

/**
 *
 * @author henry
 */
public class CraneManager {
    private String cmid;
    private String cmUser;
    private String cmpass;

    public CraneManager(String cmid, String cmUser, String cmpass) {
        this.cmid = cmid;
        this.cmUser = cmUser;
        this.cmpass = cmpass;
    }

    public CraneManager() {
    }

    public String getCmid() {
        return cmid;
    }

    public void setCmid(String cmid) {
        this.cmid = cmid;
    }

    public String getCmUser() {
        return cmUser;
    }

    public void setCmUser(String cmUser) {
        this.cmUser = cmUser;
    }

    public String getCmpass() {
        return cmpass;
    }

    public void setCmpass(String cmpass) {
        this.cmpass = cmpass;
    }
    
    
    
}
