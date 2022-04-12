package com.example.demo.service;

import com.example.demo.entity.UserEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
     /**
      * @author Lwx
      * @date 2022/3/15 2:04 PM
      * @desc 新增用户测试
      */
    void addUser(UserEntity user);
     /**
      * @author Lwx
      * @date 2022/3/15 2:41 PM
      * @desc 删除用户测试
      */
    void deleteUserById(int id);
     /**
      * @author Lwx
      * @date 2022/3/15 3:01 PM
      * @desc 更新用户测试
      */
    void updateUser(UserEntity user);
     /**
      * @author Lwx
      * @date 2022/3/15 3:07 PM
      * @desc 查询全部
      */
     List<UserEntity> findAll();
      /**
       * @author Lwx
       * @date 2022/3/28 7:57 PM
       * @desc 获取飞书开放平台 tenant_access_token
       */
      public ResponseEntity<String> getTenantAccessToken();
}
