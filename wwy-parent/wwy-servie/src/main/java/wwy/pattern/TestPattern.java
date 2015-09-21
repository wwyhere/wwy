package wwy.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestPattern {
	public static void main(String[] args) {
		//获取html源码中body之内的代码
		Pattern pattern = Pattern.compile("(?<=\\<body>)([\\s\\S]+?)(?=</body>)",Pattern.MULTILINE);
		Matcher matcher=pattern.matcher("24<body>fasdf\n\rfgg</body>asdf");
		while (matcher.find()) {
			String s0=matcher.group(0);
			System.out.println(s0);
		}
		System.out.println(matcher.matches());
	}
}
