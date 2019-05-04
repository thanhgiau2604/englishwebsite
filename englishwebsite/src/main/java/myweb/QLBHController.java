package myweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import myweb.entity.Topic;
import myweb.service.TopicService;

@Controller
public class QLBHController {
	
	@Autowired
    private TopicService topicService;
	
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
}
