package pl.tenerowicz.mmoarena.commands

import grails.validation.Validateable
import pl.tenerowicz.mmoarena.Account
import pl.tenerowicz.mmoarena.AccountRegisterToken
import pl.tenerowicz.mmoarena.AccountRole
import pl.tenerowicz.mmoarena.Player
import pl.tenerowicz.mmoarena.Role

/**
 * Created by konkit on 2014-09-07.
 */
class RegisterNewUserCommand implements Validateable {
    Account account

    String characterName
    String passwordConfirm

    static constraints = {
        account validator: { val, obj ->
            if( obj.passwordConfirm != val.password) {
                return 'passwordMismatch'
            }

            val.validate()
        }
    }

    def beforeValidate() {

    }

    def execute() {
        Account.withTransaction {
            if( hasErrors() ) {
                return false
            }

            account.save(failOnError: true)
            Player.createCharacter(characterName, account)

            def userRole = Role.findByAuthority("ROLE_USER") ?: new Role(authority: "ROLE_USER").save(failOnError: true)
            AccountRole.create(account, userRole)

            println "Sending email to " + account.emailAddress

            def accountToken = new AccountRegisterToken(account: account);
            accountToken.save();
        }
    }
}
