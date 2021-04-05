package com.cos.blog.test;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

@RestController
public class DummyControllerTest {
	
	@Autowired //di
	private UserRepository userRepository;
	
	
	public List<User> list() {
		
	}
	
	//{id} 주소로 파라미터를 전달 받을 수 있음.
	@GetMapping("/dummy/user/{id}")
	public User detail(@PathVariable int id) {
		//user/4로 들어올때, 만약 데이터베이스에서 못찾아오면 user가 null이 되기떄문에, 
		//리턴값이 null이 되므로, optional로 User객체를 감싸서 가져온다. 그렇기때문에 null값이 아닌지 확인이 필요하다 
		//User user = userRepository.findById(id).get(); //userRepository.findById(id).get();의 경우에는 절대 null이 없기 떄문에 get을 씀
		
		User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
		@Override   
		public IllegalArgumentException get() {
			// TODO Auto-generated method stub
			return new IllegalArgumentException("id : " + id + "해당 유저 없음");
		}
		
		});
		
		return user;
	}
	
	@PostMapping("/dummy/join")
	public String join(User user) {
		System.out.println("id : " + user.getId());
		System.out.println("username : " + user.getUsername());
		System.out.println("password : " + user.getPassword());
		System.out.println("email : " + user.getEmail());
		System.out.println("role : " + user.getRole());
		System.out.println("createDate : " + user.getCreateDate());
		
		user.setRole(RoleType.USER);
		userRepository.save(user);
		return "회원가입 완료";
	}
}
