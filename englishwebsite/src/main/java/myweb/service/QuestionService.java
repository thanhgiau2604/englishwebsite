package myweb.service;

import myweb.entity.Question;

public interface QuestionService {
	Iterable<Question> findAll();
	Question findOne(String idquestion);
	void UpdateQuestion(String content, String optiona, String optionb,String optionc, String optiond, String keyquestion, String explainkey, int levelquestion, String topic, String idquestion);
	void AddQuestion(String idquestion, String content, String optiona, String optionb,String optionc, String optiond, String keyquestion, String explainkey,int levelquestion, String topic);
	void DeleteQuestion(String idquestion);
}
