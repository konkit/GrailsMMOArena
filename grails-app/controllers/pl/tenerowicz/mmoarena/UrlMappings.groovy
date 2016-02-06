package pl.tenerowicz.mmoarena

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
        '/api/character/indexJson'(controller: 'character', action: 'indexJson')

        '/api/item/index'(controller: 'playerItem', action: 'indexJson')
        '/api/item/buy'(controller: 'playerItem', action: 'buyJson')
        '/api/item/equip'(controller: 'playerItem', action: 'equipJson')
        '/api/item/unequip'(controller: 'playerItem', action: 'unequipJson')
        '/api/fight/getPlayerData'(controller: 'fight', action: 'getPlayerData')
        '/api/fight/getPlayerDataJson'(controller: 'fight', action: 'getPlayerDataJson')

        '/api/playerSpell/indexJson'(controller: 'playerSpell', action: 'indexJson')

        "/"(view:"/home/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
