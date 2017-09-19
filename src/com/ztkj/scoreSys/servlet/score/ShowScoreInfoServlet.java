package com.ztkj.scoreSys.servlet.score;

import com.ztkj.scoreSys.model.Score;
import com.ztkj.scoreSys.service.ScoreService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShowScoreInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ScoreService scoreService = new ScoreService();
        List<Score> scoreList = scoreService.selectScoreInfo();
        request.setAttribute("scoreList", scoreList);
        request.getRequestDispatcher("WEB-INF/views/score/score_list.jsp").forward(request, response);
    }
}
