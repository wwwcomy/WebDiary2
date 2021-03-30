package com.iteye.wwwcomy.webdiary2.controller;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iteye.wwwcomy.webdiary2.mapper.DiaryMapper;
import com.iteye.wwwcomy.webdiary2.model.Diary;

@Service
public class DiaryService {

	@Autowired
	private DiaryMapper diaryMapper;

	public Diary getDiaryById(Long id) {
		return diaryMapper.findById(id);
	}

	public Set<String> listDiaryDatesByUsername(String username) {
		List<Date> dates = diaryMapper.findDatesByUsername(username);
		Set<String> result = new HashSet<String>();

		for (Date d : dates) {
			result.add(DateFormatUtils.format(d, "yyyy-MM-dd"));
		}
		return result;
	}
}
