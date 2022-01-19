package org.example.processors;

import org.example.dao.DAOFactory;
import org.example.entities.ProcessorResult;

import javax.servlet.http.HttpServletRequest;

public abstract class Processor {
    protected String actionToPerform;
    protected DAOFactory daoFactory;

    public boolean canHandle(String action) {
        return actionToPerform.equals(action);
    }

    public abstract ProcessorResult handle (HttpServletRequest request);
}
