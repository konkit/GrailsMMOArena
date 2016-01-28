import org.springframework.web.context.support.WebApplicationContextUtils
import pl.tenerowicz.mmoarena.BootstrapService

class BootStrap {

    BootstrapService bootstrapService

    def init = { servletContext ->
        bootstrapService.springContext = WebApplicationContextUtils.getWebApplicationContext( servletContext )
        bootstrapService.initAll()
    }

    def destroy = {

    }
}
