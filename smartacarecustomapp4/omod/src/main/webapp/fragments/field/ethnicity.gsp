<!-- <p class="required"> -->
<p>
    <label>
        ${config.label}
        <!-- <span>(${ ui.message("emr.formValidation.messages.requiredField.label") })</span> -->
    </label>
    <select name="${config.formFieldName}" size="6">
        <option value ="Igbo">Igbo</option> <!-- 163157 -->
        <option value ="Hausa">Hausa</option> <!-- 163181 -->
        <option value ="Yoruba">Yoruba</option> <!-- 163172 -->
        <option value ="Other">Other</option> <!-- 163173 -->
        <option value ="Foreigner">Foreigner</option> <!-- 163145 -->
    </select>
    <span class="field-error"></span>
</p>