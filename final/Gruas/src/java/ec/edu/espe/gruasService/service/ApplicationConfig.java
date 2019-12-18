/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.gruasService.service;

import java.util.Set;

/**
 *
 * @author henry
 */
@javax.ws.rs.ApplicationPath("beta")
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
        resources.add(ec.edu.espe.gruasService.service.ClientResource.class);
        resources.add(ec.edu.espe.gruasService.service.CompanyVehicleResource.class);
        resources.add(ec.edu.espe.gruasService.service.CraneManagerResource.class);
        resources.add(ec.edu.espe.gruasService.service.OperatorResource.class);
        resources.add(ec.edu.espe.gruasService.service.ReportResource.class);
        resources.add(ec.edu.espe.gruasService.service.ServiceResource.class);
        resources.add(ec.edu.espe.gruasService.service.UpdateLicenseVehicleResource.class);
    }
    
}
