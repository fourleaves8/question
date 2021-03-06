package com.sbs.example.mysqlTextBoard.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Util {

	public static void mkdirs(String filePath) {
		File dir = new File(filePath);
		if (dir.exists() == false) {
			dir.mkdirs();
		}
	}

	public static void fileWriter(String filePath, String body) {
		File file = new File(filePath);

		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(body);
			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void rmdir(File dirToBeDel) {
		File[] allContents = dirToBeDel.listFiles();
		if (allContents != null) {
			for (File file : allContents) {
				if (file.isDirectory()) {
					rmdir(file);
				} else {
					file.delete();
				}
			}
		}
		dirToBeDel.delete();
	}

	public static String getFileTemplate(File fileTemplate) {
		String rs = null;
		try {
			// 바이트 단위로 파일읽기
			FileInputStream fileStream = null; // 파일 스트림

			fileStream = new FileInputStream(fileTemplate);// 파일 스트림 생성
			// 버퍼 선언
			byte[] readBuffer = new byte[fileStream.available()];
			while (fileStream.read(readBuffer) != -1) {
			}

			rs = new String(readBuffer);

			fileStream.close(); // 스트림 닫기
		} catch (Exception e) {
			e.getStackTrace();
		}

		return rs;

	}
}
