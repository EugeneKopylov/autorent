<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h1>Delete model</h1>

  <!-- brand -->
<form method="post" action="/autorent/delete-car-model.action">

  <div class="mb-3">

  <script type="text/javascript" src="http://code.jquery.com/jquery-2.1.0.min.js"></script>

     <div class="mb-3">
          <label for="brand">Choose a car brand:</label>
          <select class="form-select" id="brand" name="brand">
          <option value="${branded}"><-${branded}-></option>
           <c:forEach items="${brand}" var="brand">
            <option value="${brand}">${brand}</option>
           </c:forEach>
          </select>
          </div>

          <div class="mb-3">
          <label for="models">Choose a car model:</label>
          <select class="form-select" id="model" name="model">
           <c:forEach items="${models}" var="model">
            <option value="${model}">${model}</option>
           </c:forEach>
          </select>
          </div>

     <script type="text/javascript">
         $(document).ready(function(event) {
             element.addEventListener("change", function() {
                 var enterdName = $("#name").val();
                 var element = document.querySelector('#brand');
                 var el = document.querySelector('#model');
                 let toUrl = window.location.toString().replace("NaN", "") - element.value;
                 //starting ajax call
                 $.ajax({
                     type : "GET",
                     url : window.location,
                     data : "brand=" + element.value,
                     success : function(result) {
                         //process the result
                         $("#responseDiv").html(result);
                         success: window.location.href = toUrl.toString().replace("NaN", element.value + ".view");
                     },

                 })
                 $.ajax({
                     type : "GET",
                     url : window.location,
                     data : "model=" + el.value,
                 })
             })
         })
     </script>

     <script>
         const element = document.querySelector('#brand');
         var pElem = document.getElementById('p')

         element.addEventListener("change", function() {
           const element = document.querySelector('#brand');
           var elbrand = element.value;
           pElem.innerHTML = 'selectedIndex: ' + elbrand;
         });
     </script>

     <button type="submit" class="btn btn-primary">Delete model</button>
</form>
<jsp:include page="_footer.jsp"/>

