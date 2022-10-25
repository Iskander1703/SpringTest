package iskander.tabaev.TestSpring.controllers;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/test")
public class TestController {

    //In this method I am testing sending file to ResponseBody
    @GetMapping("/pdf")
    public ResponseEntity<byte[]> getPdfFile(){
        File file=new File("/home/iskander/test.pdf");
        byte [] pdfFile=null;
        try {
            pdfFile= FileUtils.readFileToByteArray(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("Content-Type",MediaType.APPLICATION_PDF_VALUE);
        System.out.println(file.getName());
        httpHeaders.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="+file.getName());
        return new ResponseEntity<>(pdfFile,httpHeaders, HttpStatus.OK);
    }

    @GetMapping("/jpg")
    public ResponseEntity<byte[]> getJpgFile(){
        File file=new File("/home/iskander/test.jpg");
        byte [] jpgFile=null;
        try {
            jpgFile= FileUtils.readFileToByteArray(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("Content-Type",MediaType.IMAGE_JPEG_VALUE);
        System.out.println(file.getName());
        httpHeaders.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="+file.getName());
        return new ResponseEntity<>(jpgFile,httpHeaders, HttpStatus.OK);
    }

}
