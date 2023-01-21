<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h1>Add car</h1>

<form method="post" action="/autorent/add-car.action" enctype="multipart/form-data">
  <!-- brand -->

  <div class="mb-3">

  <script type="text/javascript" src="http://code.jquery.com/jquery-2.1.0.min.js"></script>

     <div class="mb-3">
     <label for="brand">Choose a car brand:</label>
     <select class="form-select" id="brand" name="brand">
     <option value="${branded}"><-${branded}-></option>
      <c:forEach items="${brand}" var="brand">
       <option value="${brand}">${brand}</option>
      </c:forEach>
     </select>
     </div>

     <div class="mb-3">
     <label for="models">Choose a car model:</label>
     <select class="form-select" id="model" name="model">
      <c:forEach items="${models}" var="model">
       <option value="${model}">${model}</option>
      </c:forEach>
     </select>
     </div>

     <script type="text/javascript">
         $(document).ready(function(event) {
             element.addEventListener("change", function() {
                 var enterdName = $("#name").val();
                 var element = document.querySelector('#brand');
                 var el = document.querySelector('#model');
                 let toUrl = window.location.toString().replace("NaN", "") - element.value;
                 //starting ajax call
                 $.ajax({
                     type : "GET",
                     url : window.location,
                     data : "brand=" + element.value,
                     success : function(result) {
                         //process the result
                         $("#responseDiv").html(result);
                         success: window.location.href = toUrl.toString().replace("NaN", element.value + ".view");
                     },

                 })
                 $.ajax({
                     type : "GET",
                     url : window.location,
                     data : "model=" + el.value,
                 })
             })
         })
     </script>

     <script>
         const element = document.querySelector('#brand');
         var pElem = document.getElementById('p')

         element.addEventListener("change", function() {
           const element = document.querySelector('#brand');
           var elbrand = element.value;
           pElem.innerHTML = 'selectedIndex: ' + elbrand;
         });
     </script>

    "${brand}"
    "${branded}"

     <div class="mb-3">
     <label for="bodyType">Choose a car body type:</label>
     <select class="form-select" id="bodyType" name="bodyType">
       <option value="SEDAN">SEDAN</option>
       <option value="HATCBACK">HATCHBACK</option>
       <option value="SUV">SUV</option>
       <option value="COUPE">COUPE</option>
       <option value="STATION WAGON">STATION WAGON</option>
       <option value="CONVERTIBLE">CONVERTIBLE</option>
       <option value="MINIVAN">MINIVAN</option>
       <option value="PICKUP TRUCK">PICKUP TRUCK</option>
     </select>
     </div>

  <!-- gearbox -->
     <div class="mb-3">
     <label for="gearbox">Choose a gearbox type:</label>
     <select class="form-select" id="gearbox" name="gearbox">
       <option value="MANUAL">MANUAL</option>
       <option value="ROBOT">ROBOT</option>
       <option value="AUTO">AUTO</option>
     </select>
     </div>

  <!-- yearOfProd -->
   <div class="mb-3">
       <label for="yearOfProd" class="form-label">Year of production</label>
       <input type="text" name="yearOfProd" class="form-control" id="yearOfProd" aria-describedby="yearOfProdHelp">
       <div id="yearOfProdHelp" class="form-text">Enter year of production</div>
   </div>
   <!-- fuelType -->
   <div class="mb-3">
     <label for="fuelType">Choose a fuel type:</label>
     <select class="form-select" id="fuelType" name="fuelType">
       <option value="PETROL">PETROL</option>
       <option value="DIESEL">DIESEL</option>
       <option value="ELECTRIC">ELECTRIC</option>
     </select>
   <!-- engineCapacity -->
   <div class="mb-3">
       <label for="engineCapacity" class="form-label">Engine Capacity</label>
       <input type="text" name="engineCapacity" class="form-control" id="engineCapacity" aria-describedby="engineHelp">
       <div id="engineHelp" class="form-text">Enter engine capacity</div>
   </div>
   <!-- cost -->
   <div class="mb-3">
       <label for="cost" class="form-label">Cost</label>
       <input type="text" name="cost" class="form-control" id="cost" aria-describedby="costHelp">
       <div id="costHelp" class="form-text">Enter cost</div>
   </div>
   <!-- carDescription -->
   <div class="mb-3">
       <label for="carDescription" class="form-label">Car description</label>
       <input type="text" name="carDescription" class="form-control" id="carDescription" aria-describedby="carDescHelp">
       <div id="carDescHelp" class="form-text">Enter car description</div>
   </div>
   <div class="mb-3">
         <label for="picture" class="form-label">Photo</label>
         <input type="file" name="picture" class="form-control" id="picture">
     </div>


  <button type="submit" class="btn btn-primary">Submit</button>
</form>
<jsp:include page="_footer.jsp"/>

