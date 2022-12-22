<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h1>Users</h1>

<table style="width:100%" class="table">
  <tr>
    <th>First name</th>
    <th>Last name</th>
    <th>Phone number</th>
    <th>email</th>
    <th>Order list</th>
  </tr>
  <c:forEach items="${users}" var="user">
  <tr>
    <td><c:out value="${user.firstName}"/></td>
    <td><c:out value="${user.lastName}"/></td>
    <td><c:out value="${user.phoneNumber}"/></td>
    <td><c:out value="${user.email}"/></td>
    <td><c:out value="${user.orderList}"/></td>
  </tr>
  </c:forEach>
</table>

<jsp:include page="_footer.jsp"/>