package pl.tenerowicz.mmoarena.commands

import grails.compiler.GrailsCompileStatic
import grails.validation.Validateable
import pl.tenerowicz.mmoarena.Account
import pl.tenerowicz.mmoarena.AccountPasswordRecovery

/**
 * Created by konkit on 29.11.14.
 */
@GrailsCompileStatic
class ChangePasswordCommand implements Validateable {
    Account account
    String passwordConfirm

    String token

    def execute() {
        if( account == null ) {
            throw new Exception()
        }

        AccountPasswordRecovery tokenObj = AccountPasswordRecovery.findByTokenAndAccount(token, account)

        if( tokenObj == null ) {
            throw new Exception()
        }

        tokenObj.delete()

        if( passwordConfirm != account.password ) {
            throw new Exception("PasswordsAreDifferent")
        }

        account.save(failOnError: true)
    }
}
