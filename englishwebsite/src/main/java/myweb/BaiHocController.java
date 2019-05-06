package myweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BaiHocController {
	// Danh sách topic
		@RequestMapping(value = "/hoc_dstopic", method = RequestMethod.GET)
		public String QLBaiHoc(Model model) {
			return "hoc_dstopic";
		}
}
