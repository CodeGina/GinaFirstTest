package org.xgun.kissolive;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@Controller
@EnableTransactionManagement
@MapperScan({"org.xgun.kissolive.dao"})
public class Zqu004Application extends WebMvcConfigurerAdapter {

	@Override
	public void addCorsMappings(CorsRegistry registry) {

		registry.addMapping("/**")
				.allowCredentials(true)
				.allowedHeaders("*")
				.allowedOrigins("*")
				.allowedMethods("*");

	}

	public static void main(String[] args) {

		SpringApplication.run(Zqu004Application.class, args);
	}

	@RequestMapping("/managerlogin")
	String managerLogin(){
		return "admin/admin_login.html";
	}

	@RequestMapping("/login")
	String teacherLogin(){
		return "login.html";
	}





	@RequestMapping("/register")
	String register(){
		return "page/user/user_register.html";
	}

    @RequestMapping("/publish")
    String published(){
        return "page/admin/activitypublished.html";
    }

	@RequestMapping("/search")
	String search(){
		return "page/user/user_search.html";
	}

	@RequestMapping("/myshoppingcart")
	String myshoppingcart(){
		return "page/user/user_myshoppingcart.html";
	}

	@RequestMapping("/admin")
	String admin(){
		return "page/admin/frameset.html";
	}

	@RequestMapping("/pay")
	String pay(){
		return "page/user/user_pay.html";
	}

    @RequestMapping("/info")
    String info(){
        return "page/user/userinfo.html";
    }

	@RequestMapping("/production_detail")
	String productionDetail(){
		return "page/user/user_productdetail.html";
	}

	@RequestMapping("/order_detail")
	String orderDetail(){
		return "page/user/user_detailorder.html";
	}

	@RequestMapping("/pay_success")
	String paySuccess(){
		return "page/user/user_successed.html";
	}

	@RequestMapping("/orderlist")
	String orderList(){
		return "page/user/user_orderlist.html";
	}

	@RequestMapping("/admin_login")
	String adminlogin(){
		return "page/admin/admin_login.html";
	}

}
