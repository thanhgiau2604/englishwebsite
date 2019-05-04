package myweb.service;

import myweb.entity.Topic;

public interface TopicService {
	Iterable<Topic> findAll();
	Topic findOne(String idtopic);
	void UpdateTopic(String name, String describe, String idtopic);
	void AddTopic(String idtopic, String name, String describe);
	void DeleteTopic(String idtopic);
}
