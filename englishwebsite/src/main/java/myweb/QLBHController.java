package myweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import myweb.entity.Topic;
import myweb.entity.Video;
import myweb.service.TopicService;
import myweb.service.VideoService;

@Controller
public class QLBHController {
	
	@Autowired
    private TopicService topicService;
	@Autowired
    private VideoService videoService;
	
	// Quản lý bài học
	@RequestMapping(value = "/qlbaihoc", method = RequestMethod.GET)
	public String QLBaiHoc(Model model) {
		return "qlbaihoc";
	}

	// Quản lý topic
	@RequestMapping(value = "/qlbaihoc_topic", method = RequestMethod.GET)
	public String QLBaiHoc_Topic(Model model) {	
		model.addAttribute("lTopic",topicService.findAll());
		return "qlbaihoc_topic";
	}
	
	//Xử lý thêm
		@RequestMapping(value = "/qlbaihoc_themtopic", method = RequestMethod.GET)
		public String QLBaiHoc_ThemTopic(Model model) {				
			return "qlbaihoc_themtopic";
		}
	
		@RequestMapping(value = "/xulythemtopic", method = RequestMethod.POST)
		public String XuLyThemTopic(@RequestParam("idtopic") String idtopic, @RequestParam("name") String name, 
				@RequestParam("describe") String describe, Model model) {	
			topicService.AddTopic(idtopic, name, describe);
			model.addAttribute("lTopic",topicService.findAll());
			return "qlbaihoc_topic";
		}
	//Xử lý chỉnh sửa
		@RequestMapping(value = "/qlbaihoc_chinhsuatopic={id}", method = RequestMethod.GET)
		public String QLBaiHoc_ChinhSuaTopic(@PathVariable("id") String idtopic,Model model) {	
			model.addAttribute("topic", topicService.findOne(idtopic)); 
			return "qlbaihoc_chinhsuatopic";
		}
	
		@RequestMapping(value = "/xulychinhsuatopic", method = RequestMethod.POST)
		public String XuLyChinhSuaTopic(@RequestParam("idtopic") String idtopic, @RequestParam("name") String name, 
				@RequestParam("describe") String describe, Model model) {	
			topicService.UpdateTopic(name, describe,idtopic);
			model.addAttribute("lTopic",topicService.findAll());
			return "qlbaihoc_topic";
		}
	//Xử lý xóa
		@RequestMapping(value = "/xoatopic={id}", method = RequestMethod.GET)
		public String XuLyXoaTopic(@PathVariable("id") String idtopic, Model model) {	
			topicService.DeleteTopic(idtopic); 
			model.addAttribute("lTopic",topicService.findAll());
			return "qlbaihoc_topic";
		}
		
	//Quản lý video
		@RequestMapping(value = "/qlbaihoc_video", method = RequestMethod.GET)
		public String QLBaiHoc_Video(Model model) {	
			model.addAttribute("lVideo",videoService.findAll());
			return "qlbaihoc_video";
		}	
		
	//Thêm video
		@RequestMapping(value = "/qlbaihoc_themvideo", method = RequestMethod.GET)
		public String QLBaiHoc_ThemVideo(Model model) {				
			return "qlbaihoc_themvideo";
		}
	
		@RequestMapping(value = "/xulythemvideo", method = RequestMethod.POST)
		public String XuLyThemVideo(@RequestParam("idvideo") String idvideo, @RequestParam("url") String url, 
				@RequestParam("namevideo") String namevideo, @RequestParam("level") String level, @RequestParam("topic") String topic, Model model) {	
			int capdo = Integer.parseInt(level);
			videoService.AddVideo(idvideo, url, namevideo, capdo, topic);
			model.addAttribute("lVideo",videoService.findAll());
			return "qlbaihoc_video";	
		}
	//Sửa video
		@RequestMapping(value = "/qlbaihoc_chinhsuavideo={id}", method = RequestMethod.GET)
		public String QLBaiHoc_ChinhSuaVideo(@PathVariable("id") String idvideo, Model model) {
			Video video = videoService.findOne(idvideo);
			model.addAttribute("level",video.getLevel());
			model.addAttribute("video", videoService.findOne(idvideo)); 
			return "qlbaihoc_chinhsuavideo";
		}
	
		@RequestMapping(value = "/xulychinhsuavideo", method = RequestMethod.POST)
		public String XuLyEditVideo(@RequestParam("idvideo") String idvideo, @RequestParam("url") String url, 
				@RequestParam("namevideo") String namevideo, @RequestParam("level") String level, @RequestParam("topic") String topic, Model model) {	
			int capdo = Integer.parseInt(level);
			videoService.UpdateVideo(url, namevideo, capdo, topic, idvideo); 
			model.addAttribute("lVideo",videoService.findAll());
			return "qlbaihoc_video";	
		}
	//Xóa video
		@RequestMapping(value = "/xoavideo={id}", method = RequestMethod.GET)
		public String XuLyXoaVideo(@PathVariable("id") String idvideo, Model model) {	
			videoService.DeleteVideo(idvideo); 
			model.addAttribute("lVideo",videoService.findAll());
			return "qlbaihoc_video";
		}	
}
