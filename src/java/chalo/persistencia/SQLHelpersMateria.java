/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chalo.persistencia;

/**
 *
 * @author Usuario
 */
public class SQLHelpersMateria {
    
 public static String getMateria(){
 
    return"SELECT codigo,  nombre, estado, tama, color, fechai, fechav, medida, preci from tblmateria";
}//fin del metodo
// // Busca dato, por medio del código
    public static String getMateria(String codigo){
 
    return"SELECT codigo,  nombre, estado, tama, color, fechai, fechav, medida, preci"
            + " from tblmateria where codigo='"+codigo+"'";
}//fin del metodo buscar
// Nos vamos para Daos
    //Insertar un dato
 //Insertar datos de la base de datos  
    
    public static String getInsertarMateria () {
 return"INSERT INTO tblmateria(codigo,  nombre, estado, tama, color, fechai, fechav, medida, preci)"
    + "values (?,?,?,?,?,?,?,?,?)";
            
            }//fin insertar
    //Actualiza los datos insertados en la tabla
    public static String getAltualizarMateria (){
    return "UPDATE tblmateria set codigo=?,estado=?,tama=?,color=?,fechai=?,fechav=?,medida=?,preci=?, perfil=?, genero=?  where nombre=?";
    }//fin actualizar
       
    
     public static String getBorrarUsuario (String cod){
    return "delete from tblmateria where materia='"+cod+"'";
    }//fin borrar


    
}

    

