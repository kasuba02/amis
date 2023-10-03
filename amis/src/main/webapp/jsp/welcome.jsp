<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WelCome</title>
</head>
<body>
<%@include file="Header.jsp"%>
<div> 
<div id="carouselExampleFade" class="carousel slide carousel-fade" data-bs-ride="carousel">
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="<%=AMView.APP_CONTEXT%>/img/slider1.jpg" class="d-block w-100" alt="..."  width="500" 
     height="700">
    </div>
   
    <div class="carousel-item">
      <img src="<%=AMView.APP_CONTEXT%>/img/slider33.jpg" class="d-block w-100" alt="..."  width="500" 
     height="700">
    </div>
     <div class="carousel-item">
      <img src="<%=AMView.APP_CONTEXT%>/img/slider44.jpg" class="d-block w-100" alt="..."  width="500" 
     height="700">
    </div>
     <div class="carousel-item">
      <img src="<%=AMView.APP_CONTEXT%>/img/slider55.jpg" class="d-block w-100" alt="..."  width="500" 
     height="700">
    </div>
     <div class="carousel-item">
      <img src="<%=AMView.APP_CONTEXT%>/img/slider66.jpg" class="d-block w-100" alt="..."  width="500" 
     height="700">
    </div>
     <div class="carousel-item">
      <img src="<%=AMView.APP_CONTEXT%>/img/slider77.jpg" class="d-block w-100" alt="..."  width="500" 
     height="700">
    </div>
     <div class="carousel-item">
      <img src="<%=AMView.APP_CONTEXT%>/img/sliderco.jpg" class="d-block w-100" alt="..."  width="500" 
     height="700">
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleFade" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleFade" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>
</div>

<%@include file="Footer.jsp"%>


</body>
</html>