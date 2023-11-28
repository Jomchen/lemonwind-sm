package com.lemonwind.sm.mapper;


import com.lemonwind.sm.entity.dto.BusinessUserDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BusinessUserMapper {

    List<BusinessUserDTO> findUserWithKongFu(@Param("count") Integer count);

}
