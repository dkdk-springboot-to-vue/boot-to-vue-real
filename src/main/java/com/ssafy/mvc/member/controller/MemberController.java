package com.ssafy.mvc.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import com.ssafy.mvc.member.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.mvc.member.service.MemberService;

@Controller
@RequestMapping("/member")
@CrossOrigin("*")
public class MemberController {

	private MemberService service;

	@Autowired
	public MemberController(@Qualifier(value = "MemberServiceMapperImpl")MemberService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/login")
	public String login() {
		return "user/loginForm";
	}
	
	@GetMapping("/regist")
	public String register() {
		return "user/registerForm";
	}
	
	@PostMapping(value = "/regist")
	public ModelAndView register(ModelAndView mav, MemberDto dto) {
		try {
			service.register(dto);
			mav.setViewName("user/loginForm");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mav.setViewName("error");
		}
		return mav;

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
	public ModelAndView login(ModelAndView mav, MemberDto dto, HttpServletRequest request){
//		System.out.println(userId+" "+userPass);
//		MemberDto dto = new MemberDto();
//		dto.setUserId(userId);
//		dto.setUserPass(userPass);
		System.out.println(dto);
		try {
			MemberDto loginDto = service.login(dto);
			System.out.println(loginDto);
			if(loginDto != null) {
				request.getSession().setAttribute("userInfo", loginDto);
				mav.setViewName("index");
			} else {
				mav.setViewName("redirect:/user/loginForm");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mav.setViewName("error");
		}
		return mav;
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request){
		System.out.println("logout");
		request.getSession().invalidate();
		return "user/loginForm";
	}

	@GetMapping("/findpw")
	public String findpw() {
		return "user/findForm";
	}
	
	@PostMapping("/findpw/{userId}")
	public ModelAndView findpw(@PathVariable("userId") String id, ModelAndView mav, HttpServletRequest request){
		System.out.println("id");
		try {
			String pw = service.findPw(id);
			mav.setViewName("user/findForm");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mav.setViewName("error");
		}
		return mav;
	}
	
	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
