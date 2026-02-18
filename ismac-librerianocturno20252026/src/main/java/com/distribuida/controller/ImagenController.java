package com.distribuida.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class ImagenController {

    private static final String UPLOAD_DIR = "uploads/portadas/";

    public ResponseEntity<Map<String, String>> uploadPortada(
            @RequestParam("file") MultipartFile file,
            @RequestParam(value = "oldImage", required = false) String oldImage
    ){
        try{

        }catch (Exception e){

        }
        return null;
    }
}
