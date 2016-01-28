package pl.tenerowicz.mmoarena

class SpellPossession {
	
	Spell spell

    boolean isEquiped = false;

	static belongsTo = [spellOwner: Player]
	
	static constraints = {
	}

    void equip() {
        this.isEquiped=true
        this.save(flush: true)
    }

    void unequip() {
        this.isEquiped=false
        this.save(flush: true)
    }
}
