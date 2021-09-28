<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'endUser.label', default: 'EndUser')}" />
        <title><g:message code="PTracker Login" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#create-endUser" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="logout"><g:message code="logout" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="create-endUser" class="content scaffold-create" role="main">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
              <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.endUser}">
              <ul class="errors" role="alert">
                  <g:eachError bean="${this.endUser}" var="error">
                  <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                  </g:eachError>
              </ul>
            </g:hasErrors>
            <g:form action="authenticate" method="POST">
              <fieldset class="form">
                <div class="fieldcontain ${hasErrors(bean: endUser, field: 'username', 'error')}">
                  <label>
                    <g:message code="endUser.username.label" default="Username" />
                  </label>
                  <g:field type="text" name="username" value="${endUser?.username}" />
                </div>
                <div class="fieldcontain ${hasErrors(bean: endUser, field: 'password', 'error')}">
                  <label>
                    <g:message code="endUser.password.label" default="Password" />
                  </label>
                  <g:field type="password" name="password" value="${endUser?.password}" />
                </div>
              </fieldset>
              <fieldset class="buttons">
                <g:submitButton name="login" class="save" value="Log In" />
              </fieldset>
            </g:form>
        </div>
    </body>
</html>
