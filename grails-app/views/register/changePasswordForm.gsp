<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main">
    <title></title>
</head>

<body>
<div class="container">
    <h1>Change password</h1>

    <g:hasErrors>
        <g:eachError><div class="alert alert-danger"><g:message error="${it}"/></div></g:eachError>
    </g:hasErrors>

    <g:form url="${createLink(action: 'changePassword')}" >
        <div class="row well">
            <input class="hidden" name="account.id" value="${accountId}" />
            <input class="hidden" name="token" value="${token}" />

            <g:render template="/common/formField" model="[
                    errorBean: 'account',
                    errorField: 'password',
                    formLabel: 'Password',
                    formName: 'account.password',
                    formType: 'password'
            ]" />
            <g:render template="/common/formField" model="[
                    errorBean: 'account',
                    errorField: 'password',
                    formLabel: 'Confirm password',
                    formName: 'passwordConfirm',
                    formType: 'password'
            ]" />
        </div>
        <a href="${createLink(controller: 'login')}" class="btn btn-default">Back</a>
        <button class="btn btn-success">${message(code: 'default.button.create.label', default: 'Change password')}</button>
    </g:form>
</div>
</body>
</html>