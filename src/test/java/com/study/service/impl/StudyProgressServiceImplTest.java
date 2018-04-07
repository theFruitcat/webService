package com.study.service.impl;

import com.study.domain.StudyProgressVO;
import com.study.service.StudyProgressService;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:Spring-myBaties.xml"})
public class StudyProgressServiceImplTest extends TestCase {

    @Autowired
    @Qualifier("StudyProgressService")
    StudyProgressService studyProgressServiceDao;

    @Test
    public void updateStudyProgress() {
        StudyProgressVO studyProgressVO = new StudyProgressVO();
        studyProgressVO.setUserId("771984187");
        studyProgressVO.setCategoryId(0);
        studyProgressVO.setCurrentNumber(3);
        studyProgressVO.setPassed("true");
        int number;
        number = studyProgressServiceDao.updateStudyProgress(studyProgressVO);
        System.out.printf(" " + number);
    }

    @Test
    //测试查询用户的学习进度
    public void testGetStudyProgress(){
        String id = "71984187";
        StudyProgressVO studyProgressVO = studyProgressServiceDao.getStudyProgress(id);
        if(studyProgressVO == null){
            System.out.printf(" " + "对象为空");
        }else{
        System.out.printf(" " + studyProgressVO.getPassed());
        }
    }

    @Test
    public void insertStudyProgress() {
        StudyProgressVO studyProgressVO = new StudyProgressVO();
        studyProgressVO.setUserId("235066");
        studyProgressVO.setCategoryId(0);
        studyProgressVO.setCurrentNumber(1);
        studyProgressVO.setPassed("none");
        int number;
        number = studyProgressServiceDao.insertStudyProgress(studyProgressVO);
        System.out.printf(" " + number);
    }
}