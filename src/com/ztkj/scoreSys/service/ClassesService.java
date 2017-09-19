package com.ztkj.scoreSys.service;

import com.ztkj.scoreSys.dao.IClassesDao;
import com.ztkj.scoreSys.dao.impl.ClassesDaoImpl;
import com.ztkj.scoreSys.model.Classes;

import java.util.List;

public class ClassesService {

    public Classes selectClassInfo(Integer classId) {
        IClassesDao iClassesDao = new ClassesDaoImpl();
        return iClassesDao.getClById(classId);
    }

    public List<Classes> selectAllClassInfo(){
        IClassesDao iClassesDao = new ClassesDaoImpl();
        return iClassesDao.getAllClasses();
    }

    public boolean updateClassesInfo(Classes classes){
        IClassesDao iClassesDao = new ClassesDaoImpl();
        return iClassesDao.updateClasses(classes);
    }

    public boolean addClassesInfo(Classes classes) {
        IClassesDao iClassesDao = new ClassesDaoImpl();
        return iClassesDao.addClasses(classes);
    }

}
