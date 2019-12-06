/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.craneService.service;

import java.util.Set;

/**
 *
 * @author henry
 */
@javax.ws.rs.ApplicationPath("")
public class ApplicationConfig extends javax.ws.rs.core.Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(ec.edu.espe.craneService.service.ClientResource.class);
        resources.add(ec.edu.espe.craneService.service.CompanyVehicleResource.class);
        resources.add(ec.edu.espe.craneService.service.ManagerResource.class);
        resources.add(ec.edu.espe.craneService.service.OperatorResource.class);
        resources.add(ec.edu.espe.craneService.service.ReportResource.class);
        resources.add(ec.edu.espe.craneService.service.ServiceResource.class);
    }
    
}
