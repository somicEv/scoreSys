package com.ztkj.scoreSys.servlet.classes;

import com.ztkj.scoreSys.model.Classes;
import com.ztkj.scoreSys.service.ClassesService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddClassInfoServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String clno = request.getParameter("clno");
        String clname = request.getParameter("clname");
        String collage = request.getParameter("collage");
        Classes classes = new Classes(clno, clname, collage);
        ClassesService classesService = new ClassesService();
        boolean b = classesService.addClassesInfo(classes);
        if (!b){
            // 如果不成功
            request.getRequestDispatcher("WEB-INF/views/classes/classes_add.jsp").forward(request, response);
        }
        response.sendRedirect("/showClassInfo");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/classes/classes_add.jsp").forward(request, response);
    }
}
