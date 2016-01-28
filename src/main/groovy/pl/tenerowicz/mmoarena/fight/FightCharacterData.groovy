package pl.tenerowicz.mmoarena.fight

import pl.tenerowicz.mmoarena.ItemPossession
import pl.tenerowicz.mmoarena.SpellPossession
import pl.tenerowicz.mmoarena.Player

/**
 * Created by konkit on 2014-10-21.
 */
class FightCharacterData {
    Long id
    String name
    Long level
    Long exp
    Long maxhealth
    Long coins

    List<ItemPossession> items
    List<SpellPossession> spells

    static FightCharacterData createFromCharacterData(Player character) {
        FightCharacterData fightPlayerData = new FightCharacterData()

        fightPlayerData.id = character.id
        fightPlayerData.name = character.name
        fightPlayerData.level = character.level
        fightPlayerData.exp = character.exp
        fightPlayerData.maxhealth = character.maxhealth
        fightPlayerData.coins = character.coins

        fightPlayerData.items = ItemPossession.findAllByItemOwnerAndIsEquiped(character, true)
        fightPlayerData.spells = SpellPossession.findAllBySpellOwnerAndIsEquiped(character, true)

        return fightPlayerData
    }
}
