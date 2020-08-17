package com.sadman.springbootfileupload;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class FileController {

    @Autowired
    FileService fileService;

    @GetMapping("/")
    public String index() {
        return "upload";
    }

    @GetMapping("/list")
    public String list(Model model) throws IOException {
        List<Image> imageList = fileService.getAllImages();
        List<String> base64List = new ArrayList<>();
        for (int i = 0; i < imageList.size(); i++) {
            byte[] encodeBase64 = Base64.encodeBase64(imageList.get(i).getData());
            String base64Encoded = new String(encodeBase64, "UTF-8");
            base64List.add(base64Encoded);
        }
        model.addAttribute("images", imageList);
        model.addAttribute("baseImages", base64List);
        return "list";
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
