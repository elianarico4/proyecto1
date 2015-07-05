/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chalo.entidades;

/**
 *
 * @author Usuario
 */
public class Usuario {

    String identidad;
    String documento;
    String nombre;
    String apellidos;
    String email;
    String celular;
    String direccion;
    String clave;
    String telefono;
    String estado;
    String perfil;
    String genero;
    Usuario siguiente;
    static Usuario cab = null;
    static Usuario cola = null;
    Usuario aux;

    public Usuario() {
    }

    public Usuario(Usuario siguiente) {
        this.cab = siguiente;
        this.siguiente = siguiente;
    }

    public Usuario(String identidad, String documento, String nombre, String apellidos, String email, String celular, String direccion, String clave, String telefono, String estado, String perfil, String genero) {
        this.identidad = identidad;
        this.documento = documento;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.celular = celular;
        this.direccion = direccion;
        this.clave = clave;
        this.telefono = telefono;
        this.estado = estado;
        this.perfil = perfil;
        this.genero = genero;
    }

    public String getIdentidad() {
        return identidad;
    }

    public void setIdentidad(String identidad) {
        this.identidad = identidad;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Usuario getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Usuario siguiente) {
        this.siguiente = siguiente;
    }

    public Usuario getCab() {
        return cab;
    }

    public void setCab(Usuario cab) {
        this.cab = cab;
    }

    public Usuario getCola() {
        return cola;
    }

    public void setCola(Usuario cola) {
        this.cola = cola;
    }

    public Usuario getAux() {
        return aux;
    }

    public void setAux(Usuario aux) {
        this.aux = aux;
    }

    //Metodos de listas
    public String insertarPrincipio(Usuario nuevo) {
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

    public String insertarFinal(Usuario nuevo) {
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

    public Usuario buscarUsuario(Usuario buscar) {
        if (buscar == null) {
            return null;
        }
        Usuario p = cab;
        while (p != null && !p.getIdentidad().equals(buscar.getIdentidad())) {
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
    public String actualizarUsuario(Usuario actualizar) {

        if (cab != null) {
            if (actualizar == null) {
                return "Actualizar registro nulo";
            } else {
                Usuario buscar = buscarUsuario(actualizar);
                if (buscar == null) {
                    return "Actualizar registro nulo";
                } else {
                    Usuario p = cab;
                    while (p != null && !p.getIdentidad().equals(actualizar.getIdentidad())) {
                        aux = p;
                        p = p.getSiguiente();
                    }
                    if (p != null) {
                        aux.setSiguiente(actualizar);
                        actualizar.setSiguiente(p.getSiguiente());
                        
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
    public String eliminarUsuario(Usuario eliminar) {

        if (cab != null) {
            if (eliminar == null) {
                return "Eliminar registro nulo";
            } else {
                Usuario buscar = buscarUsuario(eliminar);
                if (buscar == null) {
                    return "Eliminar registro nulo";
                } else {
                    Usuario p = cab;
                    while (p != null && !p.getIdentidad().equals(eliminar.getIdentidad())) {
                        aux = p;
                        p = p.getSiguiente();
                    }
                    if (p != null) {
                        aux.setSiguiente(p.getSiguiente());
                        
                    }
                }
                buscar.setApellidos(apellidos);
                return "Eliminar con exito";
            }
        }
        return "No existe lista.";
    }
    
    public void imprimirLista(){
        if(cab!=null){
            aux = cab;
            while(aux != null){
                System.out.print(" Identificacion:"+aux.getIdentidad()+"-->");
                aux = aux.getSiguiente();
            }
        }
    }
}