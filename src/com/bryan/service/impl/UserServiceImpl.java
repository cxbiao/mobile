package com.bryan.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bryan.domain.User;
import com.bryan.domain.UserCustom;
import com.bryan.domain.UserQueryVo;
import com.bryan.exception.CustomException;
import com.bryan.mapper.UserMapper;
import com.bryan.service.UserService;

/**
 * mapper开发方式
 * @author bryan
 *
 */

@Service("userService")
public class UserServiceImpl implements UserService{

	
	@Resource
	private UserMapper userMapper;
	
	@Override
	public User findUserById(int id) throws Exception {
		
		return userMapper.findUserById(id);
	}

	@Override
	public User findUserByIdResultMap(int id) throws Exception {
		return userMapper.findUserByIdResultMap(id);
	}

	@Override
	public List<UserCustom> findUserList(UserQueryVo userQueryVo)
			throws Exception {
		return userMapper.findUserList(userQueryVo);
	}

	@Override
	public int findUserListCount(UserQueryVo userQueryVo) throws Exception {
		return userMapper.findUserListCount(userQueryVo);
	}

	@Override
	public List<User> findUserByName(String name) throws Exception {
		return userMapper.findUserByName(name);
	}

	@Override
	public void insertUser(User user) throws Exception {
		
		userMapper.insertUser(user);
		
		
	}

	@Override
	public void deleteUser(int id) throws Exception {
		userMapper.deleteUser(id);	
		
	}

	@Override
	public void updateUser(User user) throws Exception {
       userMapper.updateUser(user);
       throw new CustomException("测试异常");
	}

}
