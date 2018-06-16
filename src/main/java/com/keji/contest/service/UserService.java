package com.keji.contest.service;


import com.keji.contest.dao.UserDao;
import com.keji.contest.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;


    public UserDTO add(UserDTO user) {
        String passwordHash =  passwordToHash(user.getPassword());
        user.setPassword(passwordHash);
       Long id= userDao.insert(user);
        user.setUserId(id);
        return user;
    }

    private String passwordToHash(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.update(password.getBytes());
            byte[] src = digest.digest();
            StringBuilder stringBuilder = new StringBuilder();
            // 字节数组转16进制字符串
            // https://my.oschina.net/u/347386/blog/182717
            for (byte aSrc : src) {
                String s = Integer.toHexString(aSrc & 0xFF);
                if (s.length() < 2) {
                    stringBuilder.append('0');
                }
                stringBuilder.append(s);
            }
            return stringBuilder.toString();
        } catch (NoSuchAlgorithmException ignore) {
        }
        return null;
    }

    public UserDTO findById(Long id) {
        UserDTO user = new UserDTO();
        user.setUserId(id);
        return userDao.selectByPrimaryKey(user);
    }

    public UserDTO findByName(String name) {
        UserDTO param = new UserDTO();
        param.setUsername(name);
        return userDao.findByUserName(param);
    }

    public boolean comparePassword(UserDTO user, UserDTO userInDataBase) {
        return passwordToHash(user.getPassword())      // 将用户提交的密码转换为 hash
                .equals(userInDataBase.getPassword()); // 数据库中的 password 已经是 hash，不用转换
    }
}
