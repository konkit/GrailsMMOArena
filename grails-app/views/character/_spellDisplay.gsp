<div class="col-md-12">
    <h3>Spells : </h3>

    <table>
        <thead>
            <tr>
                <th style="width: 100px;">Spell name</th>
                %{--<th>Damage</th>--}%
            </tr>
        </thead>
        <tbody>
            <g:each in="${spells}" status="i" var="spellPossessionInstance">
                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                    <td>${spellPossessionInstance.spell.name}</td>
                    %{--<td>${spellPossessionInstance.spell.damage}</td>--}%
                </tr>
            </g:each>
        </tbody>
    </table>

    <a href="${createLink(controller: "playerSpell")}">
        <button class="btn">Edit spells</button>
    </a>
</div>