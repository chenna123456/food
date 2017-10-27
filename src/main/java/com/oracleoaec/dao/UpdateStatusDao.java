package com.oracleoaec.dao;

import com.oracleoaec.entity.Status;

public interface UpdateStatusDao {
Status findBy(int vid,int aid);
void updateStatus(Status status);
void updateBy(int id,int status);

}
