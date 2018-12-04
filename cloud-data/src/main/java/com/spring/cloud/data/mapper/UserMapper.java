package com.spring.cloud.data.mapper;

import com.github.pagehelper.Page;
import com.spring.cloud.common.po.User;
import com.spring.cloud.common.po.UserWithBLOBs;
import com.spring.cloud.common.vo.UserRole;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserWithBLOBs record);

    int insertSelective(UserWithBLOBs record);

    UserWithBLOBs selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(UserWithBLOBs record);

    int updateByPrimaryKey(User record);

    Page<UserWithBLOBs> selectByPageNumSize(@Param("ur") UserRole userRole, @Param("pageNum")  int pageNum, @Param("pageSize") int pageSize, @Param("orderColumn")  String orderColumn, @Param("orderType")  String orderType);
}