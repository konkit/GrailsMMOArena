package pl.tenerowicz.mmoarena

class AccountPasswordRecovery {
    Account account
    String token = UUID.randomUUID().toString().replaceAll('-', '')

    Date dateCreated

    static constraints = {
    }
}
