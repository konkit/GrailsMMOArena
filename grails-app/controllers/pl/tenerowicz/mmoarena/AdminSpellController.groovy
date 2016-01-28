package pl.tenerowicz.mmoarena

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import org.springframework.security.access.annotation.Secured

@Transactional(readOnly = true)
@Secured('hasRole("ROLE_ADMIN")')
class AdminSpellController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond(Spell.list(params), model:[itemInstanceCount: Spell.count()])
    }

    def create() {
        respond new Spell(params)
    }

    @Transactional
    def save(Spell spellInstance) {
        if ( spellInstance == null ) {
            notFound()
            return
        }

        if ( spellInstance.hasErrors() ) {
            respond spellInstance.errors, view:'create'
            return
        }

        spellInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'item.label', default: 'Item'), spellInstance.id])
                redirect(action: "index")
            }
            '*' { respond spellInstance, [status: CREATED] }
        }
    }

    def edit(Spell spellInstance) {
        respond spellInstance
    }

    @Transactional
    def update(Spell spellInstance) {
        if ( spellInstance == null ) {
            notFound()
            return
        }

        if (spellInstance.hasErrors()) {
            respond spellInstance.errors, view:'edit'
            return
        }

        spellInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Spell.label', default: 'Spell'), spellInstance.name])
                redirect(action: "index")
            }
            '*'{ respond spellInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Spell spellInstance) {

        if (spellInstance == null) {
            notFound()
            return
        }

        spellInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Item.label', default: 'Item'), spellInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'item.label', default: 'Item'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
