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
	
}
