package pl.tenerowicz.mmoarena

class AccountRegisterToken {
    Account account
    String token = UUID.randomUUID().toString().replaceAll('-', '')

    Date dateCreated

    static constraints = {
    }
}
