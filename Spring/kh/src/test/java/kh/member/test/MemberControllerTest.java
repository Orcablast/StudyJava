package kh.member.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
public class MemberControllerTest {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberControllerTest.class);
	
	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		logger.info("setup()완료~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
	
	@After
	public void finish() {
		logger.info("테스트 종료");
	}
	
	@Test
	public void testMemberRegister() throws Exception{
		logger.info("===== testMemerRegister() 메소드 시작 =====");
		
		try {
			mockMvc.perform(post("/beginSpring/memberRegister.action").param("userid", "leess").param("passwd", "qwer1234$").param("name", "이순신").param("email", "leess@gmail.com").param("tel", "01023456789")).andDo(print()).andExpect(status().isOk());
			logger.info("테스트 수행 성공!!");
		} catch (Exception e) {
			logger.info("테스트 수행 실패 : ");
			e.printStackTrace();
		}	
	}
}
