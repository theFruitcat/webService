package com.study.dao;

import com.study.domain.AdministratorVO;
/**
 * ����Աʵ����ӿ�
 * */
public interface AdministratorVOMapper {
    //����IDɾ������Ա
    int deleteByPrimaryKey(String administratorId);
    //��ӹ���Ա ���Ƽ�
    int insert(AdministratorVO record);
    //��ӹ���Ա
    int insertSelective(AdministratorVO record);
    //��ѯ����Ա
    AdministratorVO selectByPrimaryKey(String administratorId);
    //���¹���Ա
    int updateByPrimaryKeySelective(AdministratorVO record);
    //���¹���Ա ���Ƽ�
    int updateByPrimaryKey(AdministratorVO record);
}