package kz.yeldos.delivery.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@Controller
public class MediaController {

    public String hello(){
        System.out.println("hellllo");
        return "index";
    }

    @GetMapping("media/{*path}")
    public ResponseEntity<Void> getFile(
            @PathVariable(name = "path")String imagePath,
            HttpServletResponse httpServletResponse
    ){
        System.out.println("I am in ==============================");
        File file = new File("./"+imagePath);
        System.out.println(file.getAbsolutePath());
        if(!file.exists() || !file.isFile()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        try{
            FileInputStream fileInputStream = new FileInputStream(file);
            OutputStream outputStream = httpServletResponse.getOutputStream();
            fileInputStream.transferTo(outputStream);
            outputStream.flush();
        }catch (IOException e){
            System.out.println("OOPS");
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
