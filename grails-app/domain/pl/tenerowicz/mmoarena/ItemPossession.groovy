package pl.tenerowicz.mmoarena

class ItemPossession {
	Item item
	
	Long amount
	Boolean isEquiped
	
	static belongsTo = [itemOwner: Player]
	
    static constraints = {
    }
	
	static Long getItemCount(Player cntCharacter, Item cntItem) {
		ItemPossession hasItem = ItemPossession.findByItemOwnerAndItem(cntCharacter, cntItem)
		
		if(hasItem != null ) {
			return hasItem.amount;
		}
		
		return 0;
	}


}
