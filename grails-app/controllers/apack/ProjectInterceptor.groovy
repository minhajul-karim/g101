package apack


class ProjectInterceptor {

    boolean before() { 
        // Check login
        if (!session.user) {
            redirect(controller: "EndUser", action: "login")
            return false
        }
        true
     }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
