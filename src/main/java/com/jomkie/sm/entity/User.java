package com.jomkie.sm.entity;


import com.jomkie.sm.common.JomkieEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 
 * </p>
 *
 * @author Jomkie
 * @since 2022-09-22 14:39:44
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Accessors(chain = true)
public class User extends JomkieEntity<User> {
    private static final long serialVersionUID = 2022092202393840044L;
    /** 物理表名称. */
    public static final String TABLE_NAME = "jo_user";

    private String name;

    private Integer age;

    private Integer sex;

    private String email;

    private String realName;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", email='" + email + '\'' +
                ", realName='" + realName + '\'' +
                '}';
    }
}
