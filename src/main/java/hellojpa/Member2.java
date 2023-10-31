package hellojpa;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

// JPA에서 관리하는 객체.  
//@Entity

// 객체와 테이블 이름이 다른경우 사용. 
//@Table(name = "MBR")
public class Member2 {

	@Id
	// GenerationType.IDENTITY : 기본키 생성을 데이터베이에 위임. MYSQL 같은 경우는 AI.
	// -> persist() 시점에 insert 쿼리문 바로실행됨.
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// updatable : 쿼리 update 조건.
	// insertable : 쿼리 insert 조건.
	// ullable : not null.
	@Column(name = "name", updatable = false)
	private String Username;

	private Integer age;

	// EnumType : STRING, ORDINAL(들어가는 순서).
	// -> STRING을 쓰는게 좋음.
	@Enumerated(EnumType.STRING)
	private RoleType roleType;

	// 자바 8 이후엔 쓰지않음.
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	// 이걸 많이 씀.
	@Transient
	private LocalDate test2;

	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModifiedDate;

	// @Transient : DB에 저장하고싶지 않을때 사용.
	@Transient
	private String temp;

	// @Lob : varchar 이상의 데이터를 관리.
	@Lob
	private String description;

	public Member2() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public RoleType getRoleType() {
		return roleType;
	}

	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDate getTest2() {
		return test2;
	}

	public void setTest2(LocalDate test2) {
		this.test2 = test2;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

 }
