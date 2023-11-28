package com.lemonwind.sm.entity.dto;

import com.lemonwind.sm.common.LemonwindEntity;

import java.util.List;

/**
 * 使用注解影响 懒加载效果，它会自动调用属性
 */
//@Data
//@EqualsAndHashCode(callSuper = true)
//@NoArgsConstructor
//@Accessors(chain = true)
//@ToString(callSuper = true)
public class BusinessUserDTO extends LemonwindEntity<BusinessUserDTO> {

    private String name;

    private Integer age;

    private Integer sex;

    private String email;

    private String realName;

    private List<KongFuDTO> kongFuList;

    public String getName() {
        return this.name;
    }
    public Integer getAge() {
        return this.age;
    }
    public Integer getSex() {
        return this.sex;
    }
    public String getEmail() {
        return this.email;
    }
    public String getRealName() {
        return this.realName;
    }
    public List<KongFuDTO> getKongFuList() {
        return this.kongFuList;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public void setSex(Integer sex) {
        this.sex = sex;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setgRealName(String realName) {
        this.realName = realName;
    }
    public void setKongFuList(List<KongFuDTO> kongFuList) {
        this.kongFuList = kongFuList;
    }

}
