package pl.tenerowicz.mmoarena.commands

import grails.validation.Validateable
import pl.tenerowicz.mmoarena.Account
import pl.tenerowicz.mmoarena.AccountPasswordRecovery

/**
 * Created by konkit on 29.11.14.
 */
class SendPasswordRecoveryEmailCommand implements Validateable {
    String email

    def execute() {
        Account account = Account.findByEmailAddress(email);
        if( account == null ) {
            throw new Exception("No such account");
        }

        AccountPasswordRecovery accountPasswordRecovery = new AccountPasswordRecovery(account: account)
        accountPasswordRecovery.save(failOnError: true)
    }
}
