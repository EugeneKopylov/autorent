<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<jsp:include page="_header.jsp"/>
<h1>Wide car information</h1>

<table style="width:100%" class="table">
    <div class="mb-3">
    "${brand}" "${model}"
    "${car.bodyType}"
    "${car.gearbox}"
    "${car.yearOfProd}"
    "${car.fuelType} ${engineCapacity}"
    "${price}"
    "${car.carDescription}"
    </div>

    <div class="mb-3">
    <security:authorize access="hasRole('USER')">
    <form action="/autorent/add-order/${car.brand.brandName}/${car.carModel.carModelName}/${car.cost}.view">
        <input type="submit" value="Add to order">
    </form>
    </security:authorize>

    <security:authorize access="!isAuthenticated()">
        <a href="${pageContext.request.contextPath}/login">please login to place an order</a>
    </security:authorize>
    </div>
    <div class="mb-3">
    <image src="/autorent/image/wide/${car.carPicture.id}/picture.jpg" height="400px" width="600px" class="img-thumbnail">
    </div>
<jsp:include page="_footer.jsp"/>