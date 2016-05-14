package com.bryan.mapper;

import java.util.List;

import com.bryan.domain.User;
import com.bryan.domain.UserCustom;
import com.bryan.domain.UserQueryVo;

/**
 * mapper接口
 * @author bryan
 * mapper接口规范
 * 
 * 1. 在mapper.xml中namespace等于mapper接口地址
 * 2. mapper接口中的方法名和mapper.xml中statement的id一致
 * 3. mapper接口中的方法参数类型和mapper.xml中statement的parameterType一致
 * 4. mapper接口中的方法返回值类型和mapper.xml中statement的resultType一致
 */
public interface UserMapper {
	public User findUserById(int id) throws Exception;
	
	//使用resultMap进行字段映射
	public User findUserByIdResultMap(int id) throws Exception;

	//用户综合信息查询
	public List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception;
	
	public int findUserListCount(UserQueryVo userQueryVo) throws Exception;
	
	
	public List<User> findUserByName(String name) throws Exception;

	public void insertUser(User user) throws Exception;

	public void deleteUser(int id) throws Exception;

	public void updateUser(User user) throws Exception;
}
