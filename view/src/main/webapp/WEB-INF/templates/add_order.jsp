<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="_header.jsp"/>
<h1>Add order</h1>

<form method="post" action="/autorent/add-order/${brand}/${model}/${price}.action" name="toSub">

You are ordering "${brand}" "${model}" "${price}"

  <!-- date -->
  <div class="mb-3">
    <label for="orderDateFrom" class="form-label">Set date from</label>
    <input type="text" name="orderDateFrom"  autocomplete="off" id="datef" aria-describedby="brandHelp">
  </div>

    <div class="mb-3">
      <label for="orderDateTo" class="form-label">Set date to</label>
      <input type="text" name="orderDateTo"  autocomplete="off" id="datet" aria-describedby="brandHelp">
    </div>

    	<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
    	<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.7.2/themes/smoothness/jquery-ui.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.7.2/jquery-ui.min.js"></script>


    	<script type="text/javascript">
    			var disabledDays = [${order}];

    			function nationalDays(datef) {
    				var m = datef.getMonth(), d = datef.getDate(), y = datef.getFullYear();

    				for (i = 0; i < disabledDays.length; i++) {
    					if(ArrayContains(disabledDays,d + '/' + (m+1) + '/' + y) || new Date() > datef) {
    						return [false];
    					}
    				}
    				//console.log('good:  ' + (m+1) + '-' + d + '-' + y);
    				return [true];
    			}
    			function noWeekendsOrHolidays(datef) {
    				var noWeekend = jQuery.datepicker.noWeekends(datef);
    				return nationalDays(datef);
    			}

    			function ArrayIndexOf(array,item,from){
    				var len = array.length;
    				for (var i = (from < 0) ? Math.max(0, len + from) : from || 0; i < len; i++){
    					if (array[i] === item) return i;
    				}
    				return -1;
    			}
    			function ArrayContains(array,item,from){
    				return ArrayIndexOf(array,item,from) != -1;
    			}

    			jQuery(document).ready(function() {
    				jQuery('#datef').datepicker({
    					minDate: new Date(Date.now()),   <!-- месяц / день / год -->  //new Date("03/25/2023")
    					maxDate: new Date(2033, 5, 31),
    					dateFormat: 'd/m/yy',
    					constrainInput: true,
    					beforeShowDay: noWeekendsOrHolidays
    				});
    			});



    	</script>

    	<script type="text/javascript">

            	var disabledDays = [${order}];

                function nationalDays(datet) {
                    var m = datet.getMonth(), d = datet.getDate(), y = datet.getFullYear();
                    //console.log('Checking (raw): ' + m + '-' + d + '-' + y);
                    for (i = 0; i < disabledDays.length; i++) {
                        if(ArrayContains(disabledDays,d + '/' + (m+1) + '/' + y) || new Date() > datet) {
                            return [false];
                        }
                    }
                    //console.log('good:  ' + (m+1) + '-' + d + '-' + y);
                    return [true];
                }
                function noWeekendsOrHolidays(datet) {
                    var noWeekend = jQuery.datepicker.noWeekends(datet);
                    return nationalDays(datet);
                }

                function ArrayIndexOf(array,item,from){
                    var len = array.length;
                    for (var i = (from < 0) ? Math.max(0, len + from) : from || 0; i < len; i++){
                        if (array[i] === item) return i;
                    }
                    return -1;
                }
                function ArrayContains(array,item,from){
                    return ArrayIndexOf(array,item,from) != -1;
                }

                jQuery(document).ready(function() {
                    jQuery('#datet').datepicker({
                        minDate: new Date(dar),
                        maxDate: new Date(2043, 5, 31),
                        dateFormat: 'd/m/yy',
                        constrainInput: true,
                        beforeShowDay: noWeekendsOrHolidays
                    });
                });



        </script>

        <script>
            function isOk() {
                const fromD = new Date(&quote;edocument.getElementById("datef").value&quote;);
                const toD = new Date (&quote;document.getElementById("datet").value&quote;);
                if(fromD > toD) status.innerHTML = "incorrect date values";
                    else toSub.submit();
            }
        </script>


    <body>




    </body>

    <p>${order}</p>


  <button type="submit" class="btn btn-primary" onclick="isOk()">Submit</button>
</form>
<jsp:include page="_footer.jsp"/>

