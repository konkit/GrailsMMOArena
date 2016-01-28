<%@ page import="pl.tenerowicz.mmoarena.Player" %>
<p>Name : ${cntCharacter?.name }</p>
<p>Level : ${cntCharacter?.level }</p>
<p>Exp : ${cntCharacter?.exp } / ${ Player.getExpForLevel(cntCharacter?.level)}</p>

<div class="progress">
    <div class="progress-bar" role="progressbar" aria-valuenow="${ (cntCharacter?.exp /  Player.getExpForLevel(cntCharacter?.level) * 100).toInteger()}" aria-valuemin="0" aria-valuemax="100" style="width: ${ (cntCharacter?.exp /  Player.getExpForLevel(cntCharacter?.level) * 100).toInteger()}%;"></div>
</div>