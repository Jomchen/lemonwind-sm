package com.lemonwind.sm.mapper;


import com.lemonwind.sm.entity.dto.BusinessUserDTO;

import java.util.List;

public interface BusinessUserMapper {

    List<BusinessUserDTO> findUserWithKongFu();

}
