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
	public Video findOne(String idtopic) {
		return videoRepository.findOne(idtopic);
	}

	@Override
	public void UpdateVideo(String url, String level, String topic, String idvideo) {
		videoRepository.UpdateVideo(url, level, topic, idvideo); 
		
	}

	@Override
	public void AddVideo(String url, String level, String topic, String idvideo) {
		videoRepository.AddVideo(url, level, topic, idvideo);
		
	}

	@Override
	public void DeleteVideo(String idvideo) {
		videoRepository.DeleteVideo(idvideo);
		
	}

}
