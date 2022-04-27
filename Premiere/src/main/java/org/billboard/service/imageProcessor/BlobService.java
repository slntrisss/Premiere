package org.billboard.service.imageProcessor;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;

public class BlobService {
    public static String encodeImage(Blob blob){
        String imageFile = "";
        byte[] buffer = new byte[1024];
        int bytesRead;
        try(InputStream inputStream = blob.getBinaryStream();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream()){
            while((bytesRead = (inputStream.read(buffer))) != -1){
                outputStream.write(buffer, 0, bytesRead);
            }
            byte[] imageBinary = outputStream.toByteArray();
            imageFile = Base64.getEncoder().encodeToString(imageBinary);
        }catch (IOException e){
            e.getStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return imageFile;
    }
}
