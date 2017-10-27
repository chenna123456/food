package com.oracleoaec.entity;

public class ScrollImg {
private Integer id;
private String src;
public ScrollImg(Integer id, String src) {
	super();
	this.id = id;
	this.src = src;
}
public ScrollImg() {
	super();
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getSrc() {
	return src;
}
public void setSrc(String src) {
	this.src = src;
}
@Override
public String toString() {
	return "ScrollImg [id=" + id + ", src=" + src + "]";
}

}
