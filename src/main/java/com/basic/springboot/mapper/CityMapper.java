package com.basic.springboot.mapper;

import com.basic.springboot.domain.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CityMapper {

    @Select("select * from city where state = #{state}")
    City findbyState(@Param("stata")String state);

}
