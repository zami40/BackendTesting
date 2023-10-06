package com.example.ekyc.service;
//import com.example.ekyc.DTO.NidOcrResponse;
import com.example.ekyc.DTO.NidOcrResponseDTO;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class NidOcrService {
    @Value("${tesseract.datapath}")
    private String tesseractPath;

    public NidOcrResponseDTO performOcr(MultipartFile imageFile) throws TesseractException, IOException {
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath(tesseractPath);

        // Perform OCR on the image file
        //String extractedText = tesseract.doOCR(new File(imagePath));
        BufferedImage fopimage = ImageIO.read(imageFile.getInputStream());

        // Perform OCR on the temporary file
        String extractedText = tesseract.doOCR(fopimage);

        // Process the extracted text to get NID and DOB
        // Define regular expressions to match Date of Birth and NID/ID number patterns
        Pattern dobPattern = Pattern.compile("Date of Birth: ([0-9]{2} [A-Za-z]{3} [0-9]{4})");
        Pattern nidPattern = Pattern.compile("NID No: ([0-9]+)|ID NO: ([0-9]+)");

        // Match Date of Birth
        Matcher dobMatcher = dobPattern.matcher(extractedText);
        String dob = dobMatcher.find() ? dobMatcher.group(1) : null;

        // Match NID/ID number
        Matcher nidMatcher = nidPattern.matcher(extractedText);
        String nid = nidMatcher.find() ? (nidMatcher.group(1) != null ? nidMatcher.group(1) : nidMatcher.group(2)) : null;

        NidOcrResponseDTO response = new NidOcrResponseDTO();
        response.setNid(nid);
        // Create a SimpleDateFormat object for parsing the input date string
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd MMM yyyy");

        try {
            // Parse the input date string to a Date object
            Date date = inputFormat.parse(dob);

            // Create a SimpleDateFormat object for formatting the date to "yyyy-MM-dd" format
            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");

            // Format the date and reassign it to nid
            dob = outputFormat.format(date);
        }catch (ParseException e) {
            return null;
        }
        response.setDob(dob);

        return response;
    }
}
