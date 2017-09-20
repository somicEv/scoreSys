package com.ztkj.scoreSys.servlet.score;

import com.ztkj.scoreSys.service.ScoreService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteScoreInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String scoreId = request.getParameter("scoreId");
        ScoreService scoreService = new ScoreService();
        boolean b = scoreService.deleteScoreInfo(Integer.parseInt(scoreId));
        if (!b){
            response.sendRedirect("/showScoreInfoServlet");
        }
        response.sendRedirect("/showScoreInfoServlet");
    }
}
