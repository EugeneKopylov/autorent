<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h1>Update car of ${brand}</h1>

<form method="post" action="/autorent/update-car/${car.brand.brandName}/${car.carModel.carModelName}/${car.cost}.action">

  <div class="mb-3">

     <div class="mb-3">
     <label for="models">Choose a new car model:</label>
     <select class="form-select" id="models" name="models">
      <c:forEach items="${models}" var="model">
       <option value="${model.carModelName}">${model.carModelName}</option>
      </c:forEach>
     </select>
     </div>

     <div class="mb-3">
     <label for="bodyType">Choose a new car body type:</label>
     <select class="form-select" id="bodyType" name="bodyType">
       <option value="${car.bodyType}" selected>${car.bodyType}</option>
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
       <option value="${car.gearbox}" selected>${car.gearbox}</option>
       <option value="MANUAL">MANUAL</option>
       <option value="ROBOT">ROBOT</option>
       <option value="AUTO">AUTO</option>
     </select>
     </div>

  <!-- yearOfProd -->
   <div class="mb-3">
       <label for="yearOfProd" class="form-label">Year of production</label>
       <input type="text" name="yearOfProd" value="${car.yearOfProd}" class="form-control" id="yearOfProd" aria-describedby="yearOfProdHelp" min="1900" max="2023" required>
       <div id="yearOfProdHelp" class="form-text">Enter new year of production</div>
   </div>
   <!-- fuelType -->
   <div class="mb-3">
     <label for="fuelType">Choose a new fuel type:</label>
     <select class="form-select" id="fuelType" name="fuelType">
       <option value="${car.fuelType}" selected>${car.fuelType}</option>
       <option value="PETROL">PETROL</option>
       <option value="DIESEL">DIESEL</option>
       <option value="ELECTRIC">ELECTRIC</option>
     </select>
   <!-- engineCapacity -->
   <div class="mb-3">
       <label for="engineCapacity" class="form-label">Engine Capacity</label>
       <input type="text" name="engineCapacity" value="${car.engineCapacity}" class="form-control" id="engineCapacity" aria-describedby="engineHelp">
       <div id="engineHelp" class="form-text">Enter engine capacity</div>
   </div>
   <!-- cost -->
   <div class="mb-3">
       <label for="cost" class="form-label">Cost</label>
       <input type="text" name="cost" value="${car.cost}" class="form-control" id="cost" aria-describedby="costHelp" min="5" max="5000" required>
       <div id="costHelp" class="form-text">Enter new cost</div>
   </div>
   <!-- carDescription -->
   <div class="mb-3">
       <label for="carDescription" class="form-label">Car description</label>
       <input type="text" name="carDescription" value="${car.carDescription}" class="form-control" id="carDescription" aria-describedby="carDescHelp">
       <div id="carDescHelp" class="form-text">Enter new car description</div>
   </div>

  <button type="submit" class="btn btn-primary">Submit</button>
</form>
<jsp:include page="_footer.jsp"/>

