package pl.tenerowicz.mmoarena

import org.springframework.security.access.annotation.Secured

@Secured(['permitAll'])
class HomeController {

    def index() {

    }
}
