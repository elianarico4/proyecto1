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
    
   //String codigo, String medida, String fechai, String fechav,
            //String estado, String descripcion

public static String getMateria()
{
return "SELECT codigo,  nombre, estado, tama, color, fechai, fechav, medida, preci from tblmateria";   
}//fin método  

public static String getMateria(String codigo)
{
return "SELECT codigo,  nombre, estado, tama, color,fechai, fechav, medida, preci from tblmateria where codigo='"+codigo+"'";   
}//fin método buscar un dato
//Nos vamos para---> Daos
// Buscar un dato
//insertar un dato 
public static String getInsertarMateria(){
return "INSERT INTO tblmateria(codigo,  nombre, estado, tama, color, fechai, fechav, medida, preci)"
        +"values(?,?,?,?,?,?,?,?,?)";
}//fin insertar

//Actualizar un dato
public static String getActualizarMateria(){

    return "UPDATE tblmateria codigo=?,nombre=?, estado=?,tama=?, color=?,fechai=?,fechav=?,medida=?,preci=?";
}//fin actualizar 
    //nos vamos para daos
    
}

    

