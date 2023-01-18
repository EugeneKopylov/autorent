<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h1>Add car</h1>

<form method="post" action="/autorent/add-car.action" enctype="multipart/form-data">
  <!-- brand -->

  <div class="mb-3">

  <script type="text/javascript" src="http://code.jquery.com/jquery-2.1.0.min.js"></script>


     <label for="brand">Choose a car brand:</label>
     <select class="form-select" id="brand" name="brand">
     <option value='select a brand'><-${branded}-></option>
      <c:forEach items="${brand}" var="brand">
       <option value="${brand}">${brand}</option>
      </c:forEach>
     </select>

     <label for="models">Choose a car model:</label>
     <select class="form-select" id="models" name="models">
      <c:forEach items="${models}" var="models">
       <option value="${models}">${models}</option>
      </c:forEach>
     </select>


     <script type="text/javascript">
         $(document).ready(function(event) {
             element.addEventListener("change", function() {
                 var enterdName = $("#name").val();
                 var element = document.querySelector('#brand');
                 let toUrl = window.location.toString().replace(element.value, "");
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



    "${brand}"
    "${branded}"



  <button type="submit" class="btn btn-primary">Submit</button>
</form>
<jsp:include page="_footer.jsp"/>

