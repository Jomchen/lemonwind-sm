package com.jomkie.sm.mapper;

import com.jomkie.sm.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Jomkie
 * @since 2022-09-22 14:39:44
 */
public interface UserMapper {

    List<User> findAll(@Param("beginAge") Integer beginAge, @Param("endAge") Integer endAge, @Param("sex") Integer sex);

}
