package com.iteye.wwwcomy.webdiary2.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.rtf.RTFEditorKit;

import org.apache.commons.io.IOUtils;

import com.iteye.wwwcomy.webdiary2.model.exception.SysInternalException;

public class MyStringUtil {

	public static String rtf2String(String rtfString) {
		try {
			InputStream is = IOUtils.toInputStream(rtfString, Charset.forName("ISO8859_1"));
			RTFEditorKit kit = new RTFEditorKit();
			Document doc = kit.createDefaultDocument();
			kit.read(is, doc, 0);
			String tmp = doc.getText(0, doc.getLength());
			return new String(tmp.getBytes(Charset.forName("ISO8859_1")), "GB2312");
		} catch (IOException | BadLocationException e) {
			throw new SysInternalException("Failed to do rtf2String", e);
		}
	}
}
