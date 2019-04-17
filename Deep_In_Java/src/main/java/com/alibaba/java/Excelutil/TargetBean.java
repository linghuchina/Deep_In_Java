package com.alibaba.java.util;

import java.util.Objects;

public class TargetBean {
    private String hetongNum;
    private String fahuoNum;

    public String getHetongNum() {
        return hetongNum;
    }

    public String getFahuoNum() {
        return fahuoNum;
    }

    public void setHetongNum(String hetongNum) {
        this.hetongNum = hetongNum;
    }

    public void setFahuoNum(String fahuoNum) {
        this.fahuoNum = fahuoNum;
    }

    @Override
    public String toString() {
        return "targetBean{" +
                "hetongNum='" + hetongNum + '\'' +
                ", fahuoNum='" + fahuoNum + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TargetBean that = (TargetBean) o;
        return Objects.equals(hetongNum, that.hetongNum) &&
                Objects.equals(fahuoNum, that.fahuoNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hetongNum, fahuoNum);
    }
}
