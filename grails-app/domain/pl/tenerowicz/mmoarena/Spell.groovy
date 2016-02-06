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

    static List<Item> notPossessed(Player player) {
        def possessedSpellIds = SpellPossession.findAllBySpellOwner(player).collect { poss -> poss.spell.id }
        def c = Spell.createCriteria();
        return c.list {
            not {'in'("id", possessedSpellIds)}
        }
    }
}
