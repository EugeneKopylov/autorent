<jsp:include page="_header.jsp"/>
<h1>Add permission</h1>

<form method="post" action="/autorent/add-role.action">
  <div class="mb-3">
    <label for="roleName" class="form-label">Role</label>
    <input type="text" name="roleName" class="form-control" id="roleName" aria-describedby="roleHelp">
    <div id="roleHelp" class="form-text">Enter role name</div>
  </div>
    <div class="mb-3">
      <input type="text" name="roleDescription" class="form-control" id="roleDescription" aria-describedby="roleHelp">
      <div id="roleHelp" class="form-text">Enter role description</div>
    </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>

<jsp:include page="_footer.jsp"/>