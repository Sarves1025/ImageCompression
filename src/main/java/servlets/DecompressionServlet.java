package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

@WebServlet("/decompressImage")
public class DecompressionServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

   
    	Part filePart = request.getPart("file");
        InputStream inputStream = filePart.getInputStream();

        
        String encodedImage = decodeImage(inputStream);

        
        byte[] decompressedImageBytes = decompressImage(encodedImage);

        
        response.setContentType("image/jpeg");

       
        response.getOutputStream().write(decompressedImageBytes);
    }

    private String decodeImage(InputStream inputStream) throws IOException {
        
        StringBuilder encodedImage = new StringBuilder();
        int readByte;
        while ((readByte = inputStream.read()) != -1) {
            encodedImage.append((char) readByte);
        }

        return encodedImage.toString();
    }

    private byte[] decompressImage(String encodedImage) {
        
        return Base64.getDecoder().decode(encodedImage);
    }
}
