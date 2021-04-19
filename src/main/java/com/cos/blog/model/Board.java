package com.cos.blog.model;

 
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 100)
	private String title;
	
	@Lob // 대용량 데이터 전용 
	private String content;
	
	private int count; //조회수
	
	@ManyToOne(fetch = FetchType.EAGER)  //many는 보드 user은 one , 즉 한명의 유저가 여러 개의 게시물을 쓸 수 있음 // Eager은 무조건 가져와야 하는 의미로 
	@JoinColumn(name="userId")
	private User user; 
	
	@OneToMany(mappedBy = "board", fetch = FetchType.EAGER) //mappedBy FK 아님// DB에 컬럼 생성 X 
	@JsonIgnoreProperties({"board"})
	@OrderBy("id desc")
	private List<Reply> replys; //이렇게하면 board 테이블만 가져오면 유저랑 리플까지 한꺼번에 다 가져올 수 있음 ! 
	
	@CreationTimestamp
	private Timestamp createDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Reply> getReplys() {
		return replys;
	}

	public void setReplys(List<Reply> replys) {
		this.replys = replys;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Board(int id, String title, String content, int count, User user, List<Reply> replys, Timestamp createDate) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.count = count;
		this.user = user;
		this.replys = replys;
		this.createDate = createDate;
	}

	public Board() {
		// TODO Auto-generated constructor stub
	}
	
	 
	
	
}
