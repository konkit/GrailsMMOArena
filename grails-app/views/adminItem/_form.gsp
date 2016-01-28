<%@ page import="pl.tenerowicz.mmoarena.Item" %>

<div class="container">
    <f:field bean="${itemInstance}" property="name"/>

    <f:field bean="${itemInstance}" property="attackBonus"/>
    <f:field bean="${itemInstance}" property="defenceBonus"/>

    <f:field bean="${itemInstance}" property="requiredLevel"/>
    <f:field bean="${itemInstance}" property="coinCost"/>
</div>





