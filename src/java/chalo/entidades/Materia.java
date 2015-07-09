/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chalo.entidades;

import chalo.negocio.MateriaN;
import java.util.List;

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
Materia siguiente;
static Materia cab = null;
static Materia cola = null;
 Materia aux;

     public Materia() {
    }

    public Materia(Materia siguiente) {
        this.cab = siguiente;
        this.siguiente = siguiente;
    }




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
    
   

    public Materia getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Materia siguiente) {
        this.siguiente = siguiente;
    }

    public Materia getCab() {
        return cab;
    }

    public void setCab(Materia cab) {
        this.cab = cab;
    }

    public Materia getCola() {
        return cola;
    }

    public void setCola(Materia cola) {
        this.cola = cola;
    }

    public Materia getAux() {
        return aux;
    }

    public void setAux(Materia aux) {
        this.aux = aux;
    }

    
     public String insertarPrincipio(Materia nuevo) {
        if (nuevo == null) {
            return "Nuevo registro nulo";
        } else {
            if (cab == null) {
                cab = nuevo;
                cola = nuevo;
            } else {
                aux = cab;
                cab = nuevo;
                cab.setSiguiente(aux);
            }
            return "Guardado principio con éxito";
        }
    }

    public String insertarFinal(Materia nuevo) {
        if (nuevo == null) {
            return "Nuevo registro nulo";
        } else {
            if (cola == null) {
                cola = nuevo;
                cab = nuevo;
            } else {
                cola.setSiguiente(nuevo);
                cola = nuevo;
            }

            return "Guardado final con exito";
        }
    }

    public Materia buscarMateria(Materia buscar) {
        if (buscar == null || cab == null) {
            return null;
        }
        Materia p = cab;
        while (p != null && !p.getCodigo().equals(buscar.getCodigo())) {
            p = p.getSiguiente();
        }
        return p;
    }

    /**
     * Metodo que permite actualizar la lista de usuario
     *
     * @param actualizar
     * @return String
     */
    public String actualizarMateria(Materia actualizar) {

        if (cab != null) {
            if (actualizar == null) {
                return "Actualizar registro nulo";
            } else {
                Materia buscar = buscarMateria(actualizar);
                if (buscar == null) {
                    return "Actualizar registro nulo";
                } else {
                    Materia p = cab;
                    if (buscar == cab) {
                        actualizar.setSiguiente(cab.getSiguiente());
                        cab = actualizar;
                    } else {
                        while (p != null && !p.getCodigo().equals(actualizar.getCodigo())) {
                            aux = p;
                            p = p.getSiguiente();
                        }
                        if (p != null) {
                            aux.setSiguiente(actualizar);
                            actualizar.setSiguiente(p.getSiguiente());

                        }
                    }
                }

                return "Actualizar con exito";
            }
        }
        return "No existe lista.";
    }

    /**
     *
     * @param actualizar
     * @return
     */
    public String eliminarMateria(Materia eliminar) {

        if (cab != null) {
            if (eliminar == null) {
                return "Eliminar registro nulo";
            } else {
                Materia buscar = buscarMateria(eliminar);
                if (buscar == null) {
                    return "Eliminar registro nulo";
                } else {
                    if (buscar == cab) {
                        cab = cab.getSiguiente();
                    } else {
                       Materia p = cab;
                        while (p != null && !p.getCodigo().equals(eliminar.getCodigo())) {
                            aux = p;
                            p = p.getSiguiente();
                        }
                        if (p != null) {
                            aux.setSiguiente(p.getSiguiente());

                        }
                    }
                }
                buscar.setNombre(nombre);
                return "Eliminar con exito";
            }
        }
        return "No existe lista.";
    }

    public void imprimirLista() {
        if (cab != null) {
            aux = cab;
            while (aux != null) {
                System.out.println(" Nombre:" + aux.getNombre() + "-->");
                aux = aux.getSiguiente();
            }
        }
    }
    
    public Materia cargarLista(){
        List<Materia> lista = new MateriaN().Listadomateria();
        if(lista != null){
            for (Materia materia : lista) {
                insertarFinal(materia);
            }
        }
        imprimirLista();
        return this.cab;
    }
}


