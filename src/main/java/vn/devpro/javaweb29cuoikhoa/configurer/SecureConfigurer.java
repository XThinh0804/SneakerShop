package vn.devpro.javaweb29cuoikhoa.configurer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import vn.devpro.javaweb29cuoikhoa.service.UserdetailsServiceJw29;

@Configuration
@EnableWebSecurity
public class SecureConfigurer extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// Bắt đầu cấu hình
		http.csrf().disable().authorizeRequests()// Bắt tất cả các request từ browser
				// Cho phép các request, static resources không bị ràng buộc login
				.antMatchers("/frontend/**", "/backend/**", "/UploadFiles/**", "/login", "/logout").permitAll()
				// Các requests kiểu "/admin/**" phải login (xác thực) mới vào được
//				.antMatchers("/admin/**").authenticated()
				// Các request kiểu "/ADMIN" phải có role là ADMIN
				.antMatchers("/admin/**").hasAuthority("ADMIN")
				.and()
				// Nếu chưa login (xác thực) thì redirect đến trang login
				// Với "/login" là 1 request (trong LoginController)
				.formLogin().loginPage("/login").loginProcessingUrl("/login_processing_url")
//				.defaultSuccessUrl("/admin/home/view", true)// Login thành công thì vào trang admin
				//Login thành công : chuyển đến request phù hợp với role
				.successHandler(new UrlAuthenticationSuccessHandler())
				// Login không thành công
				.failureUrl("/login?login_error=true")
				.and()
				//Cấu hình phần logout
				.logout().logoutUrl("/logout").logoutSuccessUrl("/index").invalidateHttpSession(true).deleteCookies("JSESSIONID")
				.and()
				.rememberMe().key("uniqueAndSecret").tokenValiditySeconds(86400);
	}

	@Autowired
	private UserdetailsServiceJw29 userDetailsService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder(4));
	}
//	public static void main(String[] args) {
//		System.out.println(new BCryptPasswordEncoder(4).encode("123"));
//	}
}
