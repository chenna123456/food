package com.oracleoaec.entity;

public class Status {
private Integer id;
private Integer aid;
private Integer vid;
private Integer status;
public Status(Integer id, Integer aid, Integer vid, Integer status) {
	super();
	this.id = id;
	this.aid = aid;
	this.vid = vid;
	this.status = status;
}
public Status() {
	super();
}

public Status(Integer aid, Integer vid, Integer status) {
	super();
	this.aid = aid;
	this.vid = vid;
	this.status = status;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public Integer getAid() {
	return aid;
}
public void setAid(Integer aid) {
	this.aid = aid;
}
public Integer getVid() {
	return vid;
}
public void setVid(Integer vid) {
	this.vid = vid;
}
public Integer getStatus() {
	return status;
}
public void setStatus(Integer status) {
	this.status = status;
}
@Override
public String toString() {
	return "Status [id=" + id + ", aid=" + aid + ", vid=" + vid + ", status=" + status + "]";
}

}
