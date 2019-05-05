package myweb.service;

import myweb.entity.Video;
public interface VideoService {
	Iterable<Video> findAll();
	Video findOne(String idtopic);
	void UpdateVideo(String url, String namevideo, int level, String topic, String idvideo);
	void AddVideo(String idvideo, String url, String namevideo, int level, String topic);
	void DeleteVideo(String idvideo);
}
