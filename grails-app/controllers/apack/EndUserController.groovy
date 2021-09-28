package apack

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class EndUserController {

    EndUserService endUserService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond endUserService.list(params), model:[endUserCount: endUserService.count()]
    }

    def login = { }

    def authenticate = {
        def user = EndUser.findByUsernameAndPassword(params.username, params.password)
        if (user) {
            session.user = user
            flash.message = "Hello, ${user.fullName}"
            redirect(action:"login")
        } else {
            flash.message = "Sorry, ${params.username} try again!"
            session.user = null
            redirect(action:"login")
        }
    }

    def logout = {
        flash.message = "Goodbye ${session.user.fullName}"
        session.user = null
        redirect(action: "login")
    }

    def show(Long id) {
        respond endUserService.get(id)
    }

    def create() {
        respond new EndUser(params)
    }

    def save(EndUser endUser) {
        if (endUser == null) {
            notFound()
            return
        }

        try {
            endUserService.save(endUser)
        } catch (ValidationException e) {
            respond endUser.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'endUser.label', default: 'EndUser'), endUser.id])
                redirect endUser
            }
            '*' { respond endUser, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond endUserService.get(id)
    }

    def update(EndUser endUser) {
        if (endUser == null) {
            notFound()
            return
        }

        try {
            endUserService.save(endUser)
        } catch (ValidationException e) {
            respond endUser.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'endUser.label', default: 'EndUser'), endUser.id])
                redirect endUser
            }
            '*'{ respond endUser, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        endUserService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'endUser.label', default: 'EndUser'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'endUser.label', default: 'EndUser'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
