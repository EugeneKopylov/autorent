<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h1>Change brand name</h1>

<form method="post" action="/autorent/update-car-brand/${brands}.action">
  <!-- brand -->

  <div class="mb-3">

     <div class="mb-3">
     <label for="brands">Choose a car brand:</label>
     <select class="form-select" id="brands" name="brands">
      <c:forEach items="${brand}" var="brands">
       <option value="${brands}">${brands}</option>
      </c:forEach>
     </select>
     </div>


     <div class="mb-3">
        <label for="newName" class="form-label">new brand name</label>
        <input type="text" name="newName" class="form-control" id="newName" aria-describedby="costHelp">
        <div id="brandHelp" class="form-text">Enter new brand name</div>
     </div>

  <button type="submit" class="btn btn-primary">Submit</button>
</form>
<jsp:include page="_footer.jsp"/>

