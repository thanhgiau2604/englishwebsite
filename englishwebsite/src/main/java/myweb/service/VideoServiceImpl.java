package myweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myweb.entity.Video;
import myweb.repository.VideoRepository;

@Service
public class VideoServiceImpl implements VideoService{

	@Autowired
    private VideoRepository videoRepository;
	
	@Override
	public Iterable<Video> findAll() {
		return videoRepository.findAll();
	}

	@Override
	public Video findOne(String idvideo) {
		return videoRepository.findOne(idvideo);
	}

	@Override
	public void DeleteVideo(String idvideo) {
		videoRepository.DeleteVideo(idvideo);
		
	}

	@Override
	public void UpdateVideo(String url, String namevideo, String describevideo, int level, String topic, String idvideo) {
		videoRepository.UpdateVideo(url, namevideo, describevideo, level, topic, idvideo); 
		
	}

	@Override
	public void AddVideo(String idvideo, String url, String namevideo, String describevideo, int level, String topic) {
		videoRepository.AddVideo(idvideo, url, namevideo, describevideo, level, topic); 
		
	}

}
