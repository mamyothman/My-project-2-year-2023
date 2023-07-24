package todoApp.services;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import todoApp.model.image;
import todoApp.repository.ImageRepository;
@Service
public class ImageServices {
    private final ImageRepository imageRepository;

@Autowired
    public ImageServices( ImageRepository imageRepository){
            this.imageRepository = imageRepository;
    }

   public List< image> create(MultipartFile[] file) throws IOException {

   Set<image> images = uploadFile(file);

   List<image> savImages =   imageRepository.saveAll(images);
    
     
     return savImages;
 }


 public Set<image> uploadFile(MultipartFile[] multipartFiles) throws IOException {
    Set<image> image_models = new HashSet<>();

    for (MultipartFile file : multipartFiles) {
        image image_model = new image(
                file.getOriginalFilename(),
                file.getContentType(),
                file.getBytes()
        );
        image_models.add(image_model);
    }
    return image_models;
}

public List<image> getAllImages() {
    return imageRepository.findAll();
}


}
