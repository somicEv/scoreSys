package com.ztkj.scoreSys.service;

import com.ztkj.scoreSys.dao.IScoreDao;
import com.ztkj.scoreSys.dao.impl.ScoreDaoDaoImpl;
import com.ztkj.scoreSys.model.Course;
import com.ztkj.scoreSys.model.Score;
import com.ztkj.scoreSys.model.Student;

import java.util.List;

public class ScoreService {

    public List<Score> selectScoreInfo(){
        IScoreDao iScoreDao = new ScoreDaoDaoImpl();
        return iScoreDao.getAllScores();
    }

    public Score selectScoreInfoById(Integer id){
        IScoreDao iScoreDao = new ScoreDaoDaoImpl();
        return iScoreDao.getScoreById(id);
    }

    public boolean updateScoreInfo(Double score, Integer sid, Integer cid,Integer scoreId) {
        Student student = new Student();
        student.setId(sid);
        Course course = new Course();
        course.setId(cid);
        Score updateScore = new Score();
        updateScore.setId(scoreId);
        updateScore.setScore(score);
        updateScore.setStu(student);
        updateScore.setCourse(course);
        IScoreDao iScoreDao = new ScoreDaoDaoImpl();
        return iScoreDao.updateScore(updateScore);
    }

    public boolean deleteScoreInfo(Integer scoreId) {
        IScoreDao iScoreDao = new ScoreDaoDaoImpl();
        return iScoreDao.delScore(scoreId);
    }

    public boolean addScoreInfo(Double score, Integer sid, Integer cid){
        Student student = new Student();
        student.setId(sid);
        Course course = new Course();
        course.setId(cid);
        Score saveScore = new Score();
        saveScore.setScore(score);
        saveScore.setStu(student);
        saveScore.setCourse(course);
        IScoreDao iScoreDao = new ScoreDaoDaoImpl();
        return iScoreDao.addScore(saveScore);
    }
}
