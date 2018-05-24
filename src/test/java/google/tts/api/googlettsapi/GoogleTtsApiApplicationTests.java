package google.tts.api.googlettsapi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoogleTtsApiApplicationTests {

	@Test
	public void contextLoads() throws Exception {
		System.out.println(SynthesizeText.synthesizeText("테스트 입니다.","ko-KR"));
	}

}
