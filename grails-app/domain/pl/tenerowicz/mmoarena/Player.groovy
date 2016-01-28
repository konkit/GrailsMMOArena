package pl.tenerowicz.mmoarena

class Player {
	String name;
	int level = 1;
	int exp = 0;

	int maxhealth = 100;
	
	Long coins = 100

	static hasMany = [items: ItemPossession, spells: SpellPossession]
    static belongsTo = [account: Account]
	
	static transients = [
		"EquipedItems",
		"UnequipedItems",
	]

    def addSpell(Spell cntSpell) {
        SpellPossession hasSpell = SpellPossession.findBySpellOwnerAndSpell(this, cntSpell)

        if(hasSpell == null ) {			
            hasSpell = new SpellPossession(spellOwner: this, spell: cntSpell);
            hasSpell.save()
        } else {
            throw new Exception("Spell already possessed");
        }
    }

	def getEquipedItems() {
		return ItemPossession.findAllByItemOwnerAndIsEquiped(this, true)
	}
	
	def getUnequipedItems() {
		return ItemPossession.findAllByItemOwnerAndIsEquiped(this, false)
	}

    static def createCharacter(String name, Account account) {
        Player.withTransaction {
            Player ch = new Player(
                    account: account,
                    name: name,
                    level:1,
                    exp:0,
                    coins:100,
                    maxhealth: 100
            )
            ch.save()

            Spell.getStartingSpells().each {
                ch.addSpell(it as Spell)
                ch.save()
            }

            return ch
        }
    }

    void addExp(int addedExp) {
        exp += addedExp

        if( exp > getExpForLevel(level+1) ) {
            level += 1
            exp = 0
            this.save()
        }
    }

    static int getExpForLevel(int level) {
        return level * 100
    }
}
