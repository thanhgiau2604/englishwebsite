package myweb.service;

import myweb.entity.Video;
public interface VideoService {
	Iterable<Video> findAll();
	Video findOne(String idtopic);
	void UpdateVideo(String url, String level, String topic, String idvideo);
	void AddVideo(String url, String level, String topic, String idvideo);
	void DeleteVideo(String idvideo);
}
