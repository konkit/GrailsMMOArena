<%--
  Created by IntelliJ IDEA.
  User: konkit
  Date: 2014-10-21
  Time: 18:25
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main">
    <title></title>
</head>

<body>
    <div class="row">
        <div class="col-md-6 well">
            <h2>Equiped items : </h2>
            <g:render template="equipTable" model="[itemList: equipedItems]"/>
        </div>

        <div class="col-md-6 well">
            <h2>Unequiped items : </h2>
            <g:render template="equipTable" model="[itemList: unequipedItems]"/>
        </div>
    </div>

    <h2>Buy items : </h2>
    <g:render template="buyItem" model="[itemList: allItems]"/>
</body>
</html>