package com.ztkj.scoreSys.dao.impl;

import com.ztkj.scoreSys.dao.ITeacherDao;
import com.ztkj.scoreSys.model.Teacher;
import com.ztkj.scoreSys.util.DateUtils;
import com.ztkj.scoreSys.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherDaoImpl implements ITeacherDao {

    private Connection con;
    private PreparedStatement pstm;
    private ResultSet rs;

    @Override
    public Teacher login(String tname, String tpwd) {
        Teacher teacher = null;
        try {
            con = JDBCUtil.getConnection();
            String sql = "select * from t_teacher where tname=? and tpwd=?";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, tname);
            pstm.setString(2, tpwd);
            rs = pstm.executeQuery();
            if (rs.next()) {
                teacher = new Teacher();
                teacher.setId(rs.getInt("id"));
                teacher.setTname(tname);
                teacher.setTpwd(tpwd);
                teacher.setCollage(rs.getString("collage"));
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
        return teacher;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        List<Teacher> teachersList = new ArrayList<>();
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = JDBCUtil.getConnection();
            String sql = "select * from t_teacher";
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Teacher teacher = new Teacher();
                teacher.setId(rs.getInt("id"));
                teacher.setTname(rs.getString("tname"));
                teacher.setTpwd(rs.getString("tpwd"));
                teacher.setCollage(rs.getString("collage"));
                teachersList.add(teacher);
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
        return teachersList;
    }

    @Override
    public Teacher getTeacherById(int id) {
        Teacher teacher = null;
        try {
            con = JDBCUtil.getConnection();
            String sql = "select * from t_teacher where id=?";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            if (rs.next()) {
                teacher = new Teacher();
                teacher.setId(rs.getInt("id"));
                teacher.setTname(rs.getString("tname"));
                teacher.setTpwd(rs.getString("tpwd"));
                teacher.setCollage(rs.getString("collage"));
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
        return teacher;
    }

    @Override
    public boolean delTeacher(int id) {
        try {
            con = JDBCUtil.getConnection();
            String sql = "delete from t_teacher where id=?";
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

    @Override
    public boolean updateTeacher(Teacher teacher) {
        try {
            con = JDBCUtil.getConnection();
            String sql = "update t_teacher set tname=?,tpwd=?,collage=? where id=?";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, teacher.getTname());
            pstm.setString(2, teacher.getTpwd());
            pstm.setString(3, teacher.getCollage());
            pstm.setInt(4, teacher.getId());
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
    public boolean addTeacher(Teacher teacher) {
        try {
            con = JDBCUtil.getConnection();
            String sql = "insert into t_teacher (tname,tpwd,collage) values(?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, teacher.getTname());
            pstm.setString(2, teacher.getTpwd());
            pstm.setString(3, teacher.getCollage());
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
