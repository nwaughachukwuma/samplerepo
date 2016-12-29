<!-- <p class="required"> -->
<p>
    <label>
        ${config.label}
        <!-- <span>(${ ui.message("emr.formValidation.messages.requiredField.label") })</span> -->
    </label>
    <select name="${config.formFieldName}" size="6">
        <option value ="Igbo">Igbo</option> <!-- 163177 -->
        <option value ="Hausa">Hausa</option> <!-- 163178 -->
        <option value ="Yoruba">Yoruba</option> <!-- 163175 -->
        <option value ="Ibibio">Ibibio</option> <!-- 163179 -->
        <option value ="English">English</option> <!-- 163176 -->
        <option value ="French">French</option> <!-- 163149 -->
        <option value ="Other">Other</option> <!-- 163156 -->
    </select>
    <span class="field-error"></span>
</p>