package pl.tenerowicz.mmoarena

class Message {

	Player sender
	Player receiver
	
	String topic
	String content
	
	Boolean isRead
	
    static constraints = {
		sender nullable:false
		receiver nullable:false
		topic nullable:false
		content nullable:false
    }
}
