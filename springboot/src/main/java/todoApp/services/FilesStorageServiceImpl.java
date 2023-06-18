package todoApp.services;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FilesStorageServiceImpl implements FilesStorageService {

  private final Path root = Paths.get("images");

  @Override
  public void init() {
    try {
      Files.createDirectories(root);
    } catch (IOException e) {
      throw new RuntimeException("Could not initialize folder for upload!");
    }
  }


// public void save(MultipartFile file, Long id) {
//     try {
//         String filename = file.getOriginalFilename();
//         // Save the file using the provided ID as part of the file name or any other desired approach
//         String storedFileName = id + "_" + filename;
//         Files.copy(file.getInputStream(), this.root.resolve(storedFileName));

//         // Save the ID and file details to your storage or database as necessary
//         // ...
//     } catch (Exception e) {
//         if (e instanceof FileAlreadyExistsException) {
//             throw new RuntimeException("A file of that name already exists.");
//         }
//         throw new RuntimeException(e.getMessage());
//     }
// }


@Override
  public void save(MultipartFile file) {
    try {
      Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
    } catch (Exception e) {
      if (e instanceof FileAlreadyExistsException) {
        throw new RuntimeException("A file of that name already exists.");
      }

      throw new RuntimeException(e.getMessage());
    }
  }

  @Override
  public Resource load(String filename) {
    try {
      Path file = root.resolve(filename);
      Resource resource = new UrlResource(file.toUri());

      if (resource.exists() || resource.isReadable()) {
        return resource;
      } else {
        throw new RuntimeException("Could not read the file!");
      }
    } catch (MalformedURLException e) {
      throw new RuntimeException("Error: " + e.getMessage());
    }
  }

  @Override
  public void deleteAll() {
    FileSystemUtils.deleteRecursively(root.toFile());
  }

  @Override
  public Stream<Path> loadAll() {
    try {
      return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
    } catch (IOException e) {
      throw new RuntimeException("Could not load the files!");
    }
  }
  @Override
  public Stream<Path> getById(Long id) {
    try {
      String searchFileName = id + "_*";
      return Files.walk(this.root, 1)
              .filter(path -> !path.equals(this.root))
              .filter(path -> path.getFileName().toString().matches(searchFileName))
              .map(this.root::relativize);
    } catch (IOException e) {
      throw new RuntimeException("Could not load the files by ID!");
    }
  }

}