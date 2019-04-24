package ru.eremin.tm.server.endpoint;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.2.3
 * 2019-04-24T12:36:43.985+03:00
 * Generated source version: 3.2.3
 *
 */
@WebService(targetNamespace = "http://endpoint.server.tm.eremin.ru/", name = "TaskEndpoint")
@XmlSeeAlso({ObjectFactory.class})
public interface TaskEndpoint {

    @WebMethod
    @Action(input = "http://endpoint.server.tm.eremin.ru/TaskEndpoint/findAllTasksSortedByCreateDateRequest", output = "http://endpoint.server.tm.eremin.ru/TaskEndpoint/findAllTasksSortedByCreateDateResponse", fault = {@FaultAction(className = IncorrectDataException_Exception.class, value = "http://endpoint.server.tm.eremin.ru/TaskEndpoint/findAllTasksSortedByCreateDate/Fault/IncorrectDataException"), @FaultAction(className = AccessForbiddenException_Exception.class, value = "http://endpoint.server.tm.eremin.ru/TaskEndpoint/findAllTasksSortedByCreateDate/Fault/AccessForbiddenException")})
    @RequestWrapper(localName = "findAllTasksSortedByCreateDate", targetNamespace = "http://endpoint.server.tm.eremin.ru/", className = "ru.eremin.tm.server.endpoint.FindAllTasksSortedByCreateDate")
    @ResponseWrapper(localName = "findAllTasksSortedByCreateDateResponse", targetNamespace = "http://endpoint.server.tm.eremin.ru/", className = "ru.eremin.tm.server.endpoint.FindAllTasksSortedByCreateDateResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<ru.eremin.tm.server.endpoint.TaskDTO> findAllTasksSortedByCreateDate(
        @WebParam(name = "arg0", targetNamespace = "")
        ru.eremin.tm.server.endpoint.SessionDTO arg0
    ) throws IncorrectDataException_Exception, AccessForbiddenException_Exception;

    @WebMethod
    @Action(input = "http://endpoint.server.tm.eremin.ru/TaskEndpoint/findAllTasksRequest", output = "http://endpoint.server.tm.eremin.ru/TaskEndpoint/findAllTasksResponse", fault = {@FaultAction(className = IncorrectDataException_Exception.class, value = "http://endpoint.server.tm.eremin.ru/TaskEndpoint/findAllTasks/Fault/IncorrectDataException"), @FaultAction(className = AccessForbiddenException_Exception.class, value = "http://endpoint.server.tm.eremin.ru/TaskEndpoint/findAllTasks/Fault/AccessForbiddenException")})
    @RequestWrapper(localName = "findAllTasks", targetNamespace = "http://endpoint.server.tm.eremin.ru/", className = "ru.eremin.tm.server.endpoint.FindAllTasks")
    @ResponseWrapper(localName = "findAllTasksResponse", targetNamespace = "http://endpoint.server.tm.eremin.ru/", className = "ru.eremin.tm.server.endpoint.FindAllTasksResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<ru.eremin.tm.server.endpoint.TaskDTO> findAllTasks(
        @WebParam(name = "arg0", targetNamespace = "")
        ru.eremin.tm.server.endpoint.SessionDTO arg0
    ) throws IncorrectDataException_Exception, AccessForbiddenException_Exception;

    @WebMethod
    @Action(input = "http://endpoint.server.tm.eremin.ru/TaskEndpoint/findTaskByProjectIdRequest", output = "http://endpoint.server.tm.eremin.ru/TaskEndpoint/findTaskByProjectIdResponse", fault = {@FaultAction(className = IncorrectDataException_Exception.class, value = "http://endpoint.server.tm.eremin.ru/TaskEndpoint/findTaskByProjectId/Fault/IncorrectDataException"), @FaultAction(className = AccessForbiddenException_Exception.class, value = "http://endpoint.server.tm.eremin.ru/TaskEndpoint/findTaskByProjectId/Fault/AccessForbiddenException")})
    @RequestWrapper(localName = "findTaskByProjectId", targetNamespace = "http://endpoint.server.tm.eremin.ru/", className = "ru.eremin.tm.server.endpoint.FindTaskByProjectId")
    @ResponseWrapper(localName = "findTaskByProjectIdResponse", targetNamespace = "http://endpoint.server.tm.eremin.ru/", className = "ru.eremin.tm.server.endpoint.FindTaskByProjectIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<ru.eremin.tm.server.endpoint.TaskDTO> findTaskByProjectId(
        @WebParam(name = "arg0", targetNamespace = "")
        ru.eremin.tm.server.endpoint.SessionDTO arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1
    ) throws IncorrectDataException_Exception, AccessForbiddenException_Exception;

    @WebMethod
    @Action(input = "http://endpoint.server.tm.eremin.ru/TaskEndpoint/findAllTasksSortedByStartDateRequest", output = "http://endpoint.server.tm.eremin.ru/TaskEndpoint/findAllTasksSortedByStartDateResponse", fault = {@FaultAction(className = IncorrectDataException_Exception.class, value = "http://endpoint.server.tm.eremin.ru/TaskEndpoint/findAllTasksSortedByStartDate/Fault/IncorrectDataException"), @FaultAction(className = AccessForbiddenException_Exception.class, value = "http://endpoint.server.tm.eremin.ru/TaskEndpoint/findAllTasksSortedByStartDate/Fault/AccessForbiddenException")})
    @RequestWrapper(localName = "findAllTasksSortedByStartDate", targetNamespace = "http://endpoint.server.tm.eremin.ru/", className = "ru.eremin.tm.server.endpoint.FindAllTasksSortedByStartDate")
    @ResponseWrapper(localName = "findAllTasksSortedByStartDateResponse", targetNamespace = "http://endpoint.server.tm.eremin.ru/", className = "ru.eremin.tm.server.endpoint.FindAllTasksSortedByStartDateResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<ru.eremin.tm.server.endpoint.TaskDTO> findAllTasksSortedByStartDate(
        @WebParam(name = "arg0", targetNamespace = "")
        ru.eremin.tm.server.endpoint.SessionDTO arg0
    ) throws IncorrectDataException_Exception, AccessForbiddenException_Exception;

    @WebMethod
    @Action(input = "http://endpoint.server.tm.eremin.ru/TaskEndpoint/persistTaskRequest", output = "http://endpoint.server.tm.eremin.ru/TaskEndpoint/persistTaskResponse", fault = {@FaultAction(className = IncorrectDataException_Exception.class, value = "http://endpoint.server.tm.eremin.ru/TaskEndpoint/persistTask/Fault/IncorrectDataException"), @FaultAction(className = AccessForbiddenException_Exception.class, value = "http://endpoint.server.tm.eremin.ru/TaskEndpoint/persistTask/Fault/AccessForbiddenException")})
    @RequestWrapper(localName = "persistTask", targetNamespace = "http://endpoint.server.tm.eremin.ru/", className = "ru.eremin.tm.server.endpoint.PersistTask")
    @ResponseWrapper(localName = "persistTaskResponse", targetNamespace = "http://endpoint.server.tm.eremin.ru/", className = "ru.eremin.tm.server.endpoint.PersistTaskResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.eremin.tm.server.endpoint.ResultDTO persistTask(
        @WebParam(name = "arg0", targetNamespace = "")
        ru.eremin.tm.server.endpoint.SessionDTO arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        ru.eremin.tm.server.endpoint.TaskDTO arg1
    ) throws IncorrectDataException_Exception, AccessForbiddenException_Exception;

    @WebMethod
    @Action(input = "http://endpoint.server.tm.eremin.ru/TaskEndpoint/findOneTaskRequest", output = "http://endpoint.server.tm.eremin.ru/TaskEndpoint/findOneTaskResponse", fault = {@FaultAction(className = IncorrectDataException_Exception.class, value = "http://endpoint.server.tm.eremin.ru/TaskEndpoint/findOneTask/Fault/IncorrectDataException"), @FaultAction(className = AccessForbiddenException_Exception.class, value = "http://endpoint.server.tm.eremin.ru/TaskEndpoint/findOneTask/Fault/AccessForbiddenException")})
    @RequestWrapper(localName = "findOneTask", targetNamespace = "http://endpoint.server.tm.eremin.ru/", className = "ru.eremin.tm.server.endpoint.FindOneTask")
    @ResponseWrapper(localName = "findOneTaskResponse", targetNamespace = "http://endpoint.server.tm.eremin.ru/", className = "ru.eremin.tm.server.endpoint.FindOneTaskResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.eremin.tm.server.endpoint.TaskDTO findOneTask(
        @WebParam(name = "arg0", targetNamespace = "")
        ru.eremin.tm.server.endpoint.SessionDTO arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1
    ) throws IncorrectDataException_Exception, AccessForbiddenException_Exception;

    @WebMethod
    @Action(input = "http://endpoint.server.tm.eremin.ru/TaskEndpoint/findTasksByDescriptionRequest", output = "http://endpoint.server.tm.eremin.ru/TaskEndpoint/findTasksByDescriptionResponse", fault = {@FaultAction(className = IncorrectDataException_Exception.class, value = "http://endpoint.server.tm.eremin.ru/TaskEndpoint/findTasksByDescription/Fault/IncorrectDataException"), @FaultAction(className = AccessForbiddenException_Exception.class, value = "http://endpoint.server.tm.eremin.ru/TaskEndpoint/findTasksByDescription/Fault/AccessForbiddenException")})
    @RequestWrapper(localName = "findTasksByDescription", targetNamespace = "http://endpoint.server.tm.eremin.ru/", className = "ru.eremin.tm.server.endpoint.FindTasksByDescription")
    @ResponseWrapper(localName = "findTasksByDescriptionResponse", targetNamespace = "http://endpoint.server.tm.eremin.ru/", className = "ru.eremin.tm.server.endpoint.FindTasksByDescriptionResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<ru.eremin.tm.server.endpoint.TaskDTO> findTasksByDescription(
        @WebParam(name = "arg0", targetNamespace = "")
        ru.eremin.tm.server.endpoint.SessionDTO arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1
    ) throws IncorrectDataException_Exception, AccessForbiddenException_Exception;

    @WebMethod
    @Action(input = "http://endpoint.server.tm.eremin.ru/TaskEndpoint/findAllTasksSortedByStatusRequest", output = "http://endpoint.server.tm.eremin.ru/TaskEndpoint/findAllTasksSortedByStatusResponse", fault = {@FaultAction(className = IncorrectDataException_Exception.class, value = "http://endpoint.server.tm.eremin.ru/TaskEndpoint/findAllTasksSortedByStatus/Fault/IncorrectDataException"), @FaultAction(className = AccessForbiddenException_Exception.class, value = "http://endpoint.server.tm.eremin.ru/TaskEndpoint/findAllTasksSortedByStatus/Fault/AccessForbiddenException")})
    @RequestWrapper(localName = "findAllTasksSortedByStatus", targetNamespace = "http://endpoint.server.tm.eremin.ru/", className = "ru.eremin.tm.server.endpoint.FindAllTasksSortedByStatus")
    @ResponseWrapper(localName = "findAllTasksSortedByStatusResponse", targetNamespace = "http://endpoint.server.tm.eremin.ru/", className = "ru.eremin.tm.server.endpoint.FindAllTasksSortedByStatusResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<ru.eremin.tm.server.endpoint.TaskDTO> findAllTasksSortedByStatus(
        @WebParam(name = "arg0", targetNamespace = "")
        ru.eremin.tm.server.endpoint.SessionDTO arg0
    ) throws IncorrectDataException_Exception, AccessForbiddenException_Exception;

    @WebMethod
    @Action(input = "http://endpoint.server.tm.eremin.ru/TaskEndpoint/findAllTasksSortedByEndDateRequest", output = "http://endpoint.server.tm.eremin.ru/TaskEndpoint/findAllTasksSortedByEndDateResponse", fault = {@FaultAction(className = IncorrectDataException_Exception.class, value = "http://endpoint.server.tm.eremin.ru/TaskEndpoint/findAllTasksSortedByEndDate/Fault/IncorrectDataException"), @FaultAction(className = AccessForbiddenException_Exception.class, value = "http://endpoint.server.tm.eremin.ru/TaskEndpoint/findAllTasksSortedByEndDate/Fault/AccessForbiddenException")})
    @RequestWrapper(localName = "findAllTasksSortedByEndDate", targetNamespace = "http://endpoint.server.tm.eremin.ru/", className = "ru.eremin.tm.server.endpoint.FindAllTasksSortedByEndDate")
    @ResponseWrapper(localName = "findAllTasksSortedByEndDateResponse", targetNamespace = "http://endpoint.server.tm.eremin.ru/", className = "ru.eremin.tm.server.endpoint.FindAllTasksSortedByEndDateResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<ru.eremin.tm.server.endpoint.TaskDTO> findAllTasksSortedByEndDate(
        @WebParam(name = "arg0", targetNamespace = "")
        ru.eremin.tm.server.endpoint.SessionDTO arg0
    ) throws IncorrectDataException_Exception, AccessForbiddenException_Exception;

    @WebMethod
    @Action(input = "http://endpoint.server.tm.eremin.ru/TaskEndpoint/findTasksByNameRequest", output = "http://endpoint.server.tm.eremin.ru/TaskEndpoint/findTasksByNameResponse", fault = {@FaultAction(className = IncorrectDataException_Exception.class, value = "http://endpoint.server.tm.eremin.ru/TaskEndpoint/findTasksByName/Fault/IncorrectDataException"), @FaultAction(className = AccessForbiddenException_Exception.class, value = "http://endpoint.server.tm.eremin.ru/TaskEndpoint/findTasksByName/Fault/AccessForbiddenException")})
    @RequestWrapper(localName = "findTasksByName", targetNamespace = "http://endpoint.server.tm.eremin.ru/", className = "ru.eremin.tm.server.endpoint.FindTasksByName")
    @ResponseWrapper(localName = "findTasksByNameResponse", targetNamespace = "http://endpoint.server.tm.eremin.ru/", className = "ru.eremin.tm.server.endpoint.FindTasksByNameResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<ru.eremin.tm.server.endpoint.TaskDTO> findTasksByName(
        @WebParam(name = "arg0", targetNamespace = "")
        ru.eremin.tm.server.endpoint.SessionDTO arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1
    ) throws IncorrectDataException_Exception, AccessForbiddenException_Exception;

    @WebMethod
    @Action(input = "http://endpoint.server.tm.eremin.ru/TaskEndpoint/removeTaskRequest", output = "http://endpoint.server.tm.eremin.ru/TaskEndpoint/removeTaskResponse", fault = {@FaultAction(className = IncorrectDataException_Exception.class, value = "http://endpoint.server.tm.eremin.ru/TaskEndpoint/removeTask/Fault/IncorrectDataException"), @FaultAction(className = AccessForbiddenException_Exception.class, value = "http://endpoint.server.tm.eremin.ru/TaskEndpoint/removeTask/Fault/AccessForbiddenException")})
    @RequestWrapper(localName = "removeTask", targetNamespace = "http://endpoint.server.tm.eremin.ru/", className = "ru.eremin.tm.server.endpoint.RemoveTask")
    @ResponseWrapper(localName = "removeTaskResponse", targetNamespace = "http://endpoint.server.tm.eremin.ru/", className = "ru.eremin.tm.server.endpoint.RemoveTaskResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.eremin.tm.server.endpoint.ResultDTO removeTask(
        @WebParam(name = "arg0", targetNamespace = "")
        ru.eremin.tm.server.endpoint.SessionDTO arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1
    ) throws IncorrectDataException_Exception, AccessForbiddenException_Exception;

    @WebMethod
    @Action(input = "http://endpoint.server.tm.eremin.ru/TaskEndpoint/removeAllTasksRequest", output = "http://endpoint.server.tm.eremin.ru/TaskEndpoint/removeAllTasksResponse", fault = {@FaultAction(className = IncorrectDataException_Exception.class, value = "http://endpoint.server.tm.eremin.ru/TaskEndpoint/removeAllTasks/Fault/IncorrectDataException"), @FaultAction(className = AccessForbiddenException_Exception.class, value = "http://endpoint.server.tm.eremin.ru/TaskEndpoint/removeAllTasks/Fault/AccessForbiddenException")})
    @RequestWrapper(localName = "removeAllTasks", targetNamespace = "http://endpoint.server.tm.eremin.ru/", className = "ru.eremin.tm.server.endpoint.RemoveAllTasks")
    @ResponseWrapper(localName = "removeAllTasksResponse", targetNamespace = "http://endpoint.server.tm.eremin.ru/", className = "ru.eremin.tm.server.endpoint.RemoveAllTasksResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.eremin.tm.server.endpoint.ResultDTO removeAllTasks(
        @WebParam(name = "arg0", targetNamespace = "")
        ru.eremin.tm.server.endpoint.SessionDTO arg0
    ) throws IncorrectDataException_Exception, AccessForbiddenException_Exception;

    @WebMethod
    @Action(input = "http://endpoint.server.tm.eremin.ru/TaskEndpoint/updateTaskRequest", output = "http://endpoint.server.tm.eremin.ru/TaskEndpoint/updateTaskResponse", fault = {@FaultAction(className = IncorrectDataException_Exception.class, value = "http://endpoint.server.tm.eremin.ru/TaskEndpoint/updateTask/Fault/IncorrectDataException"), @FaultAction(className = AccessForbiddenException_Exception.class, value = "http://endpoint.server.tm.eremin.ru/TaskEndpoint/updateTask/Fault/AccessForbiddenException")})
    @RequestWrapper(localName = "updateTask", targetNamespace = "http://endpoint.server.tm.eremin.ru/", className = "ru.eremin.tm.server.endpoint.UpdateTask")
    @ResponseWrapper(localName = "updateTaskResponse", targetNamespace = "http://endpoint.server.tm.eremin.ru/", className = "ru.eremin.tm.server.endpoint.UpdateTaskResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.eremin.tm.server.endpoint.ResultDTO updateTask(
        @WebParam(name = "arg0", targetNamespace = "")
        ru.eremin.tm.server.endpoint.SessionDTO arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        ru.eremin.tm.server.endpoint.TaskDTO arg1
    ) throws IncorrectDataException_Exception, AccessForbiddenException_Exception;
}
