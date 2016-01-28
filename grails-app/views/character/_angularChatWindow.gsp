<asset:javascript src="spring-websocket" />

<style>
#chatbox {
    text-align:left;
    margin:0 auto;
    margin-bottom:25px;
    padding:10px;
    background:#222222;
    height:100px;
    width:530px;
    border:1px solid #ACD8F0;
    overflow: auto;
}
</style>

<div ng-controller="ChatController">
    %{--<div style="overflow: auto; height: 145px;">--}%
        %{--<p ng-repeat="message in messages">{{message}}</p>--}%
    %{--</div>--}%

    <div id="chatbox" >
        <span ng-repeat="message in messages">{{message}}<br/></span>

    </div>


    <form ng-submit="sendMessage()" style="margin-bottom: 0em;">
        <input type="text" ng-model="messageText" placeholder="Type your message here" style="width: 460px;"/>
        <input class="btn" type="submit" value="Send" />
    </form>
</div>

<script>
    if(typeof angular == 'undefined') {
        alert("Angular is NOT working")
    }

    (function() {
        var socket = new SockJS("${createLink(uri: '/stomp')}");
        var client = Stomp.over(socket);

        var app = angular.module('mmoarena', []);
        app.controller('ChatController', ['$scope', function($scope){
            $scope.messages = [];
            $scope.characterName = "${cntCharacter.name}";

            client.connect({}, function() {
                client.subscribe("/topic/wschat", function(message) {
                    console.log("Received message from /chat/wschat")
                    $scope.messages.push(message.body);
                    $scope.$apply();

                    var objDiv = document.getElementById("chatbox");
                    objDiv.scrollTop = objDiv.scrollHeight;
                });
            });

            $scope.sendMessage = function() {
                if( $scope.messageText.length < 1) {
                    return;
                }

                client.send("/app/wschat1", {}, JSON.stringify(
                        {name: $scope.characterName, text: $scope.messageText}
                ));
                console.log("message sent");
                $scope.messageText = "";
            }
        }]);
    })();
</script>