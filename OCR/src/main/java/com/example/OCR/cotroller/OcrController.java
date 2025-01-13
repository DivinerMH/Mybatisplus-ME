package com.example.OCR.cotroller;


import com.example.OCR.utils.OcrUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * <p>
 * OCR 统一识别
 * </p>
 *
 * @Author scott
 * @since 2018-12-19
 */
@RestController
@RequestMapping("/ocr")
@Slf4j
public class OcrController {

    @Resource
    private OcrUtils ocrUtils;

    @RequestMapping(value = "/detail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String query(String url) throws Exception {
        return ocrUtils.analysis();
    }

    @RequestMapping(value = "/detail/file", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getFileAnalysis(@RequestParam("file") MultipartFile file, @RequestParam("type") String type) throws Exception {
        return ocrUtils.analysisFile(file, type);
    }


}
