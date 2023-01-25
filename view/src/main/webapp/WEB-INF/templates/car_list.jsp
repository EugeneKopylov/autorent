<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="http://code.jquery.com/jquery-2.1.0.min.js"></script>
<jsp:include page="_header.jsp"/>
<h1>All cars</h1>

        <select align="right" style="width:5%" onchange="window.location.href = this.options[this.selectedIndex].value">
        	<option value="${pageSize}">number of cars on page</option>
        	<option value="/autorent/car-list/off0pgs3.view">3</option>
        	<option value="/autorent/car-list/off0pgs5.view">5</option>
        	<option value="/autorent/car-list/off0pgs7.view">7</option>
        	<option value="/autorent/car-list/off0pgs10.view">10</option>
        </select>

<table style="width:100%" class="table">
  <tr>
    <th>Brand and Model</th>
    <th>Gearbox</th>
    <th>Year of production</th>
    <th>Cost per day</th>
    <th>Photo</th>
  </tr>
  <c:forEach items="${cars}" var="car">
  <tr>

    <td><a href="${car.brand}/${car.carModel}/${car.cost}.view"><c:out value="${car.brand} ${car.carModel}"/></a></td>
    <td><c:out value="${car.gearbox}"/></td>
    <td><c:out value="${car.yearOfProd}"/></td>
    <td><c:out value="${car.cost}"/></td>
    <td><image src="/autorent/image/${car.carIdPicture}/picture.jpg" style="width:448px;height:336px;" class="img-thumbnail"><td>

  </tr>
  </c:forEach>
</table>
<p><a href=${previousPageHref}>previous page</a></p><p><a href=${nextPageHref}>next page</a></p>

<jsp:include page="_footer.jsp"/>