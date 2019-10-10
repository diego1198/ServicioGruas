/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.service;

import java.util.Set;

/**
 *
 * @author diego
 */
@javax.ws.rs.ApplicationPath("RestFul")
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

        resources.add(ec.edu.espe.service.ClientByIdResource.class);
        resources.add(ec.edu.espe.service.CompanyVehicleByBrandResource.class);
        resources.add(ec.edu.espe.service.CompanyVehicleByIdResource.class);
        resources.add(ec.edu.espe.service.CreateOperatorResource.class);
        resources.add(ec.edu.espe.service.DeleteOperatorResource.class);
        resources.add(ec.edu.espe.service.InsuredVehicleModelResource.class);
        resources.add(ec.edu.espe.service.NumberOperatorLicenseResource.class);
        resources.add(ec.edu.espe.service.OperatorByIdResource.class);
        resources.add(ec.edu.espe.service.ReportByCustomerIdResource.class);
        resources.add(ec.edu.espe.service.ServicioPorIdResource.class);
        resources.add(ec.edu.espe.service.ServicioResource.class);
        resources.add(ec.edu.espe.service.ServicioporPlacaResource.class);
        resources.add(ec.edu.espe.service.UpdateLicenseByidResource.class);
    }
}
