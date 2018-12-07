package com.spring.cloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.context.annotation.Configuration;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.POST_TYPE;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: cloud
 * @package: com.spring.cloud.zuul.filter、
 * @email: cy880708@163.com
 * @date: 2018/11/19 下午2:36
 * @mofified By:
 */
@Configuration
public class PostFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return PRE_DECORATION_FILTER_ORDER + 1;
    }

    @Override
    public boolean shouldFilter() {
        // 判断是否需要进行处理
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        return null;
    }
}
