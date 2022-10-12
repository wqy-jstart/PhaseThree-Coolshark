package cn.tedu.boot071.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController//处理上传文件业务
public class UploadController {
    @RequestMapping("/upload")
    public String upload(MultipartFile pic) throws IOException {
        System.out.println("pic = " + pic);
        //获取原始文件名
        String fileName = pic.getOriginalFilename();
        System.out.println("原始文件名:" + fileName);
        //得到原始文件名的后缀
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        //得到唯一文件名  UUID.randomUUID()获取唯一标识符[java定义的不含后缀]
        fileName = UUID.randomUUID() + suffix;
        System.out.println("唯一文件名:" + fileName);

        //准备保存图片的路径(本机磁盘中)
        String dirPath = "G:/files";
        File dirFile = new File(dirPath);//定义该目录中的文件夹
        //判断如果不存在 则创建文件夹
        if (!dirFile.exists()) {//如果没有files文件夹
            dirFile.mkdirs();//创建(mkdirs()方法可多级创建)
        }
        //结合创建的图片路径,拼接得到文件的完整路径
        String filePath = dirPath + "/" + fileName;
        //调用transferTo(new File())方法把图片保存到上面的路径中,异常抛出
        pic.transferTo(new File(filePath));

        //最后把图片的url路径响应给客户端  /文件名(http://localHost:8080/文件名)
        return "/" + fileName;//这里的文件名是唯一文件名
    }
}
