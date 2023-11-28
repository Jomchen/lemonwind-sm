package com.lemonwind.sm.entity.dto;

import com.lemonwind.sm.common.LemonwindEntity;
import com.lemonwind.sm.entity.KongFu;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;


@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
public class BusinessUserDTO extends LemonwindEntity<BusinessUserDTO> {

    private String name;

    private Integer age;

    private Integer sex;

    private String email;

    private String realName;

    private List<KongFu> kongFuList;


}
