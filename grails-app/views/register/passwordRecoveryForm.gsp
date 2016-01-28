<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main">
    <title></title>
</head>

<body>
    <div class="container">
        <h1>Forgotten password ?</h1>

        <g:form url="${createLink(action: 'sendPasswordRecovery')}" >
        <div class="row well">
            <div class="row">
                <div class=" col-md-3 fieldcontain required">
                    <label for="email">
                        Email
                    </label>
                </div>

                <div class="col-md-9">
                    <g:field name="email" type="text" class="form-control" value="${email}" required=""/>
                </div>
            </div>
        </div>

        <a href="${createLink(controller: "login")}" class="btn btn-default">Go back</a>
        <button class="btn btn-success">Send request</button>

        </div>
    </g:form>
</body>
</html>