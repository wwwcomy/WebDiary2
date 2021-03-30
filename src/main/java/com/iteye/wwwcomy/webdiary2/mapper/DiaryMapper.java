package com.iteye.wwwcomy.webdiary2.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.iteye.wwwcomy.webdiary2.model.Diary;

@Mapper
public interface DiaryMapper {

	@Select("SELECT ID,DIARY_DATE,USERNAME,WEATHER,TITLE,MEMO,CREATED_DATE FROM DIARY WHERE ID = #{id}")
	Diary findById(@Param("id") Long id);

	@Select("SELECT DISTINCT DIARY_DATE FROM DIARY WHERE USERNAME = #{username}")
	List<Date> findDatesByUsername(@Param("username") String username);

}
