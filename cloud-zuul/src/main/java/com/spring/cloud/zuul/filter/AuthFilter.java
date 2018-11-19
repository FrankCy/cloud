package com.spring.cloud.zuul.filter;

import com.alibaba.fastjson.JSONObject;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.spring.cloud.common.exception.BaseException;
import com.spring.cloud.common.exception.BaseExceptionBody;
import com.spring.cloud.common.exception.CommonError;
import com.spring.cloud.common.vo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * 鉴权filter
 */
public class AuthFilter extends ZuulFilter {
	private static final Logger logger = LoggerFactory.getLogger(AuthFilter.class);

	@Override
	public boolean shouldFilter() {
		// 判断是否需要进行处理
		return true;
	}

	@Override
	public Object run() {
		RequestContext rc = RequestContext.getCurrentContext();
		authUser(rc);
		return null;
	}

	@Override
	public String filterType() {
//		pre：可以在请求被路由之前调用
//		route：在路由请求时候被调用
//		post：在route和error过滤器之后被调用
//		error：处理请求时发生错误时被调用
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	private static Map<String, String> httpRequestToMap(HttpServletRequest request) {
		Enumeration<String> headerNames = request.getHeaderNames();
		Map<String, String> headers = new HashMap<>();
		while (headerNames.hasMoreElements()) {
			String headerName = headerNames.nextElement();
			headers.put(headerName, request.getHeader(headerName));
		}
		return headers;
	}

	/**
	 * @description：验证用户信息
	 * @version 1.0
	 * @author: Yang.Chang
	 * @email: cy880708@163.com
	 * @date: 2018/11/19 下午2:00
	 * @mofified By:
	 */
	public static void authUser(RequestContext ctx) {
		HttpServletRequest request = ctx.getRequest();
		Map<String, String> header = httpRequestToMap(request);
		String userId = header.get(User.CONTEXT_KEY_USERID);
		if(StringUtils.isEmpty(userId)) {
			try {
				BaseException BaseException = new BaseException(CommonError.AUTH_EMPTY_ERROR.getCode(),CommonError.AUTH_EMPTY_ERROR.getCodeEn(),CommonError.AUTH_EMPTY_ERROR.getMessage(),1L);
				BaseExceptionBody errorBody = new BaseExceptionBody(BaseException);
				ctx.setSendZuulResponse(false);
				ctx.setResponseStatusCode(401);
				ctx.setResponseBody(JSONObject.toJSON(errorBody).toString());
			} catch (Exception e) {
				logger.error("println message error",e);
			}
		}else {
			return;
//			坑
//			for (Map.Entry<String, String> entry : header.entrySet()) {
//				ctx.addZuulRequestHeader(entry.getKey(), entry.getValue());
//			}
		}
	}
	
}
