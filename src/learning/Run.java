package learning;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Random;

public class Run {
	private static String filePath = "./questions.properties";

	public static void main(String[] args) {
		Questions questions = new Questions();
		questions.setQuestionMap(read(filePath));
		paint(questions);
	}
	
	//paint the frame. 
	public static void paint(Questions questions){
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
		btn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				tarea.setText(getQuestion(questions));
			}
		});
	}
	
	//get a question. 
	public static String getQuestion(Questions questions){
		Random rand = new Random();
		int i = rand.nextInt(questions.getQuestionMap().size())+1;
		String question = questions.getQuestionMap().get(String.valueOf(i));
		System.out.println("click");
		return question;
	}
	
	//get the questions and put ervery question to a question map. 
	private static HashMap<String, String> read(String filePath){
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
