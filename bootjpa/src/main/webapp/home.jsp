<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Alien | Form</title>
  </head>
  <body>
  <div class="container">
   <form action="addAlien">
     <div class="form-group">
        <label for="aid">Aid</label>
        <input type="text" class="form-control" id="aid" placeholder="Enter id" name="aid">
     </div>
     <div class="form-group">
        <label for="aname">Name</label>
        <input type="text" class="form-control" id="aname" placeholder="Enter Name" name="aname">
     </div>
     
     <div class="form-group">
        <label for="tech">Tech</label>
        <input type="text" class="form-control" id="tech" placeholder="Enter Tech" name="tech">
     </div>
     
     
      <button type="submit" class="btn btn-primary">Submit</button>
     
     </form>
     
     <hr>
     <form action="getAlien">
      <div class="form-group">
        <label for="searchId">Enter id to search</label>
        <input type="text" class="form-control" id="searchId" placeholder="Enter Id" name="aid">
     </div>
         <button type="submit" class="btn btn-primary">Submit</button>
    </form>
    
    
    <table class="table mt-5">
  <thead class="thead-dark">
    <tr>
      <th scope="col">#</th>
      <th scope="col">Name</th>
      <th scope="col">Tech</th>
    </tr>
  </thead>
  
  
  <tbody>
   <c:forEach var="item" items="${aliens}">  
    <tr>
      <th scope="row">${item.aid}</th>
      <td>${item.aname}</td>
      <td>${item.tech}</td>
   
    </tr>
    </c:forEach>
  </tbody>
</table>
 </div>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  	
  	<!-- <script>
  	
  	  var submit = document.getElementsByClassName("btn")[0];
  	  var aname = document.getElementById('aname');
  	  var lang = document.getElementById('lang');
  	  
  	  
  	  
  	  submit.addEventListener('click',(e)=>{
  		  e.preventDefault();
  		  
  		  console.log(aname.value);
  		  console.log(lang.value);
  		  
  		fetch('http://localhost:8080/home?' + new URLSearchParams({
  		    "aname":aname.value,
  		    "lang":lang.value
  		}))
  		
  		 
  	  })
  		
  	
  	</script> -->
  </body>
</html>