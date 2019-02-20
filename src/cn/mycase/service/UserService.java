package cn.mycase.service;


import cn.mycase.entity.OrdinaryUser;
import cn.mycase.entity.User;

public interface UserService {
	public User queryUser(String username);
	
	public User queryUserByid(Integer id);
	
	public void update(String password);
	
	public OrdinaryUser queryOrdinaryUser(String username);
	
	public OrdinaryUser queryOrdinaryUserByid(Integer id);
	
	public void saveOrdinaryUser(OrdinaryUser user);
}
