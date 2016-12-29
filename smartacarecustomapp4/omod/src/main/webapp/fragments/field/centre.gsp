<!-- <p class="required"> -->
<p>
    <label>
        ${config.label}
        <!-- <span>(${ ui.message("emr.formValidation.messages.requiredField.label") })</span> -->
    </label>
    <select name="${config.formFieldName}" size="6">
        <option value ="Public">Public</option> <!-- 163218 -->
        <option value ="Private">Private</option> <!-- 163168 -->
    </select>
    <span class="field-error"></span>
</p>