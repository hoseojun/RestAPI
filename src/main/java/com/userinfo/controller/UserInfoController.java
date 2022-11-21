package com.userinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.userinfo.service.UserInfoServiceImpl;
import com.userinfo.vo.UserInfoVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = {"User Info"}, description = "유저 정보 서비스")
@RestController
public class UserInfoController {
	@Autowired
	UserInfoServiceImpl userInfoService;
	
	@ApiOperation(value = "유저 목록 전체조회", notes = "유저 전체목록을 조회한다.")
	@GetMapping("/id")
	public List<UserInfoVO> selectAllUserInfo() {
		/*System.out.println("Request Method : GET");*/
		List<UserInfoVO> allUserInfo = userInfoService.selectAllUserInfo();

	    return allUserInfo;
	}
	
	@ApiOperation(value = "특정 유저 조회", notes = "특정 유저를 조회한다.")
	@GetMapping("/id/{id}")
	public UserInfoVO selectById(@PathVariable String id) {
		/*System.out.println("Request Method : GET");*/
		UserInfoVO userInfo = userInfoService.selectById(id);

	    return userInfo;
	}
	
	@ApiOperation(value = "유저 추가", notes = "유저를 추가한다.")
	@PostMapping(value="/id/new")
	public List<UserInfoVO> insertUserInfo(@RequestBody UserInfoVO userInfo) {
	      userInfoService.insertUserInfo(userInfo);

	      return userInfoService.selectAllUserInfo();
	}
	
	@ApiOperation(value = "유저 정보 수정", notes = "유저 정보를 수정한다.")
	@PutMapping(value="/id/{id}")
	public List<UserInfoVO> updateUserInfo(@PathVariable String id, @RequestBody UserInfoVO userInfo) {
	      userInfoService.updateUserInfo(id, userInfo);

	      return userInfoService.selectAllUserInfo();
	}
	
	@ApiOperation(value = "특정 유저 삭제", notes = "특정 유저를 삭제한다.")
	@DeleteMapping("/id/{id}")
	public List<UserInfoVO> deleteUserInfo(@PathVariable String id) {
	    userInfoService.deleteUserInfo(id);

	    return userInfoService.selectAllUserInfo();
	}

}
