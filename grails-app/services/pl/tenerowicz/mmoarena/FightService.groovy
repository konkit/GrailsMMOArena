package pl.tenerowicz.mmoarena

import grails.transaction.Transactional
import pl.tenerowicz.mmoarena.fight.FightAwards
import pl.tenerowicz.mmoarena.fight.FightResult

@Transactional
class FightService {

	def endFight(FightResult fightResult) {
        def fightAwards = new FightAwards()

        if( fightResult == null ) {
            throw new NullPointerException("FightResult object is null")
        }

		if( fightResult.playerHealthRemained > fightResult.enemyHealthRemained ) {
            fightAwards.expEarned = 10
            fightAwards.hasWon = true

			Player player = getCurrentPlayer()
			player.addExp(fightAwards.expEarned)
			player.save()
		} else {
            fightAwards.expEarned = 0
            fightAwards.hasWon = false
        }

        return fightAwards
	}

    private Player getCurrentPlayer() {
        Account acc = springSecurityService.currentUser ?: Account.findByUsername('user');
        return acc.character
    }
}
