<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h1>Permission</h1>

<table style="width:100%" class="table">
  <tr>
    <th>Name</th>
  </tr>
  <c:forEach items="${permissions}" var="permission">
  <tr>
    <td><c:out value="${permission}"/></td>
  </tr>
  </c:forEach>
</table>

<jsp:include page="_footer.jsp"/>