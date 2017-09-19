package com.ztkj.scoreSys.dao.impl;

import com.ztkj.scoreSys.dao.IStudentDao;
import com.ztkj.scoreSys.model.Classes;
import com.ztkj.scoreSys.model.Student;
import com.ztkj.scoreSys.util.DateUtils;
import com.ztkj.scoreSys.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements IStudentDao {

    private Connection con;
    private PreparedStatement pstm;
    private ResultSet rs;

    @Override
    public Student login(String tname, String tpwd) {
        Student stu = null;
        try {
            con = JDBCUtil.getConnection();
            String sql = "select id,stuno,stuname, spwd, gender,classid, age from t_student where stuname=? and spwd=?";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, tname);
            pstm.setString(2, tpwd);
            rs = pstm.executeQuery();
            if (rs.next()) {
                stu = new Student();
                stu.setId(rs.getInt("id"));
                stu.setStuno(rs.getString("stuno"));
                stu.setStuname(rs.getString("stuname"));
                stu.setAge((int) rs.getDouble("age"));
                Classes cl = new Classes();
                cl.setId(rs.getInt("classid"));
                stu.setCl(cl);
                stu.setGender(rs.getString("gender"));
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
        return stu;
    }

    @Override
    public List<Student> getAllStus() {
        List<Student> stuList = new ArrayList<Student>();
        try {
            con = JDBCUtil.getConnection();
            String sql = "select stu.id, stu.stuno, stu.stuname, stu.spwd, stu.gender, age,"
                    + "cl.id as classid, cl.clno, cl.clname, cl.collage from t_student stu left join t_classes cl on "
                    + "stu.classid=cl.id";
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Student stu = new Student();
                stu.setId(rs.getInt("id"));
                stu.setStuno(rs.getString("stuno"));
                stu.setStuname(rs.getString("stuname"));
                stu.setAge((int) rs.getDouble("age"));
                Classes cl = new Classes();
                cl.setId(rs.getInt("classid"));
                cl.setClno(rs.getString("clno"));
                cl.setClname(rs.getString("clname"));
                cl.setCollage(rs.getString("collage"));
                stu.setCl(cl);

                stu.setGender(rs.getString("gender"));

                stuList.add(stu);
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

        return stuList;
    }

    @Override
    public Student getStuById(int id) {
        Student stu = null;
        try {
            con = JDBCUtil.getConnection();
            String sql = "select stu.id, stu.stuno, stu.stuname, stu.spwd, stu.gender, stu.birthday,"
                    + "cl.id as classid, cl.clno, cl.clname, cl.collage from t_student stu left join t_classes cl on "
                    + "stu.classid=cl.id where stu.id=?";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            if (rs.next()) {
                stu = new Student();
                stu.setId(rs.getInt("id"));
                stu.setStuno(rs.getString("stuno"));
                stu.setStuname(rs.getString("stuname"));
                //stu.setAge((int)rs.getDouble("age"));
                stu.setBirthday(rs.getString("birthday"));
                stu.setSpwd(rs.getString("spwd"));
                Classes cl = new Classes();
                cl.setId(rs.getInt("classid"));
                stu.setCl(cl);
                stu.setGender(rs.getString("gender"));
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
        return stu;
    }

    @Override
    public boolean updateStu(Student stu) {
        try {
            con = JDBCUtil.getConnection();
            String sql = "update t_student set stuno=?,stuname=?,spwd=?,gender=?,birthday=? where id=?";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, stu.getStuno());
            pstm.setString(2, stu.getStuname());
            pstm.setString(3, stu.getSpwd());
            pstm.setString(4, stu.getGender());
            pstm.setString(5, stu.getBirthday());
            pstm.setInt(6, stu.getId());
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
    public boolean delStu(int id) {
        try {
            con = JDBCUtil.getConnection();
            String sql = "delete from t_student where id=?";
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
    public boolean addStu(Student stu) {
        try {
            con = JDBCUtil.getConnection();
            String sql = "insert into t_student (stuno, stuname, spwd, gender, birthday, age, classid) values(?,?,?,?,?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, stu.getStuno());
            pstm.setString(2, stu.getStuname());
            pstm.setString(3, stu.getSpwd());
            pstm.setString(4, stu.getGender());
            pstm.setString(5, stu.getBirthday());
            pstm.setInt(6, stu.getAge());
            pstm.setInt(7, stu.getCl().getId());
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
