package myweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myweb.entity.Question;
import myweb.repository.QuestionRepository;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	QuestionRepository questionRepository;
	@Override
	public Iterable<Question> findAll() {
		return questionRepository.findAll();
	}

	@Override
	public Question findOne(String idquestion) {
		return questionRepository.findOne(idquestion);
	}

	@Override
	public void UpdateQuestion(String content, String optiona, String optionb, String optionc, String optiond,
			String keyquestion, int levelquestion, String topic, String idquestion) {
		questionRepository.UpdateQuestion(content, optiona, optionb, optionc, optiond, keyquestion, levelquestion, topic, idquestion); 
		
	}

	@Override
	public void AddQuestion(String idquestion, String content, String optiona, String optionb, String optionc,
			String optiond, String keyquestion, int levelquestion, String topic) {
		questionRepository.AddQuestion(idquestion, content, optiona, optionb, optionc, optiond, keyquestion, levelquestion, topic);
		
	}

	@Override
	public void DeleteQuestion(String idquestion) {
		questionRepository.DeleteQuestion(idquestion);
		
	}

}
