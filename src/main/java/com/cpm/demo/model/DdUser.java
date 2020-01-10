package com.cpm.demo.model;

import lombok.Data;

@Data
public class DdUser {
    private String userid;
    private String sys_level;
    private String errmsg;
    private boolean is_sys;
    private long errcode;


    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getSys_level() {
        return sys_level;
    }

    public void setSys_level(String sys_level) {
        this.sys_level = sys_level;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public boolean isIs_sys() {
        return is_sys;
    }

    public void setIs_sys(boolean is_sys) {
        this.is_sys = is_sys;
    }

    public long getErrcode() {
        return errcode;
    }

    public void setErrcode(long errcode) {
        this.errcode = errcode;
    }

}
