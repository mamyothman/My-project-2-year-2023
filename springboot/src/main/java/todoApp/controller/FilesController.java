// package todoApp.controller;


// import java.io.FileNotFoundException;
// import java.nio.file.Path;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;
// import java.util.Optional;

// import java.util.stream.Collectors;
// import java.util.stream.Stream;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.core.io.Resource;

// import org.springframework.http.HttpHeaders;
// import org.springframework.http.HttpStatus;

// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.ResponseBody;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.multipart.MultipartFile;
// import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

// import todoApp.message.ResponseMessage;
// import todoApp.model.FileInfo;

// import todoApp.services.FilesStorageService;



// @RestController
// @CrossOrigin
// @RequestMapping("api/file")
// public class FilesController {

//   @Autowired
//   FilesStorageService storageService;



// @PostMapping("/upload")
// public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
//    String message = "";
//    try {
//       storageService.save(file);

//       String url = MvcUriComponentsBuilder
//             .fromMethodName(FilesController.class, "getFile", file.getOriginalFilename()).build().toString();

//       message = url;
//       return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
//    } catch (Exception e) {
//       message = "Could not upload the file: " + file.getOriginalFilename() + ". Error: " + e.getMessage();
//       return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
//    }
// }



// @GetMapping("/files")
// public ResponseEntity<List<FileInfo>> getListFiles() {
//     List<FileInfo> fileInfos = storageService.loadAll().map(path -> {
//         String filename = path.getFileName().toString();
//         // long id = extractIdFromFileName(filename); // Modify this to extract the ID from the file name
//         String url = MvcUriComponentsBuilder
//             .fromMethodName(FilesController.class, "getFile", path.getFileName().toString()).build().toString();

//         return new FileInfo(filename, url);
//     }).collect(Collectors.toList());

//     return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
// }

// // Modify this method to extract the ID from the file name
// private long extractIdFromFileName(String filename) {
//     // Implement your logic to extract the ID from the file name
//     // For example, if the file name is "123_file.txt", you can extract the ID as follows:
//     String[] parts = filename.split("_");
//     if (parts.length > 0) {
//         String idStr = parts[0];
//         try {
//             return Long.parseLong(idStr);
//         } catch (NumberFormatException e) {
//             // Handle the case where the ID cannot be parsed as a long
//             // Return a default value or throw an exception
//         }
//     }

//     // Return a default value or throw an exception if the ID extraction fails
//     return 0;
// }



//   @GetMapping("/files/{filename:.+}")
//   @ResponseBody
//   public ResponseEntity<Resource> getFile(@PathVariable String filename) {
//     Resource file = storageService.load(filename);
//     return ResponseEntity.ok()
//         .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
//   }


// @GetMapping("/getById/{id}")
// public ResponseEntity<Map<String, Object>> getFileById(@PathVariable Long id) {
//   try {
//     Stream<Path> fileStream = storageService.getById(id);
//     Optional<Path> fileOptional = fileStream.findFirst();

//     if (fileOptional.isPresent()) {
//       Path file = fileOptional.get();
//       Resource resource = storageService.load(file.toString());

//       Map<String, Object> fileInfo = new HashMap<>();
//       fileInfo.put("name", file.getFileName().toString());
//       fileInfo.put("url", MvcUriComponentsBuilder.fromMethodName(FilesController.class, "getFileById", id).build().toString());
//       fileInfo.put("file", resource);

//       return ResponseEntity.ok().body(fileInfo);
//     } else {
//       throw new FileNotFoundException("File not found with ID: " + id);
//     }
//   } catch (Exception e) {
//     return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//   }
// }

// }