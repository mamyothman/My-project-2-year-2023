package todoApp.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import todoApp.model.image;
import todoApp.services.ImageServices;
@CrossOrigin
@RestController
@RequestMapping("api/image")
public class ImageController {
    
    private final ImageServices imageServices;

    public ImageController(ImageServices imageServices){
            this.imageServices = imageServices;
    }

    @PostMapping("/saveImage")
    public ResponseEntity<List<image>> createUser (@RequestPart MultipartFile[] file)throws IOException {
       List< image> image2  = imageServices.create(file);
        return new ResponseEntity<>(image2, HttpStatus.CREATED);
    }

    @GetMapping("getAllimages/")

    public ResponseEntity<List<image>> getallImages(){

        List<image> images = imageServices.getAllImages();
        return new ResponseEntity<List<image>>(images, HttpStatus.OK);
    }
}
