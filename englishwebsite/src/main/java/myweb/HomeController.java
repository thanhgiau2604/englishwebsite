package myweb;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import myweb.entity.Account;
import myweb.service.AccountService;

@Controller
public class HomeController {
	
	@Autowired
    private AccountService accountService;
	
	//Mapping trang chủ, đăng nhập, đăng ký
	@RequestMapping(value = {"/","/trangchu"}, method = RequestMethod.GET)
	public String TrangChu(Model model, HttpSession session) { 	
		return "trangchu";
	}
	
	@RequestMapping(value ="/trangchuuser", method = RequestMethod.GET)
	public String TrangChuUser(Model model, HttpSession session) { 	
		return "trangchuuser";
	}
	
	@RequestMapping(value ="/trangchuad", method = RequestMethod.GET)
	public String TrangChuAdmin(Model model, HttpSession session) { 	
		return "trangchuad";
	}
	
	@RequestMapping(value = "/dangnhap", method = RequestMethod.GET)
	public String DangNhap() { 
		return "dangnhap";
	}
	
	@RequestMapping(value = "/dangky", method = RequestMethod.GET)
	public String DangKy() { 
		return "dangky";
	}
	
	
	//Xử lý đăng nhập khi press button Đăng nhập
	@RequestMapping(value = "/xulydangnhap", method = RequestMethod.POST)
	public String XuLyDangNhap(@RequestParam(name="uname") String username, @RequestParam(name="password") String password, Model model, HttpSession session) { 
		Account account = new Account();
		account = accountService.findOne(username);
		int LoginSuccess = 0;
		if (account!=null) {
			String myPass = account.getPassword().toString();
			if (myPass.equals(password))
			{
				LoginSuccess=1;	
				session.setAttribute("username", account.getUsername());
			}
		}
		
		if (LoginSuccess==1) {
			int isAd = account.getIsAd();
			if (isAd==0)
				return "trangchuuser"; else
					return "trangchuad";
		}
		model.addAttribute("isSuccess", LoginSuccess);
		return "dangnhap";
	}
	
	//Hiển thị thông tin cần cập nhật
	@RequestMapping(value = "/thaydoithongtinuser", method = RequestMethod.GET)
	public String ThayDoiThongTinUser(Model model, HttpSession session) { 
		Account user = accountService.findOne(session.getAttribute("username").toString());
		model.addAttribute("account", user);
		return "thaydoithongtinuser";
	}
	
	@RequestMapping(value = "/thaydoithongtinad", method = RequestMethod.GET)
	public String ThayDoiThongTinAdmin(Model model, HttpSession session) { 
		Account admin = accountService.findOne(session.getAttribute("username").toString());
		model.addAttribute("account", admin);
		return "thaydoithongtinad";
	}
	
	
	//Xử lý lưu thông tin cá nhân (user and admin)
	@RequestMapping(value = "/luuthongtincanhan", method = RequestMethod.POST)
	public String LuuThongTinCaNhan(@RequestParam(name="uname") String username, @RequestParam(name="fullname") String fullname, 
			@RequestParam(name="phone") String phone, @RequestParam(name="email") String email, @RequestParam(name="address") String address,
			Model model, HttpSession session) { 
		Account account = accountService.findOne(username);
		int isAd = account.getIsAd();
		accountService.UpdateInforPersonal(fullname, email, phone, address, username);
		Account updateaccount = accountService.findOne(username);
		model.addAttribute("account", updateaccount);
		if (isAd==0)
			return "thaydoithongtinuser";
		else
			return "thaydoithongtinad";
	}
	
	
	//Mapping hiển thị trang quản lý người dùng
	@RequestMapping(value = "/qlnguoidung", method = RequestMethod.GET)
	public String QLNguoiDung(Model model) { 
		model.addAttribute("lAccount",accountService.findAll());
		return "qlnguoidung";
	}
	
	//Hiển thị thông tin user
	@RequestMapping(value = "/qlthongtin={id}", method = RequestMethod.GET)
	public String QLThayDoiThongTin(@PathVariable("id") String username, Model model) { 
		Account account = accountService.findOne(username);
		int isad = account.getIsAd();
		boolean isadmin = false;
		if (isad==1) isadmin=true;
		model.addAttribute("isadmin",isadmin);
		model.addAttribute("account",account);
		return "qlthaydoithongtin";
	}
	//Cập nhật thông tin user
	@RequestMapping(value = "/qlluuthongtin", method = RequestMethod.POST)
	public String QLLuuThongTin(@RequestParam(name="uname") String username, @RequestParam(name="fullname") String fullname, 
			@RequestParam(name="phone") String phone, @RequestParam(name="email") String email, @RequestParam(name="address") String address,
			@RequestParam(value="isadmin",defaultValue="false") boolean isadmin, Model model) { 
		int admin=0;
		if (isadmin) admin=1;
		accountService.UpdateInforUser(fullname, email, phone, address, admin, username);
		model.addAttribute("lAccount",accountService.findAll());
		return "qlnguoidung";
	}
	
	//Mapping trang đổi mật khẩu
	
	@RequestMapping(value = "/doimatkhauuser", method = RequestMethod.GET)
	public String DoiMatKhauUser(Model model) { 
		return "doimatkhauuser";
	}
	
	@RequestMapping(value = "/doimatkhauad", method = RequestMethod.GET)
	public String DoiMatKhauAdmin(Model model) { 
		return "doimatkhauad";
	}
	
	
	// Xử lý đổi mật khẩu khi press button Cập nhật mật khẩu
	@RequestMapping(value = "/xulydoimatkhau", method = RequestMethod.POST)
	public String DoiMatKhau(@RequestParam(name="oldpass") String oldpass, @RequestParam(name="newpass") String newpass, 
			@RequestParam(name="repass") String repass, Model model, HttpSession session) { 
		Account account = accountService.findOne(session.getAttribute("username").toString());
		
		int isad = account.getIsAd();
		
		if (!account.getPassword().toString().equals(oldpass)) {
			model.addAttribute("checkdoimatkhau", 1);
			if (isad==0) return "doimatkhauuser"; else return "doimatkhauad";
		}
		
		if (!newpass.equals(repass)) {
			model.addAttribute("checkdoimatkhau", 2);
			if (isad==0) return "doimatkhauuser"; else return "doimatkhauad";
		}
		accountService.UpdatePassword(newpass, session.getAttribute("username").toString()); 
		model.addAttribute("checkdoimatkhau", 0);
		if (isad==0) return "trangchuuser"; else return "trangchuad";
	}
	
	// Xử lý đăng ký khi press button Đăng ký
	@RequestMapping(value = "/xulydangky", method = RequestMethod.POST)
	public String XuLyDangKy(@RequestParam(name="uname") String username, @RequestParam(name="password") String password,
			@RequestParam(name="fullname") String fullname, @RequestParam(name="phone") String phone, 
			@RequestParam(name="email") String email, @RequestParam(name="address") String address, Model model) { 
		try
		{
			accountService.AddUser(username, password, fullname, phone, email, address); 
		}
		catch (Exception e){
			return "dangky";
		}
		return "dangnhap";
	}
	
	//Quản lý bài học
}
