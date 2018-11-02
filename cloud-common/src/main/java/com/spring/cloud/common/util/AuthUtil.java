package com.spring.cloud.common.util;

import cn.springcloud.book.common.vo.User;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletResponse;

public class AuthUtil {
	public static boolean authUser(User user, HttpServletResponse respone) throws Exception{
		if(StringUtils.isEmpty(user.getUserId())) {
			return false;
		}else {
			return true;
		}
	}
}
