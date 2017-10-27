package com.oracleoaec.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CodeServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		response.setContentType("text/html;charset=utf-8");

		HttpSession session = request.getSession();

		String code = getCode(4);

		session.setAttribute("yzm", code);

		// 创建一张图片
		BufferedImage img = new BufferedImage(40, 30, BufferedImage.TYPE_INT_RGB);
		// 获取画笔
		Graphics g = img.getGraphics();

		Color c = getColor();

		g.setColor(c);
		// 画背景
		g.fillRect(0, 0, 40, 30);

		// 生成随机字符串

		// 设置字体样式
		Font f = new Font("隶书", Font.ITALIC, 50);
		// 把验证码画到图片
		g.setColor(Color.black);
		g.drawString(code, 0, 20);
		response.setContentType("image/jpeg");
		OutputStream os = response.getOutputStream();
		ImageIO.write(img, "jpeg", os);
		os.close();
	}

	public String getCode(int number) {
		String str = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		Random random = new Random();

		String code = "";

		for (int i = 0; i < number; i++) {
			int nextInt = random.nextInt(36);

			code += str.charAt(nextInt);
		}
		return code;
	}

	public Color getColor() {
		Random r = new Random();

		Color c = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));

		return c;

	}

}
