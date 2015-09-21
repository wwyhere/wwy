package service.test;

import java.util.Calendar;

public class JredisTest {

	public static void main(String[] args) {
		// http://laod.cn/wp-content/uploads/2015/04/20150519Google-hosts.txt
		String dateStr="";
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		dateStr+=year;
		int month = calendar.get(Calendar.MONTH);
		if (month<10) {
			dateStr+="0"+month;
		}else{
			dateStr+=month;
		}
		int day = calendar.get(Calendar.DATE);
		dateStr+=day;
		System.out.println(dateStr);
		String html=getHtml("http://laod.cn/wp-content/uploads/2015/04/20150519Google-hosts.txt");
		System.out.println(html);
	}

	private static String getHtml(String urlString) {
		try {
			StringBuffer html = new StringBuffer();
			java.net.URL url = new java.net.URL(urlString); // 根据 String 表示形式创建
															// URL 对象。
			java.net.HttpURLConnection conn = (java.net.HttpURLConnection) url
					.openConnection();// 返回一个 URLConnection 对象，它表示到 URL
										// 所引用的远程对象的连接。
			java.io.InputStreamReader isr = new java.io.InputStreamReader(
					conn.getInputStream());// 返回从此打开的连接读取的输入流。
			java.io.BufferedReader br = new java.io.BufferedReader(isr);// 创建一个使用默认大小输入缓冲区的缓冲字符输入流。

			String temp;
			while ((temp = br.readLine()) != null) { // 按行读取输出流
				if (!temp.trim().equals("")) {
					html.append(temp).append("\n"); // 读完每行后换行
				}
			}
			br.close(); // 关闭
			isr.close(); // 关闭
			return html.toString(); // 返回此序列中数据的字符串表示形式。
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
