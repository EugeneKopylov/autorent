<jsp:include page="_header.jsp"/>
<h1>Add user</h1>

<form method="post" action="/autorent/add-user.action">
  <div class="mb-3">
    <label for="firstName" class="form-label">First name</label>
    <input type="text" name="firstName" class="form-control" id="firstName" aria-describedby="firstNameHelp">
    <div id="firstNameHelp" class="form-text">Enter first name</div>
  </div>
  <div class="mb-3">
    <label for="lastName" class="form-label">Last name</label>
    <input type="text" name="lastName" class="form-control" id="lastName" aria-describedby="lastNameHelp">
    <div id="firstNameHelp" class="form-text">Enter last name</div>
  </div>
  <div class="mb-3">
    <label for="phoneNumber" class="form-label">Phone number</label>
    <input type="text" name="phoneNumber" class="form-control" id="phoneNumber" aria-describedby="phoneNumberHelp">
    <div id="phoneNumberHelp" class="form-text">Enter phone number</div>
  </div>
  <div class="mb-3">
    <label for="email" class="form-label">email</label>
    <input type="text" name="email" class="form-control" id="email" aria-describedby="emailHelp">
    <div id="emailHelp" class="form-text">Enter email</div>
  </div>
  <div class="mb-3">
    <label for="orderList" class="form-label">Order list</label>
    <input type="text" name="orderList" class="form-control" id="orderList" aria-describedby="orderListHelp">
    <div id="orderListHelp" class="form-text">Enter order list</div>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>

<jsp:include page="_footer.jsp"/>