package io.github.wildmeowth.util;

import java.util.Random;

import io.github.wildmeowth.entity.Questions;

public class QuestionUtil {
	public static String getQuestion(Questions questions) {
		Random rand = new Random();
		int i = rand.nextInt(questions.getQuestionMap().size())+1;
		String question = questions.getQuestionMap().get(String.valueOf(i));
		//System.out.println("click");
		return question;
	}
}
