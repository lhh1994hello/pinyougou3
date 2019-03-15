package com.pinyougou.service;

import com.pinyougou.pojo.TbSeller;
import com.pinyougou.sellergoods.service.SellerService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * 认证类
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    private SellerService sellerService;

    public void setSellerService(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("经过了:" + username + "," + new Date());
        //构建一个角色列表，
        List<GrantedAuthority> grantAuths = new ArrayList<>();//角色集合
        grantAuths.add(new SimpleGrantedAuthority("ROLE_SELLER"));

        TbSeller seller = sellerService.findOne(username);
        //如果用户名存在，且已经通过审核，才去进行密码比对
        if (seller != null && "1".equals(seller.getStatus())) {
            return new User(username, seller.getPassword(), grantAuths);
        } else {
            return null;
        }
    }
}
