package com.iteye.wwwcomy.webdiary2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.iteye.wwwcomy.webdiary2.mapper.DiaryMapper;
import com.iteye.wwwcomy.webdiary2.model.Diary;
import com.iteye.wwwcomy.webdiary2.util.MyStringUtil;

@SpringBootTest
public class Migration {

	@Autowired
	private DiaryMapper diaryMapper;

	@Test
	public void migrate() throws IOException, ParseException {
		String databaseURL = "jdbc:ucanaccess://f://Data//xxx.mdb";
		Properties properties = new Properties();
		// 这里设置连接数据库时候用的编码
		properties.setProperty("charSet", "gbk");
		properties.setProperty("password", "");
		try (Connection connection = DriverManager.getConnection(databaseURL, properties)) {
			String sql = "SELECT * FROM book";
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				String date = result.getString("date");
				String weather = result.getString("icotext");
				String title = result.getString("title");
				String memo = MyStringUtil.rtf2String(result.getString("memo"));
				System.out.println(date + ", " + weather + ", " + title + ", " + memo.length());
				Diary d = new Diary();
				d.setContent(memo);
				d.setCreatedDate(new Date());
				d.setDiaryDate(DateUtils.parseDate(date.substring(0, 10), "yyyy-MM-dd"));
				d.setTitle(title);
				d.setUsername("");
				d.setWeather(weather);
				diaryMapper.insert(d);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
