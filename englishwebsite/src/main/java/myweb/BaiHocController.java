package myweb;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import myweb.entity.Study;
import myweb.service.StudyService;
import myweb.service.TopicService;

@Controller
public class BaiHocController {
	@Autowired
	TopicService topicService;
	@Autowired
	StudyService studyService;
	// Danh sách topic
		@RequestMapping(value = "/hoc_dstopic", method = RequestMethod.GET)
		public String QLBaiHoc(Model model) {
			model.addAttribute("lTopic", topicService.findAll());
			return "hoc_dstopic";
		}
		
		@RequestMapping(value = "/xulychontopic={id}", method = RequestMethod.GET)
		public String XuLyChonTopic(@PathVariable("id") String idtopic, Model model, HttpSession session) {
			String username = session.getAttribute("username").toString();
			int level = studyService.GetLevel(username, idtopic);
			System.out.print("level="+level);
			return "hoc_dstopic";
		}
		
		
}
