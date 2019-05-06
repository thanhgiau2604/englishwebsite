package myweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myweb.entity.Topic;
import myweb.repository.TopicRepository;

@Service
public class TopicServiceImpl implements TopicService {

	@Autowired
    private TopicRepository topicRepository;
	
	@Override
	public void UpdateTopic(String name, String imagetopic, String describe, String idtopic) {
		topicRepository.UpdateTopic(name, imagetopic,describe, idtopic); 
	}

	@Override
	public void AddTopic(String idtopic, String name, String imagetopic, String describe) {
		topicRepository.AddTopic(idtopic, name, imagetopic, describe);
	}

	@Override
	public void DeleteTopic(String idtopic) {
		topicRepository.DeleteTopic(idtopic);	
	}

	@Override
	public Iterable<Topic> findAll() {
		return topicRepository.findAll();
	}

	@Override
	public Topic findOne(String idtopic) {
		return topicRepository.findOne(idtopic);
	}

}
