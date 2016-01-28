<div class="row">
    <div class=" col-md-3 fieldcontain ${hasErrors(bean: bean, field: property, 'error')} required">
        <label for="${property}">
            ${label}
        </label>
    </div>

    <div class="col-md-9">
        <g:field name="${property}" type="number" value="${value}" required=""/>
    </div>
</div>