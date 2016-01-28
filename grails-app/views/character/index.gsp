<%@ page import="pl.tenerowicz.mmoarena.Player" %>
<html>
	<head>
        <meta name="layout" content="main">

        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.8/angular.min.js"></script>
	</head>
	<body>
        <div class="col-md-3" >
            <div class="well" style="min-height: 510px;">
                <g:render template="characterStatsDisplay" model="[cntCharacter: cntCharacter]"/>
            </div>
        </div>

        <div class="col-md-6 ">
            <div class="row well" style="min-height: 75px;">
                <a href="${createLink(controller: 'fight', action: 'indexws')}">
                    <button class="btn btn-primary btn-block">Fight</button>
                </a>
            </div>

            <div class="row well" style="min-height: 200px;" >
                <div class="col-md-6">
                    <g:render template="spellDisplay" />
                </div>
                <div class="col-md-6">
                    <g:render template="itemDisplay" />
                </div>
            </div>

            <div class="row well" style="min-height: 195px;">
                <g:render template="angularChatWindow"/>
            </div>
        </div>

        <div class="col-md-3" >
            <div class="well" style="min-height: 510px;">
                <g:render template="resourcesDisplay" model="[cntCharacter: cntCharacter]"/>
            </div>
        </div>

	</body>
</html>