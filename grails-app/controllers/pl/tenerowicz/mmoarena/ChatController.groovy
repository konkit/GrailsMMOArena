package pl.tenerowicz.mmoarena

import org.grails.web.json.JSONObject
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo

class ChatController {

    @MessageMapping("/wschat1")
    @SendTo("/topic/wschat")
    protected String wschat(JSONObject jsonObject) {
        println "Name: ${jsonObject.get('name')}";
        println "Text: ${jsonObject.get('text')}";
        String response = "${jsonObject.get('name')}: ${jsonObject.get('text')}";
        return response;
    }
}
