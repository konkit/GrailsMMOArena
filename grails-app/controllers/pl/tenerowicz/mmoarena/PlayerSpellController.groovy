package pl.tenerowicz.mmoarena

import grails.transaction.Transactional

import org.springframework.security.access.annotation.Secured

@Secured('hasRole("ROLE_USER")')
class PlayerSpellController {
    def springSecurityService

    def index() {
        List<SpellPossession> equipedSpells = SpellPossession.findAllByIsEquipedAndSpellOwner(true, getCurrentPlayer() )
        List<SpellPossession> unequipedSpells = SpellPossession.findAllByIsEquipedAndSpellOwner(false, getCurrentPlayer() )
        List<Spell> allSpells = Spell.list()

        println allSpells

        return[equipedSpells: equipedSpells, unequipedSpells: unequipedSpells, allSpells: allSpells]
    }

    def equip(SpellPossession spellPossession) {
        spellPossession.equip()
        redirect(action: "index")
    }

    def unequip(SpellPossession spellPossession) {
        spellPossession.unequip()
        redirect(action: "index")
    }

    @Transactional
    def buy(Spell spell) {
        Player character = getCurrentPlayer()

        if( SpellPossession.findAllBySpellAndSpellOwner(spell, character).size() > 0) {
            flash.error = "Spell already owned"
            return redirect(action: "index")
        }

        if( character.coins - spell.coinCost < 0) {

            flash.error = "Not enough coins or crystals"
            return redirect(action: "index")
        }

        if( character.level < spell.requiredLevel ) {
            flash.error = "Not enough level"
            return redirect(action: "index")
        }

        character.coins -= spell.coinCost
        character.save(flush: true)

        character.addSpell(spell)

        redirect(action: "index")
    }

    private Player getCurrentPlayer() {
        Account acc = springSecurityService.currentUser ?: Account.findByUsername("user")
        return acc.character
    }
}
