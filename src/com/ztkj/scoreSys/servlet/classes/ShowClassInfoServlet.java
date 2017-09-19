package com.ztkj.scoreSys.servlet.classes;

import com.ztkj.scoreSys.model.Classes;
import com.ztkj.scoreSys.service.ClassesService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShowClassInfoServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClassesService classesService = new ClassesService();
        List<Classes> classesList = classesService.selectAllClassInfo();
        request.setAttribute("classList", classesList);
        request.getRequestDispatcher("WEB-INF/views/classes/classes_list.jsp").forward(request, response);
    }
}
