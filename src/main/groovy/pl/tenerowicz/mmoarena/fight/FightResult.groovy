package pl.tenerowicz.mmoarena.fight

import grails.validation.Validateable

/**
 * Object sent back from user to server after fight.
 * @author konkit
 *
 */
class FightResult implements Validateable {
	int playerHealthRemained
	int enemyHealthRemained
	
	//List<Item> playerItemsUsed
	//List<Item> enemyItemsUsed
}
