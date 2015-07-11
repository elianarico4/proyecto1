/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chalo.utilidades;

/**
 *
 * @author usuario
 */
import chalo.persistencia.SQLHelpers;

import chalo.persistencia.SQLHelpersMateria;
import chalo.persistencia.SQLHelpersGestion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *@serial 000-8999
 * @author Sani
 * @since 29-05-2014
 */
public class Conexion {
    Connection Con;
    public Conexion(){}//Constructor de la clase
    static{
    try{
    Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();//crear una instancia o una copia o un  objeto de la clase oracle Driver 
    }
    catch(ClassNotFoundException e1){
    System.out.println("ClassNotFoundException"+e1.getMessage());
            }
    catch(InstantiationException e2){
    System.out.println("InstantiationException"+e2.getMessage());//controlar las excepciones de la inicializacion
        }
    catch(IllegalAccessException e3){
    System.out.println("IllegalAccessException"+e3.getMessage());//Controla  los errores cuando se accece a la clase de forma no permitida
       }
    catch(Exception e){
    System.out.println("Exception"+e.getMessage());}//errores generales
    
    }//fin static
    public Connection getCon() {//devuelve un objeto
        ConexionDB();
                
        return Con;
    }

    public void setCon(Connection Con) {//establece y recibe como parametro un objeto
        this.Con = Con;
    }
    public void cerrar() throws SQLException{
    
    this.Con.close();
    }
    public void ConexionDB(){//Metodo vacio sin parámetros
    String host="localhost";
    String puerto="1521";//puerto por el cual va a salir la información
    String SID="xe";
    String user="prueba";//Usuario base de datos
    String password="123";//clave base de datos
    
    //Captura de errores
    try{
DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
setCon(DriverManager.getConnection("jdbc:oracle:thin:@"+host+":"+puerto+":"+SID, user, password));


}
    catch(SQLException e4){
    System.out.println("SQLException"+e4.getMessage());
            
    }
    catch (Exception e){
    System.out.println("Exception"+e.getMessage());
    }
            
    }      
    
    
    
    
     
    }//fin conexion
    
