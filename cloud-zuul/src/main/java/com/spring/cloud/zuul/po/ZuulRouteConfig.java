package com.spring.cloud.zuul.po;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: cloud
 * @package: com.spring.cloud.zuul.po、
 * @email: cy880708@163.com
 * @date: 2018/12/7 上午10:50
 * @mofified By:
 */
public class ZuulRouteConfig {

    private String id;

    private String path;

    private String serviceId;

    private String url;

    private Integer stripPrefix;

    /** 重试 **/
    private Integer retryable;

    /** 是否可用 **/
    private Integer enabled;

    /** 描述 **/
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getStripPrefix() {
        return stripPrefix;
    }

    public void setStripPrefix(Integer stripPrefix) {
        this.stripPrefix = stripPrefix;
    }

    public Integer getRetryable() {
        return retryable;
    }

    public void setRetryable(Integer retryable) {
        this.retryable = retryable;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
