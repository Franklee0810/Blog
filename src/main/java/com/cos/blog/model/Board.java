package com.cos.blog.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 100)
	private String title;
	
	@Lob // 대용량 데이터 전용 
	private String content;
}
