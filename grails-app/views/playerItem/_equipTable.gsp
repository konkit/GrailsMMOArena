<table class="table">
    <thead>
    <tr>
        <td></td>
        <td></td>
    </tr>
    </thead>
    <tbody>
    <g:each in="${itemList}" status="i" var="poss">
        <tr>
            <td>
                ${poss.item.name}
            </td>
            <td>
                <g:if test="${!poss.isEquiped}">
                    <g:link action="equip" id="${poss.id}">
                        <button class="btn">Equip</button>
                    </g:link>
                </g:if>
                <g:else>
                    <g:link action="unequip" id="${poss.id}">
                        <button class="btn">Unequip</button>
                    </g:link>
                </g:else>
            </td>
        </tr>
    </g:each>
    </tbody>
</table>