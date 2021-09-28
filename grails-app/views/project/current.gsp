<!DOCTYPE html>
<html>
  <head>
    <title>Current Projects</title>
  </head>
  <body>
    <table border="1">
      <thead>
        <th>name</td>
        <th>description</td>
        <th>dueDate</td>
      </thead>
      <g:each in="${allProjects}" status="i" var="thisProject">
        <tr>
          <td>${thisProject.name}</td>
          <td>${thisProject.description}</td>
          <td>${thisProject.dueDate}</td>
        </tr>
      </g:each>
    </table>
  </body>
</html>