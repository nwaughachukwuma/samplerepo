<!-- <p class="required"> -->
<p>
    <label>
        ${config.label}
        <!-- <span>(${ ui.message("emr.formValidation.messages.requiredField.label") })</span> -->
    </label>
    <select name="${config.formFieldName}" size="6">
        <option value ="SW">SW</option> <!-- 163144 -->
        <option value ="SE">SE</option> <!-- 163146 -->
        <option value ="SS">SS</option> <!-- 163141 -->
        <option value ="NW">NW</option> <!-- 163140 -->
        <option value ="NE">NE</option> <!-- 163142 -->
        <option value ="NC">NC</option> <!-- 163143 -->
        <option value ="Foreigner">Foreigner</option> <!-- 163145 -->
    </select>
    <span class="field-error"></span>
</p>