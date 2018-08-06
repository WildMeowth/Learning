package src.io.github.wildmeowth.entity;

import java.util.HashMap;

public class Questions {
	private HashMap<String, String> questionMap;

	public HashMap<String, String> getQuestionMap() {
		return questionMap;
	}

	public void setQuestionMap(HashMap<String, String> questionMap) {
		this.questionMap = questionMap;
	}

	@Override
	public String toString() {
		return "Questions [questionMap=" + questionMap + "]";
	}
}
