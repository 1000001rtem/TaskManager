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
 * 2019-05-06T20:44:34.339+03:00
 * Generated source version: 3.2.3
 *
 */
@WebService(targetNamespace = "http://endpoint.server.tm.eremin.ru/", name = "ProjectEndpoint")
@XmlSeeAlso({ObjectFactory.class})
public interface ProjectEndpoint {

    @WebMethod
    @Action(input = "http://endpoint.server.tm.eremin.ru/ProjectEndpoint/findAllProjectsSortedByStatusRequest", output = "http://endpoint.server.tm.eremin.ru/ProjectEndpoint/findAllProjectsSortedByStatusResponse", fault = {@FaultAction(className = IncorrectDataException_Exception.class, value = "http://endpoint.server.tm.eremin.ru/ProjectEndpoint/findAllProjectsSortedByStatus/Fault/IncorrectDataException"), @FaultAction(className = AccessForbiddenException_Exception.class, value = "http://endpoint.server.tm.eremin.ru/ProjectEndpoint/findAllProjectsSortedByStatus/Fault/AccessForbiddenException")})
    @RequestWrapper(localName = "findAllProjectsSortedByStatus", targetNamespace = "http://endpoint.server.tm.eremin.ru/", className = "ru.eremin.tm.server.endpoint.FindAllProjectsSortedByStatus")
    @ResponseWrapper(localName = "findAllProjectsSortedByStatusResponse", targetNamespace = "http://endpoint.server.tm.eremin.ru/", className = "ru.eremin.tm.server.endpoint.FindAllProjectsSortedByStatusResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<ru.eremin.tm.server.endpoint.ProjectDTO> findAllProjectsSortedByStatus(
        @WebParam(name = "arg0", targetNamespace = "")
        ru.eremin.tm.server.endpoint.SessionDTO arg0
    ) throws IncorrectDataException_Exception, AccessForbiddenException_Exception;

    @WebMethod
    @Action(input = "http://endpoint.server.tm.eremin.ru/ProjectEndpoint/findAllProjectsSortedByEndDateRequest", output = "http://endpoint.server.tm.eremin.ru/ProjectEndpoint/findAllProjectsSortedByEndDateResponse", fault = {@FaultAction(className = IncorrectDataException_Exception.class, value = "http://endpoint.server.tm.eremin.ru/ProjectEndpoint/findAllProjectsSortedByEndDate/Fault/IncorrectDataException"), @FaultAction(className = AccessForbiddenException_Exception.class, value = "http://endpoint.server.tm.eremin.ru/ProjectEndpoint/findAllProjectsSortedByEndDate/Fault/AccessForbiddenException")})
    @RequestWrapper(localName = "findAllProjectsSortedByEndDate", targetNamespace = "http://endpoint.server.tm.eremin.ru/", className = "ru.eremin.tm.server.endpoint.FindAllProjectsSortedByEndDate")
    @ResponseWrapper(localName = "findAllProjectsSortedByEndDateResponse", targetNamespace = "http://endpoint.server.tm.eremin.ru/", className = "ru.eremin.tm.server.endpoint.FindAllProjectsSortedByEndDateResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<ru.eremin.tm.server.endpoint.ProjectDTO> findAllProjectsSortedByEndDate(
        @WebParam(name = "arg0", targetNamespace = "")
        ru.eremin.tm.server.endpoint.SessionDTO arg0
    ) throws IncorrectDataException_Exception, AccessForbiddenException_Exception;

    @WebMethod
    @Action(input = "http://endpoint.server.tm.eremin.ru/ProjectEndpoint/removeProjectRequest", output = "http://endpoint.server.tm.eremin.ru/ProjectEndpoint/removeProjectResponse", fault = {@FaultAction(className = IncorrectDataException_Exception.class, value = "http://endpoint.server.tm.eremin.ru/ProjectEndpoint/removeProject/Fault/IncorrectDataException"), @FaultAction(className = AccessForbiddenException_Exception.class, value = "http://endpoint.server.tm.eremin.ru/ProjectEndpoint/removeProject/Fault/AccessForbiddenException")})
    @RequestWrapper(localName = "removeProject", targetNamespace = "http://endpoint.server.tm.eremin.ru/", className = "ru.eremin.tm.server.endpoint.RemoveProject")
    @ResponseWrapper(localName = "removeProjectResponse", targetNamespace = "http://endpoint.server.tm.eremin.ru/", className = "ru.eremin.tm.server.endpoint.RemoveProjectResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.eremin.tm.server.endpoint.ResultDTO removeProject(
        @WebParam(name = "arg0", targetNamespace = "")
        ru.eremin.tm.server.endpoint.SessionDTO arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1
    ) throws IncorrectDataException_Exception, AccessForbiddenException_Exception;

    @WebMethod
    @Action(input = "http://endpoint.server.tm.eremin.ru/ProjectEndpoint/sessionValidateRequest", output = "http://endpoint.server.tm.eremin.ru/ProjectEndpoint/sessionValidateResponse", fault = {@FaultAction(className = IncorrectDataException_Exception.class, value = "http://endpoint.server.tm.eremin.ru/ProjectEndpoint/sessionValidate/Fault/IncorrectDataException"), @FaultAction(className = AccessForbiddenException_Exception.class, value = "http://endpoint.server.tm.eremin.ru/ProjectEndpoint/sessionValidate/Fault/AccessForbiddenException")})
    @RequestWrapper(localName = "sessionValidate", targetNamespace = "http://endpoint.server.tm.eremin.ru/", className = "ru.eremin.tm.server.endpoint.SessionValidate")
    @ResponseWrapper(localName = "sessionValidateResponse", targetNamespace = "http://endpoint.server.tm.eremin.ru/", className = "ru.eremin.tm.server.endpoint.SessionValidateResponse")
    public void sessionValidate(
        @WebParam(name = "arg0", targetNamespace = "")
        ru.eremin.tm.server.endpoint.SessionDTO arg0
    ) throws IncorrectDataException_Exception, AccessForbiddenException_Exception;

    @WebMethod
    @Action(input = "http://endpoint.server.tm.eremin.ru/ProjectEndpoint/persistProjectRequest", output = "http://endpoint.server.tm.eremin.ru/ProjectEndpoint/persistProjectResponse", fault = {@FaultAction(className = IncorrectDataException_Exception.class, value = "http://endpoint.server.tm.eremin.ru/ProjectEndpoint/persistProject/Fault/IncorrectDataException"), @FaultAction(className = AccessForbiddenException_Exception.class, value = "http://endpoint.server.tm.eremin.ru/ProjectEndpoint/persistProject/Fault/AccessForbiddenException")})
    @RequestWrapper(localName = "persistProject", targetNamespace = "http://endpoint.server.tm.eremin.ru/", className = "ru.eremin.tm.server.endpoint.PersistProject")
    @ResponseWrapper(localName = "persistProjectResponse", targetNamespace = "http://endpoint.server.tm.eremin.ru/", className = "ru.eremin.tm.server.endpoint.PersistProjectResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.eremin.tm.server.endpoint.ResultDTO persistProject(
        @WebParam(name = "arg0", targetNamespace = "")
        ru.eremin.tm.server.endpoint.SessionDTO arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        ru.eremin.tm.server.endpoint.ProjectDTO arg1
    ) throws IncorrectDataException_Exception, AccessForbiddenException_Exception;

    @WebMethod
    @Action(input = "http://endpoint.server.tm.eremin.ru/ProjectEndpoint/findAllProjectsSortedByCreateDateRequest", output = "http://endpoint.server.tm.eremin.ru/ProjectEndpoint/findAllProjectsSortedByCreateDateResponse", fault = {@FaultAction(className = IncorrectDataException_Exception.class, value = "http://endpoint.server.tm.eremin.ru/ProjectEndpoint/findAllProjectsSortedByCreateDate/Fault/IncorrectDataException"), @FaultAction(className = AccessForbiddenException_Exception.class, value = "http://endpoint.server.tm.eremin.ru/ProjectEndpoint/findAllProjectsSortedByCreateDate/Fault/AccessForbiddenException")})
    @RequestWrapper(localName = "findAllProjectsSortedByCreateDate", targetNamespace = "http://endpoint.server.tm.eremin.ru/", className = "ru.eremin.tm.server.endpoint.FindAllProjectsSortedByCreateDate")
    @ResponseWrapper(localName = "findAllProjectsSortedByCreateDateResponse", targetNamespace = "http://endpoint.server.tm.eremin.ru/", className = "ru.eremin.tm.server.endpoint.FindAllProjectsSortedByCreateDateResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<ru.eremin.tm.server.endpoint.ProjectDTO> findAllProjectsSortedByCreateDate(
        @WebParam(name = "arg0", targetNamespace = "")
        ru.eremin.tm.server.endpoint.SessionDTO arg0
    ) throws IncorrectDataException_Exception, AccessForbiddenException_Exception;

    @WebMethod
    @Action(input = "http://endpoint.server.tm.eremin.ru/ProjectEndpoint/findProjectsByDescriptionRequest", output = "http://endpoint.server.tm.eremin.ru/ProjectEndpoint/findProjectsByDescriptionResponse", fault = {@FaultAction(className = IncorrectDataException_Exception.class, value = "http://endpoint.server.tm.eremin.ru/ProjectEndpoint/findProjectsByDescription/Fault/IncorrectDataException"), @FaultAction(className = AccessForbiddenException_Exception.class, value = "http://endpoint.server.tm.eremin.ru/ProjectEndpoint/findProjectsByDescription/Fault/AccessForbiddenException")})
    @RequestWrapper(localName = "findProjectsByDescription", targetNamespace = "http://endpoint.server.tm.eremin.ru/", className = "ru.eremin.tm.server.endpoint.FindProjectsByDescription")
    @ResponseWrapper(localName = "findProjectsByDescriptionResponse", targetNamespace = "http://endpoint.server.tm.eremin.ru/", className = "ru.eremin.tm.server.endpoint.FindProjectsByDescriptionResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<ru.eremin.tm.server.endpoint.ProjectDTO> findProjectsByDescription(
        @WebParam(name = "arg0", targetNamespace = "")
        ru.eremin.tm.server.endpoint.SessionDTO arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1
    ) throws IncorrectDataException_Exception, AccessForbiddenException_Exception;

    @WebMethod
    @Action(input = "http://endpoint.server.tm.eremin.ru/ProjectEndpoint/findProjectsByNameRequest", output = "http://endpoint.server.tm.eremin.ru/ProjectEndpoint/findProjectsByNameResponse", fault = {@FaultAction(className = IncorrectDataException_Exception.class, value = "http://endpoint.server.tm.eremin.ru/ProjectEndpoint/findProjectsByName/Fault/IncorrectDataException"), @FaultAction(className = AccessForbiddenException_Exception.class, value = "http://endpoint.server.tm.eremin.ru/ProjectEndpoint/findProjectsByName/Fault/AccessForbiddenException")})
    @RequestWrapper(localName = "findProjectsByName", targetNamespace = "http://endpoint.server.tm.eremin.ru/", className = "ru.eremin.tm.server.endpoint.FindProjectsByName")
    @ResponseWrapper(localName = "findProjectsByNameResponse", targetNamespace = "http://endpoint.server.tm.eremin.ru/", className = "ru.eremin.tm.server.endpoint.FindProjectsByNameResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<ru.eremin.tm.server.endpoint.ProjectDTO> findProjectsByName(
        @WebParam(name = "arg0", targetNamespace = "")
        ru.eremin.tm.server.endpoint.SessionDTO arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1
    ) throws IncorrectDataException_Exception, AccessForbiddenException_Exception;

    @WebMethod
    @Action(input = "http://endpoint.server.tm.eremin.ru/ProjectEndpoint/findAllProjectsRequest", output = "http://endpoint.server.tm.eremin.ru/ProjectEndpoint/findAllProjectsResponse", fault = {@FaultAction(className = IncorrectDataException_Exception.class, value = "http://endpoint.server.tm.eremin.ru/ProjectEndpoint/findAllProjects/Fault/IncorrectDataException"), @FaultAction(className = AccessForbiddenException_Exception.class, value = "http://endpoint.server.tm.eremin.ru/ProjectEndpoint/findAllProjects/Fault/AccessForbiddenException")})
    @RequestWrapper(localName = "findAllProjects", targetNamespace = "http://endpoint.server.tm.eremin.ru/", className = "ru.eremin.tm.server.endpoint.FindAllProjects")
    @ResponseWrapper(localName = "findAllProjectsResponse", targetNamespace = "http://endpoint.server.tm.eremin.ru/", className = "ru.eremin.tm.server.endpoint.FindAllProjectsResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<ru.eremin.tm.server.endpoint.ProjectDTO> findAllProjects(
        @WebParam(name = "arg0", targetNamespace = "")
        ru.eremin.tm.server.endpoint.SessionDTO arg0
    ) throws IncorrectDataException_Exception, AccessForbiddenException_Exception;

    @WebMethod
    @Action(input = "http://endpoint.server.tm.eremin.ru/ProjectEndpoint/updateProjectRequest", output = "http://endpoint.server.tm.eremin.ru/ProjectEndpoint/updateProjectResponse", fault = {@FaultAction(className = IncorrectDataException_Exception.class, value = "http://endpoint.server.tm.eremin.ru/ProjectEndpoint/updateProject/Fault/IncorrectDataException"), @FaultAction(className = AccessForbiddenException_Exception.class, value = "http://endpoint.server.tm.eremin.ru/ProjectEndpoint/updateProject/Fault/AccessForbiddenException")})
    @RequestWrapper(localName = "updateProject", targetNamespace = "http://endpoint.server.tm.eremin.ru/", className = "ru.eremin.tm.server.endpoint.UpdateProject")
    @ResponseWrapper(localName = "updateProjectResponse", targetNamespace = "http://endpoint.server.tm.eremin.ru/", className = "ru.eremin.tm.server.endpoint.UpdateProjectResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.eremin.tm.server.endpoint.ResultDTO updateProject(
        @WebParam(name = "arg0", targetNamespace = "")
        ru.eremin.tm.server.endpoint.SessionDTO arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        ru.eremin.tm.server.endpoint.ProjectDTO arg1
    ) throws IncorrectDataException_Exception, AccessForbiddenException_Exception;

    @WebMethod
    @Action(input = "http://endpoint.server.tm.eremin.ru/ProjectEndpoint/findAllProjectsSortedByStartDateRequest", output = "http://endpoint.server.tm.eremin.ru/ProjectEndpoint/findAllProjectsSortedByStartDateResponse", fault = {@FaultAction(className = IncorrectDataException_Exception.class, value = "http://endpoint.server.tm.eremin.ru/ProjectEndpoint/findAllProjectsSortedByStartDate/Fault/IncorrectDataException"), @FaultAction(className = AccessForbiddenException_Exception.class, value = "http://endpoint.server.tm.eremin.ru/ProjectEndpoint/findAllProjectsSortedByStartDate/Fault/AccessForbiddenException")})
    @RequestWrapper(localName = "findAllProjectsSortedByStartDate", targetNamespace = "http://endpoint.server.tm.eremin.ru/", className = "ru.eremin.tm.server.endpoint.FindAllProjectsSortedByStartDate")
    @ResponseWrapper(localName = "findAllProjectsSortedByStartDateResponse", targetNamespace = "http://endpoint.server.tm.eremin.ru/", className = "ru.eremin.tm.server.endpoint.FindAllProjectsSortedByStartDateResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<ru.eremin.tm.server.endpoint.ProjectDTO> findAllProjectsSortedByStartDate(
        @WebParam(name = "arg0", targetNamespace = "")
        ru.eremin.tm.server.endpoint.SessionDTO arg0
    ) throws IncorrectDataException_Exception, AccessForbiddenException_Exception;

    @WebMethod
    @Action(input = "http://endpoint.server.tm.eremin.ru/ProjectEndpoint/removeAllProjectsRequest", output = "http://endpoint.server.tm.eremin.ru/ProjectEndpoint/removeAllProjectsResponse", fault = {@FaultAction(className = IncorrectDataException_Exception.class, value = "http://endpoint.server.tm.eremin.ru/ProjectEndpoint/removeAllProjects/Fault/IncorrectDataException"), @FaultAction(className = AccessForbiddenException_Exception.class, value = "http://endpoint.server.tm.eremin.ru/ProjectEndpoint/removeAllProjects/Fault/AccessForbiddenException")})
    @RequestWrapper(localName = "removeAllProjects", targetNamespace = "http://endpoint.server.tm.eremin.ru/", className = "ru.eremin.tm.server.endpoint.RemoveAllProjects")
    @ResponseWrapper(localName = "removeAllProjectsResponse", targetNamespace = "http://endpoint.server.tm.eremin.ru/", className = "ru.eremin.tm.server.endpoint.RemoveAllProjectsResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.eremin.tm.server.endpoint.ResultDTO removeAllProjects(
        @WebParam(name = "arg0", targetNamespace = "")
        ru.eremin.tm.server.endpoint.SessionDTO arg0
    ) throws IncorrectDataException_Exception, AccessForbiddenException_Exception;

    @WebMethod
    @Action(input = "http://endpoint.server.tm.eremin.ru/ProjectEndpoint/findOneProjectRequest", output = "http://endpoint.server.tm.eremin.ru/ProjectEndpoint/findOneProjectResponse", fault = {@FaultAction(className = IncorrectDataException_Exception.class, value = "http://endpoint.server.tm.eremin.ru/ProjectEndpoint/findOneProject/Fault/IncorrectDataException"), @FaultAction(className = AccessForbiddenException_Exception.class, value = "http://endpoint.server.tm.eremin.ru/ProjectEndpoint/findOneProject/Fault/AccessForbiddenException")})
    @RequestWrapper(localName = "findOneProject", targetNamespace = "http://endpoint.server.tm.eremin.ru/", className = "ru.eremin.tm.server.endpoint.FindOneProject")
    @ResponseWrapper(localName = "findOneProjectResponse", targetNamespace = "http://endpoint.server.tm.eremin.ru/", className = "ru.eremin.tm.server.endpoint.FindOneProjectResponse")
    @WebResult(name = "return", targetNamespace = "")
    public ru.eremin.tm.server.endpoint.ProjectDTO findOneProject(
        @WebParam(name = "arg0", targetNamespace = "")
        ru.eremin.tm.server.endpoint.SessionDTO arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1
    ) throws IncorrectDataException_Exception, AccessForbiddenException_Exception;
}
