<div class="row">
    <div class=" col-md-3 fieldcontain ${hasErrors(bean: errorBean, field: errorField, 'error')} required">
        <label for="${formName}">
            ${formLabel}
        </label>
    </div>

    <div class="col-md-9">
        <g:field name="${formName}" type="${formType ?: 'text'}" class="form-control" value="${value}" required=""/>
    </div>
</div>