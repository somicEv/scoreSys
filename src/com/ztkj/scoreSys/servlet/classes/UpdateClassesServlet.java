package com.ztkj.scoreSys.servlet.classes;

import com.ztkj.scoreSys.model.Classes;
import com.ztkj.scoreSys.service.ClassesService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateClassesServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String clno = request.getParameter("clno");
        String clname = request.getParameter("clname");
        String collage = request.getParameter("collage");
        Classes classes = new Classes(clno,clname,collage);
        classes.setId(Integer.parseInt(id));
        ClassesService classesService = new ClassesService();
        boolean b = classesService.updateClassesInfo(classes);
        System.out.println(b);
        if (!b){
            // 如果不成功
            response.sendRedirect("/updateClassInfo");
        }
        response.sendRedirect("/showClassInfo");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String classesId = request.getParameter("classId");
        ClassesService classesService = new ClassesService();
        Classes classes = classesService.selectClassInfo(Integer.parseInt(classesId));
        request.setAttribute("classInfo",classes);
        // TODO 通过json传递信息
        request.getRequestDispatcher("WEB-INF/views/classes/classes_update.jsp").forward(request,response);
    }
}
