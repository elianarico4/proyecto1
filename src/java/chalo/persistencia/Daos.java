/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chalo.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import chalo.entidades.Usuario;

import chalo.entidades.Gestion;
import chalo.entidades.Materia;



/**
 *
 * @author Usuario
 */


public class Daos {
    //Creación lista Usuarios
public List<Usuario>ListadoUsuarios (Connection con) {
  
//Inicio conexión Usuario
 List<Usuario> resultado = new  ArrayList<Usuario>(); 
 try{
 PreparedStatement p=  con.prepareStatement(SQLHelpers.getUsuarios());
ResultSet r=p.executeQuery();
 while(r.next()){
  Usuario u= new Usuario();
    u.setIdentidad(r.getString(1));
    u.setDocumento(r.getString(2));
    u.setNombre(r.getString(3));
    u.setApellidos(r.getString(4));
    u.setEmail(r.getString(5));
    u.setCelular(r.getString(6));
    u.setDireccion(r.getString(7));
    u.setClave(r.getString(8));
    u.setTelefono(r.getString(9));
    u.setEstado(r.getString(10));
    u.setPerfil(r.getString(11));
    u.setGenero(r.getString(12));
    
    resultado.add(u);
    
 
 
}//fin mientras

 }//fin Try
 
 //Captura de errores
 catch(Exception e1){}
 finally{
try{con.close();}//fin control cerrar conexion     
 catch(Exception clo){}
 
 }//fin finally
 
 
 return resultado;  
   }//fin métodos 
    
//Se establece conexión
public Usuario getUsuario(Connection con,String ide) {    
    
Usuario u =new Usuario();
 try{
 PreparedStatement p= con.prepareStatement(SQLHelpers.getUsuarios(ide));
ResultSet r=p.executeQuery();
 while(r.next()){
    
    u.setIdentidad(r.getString(1));
    u.setDocumento(r.getString(2));
    u.setNombre(r.getString(3));
    u.setApellidos(r.getString(4));
    u.setEmail(r.getString(5));
    u.setCelular(r.getString(6));
    u.setDireccion(r.getString(7));
    u.setClave(r.getString(8));
    u.setTelefono(r.getString(9));
    u.setEstado(r.getString(10));
    u.setPerfil(r.getString(11));
    u.setGenero(r.getString(12));
}//fin mientras
}//fin Try
 catch(Exception e1){}
 finally{}
     try{con.close();}
     catch(Exception clo){}
 
    
     return u;
    }//fin finally

//Valida la recuperación de clave al correo electrónico

public Usuario getUsuarioEmail(Connection con,String email) {
        
    
Usuario u =new Usuario();
u.setIdentidad("0");
 try{
 PreparedStatement p= con.prepareStatement(SQLHelpers.getEmailUsuarios(email));
ResultSet r=p.executeQuery();
 while(r.next()){
    
    u.setIdentidad(r.getString(1));
    u.setDocumento(r.getString(2));
    u.setNombre(r.getString(3));
    u.setApellidos(r.getString(4));
    u.setEmail(r.getString(5));
    u.setCelular(r.getString(6));
    u.setDireccion(r.getString(7));
    u.setClave(r.getString(8));
    u.setTelefono(r.getString(9));
    u.setEstado(r.getString(10));
    u.setPerfil(r.getString(11));
    u.setGenero(r.getString(12));
}//fin mientras
}//fin Try
 catch(Exception e1){}
 finally{}
     try{con.close();}
     catch(Exception clo){}
 
    
     return u;
    }//fin finally

//Insertar Usuario de tipo cadena y lo guarda
public String getInsertarUsuario(
        Connection con,
       String identidad,
        String documento,
        String nombre,
        String apellidos,
        String email,
        String celular,
        String direccion,
        String clave,
        String telefono,
        String estado,
        String perfil,
        String genero
        ){
String respuesta="";
try{
PreparedStatement p= con.prepareStatement(SQLHelpers.getInsertarUsuario());
//(?,?,?,?,?)
p.setString(1, identidad);
p.setString(2, documento);
p.setString(3, nombre);
p.setString(4, apellidos);
p.setString(5, email);
p.setString(6, celular);
p.setString(7, direccion);
p.setString(8, clave);
p.setString(9, telefono);
p.setString(10, estado);
p.setString(11, perfil);
p.setString(12, genero);
//Luego ejecutamos la acciom
p.execute();//Este metdodo no retorna filas
// a diferencia del metodo executeQuery()
if(p.getUpdateCount()>0){
respuesta="Usuario agregado";
}else{
respuesta="Error..!Usuario no agregado";
}//fin si 
}catch(Exception e){
respuesta+=":"+ e.getMessage() + "Causa :"+e.getCause();
}finally{try{con.close();}catch(Exception e1){}}//fin finally
//con. close(); permite cerrar la conexion a la 
return respuesta;

}//Fin metodo regresamos a la capa de negocio
//usuarioN

//Permite actualizar un Usuario

public String getActualizarUsuario(
        Connection con,
        String identidad,
        String documento,
        String nombre,
        String apellidos,
        String email,
        String celular,
        String direccion,
        String clave,
        String telefono,
        String estado,
        String perfil,
        String genero
        ){
String respuesta="";
try{

PreparedStatement p= con.prepareStatement(SQLHelpers.getAltualizarUsuario());
//(?,?,?,?,?,?,?,?,?,?,?,?)
p.setString(1, identidad);
p.setString(2, documento);
p.setString(12, nombre);
p.setString(3, apellidos);
p.setString(4, email);
p.setString(5, celular);
p.setString(6, direccion);
p.setString(7, clave);
p.setString(8, telefono);
p.setString(9,estado);
p.setString(10,perfil);
p.setString(11,genero);
//Luego ejecutamos la acciom
p.execute();//Este metdodo no retorna filas
// a diferencia del metodo executeQuery()
if(p.getUpdateCount()>0){//SE AFECTÓ AL MENOS UN REGISTRO
respuesta="Usuario actualizado";
}else{
respuesta="Error..Usuario no actualizado";
}//fin si 
}catch(Exception e){
respuesta+=":"+ e.getMessage() + "Causa :"+e.getCause();
}finally{try{con.close();}catch(Exception e1){}}//fin finally
//con. close(); permite cerrar la conexion a la base de datos
return respuesta;

}


//Valida el ingreso al sistema con el documento de identidad y clave

public Usuario getValidarIngreso(Connection con,String identidad,String clave ){
Usuario u = new Usuario();
u.setIdentidad("0");
try{
//usuario,nombre,clave "
//        + ",perfil,estado    
PreparedStatement p= 
  con.prepareStatement(SQLHelpers.getValidarIngreso(identidad,clave));
ResultSet r=p.executeQuery();
while(r.next()){
    u.setIdentidad(r.getString(1));
    u.setDocumento(r.getString(2));
    u.setNombre(r.getString(3));
    u.setApellidos(r.getString(4));
    u.setEmail(r.getString(5));
    u.setCelular(r.getString(6));
    u.setDireccion(r.getString(7));
    u.setClave(r.getString(8));
    u.setTelefono(r.getString(9));
    u.setEstado(r.getString(10));
    u.setPerfil(r.getString(11));
    u.setGenero(r.getString(12));

}// fin mientras 
}// fin try
catch(Exception e1){}
finally{
try{con.close();}// fin control cerrar conexion    
catch(Exception clo){}

}// fin finally

 return u;   
}// fin métodos

//Verficia si existe el Usuario buscado
public boolean getVerSiExisteUsuario(Connection con,String ide) {
        
    
boolean u = false;
 try{
 PreparedStatement p= con.prepareStatement(SQLHelpers.getUsuarios(ide));
ResultSet r=p.executeQuery();
 while(r.next()){
 u=true;   
    
}//fin mientras
}//fin Try
 catch(Exception e1){}
 finally{}
 try{con.close();}
 catch(Exception clo){}
 
    
return u;
}//fin existe usuario

//Verifica si existe el correo electrónico al cual se va a enviar la recuperación de la clave

public boolean getVerSiExisteEmail(Connection con,String email) {
        
    
boolean u = false;
 try{
 PreparedStatement p= con.prepareStatement(SQLHelpers.getEmailUsuarios(email));
ResultSet r=p.executeQuery();
 while(r.next()){
 u=true;   
    
}//fin mientras
}//fin Try
 catch(Exception e1){}
 finally{}
 try{con.close();}
 catch(Exception clo){}
 
    
return u;
}//fin si existe email


public List<Materia>Listadomateria (Connection con) {
    
 List<Materia> resultado = new  ArrayList<Materia>(); 
 try{
 PreparedStatement p=  con.prepareStatement(SQLHelpersMateria.getMateria());
ResultSet r=p.executeQuery();
 while(r.next()){
  Materia u= new Materia();
     u.setCodigo(r.getString(1));
     u.setNombre(r.getString(2));
     u.setEstado(r.getString(3));
     u.setTama(r.getString(4));
     u.setColor(r.getString(5));
     u.setFechai(r.getString(6));
     u.setFechav(r.getString(7));
     u.setMedida(r.getString(8));
     u.setPreci(r.getString(9));
    
    resultado.add(u);
    
 
 
}//fin mientras

 }//fin Try
 catch(Exception e1){}
 finally{
try{con.close();}//fin control cerrar conexión     
 catch(Exception clo){}
 
 }//fin finally
 
 
 return resultado;  
   }//fin métodos 
    
public Materia getMateria(Connection con,String cod) {
        
    
Materia u =new Materia();
 try{
 PreparedStatement p= con.prepareStatement(SQLHelpersMateria.getMateria(cod));
ResultSet r=p.executeQuery();
 while(r.next()){
    
     u.setCodigo(r.getString(1));
     u.setNombre(r.getString(2));
     u.setEstado(r.getString(3));
     u.setTama(r.getString(4));
     u.setColor(r.getString(5));
     u.setFechai(r.getString(6));
     u.setFechav(r.getString(7));
     u.setMedida(r.getString(8));
     u.setPreci(r.getString(9));
}//fin mientras
}//fin Try
 catch(Exception e1){}
 finally{}
     try{con.close();}
     catch(Exception clo){}
 
    
     return u;
    }//fin finally


public String getInsertarMateria(
        Connection con,
                String codigo,
                String nombre,
                String estado,
                String tama,
                String color,
                String fechai,
                String fechav,
                String medida,
                String preci
        ){
String respuesta="";
try{
PreparedStatement p= con.prepareStatement(SQLHelpersMateria.getInsertarMateria());
//(?,?,?,?,?)
p.setString(1, codigo);
p.setString(2, nombre);
p.setString(3, estado);
p.setString(4, tama);
p.setString(5, color);
p.setString(6, fechai);
p.setString(7, fechav);
p.setString(8, medida);
p.setString(9, preci);
//Luego ejecutamos la acciom
p.execute();//Este metdodo no retorna filas
// a diferencia del metodo executeQuery()
if(p.getUpdateCount()>0){
respuesta="Materia agregada";
}else{
respuesta="Error..Materia no agregada";
}//fin si 
}catch(Exception e){
respuesta+=":"+ e.getMessage() + "Causa :"+e.getCause();
}finally{try{con.close();}catch(Exception e1){}}//fin finally
//con. close(); permite cerrar la conexion a la 
return respuesta;

}//Fin metodo regresamos a la capa de negocio
//usuarioN

public String getActualizarMateria(
        Connection con,
                String codigo,
                String nombre,
                String estado,
                String tama,
                String color,
                String fechai,
                String fechav,
                String medida,
                String preci
        ){
String respuesta="";
try{
//"UPDATE tblusuario set identidad=1, documento=2,apellidos=3,email=4,celular=5,
    //direccion=6,clave=7,telefono=8,estado=9, perfil=10, genero=11  where nombre=12"

PreparedStatement p= con.prepareStatement(SQLHelpersMateria.getAltualizarMateria());
//(?,?,?,?,?,?,?,?,?,?,?,?)
p.setString(1, codigo);
p.setString(2, nombre);
p.setString(3, estado);
p.setString(4, tama);
p.setString(5, color);
p.setString(6, fechai);
p.setString(7, fechav);
p.setString(8, medida);
p.setString(9, preci);
//Luego ejecutamos la acciom
p.execute();//Este metdodo no retorna filas
// a diferencia del metodo executeQuery()
if(p.getUpdateCount()>0){//SE AFECTÓ AL MENOS UN REGISTRO
respuesta="Materia actualizada";
}else{
respuesta="Error..Materia no actualizada";
}//fin si 
}catch(Exception e){
respuesta+=":"+ e.getMessage() + "Causa :"+e.getCause();
}finally{try{con.close();}catch(Exception e1){}}//fin finally
//con. close(); permite cerrar la conexion a la base de datos
return respuesta;

}

public boolean getVerSiExisteMateria(Connection con,String cod) {
        
    
boolean u = false;
 try{
 PreparedStatement p= con.prepareStatement(SQLHelpersMateria.getMateria(cod));
ResultSet r=p.executeQuery();
 while(r.next()){
 u=true;   
    
}//fin mientras
}//fin Try
 catch(Exception e1){}
 finally{}
 try{con.close();}
 catch(Exception clo){}
 
    
return u;
}//fin existe usuario



public List<Gestion>Listadogestion(Connection con) {

 List<Gestion> resultado = new  ArrayList<Gestion>(); 
 try{
 PreparedStatement p=  con.prepareStatement(SQLHelpersGestion.getGestion());
ResultSet r=p.executeQuery();
 while(r.next()){
     
     //consecutivo,idempleado, codmueble,idtarea,cantidad,fecha_sistema,
  //hora_Inicial ,hora_final , cant_terminadas , cant_pendientes ,usuariocreador 
    //,  estado ,  total_horas
     
 Gestion u= new Gestion();
 u.setConsecutivo(r.getString(1));
 u.setIdempleado(r.getString(2));
 u.setCodmueble(r.getString(3));
 u.setIdtarea(r.getString(4));
 u.setCantidad(r.getString(5));
 u.setFecha_sistema(r.getString(6));
 u.setHora_Inicial(r.getString(7));
 u.setHora_final(r.getString(8));
 u.setCant_terminadas(r.getString(9));
 u.setCant_pendientes(r.getString(10));
 u.setUsuariocreador(r.getString(11));
 u.setEstado(r.getString(12));
 u.setTotal_horas(r.getString(13));
 u.setNombre_empleado(r.getString(14));
  u.setNombre_mueble(r.getString(15));
  u.setNombre_tarea(r.getString(16));

 
 resultado.add(u);
 
 
}//fin mientras

 }//fin Try
 catch(Exception e1){
 e1.printStackTrace();
 
 }
 finally{
try{con.close();}//fin control cerrar conexion     
 catch(Exception clo){}
 
 }//fin finally
 
 
 return resultado;  
}//fin métodos 

public Gestion getGestion(Connection con,String idp) {
        
    
Gestion u =new Gestion();
 try{
 PreparedStatement p= con.prepareStatement(SQLHelpersGestion.getGestion(idp));
ResultSet r=p.executeQuery();
 while(r.next()){
 u.setConsecutivo(r.getString(1));
 u.setIdempleado(r.getString(2));
 u.setCodmueble(r.getString(3));
 u.setIdtarea(r.getString(4));
 u.setCantidad(r.getString(5));
 u.setFecha_sistema(r.getString(6));
 u.setHora_Inicial(r.getString(7));
 u.setHora_final(r.getString(8));
 u.setCant_terminadas(r.getString(9));
 u.setCant_pendientes(r.getString(10));
 u.setUsuariocreador(r.getString(11));
 u.setEstado(r.getString(12));
 u.setTotal_horas(r.getString(13));
 //u.NOMBRE, m.DESCRIPCION, t.DESCRIPCION
 u.setNombre_empleado(r.getString(14));
  u.setNombre_mueble(r.getString(15));
  u.setNombre_tarea(r.getString(16));


}//fin mientras
}//fin Try
 catch(Exception e1){}
 finally{}
     try{con.close();}
     catch(Exception clo){}
 
    
     return u;
    }//fin finally

  //consecutivo,idempleado, codmueble,idtarea,cantidad,fecha_sistema,
  //hora_Inicial ,hora_final , cant_terminadas , cant_pendientes ,usuariocreador 
    //,  estado ,  total_horas

public String getInsertarGestion(
        Connection con,
        String consecutivo,
        String idempleado,
        String codmueble,
        String idtarea,
        String cantidad,
        String fecha_sistema,
        String hora_Inicial,
        String hora_final,
        String cant_terminadas,
        String cant_pendientes,
        String usuariocreador,
        String estado,
        String total_horas)
{
String respuesta="";
try{
PreparedStatement p= con.prepareStatement(SQLHelpersGestion.getInsertarGestion());
//(?,?,?,?,?,?,?,?,?)
p.setString(1, consecutivo);
p.setString(2, idempleado);
p.setString(3, codmueble);
p.setString(4, idtarea);
p.setString(5, cantidad);
p.setString(6, fecha_sistema);
p.setString(7, hora_Inicial);
p.setString(8, hora_final);
p.setString(9, cant_terminadas);
p.setString(10, cant_pendientes);
p.setString(11, usuariocreador);
p.setString(12, estado);
p.setString(13, total_horas);


//Luego ejecutamos la acciom
p.execute();//Este metdodo no retorna filas
// a diferencia del metodo executeQuery()
if(p.getUpdateCount()>0){
respuesta="Tarea agregado";
}else{
respuesta="Error..!Tarea no agregado";
}//fin si 
}catch(Exception e){
respuesta+=":"+ e.getMessage() + "Causa :"+e.getCause();
}finally{try{con.close();}catch(Exception e1){}}//fin finally
//con. close(); permite cerrar la conexion a la 
return respuesta;
}//Fin metodo regresamos a la capa de negocio}

public String getActualizarGestion(
        Connection con,
        String consecutivo,
        String idempleado,
        String codmueble,
        String idtarea,
        String cantidad,
        String fecha_sistema,
        String hora_Inicial,
        String hora_final,
        String cant_terminadas,
        String cant_pendientes,
        String usuariocreador,
        String estado,
        String total_horas)
{
String respuesta="";
try{
PreparedStatement p= con.prepareStatement(SQLHelpersGestion.getActualizarGestion());
//(?,?,?,?,?,?,?,?,?)
p.setString(1, consecutivo);
p.setString(2, idempleado);
p.setString(3, codmueble);
p.setString(4, idtarea);
p.setString(5, cantidad);
p.setString(6, fecha_sistema);
p.setString(7, hora_Inicial);
p.setString(8, hora_final);
p.setString(9, cant_terminadas);
p.setString(10, cant_pendientes);
p.setString(11, usuariocreador);
p.setString(12, estado);
p.setString(13, total_horas);



//Luego ejecutamos la acciom
p.execute();//Este metdodo no retorna filas
// a diferencia del metodo executeQuery()
if(p.getUpdateCount()>0){
respuesta="Tarea Actualizada";
}else{
respuesta="Error..!Tarea no Actualizada";
}//fin si 
}catch(Exception e){
respuesta+=":"+ e.getMessage() + "Causa :"+e.getCause();
}finally{try{con.close();}catch(Exception e1){}}//fin finally
//con. close(); permite cerrar la conexion a la 
return respuesta;
}//Fin metodo regresamos a la capa de negocio}

public String getConsecutivoGestion(Connection con) {
        
    
String u = "0000000001";
 try{
 PreparedStatement p= con.prepareStatement(SQLHelpersGestion.getConsecutivoGestion());
ResultSet r=p.executeQuery();
 while(r.next()){
u=r.getString(1);   
    
}//fin mientras
}//fin Try
 catch(Exception e1){}
 finally{}
 try{con.close();}
 catch(Exception clo){}
 
    
return u;
}//fin existe usuario

}// fin métodos 



