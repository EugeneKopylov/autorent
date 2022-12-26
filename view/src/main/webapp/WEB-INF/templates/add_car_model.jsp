<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h1>Add car model</h1>

<form method="post" action="/autorent/add-car-model.action">

  <div class="mb-3">
   <label for="carBrand.id">Choose a car brand:</label>
   <select class="form-select" id="carBrand.id" name="carBrand.id">
    <c:forEach items="${brands}" var="carBrand">
     <option value="${carBrand.id}">${carBrand.brandName}</option>
    </c:forEach>
   </select>
  </div>

  <div class="mb-3">
    <label for="carModel" class="form-label">car model</label>
    <input type="text" name="carModel" class="form-control" id="carModel" aria-describedby="brandHelp">
    <div id="brandHelp" class="form-text">Enter car model</div>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>



<jsp:include page="_footer.jsp"/>