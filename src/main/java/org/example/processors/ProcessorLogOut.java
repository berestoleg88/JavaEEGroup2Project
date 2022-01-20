package org.example.processors;

import org.example.entities.ProcessorResult;

import javax.servlet.http.HttpServletRequest;

public class ProcessorLogOut extends Processor {

    public ProcessorLogOut () {
        actionToPerform = "logOut";
    }

    @Override
    public ProcessorResult handle(HttpServletRequest request) {
        request.getSession().invalidate();
        return new ProcessorResult("pages/welcome.jsp", true, null);
    }
}
