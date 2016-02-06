package pl.tenerowicz.mmoarena

import grails.converters.JSON
import org.springframework.security.access.annotation.Secured

@Secured('hasRole("ROLE_USER")')
class PlayerItemController {
    def itemService
    def springSecurityService

    def index() {
        List<ItemPossession> equippedItems = ItemPossession.findAllByIsEquipedAndItemOwner(true, getCurrentPlayer() )
        List<ItemPossession> unequippedItems = ItemPossession.findAllByIsEquipedAndItemOwner(false, getCurrentPlayer() )
        List<ItemPossession> allItems = Item.list()

        return[equippedItems: equippedItems, unequippedItems: unequippedItems, allItems: allItems]
    }

    def indexJson() {
        List<Item> equippedItems = ItemPossession.findAllByIsEquipedAndItemOwner(true, getCurrentPlayer() )
                                                 .collect { poss -> poss.item }
        List<Item> unequippedItems = ItemPossession.findAllByIsEquipedAndItemOwner(false, getCurrentPlayer() )
                                                   .collect { poss -> poss.item }
        List<Item> otherItems = Item.notPossessed(getCurrentPlayer())

        render(["equippedItems": equippedItems, "unequippedItems": unequippedItems, "otherItems": otherItems] as JSON)
    }

    def equip(ItemPossession itemPossession) {
        itemService.equipItem(itemPossession)
        redirect(action: "index")
    }

    def equipJson(Item item) {
        itemService.equipItem(ItemPossession.findByItemAndItemOwner(item, getCurrentPlayer()))
        render status: 200
    }

    def unequip(ItemPossession itemPossession) {
        itemService.unequipItem(itemPossession)
        redirect(action: "index")
    }

    def unequipJson(Item item) {
        itemService.unequipItem(ItemPossession.findByItemAndItemOwner(item, getCurrentPlayer()))
        render status: 200
    }

    def buy(Item item) {
        itemService.buyItem(item)
        redirect(action: "index")
    }

    def buyJson(Item item) {
        itemService.buyItem(item)
        render status: 200
    }

    private Player getCurrentPlayer() {
        Account acc = springSecurityService.currentUser ?: Account.findByUsername("user")
        return acc.character
    }
}
