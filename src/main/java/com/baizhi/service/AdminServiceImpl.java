package com.baizhi.service;

import com.baizhi.entity.Admin;
import com.baizhi.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional

public class AdminServiceImpl implements  AdminService {
    @Autowired
    AdminMapper adminMapper;


    @Override
    public Admin queryOne(Admin admin) {
       Admin adm =  adminMapper.selectOne(admin);
        return adm;
    }
}
