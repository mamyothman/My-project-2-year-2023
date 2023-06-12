package todoApp;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.Resource;
import todoApp.services.FilesStorageService;
import org.springframework.boot.CommandLineRunner;
@SpringBootApplication
public class TodoAppApplication implements CommandLineRunner {
  @Resource
  FilesStorageService storageService;

	public static void main(String[] args) {
		SpringApplication.run(TodoAppApplication.class, args);
	}
@Override
  public void run(String... arg) throws Exception {
//    storageService.deleteAll();
    storageService.init();
  }

}
