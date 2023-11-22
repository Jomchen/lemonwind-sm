package com.lemonwind.sm.entity;


import java.text.SimpleDateFormat;

import com.lemonwind.sm.common.LemonwindEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 
 * </p>
 *
 * @author lemonwind
 * @since 2022-09-22 14:39:44
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Accessors(chain = true)
// @ToString(callSuper = true)
public class User extends LemonwindEntity<User> {
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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createTimeStr = sdf.format(createTime);
        String updateTimeStr = sdf.format(updateTime);
        return new StringBuilder(this.getClass().getSimpleName())
            .append(",id: ").append(id)
            .append(",name: ").append(name)
            .append(",age: ").append(age)
            .append(",sex: ").append(sex)
            .append(",email: ").append(email)
            .append(",realName: ").append(realName)
            .append(",createTime: ").append(createTimeStr)
            .append(",updateTime: ").append(updateTimeStr)
            .toString();
    }

}
