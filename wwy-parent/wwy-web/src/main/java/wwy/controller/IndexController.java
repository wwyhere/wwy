package wwy.controller;

import java.util.concurrent.Callable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController extends BaseController {

	@RequestMapping("/")
	public String index(HttpServletRequest request, HttpServletResponse response) {
		String sessionId = request.getSession().getId();
		System.out.println(sessionId);
		return "index";
	}

	@RequestMapping("/asyncTest")
	@ResponseBody
	public Callable<String> asyncTest() {
		// CommonsMultipartFile orginalFile = (CommonsMultipartFile)
		// request.getFile("");// 这里的file就是前台页面的name
		// String filename = orginalFile.getOriginalFilename();
		// DataOutputStream out = null;
		// try {
		// out = new DataOutputStream(new FileOutputStream("c:/" + filename));
		// } catch (FileNotFoundException e1) {
		// e1.printStackTrace();
		// }// 存放文件的绝对路径
		// InputStream is = null;// 附件输入流
		// try {
		// is = orginalFile.getInputStream();
		// byte[] b = new byte[is.available()];
		// is.read(b);
		// out.write(b);
		// } catch (IOException exception) {
		// exception.printStackTrace();
		// } finally {
		// try {
		// if (is != null) {
		// is.close();
		// }
		// if (out != null) {
		// out.close();
		// }
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// }
		return new Callable<String>() {

			@Override
			public String call() throws Exception {
				System.out.println("开始执行!");
				Thread.sleep(4000);
				return "延迟4秒,测试异步返回!";
			}
		};
	}
}
