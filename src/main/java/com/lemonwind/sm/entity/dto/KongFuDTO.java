package com.lemonwind.sm.entity.dto;

import com.lemonwind.sm.common.LemonwindEntity;

import java.util.Date;

public class KongFuDTO extends LemonwindEntity<KongFuDTO> {

    private String name;

    private Integer level;

    private Long inventionUserId;

    public Long getId() {
        return this.id;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public String getName() {
        return this.name;
    }

    public Integer getLevel() {
        return this.level;
    }

    public Long getInventionUserId() {
        return this.inventionUserId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public void setInventionUserId(Long inventionUserId) {
        this.inventionUserId = inventionUserId;
    }

}

