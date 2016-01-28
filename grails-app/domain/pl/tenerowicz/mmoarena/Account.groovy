package pl.tenerowicz.mmoarena

class Account {

	transient springSecurityService

	String username
	String password

    String emailAddress

	boolean enabled = true
	boolean accountExpired
	boolean accountLocked = true
	boolean passwordExpired

	static transients = ['springSecurityService']

	static constraints = {
		username blank: false, unique: true
		password blank: false
	}

	static mapping = {
		password column: '`password`'
	}

	Set<Role> getAuthorities() {
		AccountRole.findAllByAccount(this).collect { it.role }
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

    def getCharacter() {
        return Player.findByAccount(this)
    }

	protected void encodePassword() {
		password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
	}

	def disable() {
		accountLocked = true
	}

	def enable() {
		accountLocked = false
	}
}
