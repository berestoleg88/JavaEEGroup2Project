package org.example.processors;

import org.example.dao.DAOFactory;
import org.example.entities.ProcessorResult;
import org.example.entities.Student;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ProcessorShowAllStudents extends Processor {

    public ProcessorShowAllStudents (DAOFactory dao) {
        actionToPerform = "showAllStudents";
        daoFactory = dao;
    }

    @Override
    public ProcessorResult handle(HttpServletRequest request) {
        List<Student> allStudents = daoFactory.getStudentDAO().getAllStudents();
        allStudents.forEach(System.out::println);
        request.setAttribute("studentList", allStudents);
        return new ProcessorResult("pages/template.jsp", true, "showAllStudents.jsp");
    }
}
