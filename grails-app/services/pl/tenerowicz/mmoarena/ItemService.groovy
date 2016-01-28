package pl.tenerowicz.mmoarena

import grails.transaction.Transactional
import pl.tenerowicz.mmoarena.exception.NotEnoughCoinsException

@Transactional
class ItemService {
    def sellItem(Item item) {
		Player character = getCurrentPlayer()
		character.coins += item.coinCost
		character.save()
		addItem(character, item, (Long)-1)
    }

    def buyItem(Item item) {
    	Player character = getCurrentPlayer()
		if( character.coins < item.coinCost ) {
			throw new NotEnoughCoinsException()
		}
		
		character.coins -= item.coinCost
		addItem(character, item, (Long)1)
    }
	
	def equipItem(ItemPossession itemPossession) {
        itemPossession.isEquiped = true;
        itemPossession.save()
	}
	
	def unequipItem(ItemPossession itemPossession) {
		itemPossession.isEquiped = false;
        itemPossession.save()
	}

    private Player getCurrentPlayer() {
        Account acc = springSecurityService.currentUser
        return acc.character
    }
	
	private def addItem(Player cntCharacter, Item cntItem, Long cntQuantity) {
		ItemPossession hasItem = ItemPossession.findByItemOwnerAndItem(cntCharacter, cntItem)
		
		if(hasItem != null ) {
			hasItem.amount += cntQuantity;
			
			if( hasItem.amount <= 0) {
				hasItem.delete()
			} else {
				hasItem.save()
			}
		} else {
			hasItem = new ItemPossession(itemOwner: cntCharacter, item: cntItem, amount:cntQuantity, isEquiped:false);
			hasItem.save()
		}
	}
}
