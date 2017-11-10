package demo.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="mydept")
public class Dept {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer did;
	
	private String dname;
	
	@OneToMany(mappedBy="dept", 
			   //fetch=FetchType.EAGER,
			   cascade=CascadeType.ALL)
	@JsonIgnore
	private Set<Emp> emps = new HashSet<Emp>(); // 一对多 关联属性  可以有级联

	public Integer getDid() {
		return did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public Set<Emp> getEmps() {
		return emps;
	}

	public void setEmps(Set<Emp> emps) {
		this.emps = emps;
	}

	@Override
	public String toString() {
		return "Dept [did=" + did + ", dname=" + dname + "]";
	}
	
	
}
