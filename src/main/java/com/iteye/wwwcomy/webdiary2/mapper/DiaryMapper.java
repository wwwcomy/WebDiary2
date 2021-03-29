package com.iteye.wwwcomy.webdiary2.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.iteye.wwwcomy.webdiary2.model.Diary;

@Mapper
public interface DiaryMapper {

	@Select("SELECT * FROM DIARY WHERE ID = #{id}")
	Diary findById(@Param("id") String id);

}
