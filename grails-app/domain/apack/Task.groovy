package apack

class Task {

    String name
    String description
    Date dueDate
    static belongsTo = [asignee: EndUser, project: Project]
    String toString() {
        "${name}"
    }

    static constraints = {
    }
}
