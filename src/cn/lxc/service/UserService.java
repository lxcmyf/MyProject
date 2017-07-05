package cn.lxc.service;

import java.util.List;

import cn.lxc.vo.User;

public interface UserService {
	public List<User> getList();

	public int delete(int id);

	public int save(User user);

	public User showInfoById(int id);

	public int update(User user);
}
