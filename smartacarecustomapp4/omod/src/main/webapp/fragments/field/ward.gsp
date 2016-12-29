<!-- <p class="required"> -->
<p>
    <label>
        ${config.label}
        <!-- <span>(${ ui.message("emr.formValidation.messages.requiredField.label") })</span> -->
    </label>
    <select name="${config.formFieldName}" size="6">
        <option value ="Medical">Medical</option> <!-- 163152 -->
        <option value ="Surgical">Surgical</option> <!-- 163186 -->
        <option value ="Obstetrics">Obstetrics</option> <!-- 163170 -->
    </select>
    <span class="field-error"></span>
</p>