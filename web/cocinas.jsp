<%-- 
    Document   : cocinas
    Created on : 28/07/2014, 09:04:17 PM
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>

<!--Catálogo en la sesión de cocinas, declaración del estilo de la ventana-->

  <link href="css/Estilo.css" rel="stylesheet" type="text/css" />
  <link href="css/productos.css" rel="stylesheet" type="text/css" />


 
</head>

<body>
    <!--Íconos a mostrar en la barra del menú-->
  <div id="main">

	<div id="menubar">
	  <div id="BIENVENIDOS">

	
	  </div>
      <div id="menu_items">
	    <ul id="menu">
       <li><a href="index.jsp">Bievenidos</a></li>
          <li><a href="empresa.jsp">La Empresa</a></li>
          <li><a target="_blank" href="productos.jsp">Productos</a></li>
           <li> <a href="init.jsp" target="_blank" onClick="window.open(this.href, this.target, 'toolbar=no, directories=yes, menubar=no, status=no, resizable=yes,scrollbars=no');
            return false;">Iniciar Sesi&#243;n</a></li>       

          <li><a href="contacto.jsp">Sugerencias</a></li>
          

        </ul>
      </div>
    </div>
  

<!--inserción de imágenes del catálogo de cocina-->
    <div id="site_content">

      <div id="gallery" class="content">
        <div class="slideshow-container">
          
          <div id="slideshow" class="slideshow"></div>
        </div>
      </div>
     
        <div id="thumbs" class="navigation">
       
          <ul class="thumbs noscript">
           
            <li>
              <a class="thumb" href="imagenes/cocinas/35.jpg"><img src="imagenes/cocinas/5.jpg" alt="two" /></a>
              <div class="caption">
            </li>

            <li>
               <a class="thumb" href="imagenes/cocinas/2.jpg"><img src="imagenes/cocinas/6.jpg"  alt="two" /></a>
              <div class="caption">
            </li>

            <li>
              <a class="thumb" href="imagenes/cocinas/s.jpg"><img src="imagenes/cocinas/20.jpg"  alt="two" /></a>
              <div class="caption">
            </li>

            <li>
               <a class="thumb" href="imagenes/cocinas/9.png"><img src="imagenes/cocinas/25.jpg"  alt="two" /></a>
              <div class="caption">
            </li>

            <li>
              <a class="thumb" href="imagenes/cocinas/26.png"><img src="imagenes/cocinas/26.jpg" alt="two" /></a>
              <div class="caption">
            </li>

            <li>
           <a class="thumb" href="imagenes/cocinas/27.png"><img src="imagenes/cocinas/27.jpg"  alt="two" /></a>
              <div class="caption">
            </li>

            <li>
                <a class="thumb" href="imagenes/cocinas/29.png"><img src="imagenes/cocinas/29.jpg"  alt="two" /></a>
              <div class="caption">
            </li>

            <li>
              <a class="thumb" href="imagenes/cocinas/30.png"><img src="imagenes/cocinas/30.jpg"  alt="two" /></a>
              <div class="caption">
            </li>

            <li>
             <a class="thumb" href="imagenes/cocinas/31.png"><img src="imagenes/cocinas/31.jpg"  alt="two" /></a>
              <div class="caption">
            </li>

        <li>
             <a class="thumb" href="imagenes/cocinas/32.png"><img src="imagenes/cocinas/32.jpg" alt="two" /></a>
              <div class="caption">
            </li>

        <li>
             <a class="thumb" href="imagenes/cocinas/33.png"><img src="imagenes/cocinas/33.jpg"  alt="two" /></a>
              <div class="caption">
            </li>

        <li>
             <a class="thumb" href="imagenes/cocinas/34.png"><img src="imagenes/cocinas/34.jpg"  alt="two" /></a>
              <div class="caption">
            </li>

       

        </div>

 
   
    

 <!--implementacion del estilo al catálogo-jquery-->
   
  <script type="text/javascript" src="js/jquery.min.js"></script>
 
  <script type="text/javascript" src="js/jquery.sooperfish.js"></script>

  <script type="text/javascript">
    $(document).ready(function() {
      $('ul.sf-menu').sooperfish();
    });
  </script>
  <!--Invocación jquery para validar diseño de imágenes-->
  <script type="text/javascript" src="js/jquery.galleriffic.js"></script>
  <script type="text/javascript" src="js/jquery.opacityrollover.js"></script>
  <script type="text/javascript">
    jQuery(document).ready(function($) {
      // Sólo queremos estos estilos aplicados cuando avascript está activado
      $('div.navigation').css({'width' : '450px', 'float' : 'left'});
      $('div.content').css('display', 'block');
      // Añadir estilo original
      var onMouseOutOpacity = 0.67;
      $('#thumbs ul.thumbs li').opacityrollover({
        mouseOutOpacity:   onMouseOutOpacity,
        mouseOverOpacity:  1.0,
        fadeSpeed:         'fast',
        exemptionSelector: '.selected'
      });
      // Inicialización avanzada galería galleriffic
      var gallery = $('#thumbs').galleriffic({


        imageContainerSel:         '#slideshow',
        controlsContainerSel:      '#controls',
  



     });
    });
  </script>
</body>
</html>