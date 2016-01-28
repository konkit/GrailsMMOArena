
<%@ page import="pl.tenerowicz.mmoarena.Message" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<title>Fight</title>

        <script type="text/javascript" >
            var unitySrc = "${ asset.assetPath(src: 'unity/Web.unity3d') }";
            var afterFightUrl = "${ createLink(controller: 'character', action:'index')}"
        </script>

        <asset:javascript src="application.js" />
		<asset:javascript src='UnityObject2.js' />
		<asset:javascript src='unitywebplayer.js' />
        <asset:stylesheet src="unitywebplayer.css" />
	</head>
	<body>
		<div class="content">
			<div id="unityPlayer">
				<div class="missing">
					<a href="http://unity3d.com/webplayer/" title="Unity Web Player. Install now!">
						<img alt="Unity Web Player. Install now!" src="http://webplayer.unity3d.com/installation/getunity.png" width="193" height="63" />
					</a>
				</div>
				<div class="broken">
					<a href="http://unity3d.com/webplayer/" title="Unity Web Player. Install now! Restart your browser after install.">
						<img alt="Unity Web Player. Install now! Restart your browser after install." src="http://webplayer.unity3d.com/installation/getunityrestart.png" width="193" height="63" />
					</a>
				</div>
			</div>
		</div>
	</body>
</html>
