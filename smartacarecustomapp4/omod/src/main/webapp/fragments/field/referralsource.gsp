<!-- <p class="required"> -->
<p>
    <label>
        ${config.label}
        <!-- <span>(${ ui.message("emr.formValidation.messages.requiredField.label") })</span> -->
    </label>
    <select name="${config.formFieldName}" size="6">
        <option value ="Clinic">Clinic</option> <!-- 163160 -->
        <option value ="Emergency">Emergency</option> <!-- 163161 -->
        <option value ="In-hospital">In-hospital</option> <!-- 163163 -->
        <option value ="External">External</option> <!-- 163162 -->
    </select>
    <span class="field-error"></span>
</p>