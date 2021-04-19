package com.cos.blog.service;
  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.model.Board;
import com.cos.blog.model.Reply;
import com.cos.blog.model.User;
import com.cos.blog.repository.BoardRepository;
import com.cos.blog.repository.ReplyRepository;

//스프링이 컴포넌트 스캔 통해서 빈에 등록 IOC
@Service
public class BoardService {
	
	@Autowired
	private ReplyRepository replyRepository;
	 
	@Autowired
	private BoardRepository boardRepository;
 
	@Transactional // 성공하면 커밋 될 것임 실패하면 롤백 
	public void 글쓰기(Board board, User user) {
		board.setCount(0); //조회 수 강제 초기화  
		board.setUser(user); //작성자 넣기 
		boardRepository.save(board); 
	}
	
	@Transactional(readOnly = true)
	public Page<Board> 글목록(Pageable pageable) { 
		return boardRepository.findAll(pageable);
	}
	
	@Transactional(readOnly = true)
	public Board 글상세보기(int id) { 
		return boardRepository.findById(id)
				.orElseThrow(()->{
					return new IllegalArgumentException("글 상세보기 실패");
				}); 
			}
	
	@Transactional
	public void 글삭제하기(int id) {
		 boardRepository.deleteById(id);
		
	}
	
	@Transactional
	public void 글수정하기(int id, Board requestboard) {
		Board board = boardRepository.findById(id)
				.orElseThrow(()->{
					return new IllegalArgumentException("글 찾기 실패"); //영속화 완료 
				});
		
		board.setTitle(requestboard.getTitle());
		board.setContent(requestboard.getContent());
		System.out.println("check체크 ");
	}
	
	
	@Transactional
	public void 댓글쓰기(User user, int boardId, Reply requestReply) {
		
		Board board = boardRepository.findById(boardId)
				.orElseThrow(()->{
					return new IllegalArgumentException("댓글 쓰기 실패"); //영속화 완료 
				});
		
		requestReply.setUser(user);
		requestReply.setBoard(board);
		 
		
		replyRepository.save(requestReply);
	}
 
	 
}
