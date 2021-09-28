package apack

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class EndUserServiceSpec extends Specification {

    EndUserService endUserService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new EndUser(...).save(flush: true, failOnError: true)
        //new EndUser(...).save(flush: true, failOnError: true)
        //EndUser endUser = new EndUser(...).save(flush: true, failOnError: true)
        //new EndUser(...).save(flush: true, failOnError: true)
        //new EndUser(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //endUser.id
    }

    void "test get"() {
        setupData()

        expect:
        endUserService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<EndUser> endUserList = endUserService.list(max: 2, offset: 2)

        then:
        endUserList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        endUserService.count() == 5
    }

    void "test delete"() {
        Long endUserId = setupData()

        expect:
        endUserService.count() == 5

        when:
        endUserService.delete(endUserId)
        sessionFactory.currentSession.flush()

        then:
        endUserService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        EndUser endUser = new EndUser()
        endUserService.save(endUser)

        then:
        endUser.id != null
    }
}
