package com.lyj.springdemo.mapper;


import org.apache.ibatis.annotations.Select;

public interface TimeMapper {

    //@Select("select now()")
    String getTime();

    //@Select("select count(*) from test_tb1")
    int getCount();
}
