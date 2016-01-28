<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main">
    <title></title>
</head>

<body>
    <div class="container">
        <h1>Register new account</h1>

        <g:hasErrors>
            <g:eachError><div class="alert alert-danger"><g:message error="${it}"/></div></g:eachError>
        </g:hasErrors>

        <g:form url="${createLink(action: 'register')}" >
            <div class="row well">
                <g:render template="/common/formField" model="[
                        errorBean: 'account',
                        errorField: 'username',
                        formLabel: 'Username',
                        formName: 'account.username',
                        value: account?.username
                ]" />
                <g:render template="/common/formField" model="[
                        errorBean: 'account',
                        errorField: 'emailAddress',
                        formLabel: 'Email address',
                        formName: 'account.emailAddress',
                        value: account?.emailAddress
                ]" />
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
            <div class="row well">

                <g:render template="/common/formField" model="[
                        formLabel: 'Character name',
                        formName: 'characterName'
                ]" />

            </div>

            <a href="${createLink(controller: 'login')}" class="btn btn-default">Back</a>
            <button class="btn btn-success">Create</button>
        </g:form>
    </div>
</body>
</html>