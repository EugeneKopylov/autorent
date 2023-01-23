<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h1>All cars</h1>

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
<p><a href="/autorent/car-list/${previousPage}.view">previous page</a></p><p><a href="/autorent/car-list/${nextPage}.view">next page</a></p>

<jsp:include page="_footer.jsp"/>