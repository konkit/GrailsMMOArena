<%@ page import="grails.validation.ValidationErrors" %>
<g:if test="${errorsList in ValidationErrors && errorsList.errorCount > 0}">
    <div class="alert alert-danger">
        <g:renderErrors bean="${errorsList}" as="list"/>
    </div>
</g:if>
<g:if test="${errorsList in List && errorsList.findAll{ it }.sum{ it in ValidationErrors ? it.errorCount : it.errors.errorCount } > 0 }">
    <div class="alert alert-danger">
        <g:each in="${errorsList}">
            <g:renderErrors bean="${it}" as="list"/>
        </g:each>
    </div>
</g:if>
<g:if test="${flash.success}">
    <div class="alert alert-success alert-dismissable">
        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
        <g:message code="${flash.success}" args="${flash.successArgs}"/>
        <% flash.success = null %>
        <% flash.successArgs = null %>
    </div>
</g:if>

<g:if test="${flash.message}">
    <div class="alert alert-info alert-dismissable">
        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
        <g:message code="${flash.message}" args="${flash.messageArgs}"/>
        <% flash.message = null %>
        <% flash.messageArgs = null %>
    </div>
</g:if>

<g:if test="${flash.error}">
    <div class="alert alert-danger alert-dismissable">
        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
        <g:message code="${flash.error}" args="${flash.errorArgs}"/>
        <% flash.error = null %>
        <% flash.errorArgs = null %>
    </div>
</g:if>