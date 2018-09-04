package io.github.wildmeowth.paint;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;

import io.github.wildmeowth.util.QuestionUtil;
import io.github.wildmeowth.util.ReadUtil;
import io.github.wildmeowth.entity.Questions;

public class Paint {
	public static void paint(){
		Frame frame = new Frame("Questions");
		frame.setVisible(true);
		frame.setSize(600, 400);
		frame.setLocation(400, 50);
//		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(""));
		TextArea tarea = new TextArea();
		Button btn = new Button("GET QUESTIONS");
		frame.add(tarea);
		frame.add(btn);
		frame.setLayout(new GridLayout(2,1));
		frame.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});

		String txtURL = Paint.class.getResource("/io/github/wildmeowth/resources/questions.properties").getPath();
		System.out.println(txtURL);
		HashMap<String, String> questionMap = ReadUtil.readQuestionTxt(txtURL);
		Questions questions = new Questions();
		questions.setQuestionMap(questionMap);
		btn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				tarea.setText(QuestionUtil.getQuestion(questions));
			}
		});
	}
}
