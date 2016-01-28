package pl.tenerowicz.mmoarena

import grails.validation.Validateable

class SendMessageCommand implements Validateable {
	Message message;
    String receiverName
	Player currentCharacter
	
	static constraints = {

	}

	boolean execute() {
        if( !validate() || hasErrors() ) {
            throw new Exception("Errors")
        }

		if( currentCharacter == null) {
			throw new Exception("Not logged in")
		}

        message.receiver = Player.findByName(receiverName)
        if( message.receiver == null) {
            errors.rejectValue('receiverName')
            throw new Exception("Player not found")
        }
		
		message.sender = currentCharacter
		message.isRead = false

		message.save(flush: true);
	}
}


