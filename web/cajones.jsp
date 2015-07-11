<%-- 
    Document   : cajones
    Created on : 28/07/2014, 09:05:51 PM
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>

<!--Catálogo en la sesión de cajones
, declaración del estilo de la ventana-->

  <link href="css/Estilo.css" rel="stylesheet" type="text/css" />
  <link href="css/productos.css" rel="stylesheet" type="text/css" />


 
</head>

<body>
  <div id="main">
<!--insertar en la interfaz principal-->
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
  <!--inserción de imágenes del catálogo de cajones-->


    <div id="site_content">

      <div id="gallery" class="content">
        <div class="slideshow-container">
          
          <div id="slideshow" class="slideshow"></div>
        </div>
      </div>
     
        <div id="thumbs" class="navigation">
       
          <ul class="thumbs noscript">
           
            <li>
              <a class="thumb" href="imagenes/cajones/1.jpg"><img src="imagenes/cajones/2.jpg" alt="two" /></a>
              <div class="caption">
            </li>


            <li>
              <a class="thumb" href="imagenes/cajones/6.jpg"><img src="imagenes/cajones/8.jpg" alt="two" /></a>
              <div class="caption">
            </li>

            <li>
               <a class="thumb" href="imagenes/cajones/7.jpg""><img src="imagenes/cajones/9.jpg" alt="two" /></a>
              <div class="caption">
            </li>

            <li>
              <a class="thumb" href="imagenes/cajones/15.jpg"><img src="imagenes/cajones/10.jpg"alt="two" /></a>
              <div class="caption">
            </li>

            <li>
           <a class="thumb" href="imagenes/cajones/f.jpg"><img src="imagenes/cajones/11.jpg" alt="two" /></a>
              <div class="caption">
            </li>

            <li>
               <a class="thumb" href="imagenes/cajones/a.jpg"><img src="imagenes/cajones/13.jpg" alt="two" /></a>
              <div class="caption">
            </li>

            <li>
                <a class="thumb" href="imagenes/cajones/e.jpg"><img src="imagenes/cajones/14.jpg" alt="two" /></a>
              <div class="caption">
            </li>

            <li>
              <a class="thumb" href="imagenes/cajones/v.jpg"><img src="imagenes/cajones/16.jpg" alt="two" /></a>
              <div class="caption">
            </li>

            <li>
             <a class="thumb" href="imagenes/cajones/l.jpg"><img src="imagenes/cajones/17.jpg" alt="two" /></a>
              <div class="caption">
            </li>

        <li>
             <a class="thumb" href="imagenes/cajones/g.jpg"><img src="imagenes/cajones/19.jpg" alt="two" /></a>
              <div class="caption">
            </li>

        <li>
             <a class="thumb" href="imagenes/cajones/4.jpg"><img src="imagenes/cajones/22.jpg" alt="two" /></a>
              <div class="caption">
            </li>

        <li>
             <a class="thumb" href="imagenes/cajones/17.png"><img src="imagenes/cajones/63.jpg" alt="two" /></a>
              <div class="caption">
            </li>

        <li>
             <a class="thumb" href="imagenes/cajones/16.png"><img src="imagenes/cajones/64.jpg" alt="two" /></a>
              <div class="caption">
            </li>

        <li>
             <a class="thumb" href="imagenes/cajones/15.png"><img src="imagenes/cajones/65.jpg" alt="two" /></a>
              <div class="caption">
            </li>

        <li>
             <a class="thumb" href="imagenes/cajones/14.png"><img src="imagenes/cajones/66.jpg" alt="two" /></a>
              <div class="caption">
            </li>

        <li>
             <a class="thumb" href="imagenes/cajones/13.png"><img src="imagenes/cajones/67.jpg" alt="two" /></a>
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
      //Sólo queremos estos estilos aplicados cuando avascript está activado
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

