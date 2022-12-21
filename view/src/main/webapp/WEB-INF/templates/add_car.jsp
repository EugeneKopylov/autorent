<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h1>Add car</h1>

<form method="post" action="/autorent/add-car.action" enctype="multipart/form-data">
  <!-- brand -->
  <div class="mb-3">
    <label for="brand" class="form-label">Brand</label>
    <input type="text" name="brand" class="form-control" id="brand" aria-describedby="brandHelp">
    <div id="brandHelp" class="form-text">Enter brand</div>
  </div>
  <!-- model -->
  <div class="mb-3">
      <label for="carModel" class="form-label">model</label>
      <input type="text" name="carModel" class="form-control" id="carModel" aria-describedby="modelHelp">
      <div id="modelHelp" class="form-text">Enter model</div>
  </div>
   <!-- bodyType -->
    <div class="mb-3">
     <label for="bodyType" class="form-label">Body Type</label>
     <input type="text" name="bodyType" class="form-control" id="bodyType" aria-describedby="bodyHelp">
     <div id="bodyHelp" class="form-text">Enter body type</div>
    </div>
  <!-- gearbox -->
    <div class="mb-3">
     <label for="gearbox" class="form-label">gearbox</label>
     <input type="text" name="gearbox" class="form-control" id="gearbox" aria-describedby="gearboxHelp">
     <div id="gearboxHelp" class="form-text">Enter gearbox</div>
    </div>
  <!-- yearOfProd -->
   <div class="mb-3">
       <label for="yearOfProd" class="form-label">Year of production</label>
       <input type="text" name="yearOfProd" class="form-control" id="yearOfProd" aria-describedby="yearOfProdHelp">
       <div id="yearOfProdHelp" class="form-text">Enter year of production</div>
   </div>
   <!-- fuelType -->
   <div class="mb-3">
       <label for="fuelType" class="form-label">Fuel Type</label>
       <input type="text" name="fuelType" class="form-control" id="fuelType" aria-describedby="fuelHelp">
       <div id="fuelHelp" class="form-text">Enter fuel type</div>
   </div>
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

