<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<jsp:include page="_header.jsp"/>
<h1>Order list information</h1>

<table style="width:100%" class="table">
  <tr>
    <th>Car brand</th>
    <th>Car model</th>
    <th>Date of order</th>
    <th>Order date from</th>
    <th>Order date to</th>
    <th>Cost</th>
  </tr>
  <c:forEach items="${orders}" var="order">
  <tr>

    <td><c:out value="${order.car.brand.brandName}"/></td>
    <td><c:out value="${order.car.carModel.carModelName}"/></td>
    <td><c:out value="${order.date}"/></td>
    <td><c:out value="${order.orderDateFrom}"/></td>
    <td><c:out value="${order.orderDateTo}"/></td>
    <td><c:out value="${order.cost}"/></td>

  </tr>
  </c:forEach>
</table>

<jsp:include page="_footer.jsp"/>