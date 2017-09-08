package com.huizhi.picture.controller;

import com.huizhi.common.result.ResultDto;
import com.huizhi.common.result.ResultDtoFactory;
import com.huizhi.common.result.ResultEnum;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by Janita on 2017/9/8 0008-上午 10:51
 * 该类是：
 */
@RestController
@RequestMapping("/pic")
public class PictureHandleController {

    @PostMapping("/upload")
    public ResultDto uploadPicture(MultipartFile file, @RequestParam("msg") String msg) throws IOException {
        if (file==null || file.isEmpty()){
            return ResultDtoFactory.toError(ResultEnum.PICTURE_EMPTY);
        }
        System.out.println("name: " + file.getOriginalFilename() + "  size: " + file.getSize());
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
}