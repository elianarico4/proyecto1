/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chalo.servlet;

import chalo.entidades.Materia;
import chalo.negocio.MateriaN;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USER
 */
public class MateriaServlet extends HttpServlet {
    static Materia lista = new Materia().cargarLista();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String modulo = "FMateria.jsp";
        String pagina = "./FPrincipal.jsp";
        request.setAttribute("targetModulo", modulo);
        String m = "";
        String d = "";
        request.setAttribute("mensajes", null);
        request.setAttribute("datos", null);
        request.setAttribute("actualizar", "");


        String codigo = request.getParameter("txtcodigo");
        String nombre = request.getParameter("txtnombre");
        String estado = request.getParameter("cboestado");
        String tama = request.getParameter("txttama");
        String color = request.getParameter("txtcolor");
        String fechai = request.getParameter("txtingreso");
        String fechav = request.getParameter("txtingresov");
        String medida = request.getParameter("cbomedida");
        String preci = request.getParameter("txtprecio");

        String boton = request.getParameter("action");
        request.setAttribute("Listado", null);
        request.setAttribute("datomateria", null);

        MateriaN un = new MateriaN();
        Materia enti = new Materia();


        if ("nuevo".equals(request.getParameter("action"))) {//la request es la peticion del cliente
            try {
                enti.setCodigo((""));
                enti.setNombre((""));
                enti.setEstado((""));
                enti.setTama((""));
                enti.setColor((""));
                enti.setFechai((""));
                enti.setFechav((""));
                enti.setMedida((""));
                enti.setPreci((""));
              

                request.setAttribute("Listado", null);
                request.setAttribute("datomateria", enti);// Inicializar valores

            } catch (Exception e) {
                m = "" + e.getMessage();
            }
            try {
                request.setAttribute("Listadomateria", null);
            } catch (Exception e) {
                m = "" + e.getMessage();
            }



        }//fin boton mostrar y regresamos a proveedores.jsp


        if ("guardar".equals(request.getParameter("action"))) {
            try {
                Materia mat = new Materia(codigo, nombre, estado, tama, color, fechai, fechav, medida, preci);
                // Validar que no exista el usuario antes de crearlo.
                MateriaServlet.lista.insertarPrincipio(mat);
                un.getInsertarMateria(mat);
                request.setAttribute("Listado", un.Listadomateria());
            } catch (Exception e) {
                m = "" + e.getMessage();
            }

        }//fin boton guardar.

        if ("actualizar".equals(request.getParameter("action"))) {
            try {
                Materia mat  = new Materia(codigo, nombre, estado, tama, color, fechai, fechav, medida, preci);
                System.out.print("Antes--> ");
                MateriaServlet.lista.imprimirLista();
                MateriaServlet.lista.actualizarMateria(mat);
                System.out.print("Despues--> ");
                MateriaServlet.lista.imprimirLista();
                un.getActualizarMateria(mat);
                request.setAttribute("listado", un.Listadomateria());
            } catch (Exception e) {
                m = "" + e.getMessage();
                e.printStackTrace();
            }
        }//fin boton actualizar





        if ("buscar".equals(request.getParameter("action"))) {
            try {
                Materia mat = new Materia();
                mat.setCodigo(codigo);
                System.out.println("buscando>>");
                mat = MateriaServlet.lista.buscarMateria(mat);
                System.out.println("Nombre--> "+mat.getNombre());
                request.setAttribute("datomateria", un.getMateria(codigo));

                request.setAttribute("actualizar", "readonly");
                //regresamos a FUsuario
            } catch (Exception e) {
                m = "" + e.getMessage();
            }
        }//fin boton buscar---- regresamos a FGestion.jsp


        if ("mostrar".equals(request.getParameter("action"))) {
            try {
                request.setAttribute("Listado", un.Listadomateria());
            } catch (Exception e) {
                m = "" + e.getMessage();
            }
        }//fin boton mostrar


        if ("bloquear".equals(request.getParameter("action"))) {
            try {
                m = "Respuesta botón del servlet: " + boton;
                d = "Nombre:" + nombre;
            } catch (Exception e) {
            }
        }//fin boton bloquear

        if ("salir".equals(request.getParameter("action"))) {
            try {
                request.getSession().invalidate();
                request.getRequestDispatcher("./index.jsp").forward(request, response);

            } catch (Exception e) {
            }
        }//fin boton actualizar 





        request.setAttribute("mensajes", m);
        request.setAttribute("datos", d);
        request.getRequestDispatcher(pagina).forward(request, response);

    }//fin metodo processRequest

        
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
