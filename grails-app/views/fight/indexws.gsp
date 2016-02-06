
<%@ page import="pl.tenerowicz.mmoarena.Message" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <title>Fight</title>

    <script src="https://cdn.socket.io/socket.io-1.3.4.js"></script>

    <script type="text/javascript" >
        var unitySrc = "${ asset.assetPath(src: 'unity/Web.unity3d') }";
        var afterFightUrl = "${ createLink(controller: 'character', action:'index')}"

        var playerData

        $.ajax({
            url: "getPlayerDataJson"
        }).done(function(data) {
            playerData = data;
            requestFight(playerData.id);
        });



        var socket = io.connect('http://127.0.0.1:5000');

        socket.on('message', function(data){
            console.log(data.message);
        });

        socket.on('requestCreated', function(data) {
            $('#js-status').append('Request created, id: ' + data.requestId + '\n');
        })

        socket.on('fightFound', function(data) {
            $('#js-status').append('Fight found: ' + JSON.stringify(data) + '\n' );

            $.ajax({
                url: "getPlayerData"
            }).done(function(playerData) {
                console.log("Player data:");
                console.log(playerData);

                u.getUnity().SendMessage("ScriptHolder", "SetPlayer", new XMLSerializer().serializeToString(playerData));

                $.ajax({
                    url: "getPlayerData/" + data.enemyId.toString()
                }).done(function(enemyData) {
                    console.log("Enemy data:");
                    console.log(enemyData);

                    u.getUnity().SendMessage("ScriptHolder", "SetEnemy",  new XMLSerializer().serializeToString(enemyData));

                    u.getUnity().SendMessage("ScriptHolder", "StartGame", data.roomId.toString() );
                });
            });


        })

        function requestFight() {
            socket.emit('fightRequest', {'playerId': playerData.id});
        }



    </script>

    <asset:javascript src="application.js" />
    <asset:javascript src='UnityObject2.js' />
    <asset:javascript src='unitywebplayer.js' />
    <asset:stylesheet src="unitywebplayer.css" />
</head>
<body>
<textarea id="js-status" style="width: 500px; height: 100px;">

</textarea>

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
