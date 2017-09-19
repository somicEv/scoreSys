package com.ztkj.scoreSys.dao.impl;

import com.ztkj.scoreSys.dao.IScoreDao;
import com.ztkj.scoreSys.model.Course;
import com.ztkj.scoreSys.model.Score;
import com.ztkj.scoreSys.model.Student;
import com.ztkj.scoreSys.model.Teacher;
import com.ztkj.scoreSys.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ScoreDaoDaoImpl implements IScoreDao {

    private Connection con;
    private PreparedStatement pstm;
    private ResultSet rs;

    @Override
    public List<Score> getAllScores() {
        List<Score> scoreList = new ArrayList<>();
        try {
            con = JDBCUtil.getConnection();
            String sql = "select ts.id, ts.score, stu.id as sid, stu.stuno, stu.stuname, tc.id as cid, tc.cname, tt.id as tid, tt.tname from t_score ts, t_student stu, t_course tc, t_teacher tt where ts.sid=stu.id and ts.cid=tc.id and tc.tid=tt.id";
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Score score = new Score();
                score.setId(rs.getInt("id"));
                score.setScore(rs.getDouble("score"));
                Student stu = new Student();
                stu.setId(rs.getInt("sid"));
                stu.setStuno(rs.getString("stuno"));
                stu.setStuname(rs.getString("stuname"));
                score.setStu(stu);
                Course course = new Course();
                course.setId(rs.getInt("cid"));
                course.setCname(rs.getString("cname"));

                Teacher teacher = new Teacher();
                teacher.setId(rs.getInt("tid"));
                teacher.setTname(rs.getString("tname"));
                course.setTeacher(teacher);
                score.setCourse(course);
                scoreList.add(score);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                JDBCUtil.closeAll(rs, pstm, con);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return scoreList;
    }

    @Override
    public Score getScoreById(int id) {
        Score score = null;
        try {
            con = JDBCUtil.getConnection();
            String sql = "select ts.id, ts.score, stu.id as sid, stu.stuno, stu.stuname, tc.id as cid, tc.cname, tt.id as tid, tt.tname from t_score ts, t_student stu, t_course tc, t_teacher tt where ts.sid=stu.id and ts.cid=tc.id and tc.tid=tt.id and ts.id=?";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            if (rs.next()) {
                score = new Score();
                score.setId(rs.getInt("id"));
                score.setScore(rs.getDouble("score"));
                Student stu = new Student();
                stu.setId(rs.getInt("sid"));
                stu.setStuno(rs.getString("stuno"));
                stu.setStuname(rs.getString("stuname"));
                score.setStu(stu);
                Course course = new Course();
                course.setId(rs.getInt("cid"));
                course.setCname(rs.getString("cname"));
                Teacher teacher = new Teacher();
                teacher.setId(rs.getInt("tid"));
                teacher.setTname(rs.getString("tname"));
                course.setTeacher(teacher);
                score.setCourse(course);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                JDBCUtil.closeAll(rs, pstm, con);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return score;
    }

    @Override
    public boolean addScore(Score score) {
        try {
            con = JDBCUtil.getConnection();
            String sql = "insert into t_score values(seq_score.nextval, ?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, score.getStu().getId());
            pstm.setInt(2, score.getCourse().getId());
            pstm.setDouble(3, score.getScore());
            int res = pstm.executeUpdate();
            if (res > 0) {
                return true;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                JDBCUtil.closeAll(null, pstm, con);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean updateScore(Score score) {
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = JDBCUtil.getConnection();
            String sql = "update t_score set sid=?,cid=?,score=? where id=?";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, score.getStu().getId());
            pstm.setInt(2, score.getCourse().getId());
            pstm.setDouble(3, score.getScore());
            pstm.setInt(4, score.getId());
            int res = pstm.executeUpdate();
            if (res > 0) {
                return true;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                JDBCUtil.closeAll(null, pstm, con);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean delScore(int id) {
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = JDBCUtil.getConnection();
            String sql = "delete from t_score where id=?";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            int res = pstm.executeUpdate();
            if (res > 0) {
                return true;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                JDBCUtil.closeAll(null, pstm, con);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

}
