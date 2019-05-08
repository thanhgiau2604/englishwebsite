package myweb.service;

import java.util.List;

import myweb.entity.Question;
import myweb.entity.Study;
import myweb.entity.Video;

public interface StudyService {
	Iterable<Study> findAll();
	void UpdatePass(String username, String topic, int level);
	void UpdateCorrect(String username, String topic, int level);
	void InsertProcess(String username, String topic, int level);
	void ResetTopic(String username, String topic);
	List<Question> SelectGroupQuestion(String topic, int level);
	Question CheckAnswer(String idquestion, String keyquestion);
	int GetLevel(String username, String topic);
	int CheckPassLevel(String username, String topic, String level);
	int GetCorrect(String username,String topic, String level);
	List<Video>SelectListVideo(String topic);
}
