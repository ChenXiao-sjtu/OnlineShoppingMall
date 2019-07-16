package com.how2java.tmall.util;

import org.springframework.web.multipart.MultipartFile;
 
public class UploadedImageFile {
    MultipartFile image;    // 属性名称必须与listCategory.jsp中上传的 type="file" name="image"一致，才能自动注入
 
    public MultipartFile getImage() {
        return image;
    }
 
    public void setImage(MultipartFile image) {
        this.image = image;
    }
 
}