<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h1>Add order</h1>

<form method="post" action="/autorent/add-order/${brand}/${model}/${price}.action">

You are ordering "${brand}" "${model}" "${price}"

  <!-- date -->
  <div class="mb-3">
    <label for="orderDateFrom" class="form-label">Set date from</label>
    <input type="date" name="orderDateFrom" id="orderDate" aria-describedby="brandHelp">
  </div>

    <div class="mb-3">
      <label for="orderDateTo" class="form-label">Set date to</label>
      <input type="date" name="orderDateTo" id="orderDate" aria-describedby="brandHelp">
    </div>

  <button type="submit" class="btn btn-primary">Submit</button>
</form>
<jsp:include page="_footer.jsp"/>

