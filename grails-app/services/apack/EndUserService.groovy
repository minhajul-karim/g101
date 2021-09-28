package apack

import grails.gorm.services.Service

@Service(EndUser)
interface EndUserService {

    EndUser get(Serializable id)

    List<EndUser> list(Map args)

    Long count()

    void delete(Serializable id)

    EndUser save(EndUser endUser)

}