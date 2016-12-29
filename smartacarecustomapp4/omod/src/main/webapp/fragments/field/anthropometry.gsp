<!-- <p class="required"> -->
<p>
    <label>
        ${config.label}
        <!-- <span>(${ ui.message("emr.formValidation.messages.requiredField.label") })</span> -->
    </label>
    <p name="${config.formFieldName}">
	    Weight(kg)<br/><input type="number" id="weight" min="1" name="weight" /><br/> <!-- 163174 -->
	    Height(m)<br/>
	    <input type="number" id="height" min="1" step="0.01" name="height" onblur="calculateBMI()" onkeyup="calculateBMI()" /><br/> <!-- 163159 -->
	    BMI<br/>
	    <input type="number" id="bmi" min="1" name="BMI" disabled="true" /><br/> <!-- 163206 -->
	    Waist Circumference<br/>
	    <input type="number" id="waist_circ" min="1" name="waist circumference" /><br/> <!-- 163207 -->
	    Hip Circumference<br/>
	    <input type="number" id="hip_circ" min="1" name="hip circumference" onblur="calculateWHR()" onkeyup="calculateWHR()" /><br/> <!-- 163184 -->
	    Waist-Hip ratio<br/>
	    <input type="text" id="waist_hip"  name="waist-hip ratio" disabled="true" /> <!-- 163183 -->
	    <span class="field-error"></span>
    </p>
    
    
    <script>

    	// custom function written to calculate the body mass index(BMI).
    	function calculateBMI(){
		  	var waist_circ = document.getElementById("weight").value;
		    var height = document.getElementById("height").value;
			if (weight !== "" && height !== ""){
				var bmi = weight/(height * height);
				document.getElementById("bmi").value = bmi;
			}
			else {
				//ui.message("enter waist circumference");
				document.getElementById("weight").blur(function(){
					var weight = document.getElementById("weight").value;
					var height = document.getElementById("height").value;
					var bmi = weight/(height * height);
					document.getElementById("bmi").value = bmi;
				});
				document.getElementById("weight").onkeyup = function(){
					var weight = document.getElementById("weight").value;
					var height = document.getElementById("height").value;
					var bmi = weight/(height * height);
					document.getElementById("bmi").value = bmi;
				};
			}
		};

    	// custom function written to calculate the Waist-hip ratio (WHR).
    	function calculateWHR(){
		  	var waist_circ = document.getElementById("waist_circ").value;
		    var hip_circ = document.getElementById("hip_circ").value;
			if (waist_circ !== "" && hip_circ !== ""){
				var waist_hip = waist_circ/hip_circ;
				document.getElementById("waist_hip").value = waist_hip;
			}
			else {
				//ui.message("enter waist circumference");
				document.getElementById("waist_circ").blur(function(){
					var waist_circ = document.getElementById("waist_circ").value;
					var hip_circ = document.getElementById("hip_circ").value;
					var waist_hip = waist_circ/hip_circ;
					document.getElementById("waist_hip").value = waist_hip;
				});
				document.getElementById("waist_circ").onkeyup = function(){
					var waist_circ = document.getElementById("waist_circ").value;
					var hip_circ = document.getElementById("hip_circ").value;
					var waist_hip = waist_circ/hip_circ;
					document.getElementById("waist_hip").value = waist_hip;
				};
			}
		};    
    </script>
</p>