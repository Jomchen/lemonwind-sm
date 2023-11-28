package com.lemonwind.sm.entity;

import com.lemonwind.sm.common.LemonwindEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;


@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
public class KongFu extends LemonwindEntity<KongFu> {

    /** 物理表名称. */
    public static final String TABLE_NAME = "jo_kong_fu";

    private String name;

    private Integer level;

    private Long inventionUserId;

}