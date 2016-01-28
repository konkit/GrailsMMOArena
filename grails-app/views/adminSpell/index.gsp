
<%@ page import="pl.tenerowicz.mmoarena.Item" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'spell.label', default: 'Spell')}" />
    <title>Spells</title>
</head>
<body>
<div class="nav" role="navigation">
    <button class="btn" >
        <g:link class="create" action="create">Create new Spell</g:link>
    </button>
</div>
<div id="list-spell" class="content scaffold-list" role="main">
    <h1>Spells</h1>

    <table class="table">
        <thead>
        <tr>
            <g:sortableColumn property="name" title="${message(code: 'spell.name.label', default: 'Name')}" />
            <g:sortableColumn property="damage" title="${message(code: 'spell.damage.label', default: 'Damage')}" />
            <g:sortableColumn property="prefabType" title="${message(code: 'spell.prefabType.label', default: 'Prefab Type')}" />
            <g:sortableColumn property="cooldown" title="${message(code: 'spell.cooldownType.label', default: 'Cooldown time')}" />

            <td></td>
            <td></td>
        </tr>
        </thead>
        <tbody>
        <g:each in="${spellInstanceList}" status="i" var="spellInstance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                <td>
                    ${fieldValue(bean: spellInstance, field: "name")}
                </td>
                <td>
                    ${fieldValue(bean: spellInstance, field: "damage")}
                </td>
                <td>
                    ${fieldValue(bean: spellInstance, field: "prefabType")}
                </td>
                <td>
                    ${fieldValue(bean: spellInstance, field: "cooldownTime")}
                </td>
                <td>
                    <g:link action="edit" id="${spellInstance.id}">
                        <button class="btn">Edit</button>
                    </g:link>
                </td>
                <td>
                    <button class="btn btn-danger">Remove</button>
                </td>
            </tr>
        </g:each>
        </tbody>
    </table>
    <div class="pagination">
        <g:paginate total="${spellInstanceCount ?: 0}" />
    </div>
</div>
</body>
</html>
