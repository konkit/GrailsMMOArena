package pl.tenerowicz.mmoarena.commands

import grails.transaction.Transactional
import grails.validation.Validateable
import pl.tenerowicz.mmoarena.Account
import pl.tenerowicz.mmoarena.AccountRegisterToken

/**
 * Created by konkit on 29.11.14.
 */
class ConfirmTokenCommand implements Validateable {
    String token
    Long accountId

    protected Account account

    void beforeValidate() {

    }

    @Transactional
    void execute() {
        account = Account.get(accountId)

        if( account == null ) {
            throw new Exception()
        }

        AccountRegisterToken registerTokenObj = AccountRegisterToken.findByTokenAndAccount(token, account)

        if( registerTokenObj == null ) {
            throw new Exception()
        }

        registerTokenObj.delete()

        account.enable()
        account.save(failOnError: true)
    }
}
