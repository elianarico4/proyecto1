<%-- 
    Document   : materia
    Created on : 28/07/2014, 09:09:28 PM
    Author     : Usuario
--%>


<%@page import="chalo.entidades.Materia"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%
    
        String codigo = request.getParameter("txtcodigo");
        String nombre = request.getParameter("txtnombre");
        String estado = request.getParameter("cboestado");
        String tama = request.getParameter("txttama");
        String color = request.getParameter("txtcolor");
        String fechai = request.getParameter("txtingreso");
        String fechav = request.getParameter("txtingresov");
        String medida = request.getParameter("cbomedida");
        String preci = request.getParameter("txtprecio");
        
        
       
        
    String men1 = (String) request.getAttribute("mensaje");
    String dat1 = (String) request.getAttribute("datos");
  List<Materia> LP = (List<Materia>) request.getAttribute("Listado")!=null? 
            (List<Materia>) request.getAttribute("Listado"):null;
 Materia mat=(Materia) request.getAttribute("datomateria")!=null?
          (Materia) request.getAttribute("datomateria"):null;
 //los datos estan cargadoes en un usu(objeto) detipo Usuario
 //cargamos los datos en las variables
 if(mat!=null){
     codigo=mat.getCodigo();
     nombre=mat.getNombre();
     tama=mat.getTama();
     color=mat.getColor();
     fechai=mat.getFechai();
     fechav=mat.getFechav();
     medida=mat.getMedida();
     preci=mat.getPreci();

     
     
    
     
}//fin si 
         
 
String ed =(String) request.getAttribute("actualizar")!=null?      
        (String) request.getAttribute("actualizar"):""; 
 
%>  

 <script type="text/javascript" src="js/validar.js"></script>
          <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ebanisteria Chalo</title>
    <link rel="stylesheet" type="text/css" href="css/estil.css"></link>
    <script type="text/javascript" src="js/validar.js"> </script>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.11.1/themes/smoothness/jquery-ui.css">
  <script src="js/jquery-1.10.2.js"></script>
  <script src="js/jquery-ui.js"></script>
  <link rel="stylesheet" href="css/style.css">
  <script>
  $(function() {
    $( "#fechai" ).datepicker();
  });
  
   $(function() {
    $( "#fechav" ).datepicker();
  });
  </script>
    
    
    
    
    
</head>
<div id="materia">
     
 
<form name="xform" id=" " method="POST" action="./MateriaServlet">
<h1><center>Materia Prima</h1></center>

<h1><center>Ebanistería y Carpintería "Chalo"</h1></center>
<table>
<tr>

</tr>
<tr>
<td>C&#243;digo</td>
<td><input type="text" name="txtcodigo" <%=ed%> class="texto" value="<%=codigo!=null?codigo:""%>" placeholder="Ingrese c&#243;digo" onkeypress="return numeros(event); "
id="" size="15" maxlength="10">
</td>



<tr>
</tr>
<tr>
<td>Nombre de la materia</td>
<td><input type="text" name="txtnombre" <%=ed%> class="texto" value="<%=nombre!=null?nombre:""%>" placeholder="Ingrese nombre" 
id="" size="15" maxlength="10">
</td>
  <td>Estado</td>
   <td><select  name="cboestado" class="texto">
   <option value="">Seleccione</option>
     <option value="Activo"<%if("Activo".equals(estado)){%>selected<% }%>>Activo</option>
     <option value="Inactivo"<%if("Inactivo".equals(estado)){%>selected<% }%>>Inactivo</option>

</tr>

<tr>
<td>Tamaño</td>
<td><input type="text" name="txttama"value="<%=codigo!=null?codigo:""%>" placeholder="Ingrese tamaño" onkeypress="return numeros(event); "
id="" size="15" maxlength="10">
</td>


<td>Color</td>
<td><input type="text" name="txtcolor" class="texto" value="<%=codigo!=null?codigo:""%>" placeholder="Ingrese color"
id="" size="15" maxlength="20">
</td>

</tr>

<tr>
<td>Fecha Ingreso</td>
<td><input type="text" name="txtingreso" id ="fechai" value="<%=fechai!=null?fechai:""%>"  placeholder="Ingrese fecha"
id="" size="15" maxlength="10">
</td>

<td>Fecha Vto.</td>
<td><input type="text" name="txtingresov"  id ="fechav"  value="<%=fechav!=null?fechav:""%>"  placeholder="Ingrese fecha" id="" size="15" maxlength="10">
</td>

</tr>


<tr>
<td>Uni. Medida</td>
<td>
    
<select name="cbomedida" class="texto">
<option value="">Seleccione</option>
<option value="Kg" <%if("Kg".equals(medida)){%>selected<% }%> >Kg</option>
<option value="Gl" <%if("Gl".equals(medida)){%>selected<% }%> >Gl</option>
<option value="Lt" <%if("Lt".equals(medida)){%>selected<% }%> >Lt</option>
<option value="Ml" <%if("Ml".equals(medida)){%>selected<% }%> >Ml</option>
<option value="Cms" <%if("Cms".equals(medida)){%>selected<% }%> >Cms</option>
<option value="M3" <%if("M3".equals(medida)){%>selected<% }%> >M3</option>
</select>

<td>Precio</td>
<td><input type="text" name="txtprecio"  id ="fechav"  value="<%=fechav!=null?fechav:""%>"  placeholder="Ingrese fecha" id="" size="15" maxlength="10" onkeypress="return numeros(event); ">
 
</td>

</tr>

</tr>
</table>

<jsp:include page="FBotones.jsp" flush="true"/>
                <p><%=men1!=null? men1:""%></p>
              <%if(LP!= null ){%>
              <table width="100%" height="200" border="1" cellspacing="3" cellpading=5"">
                  <tr>
                       <td>Código</td>       
                       <td>Nombre</td>
                       <td>Tamaño</td>
                       <td>Precio</td>    
                       <td>Estado</td>                   
                      
                  </tr>
                  <!--Recorrer para cargar datos-->
                  <%for(Materia us:LP){%>
                  <tr>
                      
                      <td><%=us.getCodigo()%></td>
                      <td><%=us.getNombre()%></td>
                      <td><%=us.getTama()%></td>
                      <td><%=us.getPreci()%></td>
                      <td><%=us.getEstado()%></td>
                        
                      <td><a href="./MateriaServlet?action=buscar&txtcodigo=<%=us.getCodigo()%>"><img src="imagenes/au.png" border="0" ></a></td>
                  
                             
                      
                      
                  </tr>
                  <%}%>
                  
              </table>
              <%}%>




</form>
