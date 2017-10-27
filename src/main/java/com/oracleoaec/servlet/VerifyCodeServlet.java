package com.oracleoaec.servlet;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/*
 * author:刘飞
 * time:20171025
 * 生成验证码
 * */
public class VerifyCodeServlet extends HttpServlet{

	private static final long serialVersionUID = 3880113185095966926L;

	private int w = 75; //验证码图片宽度(px)
	private int h = 35; //验证码图片宽度

	private Random r = new Random();
	private String[] fontNames = {"宋体","华文楷体","黑体","隶书","黑体","微软雅黑","楷体_GB2312"};
	//可选字符
	private String codes = "23456789abcdefghijkmnpqrstuvwxyzABCDEFGHIJKLMNPQRSTUVWXYZ";
	//背景色
	private Color bgColor = new Color(255, 255, 255);
	//验证码上的字符
	private String text;

	//生成随机颜色
	private Color randomColor(){
		int red = r.nextInt(150);
		int green = r.nextInt(150);
		int blue = r.nextInt(150);
		return new Color(red, green, blue);
	}

	//生成随机字体
	private Font randomFont(){
		int index =r.nextInt(fontNames.length);
		String fontName = fontNames[index];  //生成随机字体名
		int style = r.nextInt(4); //生成随机样式  0(无样式) 1(粗体) 2(斜体) 3(粗体+斜体)
		int size = r.nextInt(5)+24; //生成随机字号，24 ~ 28
		return new Font(fontName, style, size);
	}

	//画干扰线
	private void drawLine(BufferedImage image){
		int num =3;  //一共画三条
		Graphics2D g2 = (Graphics2D) image.getGraphics();
		for(int i = 0; i<num; i++){ //生成两个点的坐标，即4个值
			int x1 = r.nextInt(w);
			int y1 = r.nextInt(h);
			int x2 = r.nextInt(w);
			int y2 = r.nextInt(h);
			g2.setStroke(new BasicStroke(1.5f));
			g2.setColor(Color.blue);
			g2.drawLine(x1, y1, x2, y2); //划线
		}
	}

	//随机生成一个字符
	private char randomChar(){
		int index = r.nextInt(codes.length());
		return codes.charAt(index);
	}

	//创建一张图片（BufferedImage）
	private BufferedImage createImage(){
		BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = (Graphics2D) image.getGraphics();
		g2.setColor(this.bgColor);
		g2.fillRect(0, 0, w, h); //填充矩形，开始坐标（0,0），宽w,高h,
		return image;
	}

	//获取图片
	public BufferedImage getImage(){
		BufferedImage image = createImage();//创建图片缓冲区
		Graphics2D g2 = (Graphics2D) image.getGraphics();//获取绘制环境
		StringBuffer sb = new StringBuffer();//用来装载验证码文本
		//向图片中画4个字符
		for (int i = 0; i < 4; i++) { //循环四次，每次生成一个字符
			String s = randomChar() + "";//随机生成一个字符
			sb.append(s); //把字符添加到sb中
			float x = i * 1.0f * w /4; //设置当前字符的x坐标
			g2.setFont(randomFont());//设置随机字体 
			g2.setColor(randomColor()); //设置随机颜色
			g2.drawString(s, x, h-5); //画图
		}
		text = sb.toString(); //把生成的字符串赋给了this.text
		drawLine(image); //添加干扰线
		return image;
	}

	//返回验证码上的字符
	public  String getText(){
		return text;
	}

	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("image/jpg;charset=utf-8");
		
		//获取生成的验证码图片，同时也得到了验证码图片上的字符
		BufferedImage bi = getImage();
		//获取验证码图片上的字符串
		String code = getText();
		//将验证码存到session中，以便之后验证登录使用
		request.getSession().setAttribute("code", code);
		System.out.println(code);
		//创建流对象
		ServletOutputStream sos = response.getOutputStream();
		//压缩图片
		ImageIO.write(bi,"jpeg",sos);
		sos.close();
	}
}
