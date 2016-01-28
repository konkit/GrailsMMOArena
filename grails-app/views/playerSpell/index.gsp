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
            <h2>Equiped spells : </h2>
            <g:render template="equipTable" model="[spellList: equipedSpells]"/>
        </div>

        <div class="col-md-6 well">
            <h2>Unequiped spells : </h2>
            <g:render template="equipTable" model="[spellList: unequipedSpells]"/>
        </div>
    </div>

    <h2>Buy a spell</h2>
    <g:render template="buySpell" model="[spellList: allSpells]" />
</body>
</html>