package bg.softuni.weedinfplanner.service.impl;

import bg.softuni.weedinfplanner.service.CloudinaryImage;
import bg.softuni.weedinfplanner.service.CloudinaryService;
import com.cloudinary.Cloudinary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryServiceImpl implements CloudinaryService {
    private static final String TEMP_FILE = "temp-file";
    private static final String URL = "url";
    private static final String PUBLIC_ID = "public_id";

    private final Cloudinary cloudinary;

    public CloudinaryServiceImpl(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    @Override
    public CloudinaryImage upload(MultipartFile file) throws IOException {
        File tempFile=File.createTempFile(TEMP_FILE, file.getOriginalFilename());
        file.transferTo(tempFile);
        try{
            @SuppressWarnings("unchecked")
            Map<String,String> upload = this.cloudinary
                    .uploader()
                    .upload(tempFile, Map.of());

            String url=upload.getOrDefault(URL,"https://i.stack.imgur.com/6M513.png");
            String publicId=upload.getOrDefault(PUBLIC_ID,"");

           return new CloudinaryImage()
                    .setUrl(url)
                    .setPublicId(publicId);
        } finally {
            tempFile.delete();
        }

    }

    @Override
    public boolean delete(String publicId) {
        try {
            this.cloudinary.uploader().destroy(publicId,Map.of());
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}
