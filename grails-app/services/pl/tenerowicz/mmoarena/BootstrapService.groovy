package pl.tenerowicz.mmoarena

import org.springframework.web.context.support.WebApplicationContextUtils

/**
 * Created by konkit on 2014-08-31.
 */
class BootstrapService {
    def springContext


    def initAll() {
//        springContext.getBean( "customMarshallersInitializer" ).init()

        def userRole = Role.findByAuthority("ROLE_USER") ?: new Role(authority: "ROLE_USER").save(failOnError: true)
        def adminRole = Role.findByAuthority("ROLE_ADMIN") ?: new Role(authority: "ROLE_ADMIN").save(failOnError: true)

        Account account = Account.findByUsername('user')
        if( !account) {
            account = new Account(
                    username: 'user',
                    password: 'user',
                    emailAddress: 'user@mail.com',
                    accountLocked: false
            )
            account.save()
            AccountRole.create(account, userRole)
        }

        Account account2 = Account.findByUsername('user2')
        if( !account2) {
            account2 = new Account(
                    username: 'user2',
                    password: 'user2',
                    emailAddress: 'user2@mail.com',
                    accountLocked: false
            )
            account2.save()
            AccountRole.create(account2, userRole)
        }

        Account adminAccount = Account.findByUsername('admin')
        if( !adminAccount) {
            adminAccount = new Account(
                    username: 'admin',
                    password: 'admin',
                    emailAddress: 'admin@mail.com',
                    accountLocked: false
            )
            adminAccount.save()
            AccountRole.create(adminAccount, adminRole)
        }

        Player character1 = Player.findByName('Character1')
        if( !character1 ) {
            Player ch = Player.createCharacter('Character1', account)
        }

        Player enemy1 = Player.findByName('Enemy1')
        if( !enemy1 ) {
            Player.createCharacter('Enemy1', account2)
        }

        if( !Item.findByName('Simple sword') ) {
            Item item = new Item(name: 'Simple sword', attackBonus: 1L, defenceBonus: 0L, coinCost: 10L, requiredLevel: 1L)
            item.save()
        }
        if( !Item.findByName('Better sword') ) {
            Item item = new Item(name: 'Better sword', attackBonus: 2L, defenceBonus: 0L, coinCost: 20L, requiredLevel: 1L)
            item.save()
        }
        if( !Item.findByName('Even better sword') ) {
            Item item = new Item(name: 'Even better sword', attackBonus: 3L, defenceBonus: 0L, coinCost: 30L, requiredLevel: 1L)
            item.save()
        }
    }
}
