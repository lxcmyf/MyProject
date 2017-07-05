package cn.lxc.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import cn.lxc.dao.UserDao;
import cn.lxc.vo.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<User> getList() {
		return sqlSessionTemplate.selectList("cn.lxc.vo.UserMapper.getList");
	}
	@Override
	public int delete(int id) {
		return sqlSessionTemplate.delete("cn.lxc.vo.UserMapper.delete",id);
	}
	@Override
	public int save(User user) {
		return sqlSessionTemplate.insert("cn.lxc.vo.UserMapper.insert",user);
		
	}
	@Override
	public User getEntity(int id) {
		return sqlSessionTemplate.selectOne("cn.lxc.vo.UserMapper.selectByPk", id);
	}
	@Override
	public int update(User user) {
		return sqlSessionTemplate.update("cn.lxc.vo.UserMapper.update", user);
	}
	/*****************************getter&setter****************************/
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
}
