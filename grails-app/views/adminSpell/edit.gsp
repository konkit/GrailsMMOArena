<%@ page import="pl.tenerowicz.mmoarena.Item" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'item.label', default: 'Item')}" />
    <title><g:message code="default.edit.label" args="[entityName]" /></title>
</head>
<body>
<a href="${createLink(action:"index")}" class="skip" tabindex="-1">
    <button class="btn button" value="message(code: 'default.link.skip.label">
        <g:message code="default.link.skip.label" default="Skip to content&hellip;"/>
    </button>
</a>

<div id="edit-item" class="container" role="main">
    <h1><g:message code="default.edit.label" args="[entityName]" /></h1>

    <g:form action="update" id="${spellInstance.id}" method="PUT" >
        <fieldset class="form">
            <g:render template="form"/>
        </fieldset>
        <fieldset class="buttons">
            <button type="submit" class="btn" action="update">Update</button>
        </fieldset>
    </g:form>
</div>
</body>
</html>
