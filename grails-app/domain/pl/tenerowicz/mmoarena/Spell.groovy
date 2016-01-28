package pl.tenerowicz.mmoarena

class Spell {
	String name
	Long damage

	Long prefabType
	Long cooldownTime

    Long coinCost
    Long requiredLevel
	
    static constraints = {
    }

    static List getStartingSpells() {
        return Spell.findAllByRequiredLevel(1)
    }
}
