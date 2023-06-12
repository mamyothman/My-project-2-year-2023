package todoApp.services;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
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

    public image store(MultipartFile file) throws IOException {
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    image image = new image(fileName,file.getContentType(),file.getBytes());

    return imageRepository.save(image);
  }

  public image getFile(String id) {
    return imageRepository.findById(id).get();
  }
  
  public Stream<image> getAllFiles() {
    return imageRepository.findAll().stream();
  }
}
