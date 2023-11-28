package com.lemonwind.sm.mapper;

import com.lemonwind.sm.entity.KongFu;
import java.util.List;

public interface KongFuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(KongFu row);

    KongFu selectByPrimaryKey(Long id);

    List<KongFu> selectAll();

    int updateByPrimaryKey(KongFu row);

    List<KongFu> findByInventionUserIdKongFus(Long userId);

}