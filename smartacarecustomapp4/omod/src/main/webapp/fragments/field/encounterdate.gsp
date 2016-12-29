<!-- <p class="required"> -->
<p>
    <label>
        ${config.label}
        <!-- <span>(${ ui.message("emr.formValidation.messages.requiredField.label") })</span> -->
    </label>
    <input type="date" name="${config.formFieldName}" id="encounterdate" /> <!-- 163221 -->
    <span class="field-error"></span>
    
    
    <script>
      var month_array = {"Jan": 01, "Feb": 02, "Mar": 03, "Apr":04, "May": 05,
      "Jun": 06,"Jul":07, "Aug": 08, "Sep": 09, "Oct":10, "Nov": 11, "Dec": 12};
    
	  var temp = new Date().toDateString().substr(4,11);
	  var get_month_pos = temp.substr(0,3);
	  var get_month = month_array[get_month_pos];
	  var month_in_num = temp.replace(get_month_pos, get_month);
	  var split_arr = month_in_num.split(" ");
	  var new_date = split_arr[2]+'-'+split_arr[0]+'-'+split_arr[1];
	
	  document.getElementById("encounterdate").value = new_date;
    </script>
</p>