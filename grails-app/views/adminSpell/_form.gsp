<%@ page import="pl.tenerowicz.mmoarena.Spell" %>

<div class="container">
    <f:field bean="${spellInstance}" property="name"/>
    <f:field bean="${spellInstance}" property="damage"/>

    <f:field bean="${spellInstance}" property="prefabType"/>
    <f:field bean="${spellInstance}" property="cooldownTime"/>

    <f:field bean="${spellInstance}" property="coinCost"/>
    <f:field bean="${spellInstance}" property="requiredLevel"/>
</div>