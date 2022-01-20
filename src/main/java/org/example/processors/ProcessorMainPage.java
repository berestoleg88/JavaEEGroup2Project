package org.example.processors;

import org.example.dao.DAOFactory;
import org.example.entities.ProcessorResult;

import javax.servlet.http.HttpServletRequest;

public class ProcessorMainPage extends Processor {

    public ProcessorMainPage (DAOFactory dao) {
        actionToPerform = "mainPage";
        daoFactory = dao;
    }

    @Override
    public ProcessorResult handle(HttpServletRequest request) {
        System.out.println("main page");
        String username = request.getParameter("username");
        request.getSession().setAttribute("username", username);
        return new ProcessorResult("pages/template.jsp", true, null);
    }
}
