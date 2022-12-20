<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h1>Employees</h1>

<table style="width:100%" class="table">
  <tr>
    <th>Brand and Model</th>
    <th>Body type</th>
    <th>Gearbox</th>
    <th>Year of production</th>
    <th>Fuel type and engine capacity</th>
    <th>Cost</th>
    <th>Car description</th>
    <th>Photo</th>
  </tr>
  <c:forEach items="${cars}" var="car">
  <tr>
    <td><c:out value="${car.brand} ${car.carModel}"/></td>
    <td><c:out value="${car.bodyType}"/></td>
    <td><c:out value="${car.gearbox}"/></td>
    <td><c:out value="${car.yearOfProd}"/></td>
    <td><c:out value="${car.fuelType} ${engineCapacity}"/></td>
    <td><c:out value="${car.cost}"/></td>
    <td><c:out value="${car.carDescription}"/></td>
    <td><image src="/autorent/image/${car.id}/picture.jpg" class="img-thumbnail"><td>
  </tr>
  </c:forEach>
</table>

<jsp:include page="_footer.jsp"/>