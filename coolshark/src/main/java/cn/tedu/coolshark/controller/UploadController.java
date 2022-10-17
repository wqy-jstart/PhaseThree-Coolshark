package cn.tedu.coolshark.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class UploadController {

    @RequestMapping("/upload")
    public String upload(MultipartFile pic) throws IOException {
        //得到唯一文件名
        String fileName = pic.getOriginalFilename();

        String suffix = fileName.substring(fileName.lastIndexOf("."));
        fileName = UUID.randomUUID()+suffix;
        //准备保存图片的文件夹
        String dirPath = "G:/files";
        File dirFile = new File(dirPath);
        if (!dirFile.exists()){
            dirFile.mkdirs();
        }
        //把图片保存到指定文件夹下面   异常抛出
        String filePath = dirPath+"/"+fileName;
        pic.transferTo(new File(filePath));
        return "/"+fileName;
    }

    @RequestMapping("/remove")
    public void remove(String url){
        //删除指定路径的图片文件
        if (new File("G:/files"+url).delete()){
            System.out.println("图片删除成功!");
        }else {
            System.out.println("图片删除失败!");
        }
    }
}
