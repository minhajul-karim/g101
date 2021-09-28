package apack

class EndUser {

    String username
    String password
    String fullName
    static hasMany = [project: Project, tasks: Task]
    String toString() {
        "${fullName}"
    }

    static constraints = {
        fullName size: 1..30, blank: false
        username size: 1..10, blank: false, unique: true
        password size: 1..10, blank: false, password: true
    }
}
