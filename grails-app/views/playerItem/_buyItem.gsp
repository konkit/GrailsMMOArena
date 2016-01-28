<table class="table">
    <thead>
    <tr>
        <td></td>
        <td></td>
    </tr>
    </thead>
    <tbody>
    <g:each in="${itemList}" status="i" var="item">
        <tr>
            <td>
                ${item.name}
            </td>
            <td>
                <g:link action="buy" id="${item.id}">
                    <button class="btn">Buy</button>
                </g:link>
            </td>
        </tr>
    </g:each>
    </tbody>
</table>