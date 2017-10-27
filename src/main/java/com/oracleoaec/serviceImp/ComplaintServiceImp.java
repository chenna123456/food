package com.oracleoaec.serviceImp;

import java.util.Date;
import java.util.List;

import com.oracleoaec.dao.ComplaintDao;
import com.oracleoaec.daoImp.ComplaintDaoImp;
import com.oracleoaec.entity.Complaint;
import com.oracleoaec.service.ComplaintService;

public class ComplaintServiceImp implements ComplaintService {

	public int addComplaint(String title, String content, String complaintName, String gender, int vipId,
			String address) {
		ComplaintDao dao=new ComplaintDaoImp();
		Complaint complaint=new Complaint();
		complaint.setTitle(title);
		complaint.setContent(content);
		complaint.setComplaintName(complaintName);
		complaint.setGender(gender);
		complaint.setVipId(vipId);
		complaint.setAddress(address);
		complaint.setComplaintDate(new Date());
		int i = dao.addComplaintDao(complaint);
		return i;
		
	}

	public List<Complaint> findComplaintByPage(int page, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public Complaint findComplaintById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deletefindComplaintById(Complaint complaint) {
		// TODO Auto-generated method stub

	}

	

}
