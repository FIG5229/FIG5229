package com.integration.filter;

import com.integration.entity.Audience;
import com.integration.utils.JwtHelper;
import com.integration.utils.RedisUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 验证token
 * @program: integration
 * @description
 * @author: hlq
 * @create: 2020-03-05 16:34
 **/
@Component
public class TokenVerification {

    @Autowired
    private RedisUtils redisUtil;

    @Autowired
    private Audience audience;

    public boolean TokenVerification(String username){
        Claims t = JwtHelper.parseJWT(username, audience.getBase64Secret());
        if (t != null ) {
            String key = t.get("id").toString();
            String userOrder = t.get("userOrder").toString();
            if (redisUtil.exists(userOrder+key)) {
                if (redisUtil.get(userOrder+key).equals(username)) {
                    return true;
                } else {
                    return false;
                }
            }else {
                return false;
            }
        }else {
            return false;
        }
    }
}
