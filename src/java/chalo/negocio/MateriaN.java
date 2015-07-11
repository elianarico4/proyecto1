/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chalo.negocio;

import chalo.entidades.Materia;
import chalo.persistencia.Daos;
import chalo.utilidades.Conexion;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author ELIANA RICO
 */
public class MateriaN {
    
    Daos dao;

    public MateriaN() {
        dao = new Daos();
    }// fin constructor

    public List<Materia> Listadomateria() {
        Connection c = new Conexion().getCon();
        return dao.Listadomateria(c);
        //una vez programado pasamos al servlet

    }  //fin lista de datos

    public Materia getMateria(String cod) {
        Connection c = new Conexion().getCon();
        return dao.getMateria(c, cod);
        //una vez programado pasamos al servlet al buscar

    }


    public void getInsertarMateria(Materia mate) throws Exception {
//throws es una clase que permite programar nuestras propias excepciones

        Conexion con = new Conexion();
        String mensajeError = "";
        String codigo = mate.getCodigo();
        String nombre = mate.getNombre();
        String estado = mate.getEstado();
        String tama = mate.getTama();
        String color = mate.getColor();        
        String fechai = mate.getFechai();
        String fechav = mate.getFechav();
        String medida = mate.getMedida();
        String preci = mate.getPreci();


     
if("".equals(codigo) || null==codigo){
mensajeError+="<br>Ingrese el codigo";
}

if("".equals(nombre) || null==nombre){
mensajeError+="<br>Ingrese nombre";
}

if("".equals(estado) || null==estado){
mensajeError+="<br>Ingrese estado";
}

if("".equals(tama) || null==tama){
mensajeError+="<br>Ingrese tamaño";
}

if("".equals(color) || null==color){
mensajeError+="<br>Ingrese color";
}

if("".equals(fechai) || null==fechai){
mensajeError+="<br>Ingrese Fecha Ingreso";
}
if("".equals(fechav) || null==fechav){
mensajeError+="<br>Ingrese Fecha Vto";

}
if("".equals(medida) || null==medida){
mensajeError+="<br>Ingrese la Unidad de Medida";
}
if("".equals(preci) || null==preci){
mensajeError+="<br>Ingrese precio";
}

      
        if (!"".equals(mensajeError)) {
//! se está negando

            throw new Exception(mensajeError);
        }//fin si no hay ningún error
//ejecutamos la acción
        Connection c = new Conexion().getCon();
        if (dao.getVerSiExisteUsuario(c, codigo)) {
            mensajeError = "Ya existe el código :" + codigo;
            throw new Exception(mensajeError);
        }

        

//lanzar una excepción si el email ya existe


        mensajeError = dao.getInsertarMateria(con.getCon(), codigo,  nombre, estado, tama, color,
             fechai, fechav, medida, preci);

//validamos y enviamos una excepción al guardar el dato

        if (!"".equals(mensajeError)) {
            throw new Exception(mensajeError);
        }

    } //fin método,no retorna nada. Regresamos al usario servlet

    public void getActualizarMateria(Materia mate) throws Exception {
//throws es una clase que permite programar nuestras propias excepciones

        Conexion con = new Conexion();
        String mensajeError = "";
        String codigo = mate.getCodigo();
        String nombre = mate.getNombre();
        String estado = mate.getEstado();
        String tama = mate.getTama();
        String color = mate.getColor();        
        String fechai = mate.getFechai();
        String fechav = mate.getFechav();
        String medida = mate.getMedida();
        String preci = mate.getPreci();


        
if("".equals(codigo) || null==codigo){
mensajeError+="<br>Ingrese el codigo";
}

if("".equals(nombre) || null==nombre){
mensajeError+="<br>Ingrese nombre";
}

if("".equals(estado) || null==estado){
mensajeError+="<br>Ingrese estado";
}

if("".equals(tama) || null==tama){
mensajeError+="<br>Ingrese tamaño";
}

if("".equals(color) || null==color){
mensajeError+="<br>Ingrese color";
}

if("".equals(fechai) || null==fechai){
mensajeError+="<br>Ingrese Fecha Ingreso";
}
if("".equals(fechav) || null==fechav){
mensajeError+="<br>Ingrese Fecha Vto";

}
if("".equals(medida) || null==medida){
mensajeError+="<br>Ingrese la Unidad de Medida";
}
if("".equals(preci) || null==preci){
mensajeError+="<br>Ingrese precio";
}

  

        if (!"".equals(mensajeError)) {
//! se está negando

            throw new Exception(mensajeError);
        }//fin si no hay ningún error
//ejecutamos la acción



//verificamos si elusuario existe


        mensajeError = dao.getActualizarMateria(con.getCon(), codigo,  nombre, estado, tama, color,
             fechai, fechav, medida, preci);

//validamos y enviamos una excepción al guardar el dato

        if (!"".equals(mensajeError)) {
            throw new Exception(mensajeError);
        }

//verificamos si elusuario existe




    } //fin método,no retorna nada. Regresamos al usario servlet  
    
}
