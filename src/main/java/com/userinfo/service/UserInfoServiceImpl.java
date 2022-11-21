package com.userinfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userinfo.dao.UserInfoDAO;
import com.userinfo.vo.UserInfoVO;

@Service
public class UserInfoServiceImpl implements UserInfoService {
	@Autowired
	UserInfoDAO userInfoDAO;
	
	@Override
	public List<UserInfoVO> selectAllUserInfo() {
		return userInfoDAO.selectAllUserInfo();
	}

	@Override
	public UserInfoVO selectById(String id) {
	    return userInfoDAO.selectById(id);
	}

	@Override
	public void insertUserInfo(UserInfoVO userInfo) {
		userInfoDAO.insert(userInfo);
	}
	  
	@Override
	public void updateUserInfo(String id, UserInfoVO updateUserInfo) {
		UserInfoVO userInfo = userInfoDAO.selectById(id);

	    if (userInfo != null) {
	    	/*userInfo.setId(updateUserInfo.getId());*/
	    	userInfo.setName(updateUserInfo.getName());
	    	userInfo.setAge(updateUserInfo.getAge());
	    	
	      userInfoDAO.update(userInfo);
	    } else {
	      throw new IllegalStateException("해당 사용자가 존재하지 않습니다");
	    }
	  }

	@Override
	public void deleteUserInfo(String id) {
		if (userInfoDAO.selectById(id) != null) {
			userInfoDAO.delete(id);

	    } else {
	      throw new IllegalStateException("해당 사용자는 이미 삭제되었습니다.");
	    }
	}
}
