package com.example.rsocialback.Services;

import com.example.rsocialback.Dao.RoleDao;
import com.example.rsocialback.Model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

  @Autowired
    private RoleDao roleDao;

  public Role AddRole(Role role){
    return roleDao.save(role);
  }
}
