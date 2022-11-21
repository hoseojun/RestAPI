package com.userinfo.service;

import java.util.List;
import com.userinfo.vo.UserInfoVO;

public interface UserInfoService {

  List<UserInfoVO> selectAllUserInfo();
  UserInfoVO selectById(String id);
  void insertUserInfo(UserInfoVO userInfo);
  void updateUserInfo(String id, UserInfoVO userInfo);
  void deleteUserInfo(String id);
  
}