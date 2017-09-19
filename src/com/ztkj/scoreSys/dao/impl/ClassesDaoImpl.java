package com.ztkj.scoreSys.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ztkj.scoreSys.dao.IClassesDao;
import com.ztkj.scoreSys.model.Classes;
import com.ztkj.scoreSys.util.JDBCUtil;



public class ClassesDaoImpl implements IClassesDao {

	private Connection con;

	private PreparedStatement pstm;

	private ResultSet rs;

	@Override
	public List<Classes> getAllClasses() {
		List<Classes> clsList = new ArrayList<>();
		try {
			con = JDBCUtil.getConnection();
			String sql = "select * from t_classes order by id";
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				Classes cl = new Classes();
				cl.setId(rs.getInt("id"));
				cl.setClno(rs.getString("clno"));
				cl.setClname(rs.getString("clname"));
				cl.setCollage(rs.getString("collage"));
				clsList.add(cl);
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
		return clsList;
	}

	@Override
	public boolean addClasses(Classes cl) {
		try {
			con = JDBCUtil.getConnection();
			String sql = "insert into t_classes (clno, clname, collage) values(?, ?, ?)";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, cl.getClno());
			pstm.setString(2, cl.getClname());
			pstm.setString(3, cl.getCollage());
			int res = pstm.executeUpdate();
			if (res >= 1) {
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
	public Classes getClById(int id) {
		Classes cl = null;
		try {
			con = JDBCUtil.getConnection();
			String sql = "select * from t_classes where id=?";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			if (rs.next()) {
				cl = new Classes();
				cl.setId(rs.getInt("id"));
				cl.setClno(rs.getString("clno"));
				cl.setClname(rs.getString("clname"));
				cl.setCollage(rs.getString("collage"));
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
		return cl;
	}

	@Override
	public boolean updateClasses(Classes cl) {
		try {
			con = JDBCUtil.getConnection();
			String sql = "update t_classes set clno=?, clname=? ,collage=? where id=?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, cl.getClno());
			pstm.setString(2, cl.getClname());
			pstm.setString(3,cl.getCollage());
			pstm.setInt(4, cl.getId());
			int res = pstm.executeUpdate();
			if (res >= 1) {
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
