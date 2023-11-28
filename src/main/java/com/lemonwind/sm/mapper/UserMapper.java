package com.lemonwind.sm.mapper;

import com.lemonwind.sm.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lemonwind
 * @since 2022-09-22 14:39:44
 */
public interface UserMapper {

    List<User> findById(@Param("id") Long id);

    List<User> findCondition(
            @Param("beginAge") Integer beginAge,
            @Param("endAge") Integer endAge,
            @Param("sex") Integer sex,
            @Param("keywords") String keywords);

}
