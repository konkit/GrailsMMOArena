package pl.tenerowicz.mmoarena

import grails.converters.JSON
import grails.converters.XML
import pl.tenerowicz.mmoarena.fight.FightCharacterData

/**
 * Created by konkit on 2015-03-04.
 */
class PlayerMarshaller {
    void init() {
//        XML.use("deep") {
//            XML.registerObjectMarshaller( Player ) { Player player ->
//                return new FightCharacterData(
//                        id: player.id,
//                        name: player.name,
//                        level: player.level,
//                        exp: player.exp,
//                        maxhealth: player.maxhealth,
//                        coins: player.coins,
//                        items: player.items,
//                        spells: player.spells
//                )
//            }
//        }
//
//        JSON.use("deep") {
//            JSON.registerObjectMarshaller( Player ) { Player player ->
//                return new FightCharacterData(
//                        id : player.id,
//                        name: player.name,
//                        level: player.level,
//                        exp: player.exp,
//                        maxhealth: player.maxhealth,
//                        coins: player.coins,
//                        items: player.items,
//                        spells: player.spells
//                )
//            }
//        }
    }
}
