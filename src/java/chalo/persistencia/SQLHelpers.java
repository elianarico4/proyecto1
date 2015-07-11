/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chalo.persistencia;

/**
 *
 * @author USER
 */
public class SQLHelpers {
    
//Selecciona los datos insertados en la base de datos y los implementa    
public static String getUsuarios(){
 
    return"SELECT identidad, documento, nombre, apellidos, email, celular,  direccion, clave, telefono, estado, perfil, genero from tblusuario";

}//fin del método


// Busca dato, por medio de la identidad
    public static String getUsuarios(String identidad){
 
    return"SELECT identidad, documento, nombre, apellidos, email, celular,  direccion, clave, telefono, estado, perfil, genero"
            + " from tblusuario where identidad='"+identidad+"'";
}//fin del metodo buscar
// Nos vamos para Daos
    //Insertar un dato
   
//Busca correo electrónico en la base de datos para reanudar clave    
     public static String getEmailUsuarios(String email){
 
    return"SELECT identidad, documento, nombre, apellidos, email, celular,  direccion, clave, telefono, estado, perfil, genero"
            + " from tblusuario where email='"+email+"'";
}//fin del metodo email
    
//Insertar datos de la base de datos     
    public static String getInsertarUsuario () {
 return"INSERT INTO tblusuario(identidad, documento, nombre, apellidos, email, celular,  direccion, clave, telefono, estado, perfil, genero)"
    + "values (?,?,?,?,?,?,?,?,?,?,?,?)";
            
 }//fin insertar
    
    //Actualiza los datos insertados en la tabla
    public static String getAltualizarUsuario (){
    return "UPDATE tblusuario set identidad=?, documento=?,apellidos=?,email=?,celular=?,direccion=?,clave=?,telefono=?,estado=?, perfil=?, genero=?  where nombre=?";
    }//fin actualizar
    
    //Selecciona los datos de la base de datos y recoge la identidad y clave
    //para el ingreso al sistema.
    
    public static String getValidarIngreso(String identidad, String clave)    {
return "SELECT identidad,documento,nombre,apellidos "
        + ",email,celular,direccion,clave,telefono,estado,perfil,genero from tblusuario"
        + "  where identidad ='"+identidad+"' and clave ='"+clave+"'";  
}
   
    
     public static String getBorrarUsuario (String ide){
    return "delete from tblusuario where usuario='"+ide+"'";
    }//fin borrar       
     
}//fin de la clase
 

    
