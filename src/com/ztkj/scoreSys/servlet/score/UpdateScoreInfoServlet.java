package com.ztkj.scoreSys.servlet.score;

import com.ztkj.scoreSys.model.Score;
import com.ztkj.scoreSys.service.ScoreService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateScoreInfoServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sid = request.getParameter("sid");
        String cid = request.getParameter("cid");
        String score = request.getParameter("score");
        String scoreId = request.getParameter("id");
        ScoreService scoreService = new ScoreService();
        boolean b = scoreService.updateScoreInfo(Double.parseDouble(score), Integer.parseInt(sid),Integer.parseInt(cid),Integer.parseInt(scoreId));
        if (!b){
            response.sendRedirect("/updateScoreInfoServlet");
        }
        response.sendRedirect("/showScoreInfoServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String scoreId = request.getParameter("scoreId");
        ScoreService scoreService = new ScoreService();
        Score score = scoreService.selectScoreInfoById(Integer.parseInt(scoreId));
        request.setAttribute("scoreInfo",score);
        request.getRequestDispatcher("WEB-INF/views/score/score_update.jsp").forward(request, response);
    }
}
