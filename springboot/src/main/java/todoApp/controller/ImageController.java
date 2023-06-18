package todoApp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import todoApp.dto.imageDTO;
import todoApp.message.ResponseMessage;
import todoApp.model.UserInfomation;
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
    public ResponseEntity<image> createUser(@RequestBody image image) {
        image image2  = imageServices.create(image);
        return new ResponseEntity<>(image2, HttpStatus.CREATED);
    }
}
