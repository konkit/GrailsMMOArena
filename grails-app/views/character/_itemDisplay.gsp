<div class="col-md-12">
    <h3>Items : </h3>

    <table>
        <thead>
            <tr>
                <th style="width: 100px;">Item name</th>
            </tr>
        </thead>
        <tbody>
            <g:each in="${items}" status="i" var="itemPossessionInstance">
                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                    <td>${itemPossessionInstance.item.name}</td>
                </tr>
            </g:each>
        </tbody>
    </table>

    <a href="${createLink(controller: "playerItem")}">
        <button class="btn">Edit items</button>
    </a>
</div>
