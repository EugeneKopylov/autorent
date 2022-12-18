<jsp:include page="_header.jsp"/>
<h1>Add permission</h1>

<form method="post" action="/autorent/add-permission.html">
  <div class="mb-3">
    <label for="desc" class="form-label">Description</label>
    <input type="text" name="desc" class="form-control" id="desc" aria-describedby="descHelp">
    <div id="descHelp" class="form-text">Enter description</div>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>

<jsp:include page="_footer.jsp"/>


