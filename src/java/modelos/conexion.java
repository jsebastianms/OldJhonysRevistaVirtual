/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author camilo
 */
public class conexion {
    public DriverManagerDataSource conectar(){
        DriverManagerDataSource datos = new DriverManagerDataSource();
        datos.setDriverClassName("org.postgresql.Driver");
        datos.setUrl("jdbc:postgresql://localhost:5432/mercadolibro");
        datos.setUsername("postgres");
        datos.setPassword("camilo");
        return datos;
    }
}
