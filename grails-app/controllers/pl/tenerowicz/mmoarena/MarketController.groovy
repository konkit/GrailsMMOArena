package pl.tenerowicz.mmoarena

import org.springframework.security.access.annotation.Secured

@Secured('hasRole("ROLE_USER")')
class MarketController {
	ItemService itemService
	
    def index() { 
		redirect(action: 'buy')
	}
	
	def buy() {
		return [allItems: Item.list(), coins: getCurrentPlayer().coins]
	}
	
	def sell() {	
		return [playerItems: getCurrentPlayer().items, coins: getCurrentPlayer().coins]
	}
	
	def sellItem(Item item) {
		itemService.sellItem(item)
		
		redirect(action: 'sell')
	}
	
	def buyItem(Item item) {		
		itemService.buyItem(item)
		
		redirect(action: 'buy')
	}
	
	private Player getCurrentPlayer() {
		Account acc = springSecurityService.currentUser
        return acc.character
	}
}
