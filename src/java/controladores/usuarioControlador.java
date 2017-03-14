/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.util.List;
import modelos.conexion;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.controller;

/**
 *
 * @author camilo
 */
@Controller
@RequestMapping("usuario.htm")
public class usuarioControlador {
        private JdbcTemplate jdbc;

    public usuarioControlador() {
        conexion con = new conexion();
        this.jdbc = new JdbcTemplate(con.conectar());
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView autor() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("usuario");
        String SQL = "select * from Usuario;";
        List l;
        l = this.jdbc.queryForList(SQL);
//        System.out.println(l.toString());
        mv.addObject("datos", l);
        return mv;
    }
     @RequestMapping(method = RequestMethod.POST)
    public void añadir(@RequestParam("nombreUsuario")String nombre,@RequestParam("Apellido")String apellido,@RequestParam("dirreccionUsuario")String direccion,@RequestParam("telefonoUsuario")String telefono) {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("usuario");
        String SQL="insert into autor(nombre,apellido,dirrecion,telefono) values('"+nombre+"',"+"'"+apellido+"',"+"'"+direccion+"',"+"'"+telefono+"');";
        List l;
        this.jdbc.execute(SQL);
//        System.out.println(l.toString());
//        mv.addObject("datos",l);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void modificar(@RequestParam("idUsuario")String id,@RequestParam("nombreUsuario")String nombre,@RequestParam("Apellido")String apellido,@RequestParam("dirreccionUsuario")String direccion,@RequestParam("telefonoUsuario")String telefono) {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("autor");
        String SQL = "update autor set nombre='" + nombre + "',apellido='" + apellido + "',direccion='" + direccion  + "',telefono='" + telefono + "'where id =" + id + ";";
        List l;
        this.jdbc.execute(SQL);
//        System.out.println(l.toString());
//        mv.addObject("datos",l);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ModelAndView eliminar(@RequestParam("idUsuario") String id, ModelMap model) {
        System.out.println("hola :" + id);
        //model.addAttribute("id",id);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("usuario");
        String SQL = "delete from usuario where id =" + id + ";";
        this.jdbc.execute(SQL);
        return null;
    }
}
