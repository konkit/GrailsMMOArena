package pl.tenerowicz.mmoarena

class Item {
	String name

    Long attackBonus
    Long defenceBonus

    Long coinCost
    Long requiredLevel

    static constraints = {
        name nullable: false
        coinCost validator: {
            return it > 0
        }
    }

    static List<Item> notPossessed(Player player) {
        def possessedItemsIds = ItemPossession.findAllByItemOwner(player).collect { poss -> poss.item.id }
        def c = Item.createCriteria();
        return c.list {
            not {'in'("id", possessedItemsIds)}
        }
    }
	
}
