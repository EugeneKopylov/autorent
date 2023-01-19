<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h1>Add car</h1>

<form method="post" action="/autorent/add-order/${brand}/${model}/${price}.action">

"${brand}"
"${model}"
"${price}"

  <!-- date -->
  <div class="mb-3">
    <label for="orderDate" class="form-label">Set date</label>
    <input type="text" name="orderDate" class="form-control" id="orderDate" aria-describedby="brandHelp">
    <div id="brandHelp" class="form-text">Set date</div>
  </div>
  </div>

  <button type="submit" class="btn btn-primary">Submit</button>
</form>
<jsp:include page="_footer.jsp"/>

