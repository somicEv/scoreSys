package com.ztkj.scoreSys.service;

import com.ztkj.scoreSys.dao.IScoreDao;
import com.ztkj.scoreSys.dao.impl.ScoreDaoDaoImpl;
import com.ztkj.scoreSys.model.Score;

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
}
