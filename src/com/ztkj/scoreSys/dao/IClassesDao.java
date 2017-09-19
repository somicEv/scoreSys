package com.ztkj.scoreSys.dao;

import java.util.List;

import com.ztkj.scoreSys.model.Classes;

public interface IClassesDao {
    List<Classes> getAllClasses();

    boolean addClasses(Classes cl);

    Classes getClById(int id);

    boolean updateClasses(Classes cl);
}
