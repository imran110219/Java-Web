package com.sadman.springbootfileupload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.Arrays;

@Controller
public class FileController {

    @Autowired
    FileService fileService;

    @GetMapping("/")
    public String index() {
        return "upload";
    }

    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {

        try {
            byte[] bytes = file.getBytes();
            Image image = new Image(file.getOriginalFilename(), bytes);
            fileService.uploadFile(image);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded " + file.getOriginalFilename() + "!");
        } catch (IOException e) {
            e.printStackTrace();
            throw new FileStorageException("Could not store file " + file.getOriginalFilename()
                    + ". Please try again!");
        }

        return "redirect:/";
    }

    @PostMapping("/uploadFiles")
    public String uploadFiles(@RequestParam("files") MultipartFile[] files, RedirectAttributes redirectAttributes) {


        Arrays.asList(files)
                .stream()
                .forEach(file -> {
                    try {
                        byte[] bytes = file.getBytes();
                        Image image = new Image(file.getOriginalFilename(), bytes);
                        fileService.uploadFile(image);
                        redirectAttributes.addFlashAttribute("message",
                                "You successfully uploaded all files!");
                    } catch (IOException e) {
                        e.printStackTrace();
                        throw new FileStorageException("Could not store file " + file.getOriginalFilename()
                                + ". Please try again!");
                    }
                });

        return "redirect:/";
    }
}
