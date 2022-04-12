package com.example.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.demo.entity.UserEntity;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;
    @Resource
    RestTemplate restTemplate;
    private static final String GetTokenUrl="https://open.feishu.cn/open-apis/auth/v3/tenant_access_token/internal";
    @Override
    public void addUser(UserEntity user) {
        userMapper.addUser(user);
    }

    /**
     * @param id
     * @author Lwx
     * @date 2022/3/15 2:41 PM
     * @desc 删除用户测试
     */
    @Override
    public void deleteUserById(int id) {
        userMapper.deleteUserById(id);
    }

    /**
     * @param user
     * @author Lwx
     * @date 2022/3/15 3:01 PM
     * @desc 更新用户测试
     */
    @Override
    public void updateUser(UserEntity user) {
        userMapper.updateUser(user);
    }

    /**
     * @author Lwx
     * @date 2022/3/15 3:07 PM
     * @desc 查询全部
     */
    @Override
    public List<UserEntity> findAll() {
        return userMapper.selectAll();
    }

     /**
      * @author Lwx
      * @date 2022/3/28 7:37 PM
      * @desc 获取飞书开放平台 tenant_access_token
      */
    public ResponseEntity<String>  getTenantAccessToken(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf(MediaType.APPLICATION_JSON_UTF8_VALUE));
        Map<String,String> map=new HashMap<>();
        map.put("app_id","cli_a0f921645878d00b");
        map.put("app_secret","lldBxURC4B9skRte4AYYAfGAaXoa0ewo");
        String s = JSON.toJSONString(map);
        ResponseEntity<String> exchange = restTemplate.exchange(GetTokenUrl, HttpMethod.POST, new HttpEntity<>(s, headers), String.class);
        return exchange;
    }

}
