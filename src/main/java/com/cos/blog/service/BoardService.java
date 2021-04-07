package com.cos.blog.service;

 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.model.Board;
import com.cos.blog.model.User;
import com.cos.blog.repository.BoardRepository;

//스프링이 컴포넌트 스캔 통해서 빈에 등록 IOC
@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;
 
	@Transactional // 성공하면 커밋 될 것임 실패하면 롤백 
	public void 글쓰기(Board board, User user) {
		board.setCount(0); //조회 수 강제 초기화  
		board.setUser(user); //작성자 넣기 
		boardRepository.save(board); 
	}

	public List<Board> 글목록() {
		
		return boardRepository.findAll();
	}
 
	 
}
