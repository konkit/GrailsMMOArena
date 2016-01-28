package pl.tenerowicz.mmoarena

import grails.converters.JSON
import grails.converters.XML
import pl.tenerowicz.mmoarena.exception.NoCurrentFightException
import pl.tenerowicz.mmoarena.fight.FightAwards
import pl.tenerowicz.mmoarena.fight.FightResult

import org.springframework.security.access.annotation.Secured

//@Secured('hasRole("ROLE_USER")')
@Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
class FightController {
    def springSecurityService
	FightService fightService

    /**
     * On this action a game webplayer is rendered
     */
    def index() {
        // webplayer rendering
	}

    def indexws() {
        // webplayer rendering
    }

    def getPlayerData(Long id) {
        Player character = Player.get(id) ?: getCurrentPlayer()

        XML.use('deep')
        render( character as XML )
    }

    def getPlayerDataJson(Long id) {
        Player character = Player.get(id) ?: getCurrentPlayer()

        JSON.use('deep')
        render( character as JSON )
    }

    /**
     * This is run AFTER the fight.
     * @param fightResult results of the fight (health left, items used, etc)
     * @return FightAwards object which has info f. e. about earned xp.
     */
	def storeResults(FightResult fightResult) {
		try {
			FightAwards awards = fightService.endFight(fightResult)
            return render( awards as XML )
		} catch (NoCurrentFightException e) {
            println "No current fight exception"
        } catch (Exception e) {
			println "An exception occured : " + e.class + ", message : " + e.message
            FightAwards awards = new FightAwards(error: "Exception occured : " + e.class + ", message : " + e.message)
            return render( awards as XML )
		}
	}

    private Player getCurrentPlayer() {
        Account acc = springSecurityService.currentUser ?: Account.findByUsername("user")
        return acc.character
    }
}
