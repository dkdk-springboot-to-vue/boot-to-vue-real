package com.ssafy.mvc.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import com.ssafy.mvc.member.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.ssafy.mvc.member.service.MemberService;

@RestController
@RequestMapping("/restmem")
@CrossOrigin("*")
public class MemberRestController {

	private MemberService service;

	@Autowired
	public MemberRestController(@Qualifier(value = "MemberServiceMapperImpl")MemberService service) {
		super();
		this.service = service;
	}
	
	@PostMapping(value = "/regist")
	public ResponseEntity<?> register(@RequestBody MemberDto dto) {
		try {
			service.register(dto);
			List<MemberDto> list = service.listMember();
			return new ResponseEntity<List<MemberDto>>(list, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return exceptionHandling(e);
		}

	}
	
	@PutMapping("/user")
	public ResponseEntity<?> update(@RequestBody MemberDto dto){
		try {
			service.update(dto);
			List<MemberDto> list = service.listMember();
			return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return exceptionHandling(e);
		}
	}
	
	@DeleteMapping("/user/{userId}")
	public ResponseEntity<?> delete(@PathVariable("userId") String userId){
		System.out.println(userId);
		try {
			service.delete(userId);
			List<MemberDto> list = service.listMember();
			return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return exceptionHandling(e);
		}
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody MemberDto dto, HttpServletRequest request){
//		System.out.println(userId+" "+userPass);
//		MemberDto dto = new MemberDto();
//		dto.setUserId(userId);
//		dto.setUserPass(userPass);
		System.out.println(dto);
		try {
			MemberDto loginDto = service.login(dto);
			System.out.println(loginDto);
			if(loginDto != null) {
				request.getSession().setAttribute("userInfo", loginDto.getUserId());
				return new ResponseEntity<MemberDto>(loginDto, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return exceptionHandling(e);
		}
	}
	
	@GetMapping("/logout")
	public ResponseEntity<?> logout(HttpServletRequest request){
		request.getSession().invalidate();
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@GetMapping("/findpw/{userId}")
	public ResponseEntity<?> logout(@PathVariable("userId") String id, HttpServletRequest request){
		try {
			String pw = service.findPw(id);
			return new ResponseEntity<String>(pw, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return exceptionHandling(e);
		}
	}
	
	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
