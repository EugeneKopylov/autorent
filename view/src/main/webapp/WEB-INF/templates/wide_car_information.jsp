<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h1>Wide car information</h1>

<table style="width:100%" class="table">

"${brand}"
"${model}"
"${price}"

    "${car.brand} ${car.carModel}"
    "${car.bodyType}"
    "${car.gearbox}"
    "${car.yearOfProd}"
    "${car.fuelType} ${engineCapacity}"
    "${car.cost}"
    "${car.carDescription}"
    <image src="/autorent/image/wide/${car.carPicture.id}/picture.jpg" class="img-thumbnail">

<jsp:include page="_footer.jsp"/>