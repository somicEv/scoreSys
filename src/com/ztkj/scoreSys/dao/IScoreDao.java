package com.ztkj.scoreSys.dao;

import com.ztkj.scoreSys.model.Score;

import java.util.List;

public interface IScoreDao {

    List<Score> getAllScores();

    Score getScoreById(int id);

    boolean addScore(Score score);

    boolean updateScore(Score score);

    boolean delScore(int id);

}
