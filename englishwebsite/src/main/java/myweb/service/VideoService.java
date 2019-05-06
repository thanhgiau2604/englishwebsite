package myweb.service;

import myweb.entity.Video;
public interface VideoService {
	Iterable<Video> findAll();
	Video findOne(String idvideo);
	void UpdateVideo(String url, String namevideo, String describevideo,int level, String topic, String idvideo);
	void AddVideo(String idvideo, String url, String namevideo, String describevideo ,int level, String topic);
	void DeleteVideo(String idvideo);
}
