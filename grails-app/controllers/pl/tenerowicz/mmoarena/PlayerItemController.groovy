package pl.tenerowicz.mmoarena

import org.springframework.security.access.annotation.Secured

@Secured('hasRole("ROLE_USER")')
class PlayerItemController {
    def itemService
    def springSecurityService

    def index() {
        List<ItemPossession> equipedItems = ItemPossession.findAllByIsEquipedAndItemOwner(true, getCurrentPlayer() )
        List<ItemPossession> unequipedItems = ItemPossession.findAllByIsEquipedAndItemOwner(false, getCurrentPlayer() )
        List<ItemPossession> allItems = Item.list()

        return[equipedItems: equipedItems, unequipedItems: unequipedItems, allItems: allItems]
    }

    def equip(ItemPossession itemPossession) {
        itemService.equipItem(itemPossession)
        redirect(action: "index")
    }

    def unequip(ItemPossession itemPossession) {
        itemService.unequipItem(itemPossession)
        redirect(action: "index")
    }

    def buy(Item item) {
        itemService.buyItem(item)
        redirect(action: "index")
    }

    private Player getCurrentPlayer() {
        Account acc = springSecurityService.currentUser ?: Account.findByUsername("user")
        return acc.character
    }
}
