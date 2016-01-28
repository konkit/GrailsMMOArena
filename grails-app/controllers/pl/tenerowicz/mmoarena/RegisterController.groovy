package pl.tenerowicz.mmoarena

import groovy.transform.CompileStatic
import pl.tenerowicz.mmoarena.commands.ChangePasswordCommand
import pl.tenerowicz.mmoarena.commands.ConfirmTokenCommand
import pl.tenerowicz.mmoarena.commands.RegisterNewUserCommand
import pl.tenerowicz.mmoarena.commands.SendPasswordRecoveryEmailCommand

import org.springframework.security.access.annotation.Secured

import javax.xml.bind.ValidationException

@Secured(['permitAll'])
@CompileStatic
class RegisterController {

    def index() {
        [errors: flash.errorList]
    }

    def register(RegisterNewUserCommand cmd) {
        try {
            if (!cmd.execute()) {
                throw new ValidationException('Validation error')
            }
            flash.success = "Register successful, please confirm your email"
            return redirect(action: 'registerSuccess')
        }catch(ValidationException e) {
            flash.errorList = cmd.errors
            return redirect(action: 'index')
        }catch(Exception e) {
			flash.error = e.message
            println "Exception occured : class : " + e.class + ", message : " + e.message
            return redirect(action:'index')
        }
    }

    def registerSuccess() {

    }

    def registerConfirm(ConfirmTokenCommand cmd) {
        try {
            cmd.execute()
            render(view: 'registerConfirmSuccess')
        }catch(Exception e) {
            render(view: 'registerConfirmError', model: [errorMsg: e.message])
        }
    }

    def passwordRecoveryForm() {
        return []
    }

    def sendPasswordRecovery(SendPasswordRecoveryEmailCommand cmd) {
        try {
            cmd.execute()
            flash.success = "Email with password recovery sent"
        }catch(Exception e) {
            flash.error = "Error occured : " + e.message
        }
    }

    def changePasswordForm(Long accountId, String token) {
        return [accountId: accountId, token: token]
    }

    def changePassword(ChangePasswordCommand cmd) {
        try {
            cmd.execute()
            flash.success = "Email with password recovery sent"
        }catch(Exception e) {
            flash.error = "Error occured : " + e.message
        }
    }
}

