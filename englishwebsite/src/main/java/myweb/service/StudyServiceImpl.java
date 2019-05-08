package myweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myweb.entity.Question;
import myweb.entity.Study;
import myweb.entity.Video;
import myweb.repository.StudyRepository;

@Service
public class StudyServiceImpl implements StudyService{

	@Autowired
	StudyRepository studyRepository;
	@Override
	public Iterable<Study> findAll() {
		return studyRepository.findAll();
	}

	@Override
	public void UpdatePass(String username, String topic, int level) {
		studyRepository.UpdatePass(username, topic, level);
		
	}

	@Override
	public void UpdateCorrect(String username, String topic, int level) {
		studyRepository.UpdateCorrect(username, topic, level);
		
	}

	@Override
	public void InsertProcess(String username, String topic, int level) {
		studyRepository.InsertProcess(username, topic, level);
		
	}

	@Override
	public void ResetTopic(String username, String topic) {
		studyRepository.ResetTopic(username, topic);
		
	}

	@Override
	public List<Question> SelectGroupQuestion(String topic, int level) {
		return studyRepository.SelectGroupQuestion(topic, level);
	}

	@Override
	public Question CheckAnswer(String idquestion, String keyquestion) {
		return studyRepository.CheckAnswer(idquestion, keyquestion);
	}

	@Override
	public int GetLevel(String username, String topic) {
		return studyRepository.GetLevel(username, topic);
	}

	@Override
	public int CheckPassLevel(String username, String topic, String level) {
		return studyRepository.CheckPassLevel(username, topic, level);
	}

	@Override
	public int GetCorrect(String username, String topic, String level) {
		return studyRepository.GetCorrect(username, topic, level);
	}

	@Override
	public List<Video> SelectListVideo(String topic) {
		return studyRepository.SelectListVideo(topic); 
	}
	
}
