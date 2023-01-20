<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h1>Add user</h1>

<form method="post" action="/autorent/add-user.action">
  <div class="mb-3">
    <label for="nickname" class="form-label">nickname</label>
    <input type="text" name="nickname" class="form-control" id="nickname" aria-describedby="nicknameHelp">
    <div id="nicknameHelp" class="form-text">Enter nickname</div>
  </div>

  <div class="mb-3">
    <label for="password" class="form-label">password</label>
    <input type="text" name="password" class="form-control" id="password" aria-describedby="passwordHelp">
    <div id="passwordHelp" class="form-text">Enter password</div>
  </div>

  <div class="mb-3">
   <label for="roleName">Choose a role:</label>
   <select class="form-select" id="roleName" name="roleName">
      <c:forEach items="${roleName}" var="roleName">
     <option value="${roleName}">${roleName}</option>
    </c:forEach>
   </select>
  </div>

  <button type="submit" class="btn btn-primary">Submit</button>
</form>

<jsp:include page="_footer.jsp"/>