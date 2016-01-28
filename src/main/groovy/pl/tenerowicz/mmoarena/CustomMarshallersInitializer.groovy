package pl.tenerowicz.mmoarena

/**
 * Created by konkit on 2015-03-04.
 */
class CustomMarshallersInitializer {
    List marshallers = []

    def init() {
        marshallers.each{ it.init() }
    }
}
