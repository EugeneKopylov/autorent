<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h1>Add car model</h1>

<form method="post" action="/autorent/add-car-model.action">

  <div class="mb-3">
   <label for="brand.id">Choose a car brand:</label>
   <select class="form-select" id="brand.id" name="brand.id">
    <c:forEach items="${brands}" var="brand">
     <option value="${brand.id}">${brand.brandName}</option>
    </c:forEach>
   </select>
  </div>

  <div class="mb-3">
    <label for="carModelName" class="form-label">car model</label>
    <input type="text" name="carModelName" class="form-control" id="carModelName" aria-describedby="brandHelp">
    <div id="brandHelp" class="form-text">Enter car model</div>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>



<jsp:include page="_footer.jsp"/>