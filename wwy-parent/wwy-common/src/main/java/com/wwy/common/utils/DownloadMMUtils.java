package com.wwy.common.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 下载MM，不多说
 * 
 * @author wwy
 * @date 2015年5月31日上午9:25:39
 */
public class DownloadMMUtils {

	private final static String MMPATH = "F:/MM";
	private final static String YELLOWMMPATH = "F:/YellowMM";

	public static void main(String[] args) throws Exception {
		getYellowMM();
	}

	@SuppressWarnings("resource")
	public static void getMM() throws MalformedURLException, IOException {
		File file = new File(MMPATH);
		if (!file.exists() && !file.isDirectory()) {
			file.mkdirs();
		}
		String url = "http://www.mzitu.com/share/comment-page-";
		Pattern reg = Pattern.compile("<p><img src=\"(.*?)\"");
		for (int j = 0, i = 1; i <= 10; i++) {
			Matcher m = reg.matcher(new Scanner(new URL(url + i).openStream()).useDelimiter("\\A").next());
			while (m.find()) {
				Files.copy(new URL(m.group(1)).openStream(),
						Paths.get(MMPATH + File.separator + UUID.randomUUID() + ".jpg"));
				System.out.println("已下载:" + j++);
			}
		}
	}

	public static void getYellowMM() throws MalformedURLException, IOException {
		String out = "F:/YellowMM";// 输出地址，默认F盘
		File file = new File(out);
		if (!file.exists() && !file.isDirectory()) {
			file.mkdirs();
		}

		ExecutorService executorService = Executors.newFixedThreadPool(20);
		for (int j = 1, i = 7042; i <= 63467; i++) {
			Thread thread = new DownYellowMM(i, j);
			executorService.execute(thread);
		}
		executorService.shutdown();
		cleanRepeatMM();
	}

	public static void cleanRepeatMM() {
		// 删除重复图片
		Map<String, Object> md5map = new HashMap<String, Object>();
		File f = new File(YELLOWMMPATH);
		File[] files = f.listFiles();
		for (File file2 : files) {
			String md5;
			try {
				md5 = MD5Utils.getMd5ByFile(file2);
				if (md5map.containsKey(md5)) {
					file2.delete();
				} else {
					md5map.put(md5, md5);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 
	 * 多线程下载YellowMM
	 * 
	 * @author wwy
	 * @date 2015年5月31日下午8:47:13
	 */
	static class DownYellowMM extends Thread {

		private int i;
		private int j;

		public DownYellowMM(int i, int j) {
			this.i = i;
			this.j = j;
		}

		@SuppressWarnings("resource")
		@Override
		public void run() {
			String url = "http://47pupu.com/tupianqu/yazhou/";
			Pattern reg = Pattern.compile("<br><img src=\"(.*?)\"");
			Matcher m;
			try {
				System.out.println("正在下载:" + url + "i.html");
				m = reg.matcher(new Scanner(new URL(url + i + ".html").openStream()).useDelimiter("\\A").next());
				while (m.find()) {
					Files.copy(new URL(m.group(1)).openStream(),
							Paths.get(DownloadMMUtils.YELLOWMMPATH + File.separator + (i + "-" + j) + ".jpg"));
					System.out.println("已下载:" + url + "i" + j++ + ".jpg");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
