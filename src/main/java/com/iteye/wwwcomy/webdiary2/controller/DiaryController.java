package com.iteye.wwwcomy.webdiary2.controller;

import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iteye.wwwcomy.webdiary2.model.Diary;
import com.iteye.wwwcomy.webdiary2.model.exception.InvalidParameterException;

@RestController
@RequestMapping("/diaries")
public class DiaryController {

	@Autowired
	private DiaryService diaryService;

	@GetMapping("/{id}")
	public Diary getDiaryById(@PathVariable Long id) {
		return diaryService.getDiaryById(id);
	}

	@GetMapping("/dates")
	public Set<String> listDiaryDateByUser(String username) {
		if (StringUtils.isEmpty(username)) {
			throw new InvalidParameterException("username cannot be empty.");
		}
		return diaryService.listDiaryDatesByUsername(username);
	}
}
