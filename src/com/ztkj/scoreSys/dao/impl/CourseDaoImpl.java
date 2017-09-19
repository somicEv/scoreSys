package com.ztkj.scoreSys.dao.impl;

import com.ztkj.scoreSys.dao.ICourseDao;
import com.ztkj.scoreSys.model.Course;
import com.ztkj.scoreSys.model.Teacher;
import com.ztkj.scoreSys.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoImpl implements ICourseDao{

    private Connection con;
    private PreparedStatement pstm;
    private ResultSet rs;

    @Override
    public List<Course> getAllCourses(){
        List<Course> courseList = new ArrayList<>();
        try {
            con = JDBCUtil.getConnection();
            String sql = "select tc.id, tc.cname,tc.tid, tt.tname  from t_course tc left join t_teacher tt on tc.tid=tt.id";
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Course course = new Course();
                course.setId(rs.getInt("id"));
                course.setCname(rs.getString("cname"));
                Teacher teacher = new Teacher();
                teacher.setId(rs.getInt("tid"));
                teacher.setTname(rs.getString("tname"));
                course.setTeacher(teacher);
                courseList.add(course);
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
        return courseList;
    }

    @Override
    public Course getCourseById(int id) {
        Course course = null;
        try {
            con = JDBCUtil.getConnection();
            String sql = "select tc.id, tc.cname,tc.tid, tt.tname  from t_course tc left join t_teacher tt on tc.tid=tt.id where tc.id=?";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            if (rs.next()) {
                course = new Course();
                course.setId(rs.getInt("id"));
                course.setCname(rs.getString("cname"));
                Teacher teacher = new Teacher();
                teacher.setId(rs.getInt("tid"));
                teacher.setTname(rs.getString("tname"));
                course.setTeacher(teacher);
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
        return course;
    }

    @Override
    public boolean addCourse(Course course) {
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = JDBCUtil.getConnection();
            String sql = "insert into t_course (cname, tid) values(?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, course.getCname());
            pstm.setInt(2, course.getTeacher().getId());
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
    public boolean updateCourse(Course course) {
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = JDBCUtil.getConnection();
            String sql = "update t_course set cname=?, tid=? where id=?";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, course.getCname());
            pstm.setInt(2, course.getTeacher().getId());
            pstm.setInt(3, course.getId());
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
    public boolean delCourse(int id) {
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = JDBCUtil.getConnection();
            String sql = "delete from t_course where id=?";
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
