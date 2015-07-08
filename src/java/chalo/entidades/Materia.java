/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chalo.entidades;

/**
 *
 * @author Usuario
 */
public class Materia {
    
String codigo;
String nombre;
String estado;
String tama;
String color;
String fechai;
String fechav;
String medida;
String preci;



public Materia (){}

    public Materia(String codigo, String nombre, String estado, String tama,  String color,
            String fechai, String fechav, String medida, String preci) {
        
        this.codigo = codigo;
        this.nombre = nombre;
        this.estado = estado;
        this.tama = tama;
        this.color = color;
        this.fechai = fechai;
        this.fechav = fechav;
        this.medida = medida;
        this.preci = preci;
        
        
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public String getTama() {
        return tama;
    }

    public void setTama(String tama) {
        this.tama = tama;
    }
    
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFechai() {
        return fechai;
    }

    public void setFechai(String fechai) {
        this.fechai = fechai;
    }

    public String getFechav() {
        return fechav;
    }

    public void setFechav(String fechav) {
        this.fechav = fechav;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public String getPreci() {
        return preci;
    }

    public void setPreci(String preci) {
        this.preci = preci;
    }
    
   

    
    
}
