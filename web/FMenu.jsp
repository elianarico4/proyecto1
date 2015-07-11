

<%@page import="chalo.entidades.Usuario"%>
<%
    //Declaración de variables de tipo cadena
    
Usuario entUsuario =(Usuario) session.getAttribute("user");
String identidad =  entUsuario.getIdentidad();
String documento = entUsuario.getDocumento();
String nombre =entUsuario.getNombre();
String apellidos = entUsuario.getApellidos();
String email =   entUsuario.getEmail();
String celular = entUsuario.getCelular();
String direccion = entUsuario.getDireccion();
String clave = entUsuario.getClave();
String telefono =  entUsuario.getTelefono();
String estado = entUsuario.getEstado();
String perfil = entUsuario.getPerfil();
String genero = entUsuario.getGenero();
%>
 

	   <ul id="menu">
              
<!-- Se declaran las opciones del estado: si está activo o inactivo-->
	  
         <% if(!"0".equals(identidad)){%>      
         <li><%=nombre%> |  <%=perfil%></li>
        <% if(!"Inactivo".equals(estado)){%> 
         
<!--Declaración de perifiles: Dependiendo del perfil se muestran diferentes ventanas
ADMINISTRADOR: Se muestran todas las ventanas -->         
         
        <% if("Administrador".equals(perfil)){%>      
        <li><a href="./UsuarioServlet" title="Usuarios">Registro de Usuarios </a>
        </li>
        <li><a href="./MateriaServlet" title="materia">Materia Prima</a> </li>
        <li><a href="./GestionServlet?action=nuevo&txtusuariocreador=<%=identidad%>" title="gestion">Gestión de Tareas</a></li>
        
        
        <%}%>
        
        <!-- EMPLEADO: Solo se le permite ver la ventana de gestión de tareas-->
        
          <% if("Empleado".equals(perfil)){%>      
       <li><a href="./GestionServlet?action=nuevo&txtusuariocreador=<%=identidad%>" title="gestion">Gestión de Tareas</a></li>

     
        <%}%>
        
        <!--Si el usuario no está activo, no permite ver ninguna ventana-->
       
        <%}else{%>
        <tr><td>!Usted no est&#225; activo¡</td></tr>
        <%}%>
        <%}else{%>
        <tr><td>Error al ingresar al sistema..</td></tr>
         <%}%>
         <li> <a href="./UsuarioServlet?action=salir" title="Cerrar sesion">Cerrar Sesi&#243;n</a> </li>
    </ul>    
    
</div>


