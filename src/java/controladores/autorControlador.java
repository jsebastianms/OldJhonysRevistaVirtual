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

/**
 *
 * @author camilo
 */
@Controller
@RequestMapping("autor.htm")
public class autorControlador {

    private JdbcTemplate jdbc;

    public autorControlador() {
        conexion con = new conexion();
        this.jdbc = new JdbcTemplate(con.conectar());
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView autor() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("autor");
        String SQL = "select * from autor;";
        List l;
        l = this.jdbc.queryForList(SQL);
//        System.out.println(l.toString());
        mv.addObject("datos", l);
        return mv;
    }
   //  @RequestMapping(method = RequestMethod.POST)
//    public void añadir(@RequestParam("nombreAutor")String nombre,@RequestParam("tipoAutor")String tipo) {
//
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("autor");
//        String SQL="insert into autor(nombre,tipo) values('"+nombre+"',"+"'"+tipo+"');";
//        List l;
//        this.jdbc.execute(SQL);
////        System.out.println(l.toString());
////        mv.addObject("datos",l);
//    }

    @RequestMapping(method = RequestMethod.POST)
    public void modificar(@RequestParam("idAutor") String id, @RequestParam("nombreAutor") String nombre, @RequestParam("tipoAutor") String tipo) {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("autor");
        String SQL = "update autor set nombre='" + nombre + "',tipo='" + tipo + "'where id =" + id + ";";
        List l;
        this.jdbc.execute(SQL);
//        System.out.println(l.toString());
//        mv.addObject("datos",l);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ModelAndView eliminar(@RequestParam("idAutor") String id, ModelMap model) {
        System.out.println("hola :" + id);
        //model.addAttribute("id",id);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("autor");
        String SQL = "delete from autor where id =" + id + ";";
        this.jdbc.execute(SQL);
        return null;
    }
}
