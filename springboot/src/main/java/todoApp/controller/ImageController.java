// package todoApp.controller;

// import java.util.ArrayList;
// import java.util.List;
// import java.util.stream.Collectors;

// import org.springframework.http.HttpHeaders;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.multipart.MultipartFile;
// import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

// import todoApp.dto.imageDTO;
// import todoApp.message.ResponseMessage;
// import todoApp.model.image;
// import todoApp.services.ImageServices;
// @CrossOrigin
// @RestController
// @RequestMapping("api/image")
// public class ImageController {
    
//     private final ImageServices imageServices;

//     public ImageController(ImageServices imageServices){
//             this.imageServices = imageServices;
//     }
//     @PostMapping("/SaveImages/{file}")
//   public ResponseEntity<ResponseMessage> uploadFile(@PathVariable("file") str MultipartFile file) {
//     String message = "";
//     try {
//       imageServices.store(file);

//       message = "Uploaded the file successfully: " + file.getOriginalFilename();
//       return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
//     } catch (Exception e) {
//       message = "Could not upload the file: " + file.getOriginalFilename() + "!";
//       return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
//     }
//   }

//   @GetMapping("/GetAllimages")
//   public ResponseEntity<List<imageDTO>> getListFiles() {
//     List<imageDTO> files = imageServices.getAllFiles().map(dbFile -> {
//       String fileDownloadUri = ServletUriComponentsBuilder
//           .fromCurrentContextPath()
//           .path("/images/")
//           .path(dbFile.getId())
//           .toUriString();

//       return new imageDTO(
//           dbFile.getFilename(),
//           fileDownloadUri,
//           dbFile.getType(),
//           dbFile.getData().length);
//     }).collect(Collectors.toList());

//     return ResponseEntity.status(HttpStatus.OK).body(files);
//   }






//   @GetMapping("/files/{id}")
//   public ResponseEntity<byte[]> getFile(@PathVariable String id) {
//     image image = imageServices.getFile(id);

//     return ResponseEntity.ok()
//         .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + image.getFilename() + "\"")
//         .body(image.getData());
//   }
// }
