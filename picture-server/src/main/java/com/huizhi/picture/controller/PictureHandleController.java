package com.huizhi.picture.controller;

import com.huizhi.common.result.ResultDto;
import com.huizhi.common.result.ResultDtoFactory;
import com.huizhi.common.result.ResultEnum;
import com.huizhi.picture.context.CustomProperties;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.UUID;

/**
 * Created by Janita on 2017/9/8 0008-上午 10:51
 * 该类是：
 */
@RestController
@RequestMapping("/pic")
public class PictureHandleController {

    @PostMapping("/mergePicture")
    public ResultDto mergePicture(MultipartFile file, @RequestParam(value = "msg", defaultValue = "带上发生发斯蒂芬斯蒂芬萨芬撒法萨芬撒放") String msg) throws IOException {
        if (file==null || file.isEmpty()) return ResultDtoFactory.toError(ResultEnum.PICTURE_EMPTY);
        //大的背景图片
        String backgroundPic = CustomProperties.BACKGROUND_PIC;
        System.out.println("\n***** : " + backgroundPic);
        InputStream inputStream = file.getInputStream();
        mergePic(inputStream, backgroundPic,msg);
        return ResultDtoFactory.toSuccess();
    }




    @PostMapping("/upload")
    public ResultDto uploadPicture(MultipartFile file, @RequestParam(value = "msg",defaultValue = "开心") String msg) throws IOException {
        if (file==null || file.isEmpty()) return ResultDtoFactory.toError(ResultEnum.PICTURE_EMPTY);
        //大的背景图片
        String pathName = "D:\\";
        String picFullFileName = pathName + UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(picFullFileName);
            fos.write(file.getBytes()); // 写入文件
            return ResultDtoFactory.toSuccessData(picFullFileName);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultDtoFactory.toError(ResultEnum.UPLOAD_PICTURE_FAIL);
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }




    public void mergePic(InputStream uploadPicIs, String backgroundPicPath, String message) throws IOException {
        InputStream backgroundPicIs = new FileInputStream(backgroundPicPath);
        BufferedImage backgroundImage = ImageIO.read(backgroundPicIs);
        BufferedImage uploadPicIsImage = ImageIO.read(uploadPicIs);
        Graphics graphics = backgroundImage.getGraphics();
        graphics.drawImage(
                uploadPicIsImage,
                backgroundImage.getWidth()/2 - uploadPicIsImage.getWidth()/2,
                backgroundImage.getHeight()/2 - uploadPicIsImage.getHeight()/2,
                uploadPicIsImage.getWidth(),
                uploadPicIsImage.getHeight(),
                null);
        graphics.drawString(message, 10, 10);
        OutputStream outImage = new FileOutputStream("D:" + File.separator + System.currentTimeMillis() + ".jpg");
        JPEGImageEncoder enc = JPEGCodec.createJPEGEncoder(outImage);
        enc.encode(backgroundImage);
        backgroundPicIs.close();
        uploadPicIs.close();
        outImage.close();
    }

    /**
     * 图片合成
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        InputStream backgroundPicIs = new FileInputStream("D:\\"+"i" + ".jpg");
        InputStream uploadPicIs = new FileInputStream("D:\\"+"j"+ ".jpg");

        BufferedImage backgroundImage = ImageIO.read(backgroundPicIs);
        BufferedImage uploadPicIsImage = ImageIO.read(uploadPicIs);

        Graphics graphics = backgroundImage.getGraphics();
        graphics.drawImage(
                uploadPicIsImage,
                backgroundImage.getWidth()/2 - uploadPicIsImage.getWidth()/2,
                backgroundImage.getHeight()/2 - uploadPicIsImage.getHeight()/2,
                uploadPicIsImage.getWidth(),
                uploadPicIsImage.getHeight(),
                null);

        graphics.drawString("大家好斯蒂芬斯蒂芬",2,30);

        OutputStream outImage = new FileOutputStream("D:" + File.separator + System.currentTimeMillis() + "合成" + ".jpg");
        JPEGImageEncoder enc = JPEGCodec.createJPEGEncoder(outImage);
        enc.encode(backgroundImage);
        backgroundPicIs.close();
        uploadPicIs.close();
        outImage.close();

    }
}