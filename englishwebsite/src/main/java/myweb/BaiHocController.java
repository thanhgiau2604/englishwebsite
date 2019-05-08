package myweb;

import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import myweb.entity.Question;
import myweb.entity.Study;
import myweb.entity.Video;
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
			String thongbao1="", thongbao2="";
			if (level==0)
			{
				thongbao1="Bạn chưa vượt qua bài test nào cả!\n";
				thongbao2="Bắt đầu học nào!";
			}
			else
				if (level==1)
				{
					thongbao1="Bạn đã vượt qua bài test mức độ dễ!\n";
					thongbao2="Hãy đến với mức độ tiếp theo nhé!";
				}
				else
					if (level==2)
					{
						thongbao1="Bạn đã vượt qua bài test mức độ dễ trung bình!\n";
						thongbao2="Hãy đến với mức độ tiếp theo nhé!";
					}
					else
						if (level==3)
						{
							thongbao1="Bạn đã hoàn thành tất cả bài thi!\n";
							thongbao2="Bạn có thể học topic khác, hoặc reset lại topic để ôn luyện nhé!";
						}
			String thongbao=thongbao1.concat(thongbao2);
			model.addAttribute("thongbao", thongbao);
			model.addAttribute("topic", idtopic);
			model.addAttribute("level", level+1);
			return "hoc_luachonnd";
		}	
		
		@RequestMapping(value = "/resettopic={id}", method = RequestMethod.GET)
		public String ResetTopic(@PathVariable("id") String idtopic,Model model, HttpSession session) {
			String username=session.getAttribute("username").toString();
			studyService.ResetTopic(username, idtopic);
			model.addAttribute("lTopic", topicService.findAll());
			return "hoc_dstopic";
		}
		
		@RequestMapping(value = "/hienthidsvideo={id}/{level}", method = RequestMethod.GET)
		public String DSVideo(@PathVariable("id") String idtopic, @PathVariable("level") String level, Model model, 
				HttpSession session) {
			int lev = Integer.parseInt(level);
			String capdo="";
			switch (lev) {
			case 1:
				capdo="Mức độ dễ";
				break;
			case 2:
				capdo="Mức độ trung bình";
				break;
			case 3:
				capdo="Mức độ khó";
				break;
			}
			model.addAttribute("strlevel", capdo);
			model.addAttribute("level", lev);
			model.addAttribute("topic", idtopic);
			List<Video> lVideo = studyService.SelectListVideo(idtopic);
			String username=session.getAttribute("username").toString();	
			model.addAttribute("lVideo",lVideo);
			return "hoc_dsvideo";
		}
		
		@RequestMapping(value = "/test/{topic}/{level}", method = RequestMethod.GET)
		public String DoTest(@PathVariable("topic") String topic, @PathVariable("level") String level, Model model, HttpSession session) {
			int lev = Integer.parseInt(level);
			String capdo="";
			switch (lev) {
			case 1:
				capdo="Mức độ dễ";
				break;
			case 2:
				capdo="Mức độ trung bình";
				break;
			case 3:
				capdo="Mức độ khó";
				break;
			}
			model.addAttribute("strlevel", capdo);
			model.addAttribute("level", lev);
			model.addAttribute("topic", topic);
			List<Question> lQuestion = studyService.SelectGroupQuestion(topic, lev);
			model.addAttribute("lQuestion", lQuestion);
			session.setAttribute("lQuestion", lQuestion);
			return "hoc_test";
		}
		
		@RequestMapping(value = "/processresult/{topic}/{level}", method = RequestMethod.POST)
		public String XuLyKQ(@PathVariable("topic") String topic, @PathVariable("level") String level, Model model, HttpServletRequest request, HttpSession session) {
			String username=session.getAttribute("username").toString();
			List<Question> lQuestion = (List<Question>) session.getAttribute("lQuestion");
		    /*String value1= request.getParameter("question1");
		    String value2= request.getParameter("question2");
		    System.out.print("value1="+value1+" value2="+value2); */
			int count=0;
			for (int i = 0; i < lQuestion.size(); i++) {
				String param = "question"+(i+1);
				String userchoose = request.getParameter(param);
				if (userchoose.equals(lQuestion.get(i).getKeyquestion()))
						count+=1;
			}
			double phantram = (count*100)/lQuestion.size();
			double diemso = (10/lQuestion.size())*count;
			String diemSo = String.format("%.2f", diemso);
			String thongbao="",strlev="";
			int lev = Integer.parseInt(level);
			
			if (lev==1)
				strlev="dễ";
			else
				if (lev==2)
					strlev="trung bình";
				else
					if (lev==3)
						strlev="khó";
			if (phantram>75) {
				studyService.InsertProcess(username, topic, lev,count); 
				thongbao="Điểm số:"+diemSo+". Bạn đã vượt qua mức độ "+strlev+", bạn có thể chọn BẮT ĐẦU để đến với mức độ tiếp theo";
				model.addAttribute("level", lev+1);
			}
			else
			{
				thongbao="Điểm số:"+diemSo+". Bạn không vượt qua mức độ "+strlev+", bạn có thể chọn BẮT ĐẦU để xem lại bài học!";
				model.addAttribute("level", lev);
			}
			model.addAttribute("thongbao", thongbao);
			model.addAttribute("topic", topic);
			
			return "hoc_luachonnd";
		}
}
