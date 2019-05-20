<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="/WEB-INF/views/head.jsp"/>


<c:set var="task" value="${requestScope.task}"/>
<c:set var="projects" value="${requestScope.projects}"/>
<c:set var="statuses" value="${requestScope.statuses}"/>

<div class="pageTitle">Edit Task</div>

<form action="${pageContext.request.contextPath}/enter/task-edit" method="POST">
    <input name="id" class="form-control" type="hidden" value="${task.getId()}">
    <div class="form-group">
        <label for="nameInput">Task Name</label>
        <input name="name" type="text" id="nameInput" class="form-control" value="${task.getName()}">
    </div>
    <div class="form-group">
        <label for="descriptionInput">Description</label>
        <input name="description" type="text" id="descriptionInput" class="form-control"
               value="${task.getDescription()}">
    </div>
    <div class="form-group">
        <label for="startDateInput">Start Date</label>
        <input name="startDate" type="date" id="startDateInput" class="form-control" value="${task.getStartDate()}">
    </div>
    <div class="form-group">
        <label for="endDateInput">End Date</label>
        <input name="endDate" type="date" id="endDateInput" class="form-control" value="${task.getEndDate()}">
    </div>
    <div class="form-group">
        <label for="statusSelect">Status</label>
        <select name="status" id="statusSelect" class="form-control">
            <c:forEach var="status" items="${statuses}">
                <option value="${status.getDisplayName()}">${status.getDisplayName()}</option>
            </c:forEach>
        </select>    </div>
    <div class="form-group">
        <label for="projectSelect">Project</label>
        <select name="projectId" id="projectSelect" class="form-control">
            <c:forEach var="project" items="${projects.values()}">
                <option value="${project.getId()}">${project.getName()}</option>
            </c:forEach>
        </select>
    </div>
    <button type="submit" class="btn btn-primary">Save</button>
</form>

<jsp:include page="/WEB-INF/views/foot.jsp"/>