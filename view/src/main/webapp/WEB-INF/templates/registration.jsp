<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<jsp:include page="_header.jsp"/>
<h1>Add user</h1>
<body>
<form method="post" action="/autorent/add-reg-user.action" name="toSub">

        <script>
            function isOk() {
            var email = document.getElementById("email").value;
            var nickname = document.getElementById("nickname").value;
            var password = document.getElementById("password").value;
            var status = document.getElementById("status");
            var re = /^[^\s()<>@,;:\/]+@\w[\w\.-]+\.[a-z]{2,}$/i;
            if(isEmpty(email) && isEmpty(nickname) && isEmpty(password)) status.innerHTML = "empty fields nickname & email & password";
                else if(isEmpty(email) && isEmpty(nickname)) status.innerHTML = "empty fields nickname & email";
                else if(isEmpty(nickname) && isEmpty(password)) status.innerHTML = "empty field nickname & password";
                else if(isEmpty(password) && isEmpty(email)) status.innerHTML = "empty fields password & email";
                else if(isEmpty(nickname)) status.innerHTML = "empty field nickname";
                else if(isEmpty(email)) status.innerHTML = "empty field mail";
                else if(isEmpty(password)) status.innerHTML = "empty field password";
                else if(re.test(email)) toSub.submit();
                else status.innerHTML = "incorrect email";
            }
            function isEmpty(email){
                return (email == null) || (email.length == 0);
            }
            function isEmpty(name){
                return (nickname == null) || (nickname.length == 0);
            }
            function isEmpty(password){
                return (password == null) || (password.length == 0);
            }
        </script>

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
    <label for="firstName" class="form-label">First name</label>
    <input type="text" name="firstName" class="form-control" id="firstName" aria-describedby="firstNameHelp">
    <div id="firstNameHelp" class="form-text">Enter first name</div>
  </div>

  <div class="mb-3">
    <label for="lastName" class="form-label">Last name</label>
    <input type="text" name="lastName" class="form-control" id="lastName" aria-describedby="lastNameHelp">
    <div id="lastNameHelp" class="form-text">Enter last name</div>
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

  <input type="button" value="Enter" onclick="isOk()"><span id="status"></span>
</form>
</body>

<jsp:include page="_footer.jsp"/>
</html>