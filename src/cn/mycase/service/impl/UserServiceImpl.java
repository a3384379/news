package cn.mycase.service.impl;

import java.util.List;

import cn.mycase.entity.OrdinaryUser;
import cn.mycase.entity.User;
import cn.mycase.mapper.UserMapper;
import cn.mycase.service.UserService;

public class UserServiceImpl implements UserService {

	private UserMapper userMapper;
	
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	@Override
	public User queryUser(String username) {
		return userMapper.queryUser(username);
	}
	@Override
	public User queryUserByid(Integer id) {
		return userMapper.queryUserByid(id);
	}
	@Override
	public void update(String password) {
		userMapper.update(password);
	}
	@Override
	public OrdinaryUser queryOrdinaryUser(String username) {
		return userMapper.queryOrdinaryUser(username);
	}
	@Override
	public OrdinaryUser queryOrdinaryUserByid(Integer id) {
		return userMapper.queryOrdinaryUserByid(id);
	}
	@Override
	public void saveOrdinaryUser(OrdinaryUser user) {
		userMapper.saveOrdinaryUser(user);
	}

}
