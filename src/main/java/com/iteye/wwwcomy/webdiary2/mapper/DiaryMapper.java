package com.iteye.wwwcomy.webdiary2.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.iteye.wwwcomy.webdiary2.model.Diary;

@Mapper
public interface DiaryMapper {

	@Select("SELECT ID,DIARY_DATE,USERNAME,WEATHER,TITLE,MEMO,CREATED_DATE FROM DIARY WHERE ID = #{id}")
	@Results({ @Result(property = "diaryDate", column = "diary_date"), @Result(property = "content", column = "memo"),
			@Result(property = "createdDate", column = "created_date") })
	Diary findById(@Param("id") Long id);

	@Select("SELECT DISTINCT DIARY_DATE FROM DIARY WHERE USERNAME = #{username}")
	List<Date> findDatesByUsername(@Param("username") String username);

	@Insert("INSERT INTO DIARY (DIARY_DATE,USERNAME,WEATHER,TITLE,MEMO,CREATED_DATE) values (#{diaryDate},#{username},#{weather},#{title},#{content},#{createdDate})")
	void insert(Diary diary);

	@Update("UPDATE DIARY SET title=#{title}, weather=#{weather}, memo=#{content} where id=#{id}")
	void update(Diary diary);

	@Delete("DELETE FROM DIARY WHERE ID = #{id}")
	void delete(@Param("id") Long id);
}
