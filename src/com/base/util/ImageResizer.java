package com.base.util;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;

public class ImageResizer {

	public ImageResizer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void imageResize(String source, String target, int limitWidth, int limitHeight) {
		try {

			BufferedImage src = ImageIO.read(new File(source));
			int width = src.getWidth();
			int height = src.getHeight();

			java.text.DecimalFormat df = new java.text.DecimalFormat("#0.####");
			int reWidth, reHeight;
			double scaleRate;
			
			int s;
			if(width>height){
				s=width;
			}else{
				s=height;
			}

			// ª½¦¡
			scaleRate = s / 500.0;
			//reWidth = (int) Math.round(Double.parseDouble(String.valueOf(width)) * scaleRate);
			//reHeight = (int) Math.round(Double.parseDouble(String.valueOf(height)) * scaleRate);
			
			reWidth = (int) Math.round(Double.parseDouble(String.valueOf(width)) / scaleRate);
			reHeight = (int) Math.round(Double.parseDouble(String.valueOf(height)) / scaleRate);
			
			System.out.println("scaleRate="+scaleRate);
			System.out.println("width="+width+"--height="+height);
			System.out.println("reWidth="+reWidth+"--reHeight="+reHeight);

			Image image = src.getScaledInstance(reWidth, reHeight, Image.SCALE_DEFAULT);
			BufferedImage tag = new BufferedImage(reWidth, reHeight, BufferedImage.TYPE_INT_RGB);
			Graphics g = tag.getGraphics();
			g.drawImage(image, 0, 0, null);
			g.dispose();

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(tag, "JPEG", baos);
			byte[] bytes = baos.toByteArray();

			OutputStream o = new FileOutputStream(target);
			// OutputStream o = response.getOutputStream();
			o.write(bytes);
			o.flush();
			o.close();
		} catch (Exception e) {
			System.out.println("imageResize error=" + e.toString());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		imageResize("D:\\tmp\\1-ª½.JPG", "D:\\tmp\\116-1.jpg", 3264, 2448);
	}

}
