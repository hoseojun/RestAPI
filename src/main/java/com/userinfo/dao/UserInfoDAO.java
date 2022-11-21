package com.userinfo.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.userinfo.vo.UserInfoVO;

@Mapper
public interface UserInfoDAO {
	List<UserInfoVO> selectAllUserInfo();
	UserInfoVO selectById(String id);
	void insert(UserInfoVO userInfo);
	void update(UserInfoVO userInfo);
	void delete(String id);

}
