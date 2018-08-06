package io.github.wildmeowth.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

public class ReadUtil {
	public static HashMap<String, String> readQuestionTxt(String filePath){
		BufferedReader br;
		HashMap<String, String> questionMap = new HashMap<String, String>();
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
			String line = "";
			int i = 0;
			while((line = br.readLine())!=null){
				i++;
				questionMap.put(String.valueOf(i), line);
			}
			br.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Read it at first");
		return questionMap;
	}
}
