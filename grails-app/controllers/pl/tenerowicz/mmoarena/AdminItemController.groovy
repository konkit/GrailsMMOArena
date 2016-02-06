package pl.tenerowicz.mmoarena

import org.springframework.security.access.annotation.Secured
import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
@Secured('hasRole("ROLE_ADMIN")')
class AdminItemController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        return [itemInstanceList: Item.list(params), itemInstanceCount: Item.count()]
    }

    def create() {
        return [itemInstance: new Item(params)]
    }

    @Transactional
    def save(Item itemInstance) {
        if (itemInstance == null) {
            notFound()
            return
        }

        if (itemInstance.hasErrors()) {
            respond itemInstance.errors, view:'create'
            return
        }

        itemInstance.save flush:true
        flash.message = message(code: 'default.created.message', args: [message(code: 'item.label', default: 'Item'), itemInstance.id])
        redirect(action: "index")
    }

    def edit(Item itemInstance) {
        return [itemInstance: itemInstance]
    }

    @Transactional
    def update(Item itemInstance) {
        if (itemInstance == null) {
            println "Item instance is null"
            notFound()
            return
        }

        if (itemInstance.hasErrors()) {
            println "item instance has errors"
            respond itemInstance.errors, view:'edit'
            return
        }

        itemInstance.save flush:true
        flash.message = message(code: 'default.updated.message', args: [message(code: 'Item.label', default: 'Item'), itemInstance.id])
        redirect(action: "index")
    }

    @Transactional
    def delete(Item itemInstance) {

        if (itemInstance == null) {
            notFound()
            return
        }

        itemInstance.delete flush:true
        flash.message = message(code: 'default.deleted.message', args: [message(code: 'Item.label', default: 'Item'), itemInstance.id])
        redirect action:"index", method:"GET"
    }

    protected void notFound() {
        flash.message = message(code: 'default.not.found.message', args: [message(code: 'item.label', default: 'Item'), params.id])
        redirect action: "index", method: "GET"
    }
}
