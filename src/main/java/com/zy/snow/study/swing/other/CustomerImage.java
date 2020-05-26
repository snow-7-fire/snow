package com.zy.snow.study.swing.other;

import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;

/**
 * 重绘图片
 *
 * @Description: com.zy.snow.study.string
 * @author: Snow
 * @Date: 2020/5/26
 */
public class CustomerImage {

    private void creating(String baseContext, String imagePath) {
        try {
            BufferedImage image = ImageIO.read(new File(imagePath));
            BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
            Graphics2D graphics2D = (Graphics2D) newImage.getGraphics();
            //设置字体风格、样式和大小
            graphics2D.setFont(new Font("黑体", Font.BOLD, 12));
            //每隔12个像素点就替换为文字
            int index = 0;
            for (int y = 0; y < image.getHeight(); y += 12) {
                for (int x = 0; x < image.getWidth(); x += 12) {
                    //获取图片当前位置像素的颜色
                    int pxcolor = image.getRGB(x, y);
                    //分离出rgb三种颜色，分别进行灰度和二值化处理
                    int r = (pxcolor & 0xff0000) >> 16,
                            g = (pxcolor & 0xff00) >> 8,
                            b = pxcolor & 0xff;
                    //设置字体颜色
                    graphics2D.setColor(new Color(r, g, b));
                    graphics2D.drawString(String.valueOf(baseContext.charAt(index % baseContext.length())), x, y);
                    index++;
                }
            }
            ImageIO.write(newImage, "JPG", new FileOutputStream("/Users/to7forsnow/Desktop/temp.jpg"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1(){
        System.out.println("正在生成中:");
        creating("snow","/Users/to7forsnow/Desktop/IMG_0960.jpeg");
        System.out.println("生成成功");
    }
}
