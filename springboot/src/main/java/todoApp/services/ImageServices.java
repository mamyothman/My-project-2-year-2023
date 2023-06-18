package todoApp.services;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import todoApp.model.Order;
import todoApp.model.image;
import todoApp.repository.ImageRepository;
@Service
public class ImageServices {
    private final ImageRepository imageRepository;

@Autowired
    public ImageServices( ImageRepository imageRepository){
            this.imageRepository = imageRepository;
    }

   public image create(image image){
    return imageRepository.save(image);
 }


}
