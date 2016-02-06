package pl.tenerowicz.mmoarena

import grails.converters.JSON
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

    def indexJson() {
        render([
            character: getCurrentPlayer(),
            items: getCurrentPlayer().equipedItems.collect { poss -> poss.item },
            spells: getCurrentPlayer().equipedSpells.collect { poss -> poss.spell }
        ] as JSON)
    }

    private Player getCurrentPlayer() {
        Account acc = springSecurityService.currentUser
        return acc.character
    }
}
