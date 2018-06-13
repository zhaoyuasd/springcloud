package com.laozhao.config_client;

import java.io.File;
import java.io.IOException;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/fileserver/pictures")
public class PictureController {
    private final String CATEGORY_TEST = "pics";

    @RequestMapping(value = "test")
    @ResponseBody
    public String testFileServer() {
        return "文件服务器已启动";
    }

    /**
     * 上传文件。
     * @param file, 文件字节流， 其中filename是multipart中的变量名称
     * @return
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public PictureResp  uploadFile(/**HttpServletRequest request, 拿到请求的所有信息 */
                                  //@RequestHeader(value = "Range") String range,   //大文件分段上传，格式： Range: start-end/total
                                  @RequestHeader(value = "Content-Type") String type,
                                  //@RequestParam(value = "signparam") String data,  //在http包体里添加验签的json
                                  @RequestParam(value = "filename", required = true)MultipartFile file) {
        //System.out.println(request.getHeader("Content-Type"));   //文件分片或断点续传需要Range头，表示字节流对应原始文件的位置
        System.out.println("请求类型：" + type);
        PictureResp resp = new PictureResp();
        try {
            File dir = new File(CATEGORY_TEST);
            if (!dir.exists()) {
                dir.mkdirs();  //判断并创建文件夹
            }

            byte[] bytes = file.getBytes();   //文件字节流
            File fileToSave = new File(dir.getAbsolutePath()  + File.separator +  file.getOriginalFilename());

            FileCopyUtils.copy(bytes, fileToSave);   //保存文件

            //数据表里要存储原始文件名、用户id、时间戳、服务器生成的文件名， 客户端文件起始位置start、客户端文件终止位置end、客户端文件大小total等
            resp.setStatus(0);
            resp.setSize(fileToSave.length());
            resp.setPath(fileToSave.getPath());
        } catch (IOException ex) {
            ex.printStackTrace();

            resp.setStatus(1);  //失败
        }

        return resp;
    }

}
