package hw.controller;

import hw.model.Greeting;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.logging.Logger;


@Controller
public class FileController {

    //private static final Logger logger = (Logger) LoggerFactory.getLogger(FileController.class);

    @GetMapping("/uploading")
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "upload";
    }
    @PostMapping("/uploading")
    public String uploadFile(@RequestParam("file") MultipartFile file) {// имена параметров (тут - "file") - из формы JSP.

        String name = null;

        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();

                name = file.getOriginalFilename();

                String rootPath = "C://Users//Лилия//IdeaProjects//SpringHW//output//" ; //try also "C:\path\"
                File dir = new File(rootPath + File.separator + "loadFiles");

                if (!dir.exists()) {
                    dir.mkdirs();
                }

                File uploadedFile = new File(dir.getAbsolutePath() + File.separator + name);

                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(uploadedFile));
                stream.write(bytes);
                stream.flush();
                stream.close();

                //logger.info("uploaded: " + uploadedFile.getAbsolutePath());

                return "/file_success";

            } catch (Exception e) {
                return "/file_exc" + e.getMessage();
            }
        } else {
            return "/file_null";
        }
    }

}