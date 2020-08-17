package com.sadman.springbootfileupload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FileService {

    @Autowired
    ImageRepository imageRepository;

    public int uploadFile(Image image) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            image.setUploadDate(date);
            imageRepository.save(image);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public List<Image> getAllImages()
    {
        List<Image> result = (List<Image>) imageRepository.findAll();

        if(result.size() > 0) {
            return result;
        } else {
            return new ArrayList<Image>();
        }
    }
}
