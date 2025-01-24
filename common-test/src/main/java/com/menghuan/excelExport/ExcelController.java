package com.menghuan.excelExport;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @Author: menghuan
 * @Date: 2025/1/17 18:00
 */
@RestController
public class ExcelController {

    @PostMapping("/uploadExcel")
    public ResponseEntity<Map<String, Object>> uploadExcel(@RequestParam("file") MultipartFile file) {
        Map<String, Object> response = new HashMap<>();
        try {
            // 验证文件类型和大小等（可选）
            if (!file.isEmpty() && file.getOriginalFilename().endsWith(".xlsx")
                || file.getOriginalFilename().endsWith(".xls")) {
                // 使用Apache POI读取Excel文件
                Workbook workbook = WorkbookFactory.create(file.getInputStream());
                Sheet sheet = workbook.getSheetAt(0); // 假设只读取第一个Sheet
                List<Map<String, String>> dataList = new ArrayList<>();

                // 读取表头（可选，如果需要表头信息）
                Row headerRow = sheet.getRow(0);
                List<String> headers = new ArrayList<>();
                for (Cell cell : headerRow) {
                    headers.add(cell.getStringCellValue());
                }

                // 读取数据行
                for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                    Row row = sheet.getRow(i);
                    Map<String, String> dataMap = new HashMap<>();
                    for (int j = 0; j < headers.size(); j++) {
                        Cell cell = row.getCell(j);
                        dataMap.put(headers.get(j), cell.toString()); // 根据需要转换单元格类型
                    }
                    dataList.add(dataMap);
                }

                // 将数据转换为JSON格式（这里使用Jackson库，Spring Boot默认集成）
                ObjectMapper objectMapper = new ObjectMapper();
                String jsonData = objectMapper.writeValueAsString(dataList);

                // 将JSON数据放入响应中
                response.put("data", jsonData);
                response.put("message", "上传成功");
                return ResponseEntity.ok(response);
            } else {
                response.put("message", "文件类型或大小不符合要求");
                return ResponseEntity.badRequest().body(response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.put("message", "上传失败：" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
