package org.example.controllers;

import org.example.dao.DAOFactory;
import org.example.dao.DBType;
import org.example.entities.ProcessorResult;
import org.example.processors.Processor;
import org.example.processors.ProcessorMainPage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DispatcherServlet extends HttpServlet {
    private List<Processor> processorList = new ArrayList<>();


    @Override
    public void init() throws ServletException {
        super.init();
        DAOFactory daoFactory = DAOFactory.getDAOFactory(DBType.ORACLE);
        processorList.add(new ProcessorMainPage(daoFactory));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        System.out.println("It works");
        String action = req.getParameter("action");
        for (Processor processor: processorList) {
            if (processor.canHandle(action)) {
                ProcessorResult processorResult = processor.handle(req);
                if (processorResult.getIncludedPage() != null) {
                    req.getSession().setAttribute("includedPage", processorResult.getIncludedPage());
                }
                if (processorResult.isForward()) {
                    req.getRequestDispatcher(processorResult.getUrl()).forward(req, resp);
                } else {
                    resp.sendRedirect(processorResult.getUrl());
                }
            }
        }
    }
}
