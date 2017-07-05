package cn.lxc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lxc.dao.UserDao;
import cn.lxc.service.UserService;
import cn.lxc.vo.User;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	
	@Override
	public List<User> getList() {
		return userDao.getList();
	}
	@Override
	public int delete(int id) {
		return userDao.delete(id);
	}
	@Override
	public int save(User user) {
		return userDao.save(user);
		
	}
	@Override
	public User showInfoById(int id) {
		return userDao.getEntity(id);
	}
	@Override
	public int update(User user) {
		return userDao.update(user);
	}
	/*************************getter&setter**************************/
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
