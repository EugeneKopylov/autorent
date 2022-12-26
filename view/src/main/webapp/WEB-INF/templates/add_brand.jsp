<jsp:include page="_header.jsp"/>
<h1>Add user</h1>

<form method="post" action="/autorent/add-brand.action">
  <div class="mb-3">
    <label for="brandName" class="form-label">Brand name</label>
    <input type="text" name="brandName" class="form-control" id="brandName" aria-describedby="brandHelp">
    <div id="brandHelp" class="form-text">Enter brand name</div>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>

<jsp:include page="_footer.jsp"/>