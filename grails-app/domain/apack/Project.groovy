package apack

class Project {

    String name
    String description
    String billingType
    Date dueDate

    static belongsTo = [owner: EndUser]
    static hasMany = [tasks: Task]
    
    String toString() {
        "${name}"
    }

    static constraints = {
        billingType(inList: ["Hourly", "Milestone", "Non-billable"])
    }
}
