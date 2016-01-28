<table class="table">
    <thead>
    <tr>
        <td>Spell name</td>
        <td>Coins</td>
        <td></td>
    </tr>
    </thead>
    <tbody>
    <g:each in="${spellList}" status="i" var="spell">
        <tr>
            <td>
                ${spell.name}
            </td>
            <td>
                ${spell.coinCost}
            </td>
            <td>
                <g:link action="buy" id="${spell.id}">
                    <button class="btn">Buy</button>
                </g:link>
            </td>
        </tr>
    </g:each>
    </tbody>
</table>