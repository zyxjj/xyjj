package demo.bean;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="myemp")
public class Emp {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer eid; //主键属性
	
	private String ename;
	private String sex;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
	private Date hire;
	
	private Float sar;
	

	@Column(insertable=false, updatable=false)
	private Integer deptid; // 外键字段
	
	@ManyToOne
	@JoinColumn(name="deptid")
	private Dept dept; // 关联属性  多对一  没有级联

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getHire() {
		return hire;
	}

	public void setHire(Date hire) {
		this.hire = hire;
	}

	public Float getSar() {
		return sar;
	}

	public void setSar(Float sar) {
		this.sar = sar;
	}


	public Integer getDeptid() {
		return deptid;
	}

	public void setDeptid(Integer deptid) {
		this.deptid = deptid;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Emp [eid=" + eid + ", ename=" + ename + ", sex=" + sex + ", hire=" + hire + ", sar=" + sar + ", deptid="
				+ deptid + "]";
	}




	
}
