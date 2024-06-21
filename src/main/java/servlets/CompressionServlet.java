package servlets;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Iterator;

@WebServlet("/compressImage")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, 
        maxFileSize = 1024 * 1024 * 10,      
        maxRequestSize = 1024 * 1024 * 100   
)
public class CompressionServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        Part filePart = request.getPart("file1");
        InputStream inputStream = filePart.getInputStream();

        byte[] compressedImageBytes = compressImage(inputStream);

       
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=compressedImage.jpg");

        
        OutputStream out = response.getOutputStream();
        out.write(compressedImageBytes);
    }

    private byte[] compressImage(InputStream inputStream) throws IOException {
        BufferedImage image = ImageIO.read(inputStream);

       
        ByteArrayOutputStream compressedStream = new ByteArrayOutputStream();

        
        Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("jpg");
        ImageWriter writer = writers.next();
        ImageWriteParam param = writer.getDefaultWriteParam();
        param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        param.setCompressionQuality(0.05f);

       
        try (ImageOutputStream ios = ImageIO.createImageOutputStream(compressedStream)) {
            writer.setOutput(ios);
            writer.write(null, new IIOImage(image, null, null), param);
        }

        
        writer.dispose();

        
        return compressedStream.toByteArray();
    }
}
