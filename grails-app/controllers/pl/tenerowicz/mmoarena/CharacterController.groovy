package pl.tenerowicz.mmoarena

import org.springframework.security.access.annotation.Secured

@Secured('hasRole("ROLE_USER")')
class CharacterController {

    def springSecurityService

    def index() {
        return [
                cntCharacter: getCurrentPlayer(),
                items: getCurrentPlayer().items,
                spells: getCurrentPlayer().spells
        ]
    }

    private Player getCurrentPlayer() {
        Account acc = springSecurityService.currentUser
        return acc.character
    }
}
