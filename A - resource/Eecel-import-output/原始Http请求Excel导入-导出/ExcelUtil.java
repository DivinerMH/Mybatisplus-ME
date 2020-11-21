package com.joolun.cloud.mall.common.util;

import com.github.crab2died.annotation.ExcelField;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.apache.xmlbeans.impl.piccolo.io.FileFormatException;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Field;
import java.util.*;

/**
 * @Author: Wong
 * @ClassName: ExcelUtil
 * @Date: 2020/11/11 11:35
 * @Description: Exceil工具类
 * @Version: V1.0
 **/
@Slf4j
public class ExcelUtil {

	public static final String EXTENSION_XLS = "xls";
	public static final String EXTENSION_XLSX = "xlsx";

	/*
	 * @Author wong
	 * @Description //TODO 取得Workbook对象(xls和xlsx对象不同,不过都是Workbook的实现类)[xls:HSSFWorkbook,xlsx：XSSFWorkbook]
	 * @Date
	 * @Param
	 * @return  filePath
	 * @throws IOException
	 **/
	private static Workbook getWorkbook(String filePath) throws IOException {
		Workbook workbook = null;
		// 检查
		preReadCheck(filePath);
		InputStream is = new FileInputStream(filePath);
		// 获取workbook对象
		if (filePath.endsWith(EXTENSION_XLS)) {
			workbook = new HSSFWorkbook(is);
		} else if (filePath.endsWith(EXTENSION_XLSX)) {
			workbook = new XSSFWorkbook(is);
		}
		is.close();
		return workbook;
	}

	/**
	 * 文件检查
	 *
	 * @param filePath
	 * @throws FileNotFoundException
	 * @throws FileFormatException
	 */
	private static void preReadCheck(String filePath) throws FileNotFoundException, FileFormatException {
		// 常规检查
		File file = new File(filePath);
		if (!file.exists()) {
			throw new FileNotFoundException("传入的文件不存在：" + filePath);
		}

		if (!(filePath.endsWith(EXTENSION_XLS) || filePath.endsWith(EXTENSION_XLSX))) {
			throw new FileFormatException("传入的文件不是excel");
		}
	}

	/**
	 * 读取excel文件内容
	 *
	 * @param filePath
	 * @throws FileNotFoundException
	 * @throws FileFormatException
	 */
	public static List<Map<String, String>> readAllExcel(String filePath) throws FileNotFoundException, FileFormatException {
		List<Map<String, String>> res = new ArrayList<>();
		Workbook workbook = null;
		try {
			workbook = getWorkbook(filePath);
			// 读文件 一个sheet一个sheet地读取
			for (int numSheet = 0; numSheet < workbook.getNumberOfSheets(); numSheet++) {
				Sheet sheet = workbook.getSheetAt(numSheet);
				if (sheet == null) {
					continue;
				}
				log.info("=======================" + sheet.getSheetName() + "=========================");

				int firstRowIndex = sheet.getFirstRowNum();
				int lastRowIndex = sheet.getLastRowNum();

				// 读取首行 即,表头
				Row firstRow = sheet.getRow(firstRowIndex);
				if (firstRow != null) {

					for (int i = firstRow.getFirstCellNum(); i <= firstRow.getLastCellNum(); i++) {
						Cell cell = firstRow.getCell(i);
						String cellValue = getCellValue(cell, true);

					}
					// 读取数据行
					for (int rowIndex = firstRowIndex + 1; rowIndex <= lastRowIndex; rowIndex++) {
						Map<String, String> map = new HashMap<>();
						Row currentRow = sheet.getRow(rowIndex);// 当前行
						int firstColumnIndex = currentRow.getFirstCellNum(); // 首列
						int lastColumnIndex = currentRow.getLastCellNum();// 最后一列

						String s = "";
						for (int columnIndex = firstColumnIndex; columnIndex <= lastColumnIndex; columnIndex++) {
							Cell currentCell = currentRow.getCell(columnIndex);// 当前单元格
							String currentCellValue = getCellValue(currentCell, true);// 当前单元格的值
							map.put("cell" + columnIndex, currentCellValue);
							s += currentCellValue + "\t";
						}
						log.info(s);
						res.add(map);
					}
					log.info("=========================读取Excel=============================");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (workbook != null) {
				try {
					workbook.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return res;
	}

	/**
	 * 取单元格的值
	 *
	 * @param cell       单元格对象
	 * @param treatAsStr 为true时，当做文本来取值 (取到的是文本，不会把“1”取成“1.0”)
	 * @return
	 */
	private static String getCellValue(Cell cell, boolean treatAsStr) {
		if (cell == null) {
			return "";
		}
		if (treatAsStr) {
			// 虽然excel中设置的都是文本，但是数字文本还被读错，如“1”取成“1.0”
			// 加上下面这句，临时把它当做文本来读取
			cell.setCellType(Cell.CELL_TYPE_STRING);
		}
		switch (cell.getCellType()) {
			case Cell.CELL_TYPE_BOOLEAN:
				return String.valueOf(cell.getBooleanCellValue());
			case Cell.CELL_TYPE_NUMERIC:
				return String.valueOf(cell.getNumericCellValue());
			default:
				return String.valueOf(cell.getStringCellValue());
		}
	}

//================================================================================================

	/**
	 * 导出 生成Excel表格
	 * @param list 一个list对象
	 * @param cls  映射实体对象的的class
	 * @param sumData   null
	 */
	// 生成excel，list导出的数据，list里的实体class，sumData合计数据
	public static <Q> XSSFWorkbook createExcel(List<Q> list, Class<Q> cls, Q sumData) throws IOException, IllegalArgumentException, IllegalAccessException {
		// 第一步，创建一个HSSFWorkbook，对应一个Excel文件
		XSSFWorkbook wb = new XSSFWorkbook();

		//获取bean数据省
		Field[] fields = cls.getDeclaredFields();

		//创建excel表头list
		ArrayList<String> headList = new ArrayList<String>();

		// 添加合计数据
		if (sumData != null) {
			list.add(sumData);
		}

		HashMap<String, String> map = new HashMap<>();


		//循环bean数据添加表头list
		for (Field f : fields) {
			ExcelField field = f.getAnnotation(ExcelField.class);
			if (field != null) {
				headList.add(field.title());
			}
		}

		//获取表头样式
		XSSFCellStyle style = getCellStyle(wb);

		//创建一个sheet
		XSSFSheet sheet = wb.createSheet();

		// 设置Excel表的第一行即表头
		XSSFRow row = sheet.createRow(0);
		for (int i = 0; i < headList.size(); i++) {
			XSSFCell headCell = row.createCell(i);
			headCell.setCellType(Cell.CELL_TYPE_STRING);
			headCell.setCellStyle(style);// 设置表头样式
			headCell.setCellValue(String.valueOf(headList.get(i)));
			sheet.autoSizeColumn((short) i);// 设置单元格自适应
			sheet.setColumnWidth(0, 15 * 256);
		}
		for (int i = 0; i < list.size(); i++) {
			XSSFRow rowdata = sheet.createRow(i + 1);// 创建数据行
			Q q = list.get(i);
			Field[] ff = q.getClass().getDeclaredFields();
			int j = 0;
			for (Field f : ff) {
				ExcelField field = f.getAnnotation(ExcelField.class);
				if (field == null) {
					continue;
				}
				f.setAccessible(true);
				Object obj = f.get(q);
				XSSFCell cell = rowdata.createCell(j);
				cell.setCellType(Cell.CELL_TYPE_STRING);
				// 当数字时
				if (obj instanceof Integer) {
					cell.setCellValue((Integer)obj);
					// 将序号替换为123456
					if (j == 0)
						cell.setCellValue(i + 1);
				}
				// 当为字符串时
				else if (obj instanceof String)
					cell.setCellValue((String)obj);
					// 当为布尔时
				else if (obj instanceof Boolean)
					cell.setCellValue((Boolean)obj);
					// 当为时间时
				else if (obj instanceof Date)
					cell.setCellValue((Date) obj);
					// 当为时间时
				else if (obj instanceof Calendar)
					cell.setCellValue((Calendar)obj);
					// 当为小数时
				else if (obj instanceof Double)
					cell.setCellValue((Double)obj);
				j++;
			}
		}
		if (sumData != null) {
			int rowIndex = list.size();
			XSSFRow sumRow = sheet.getRow(rowIndex);
			XSSFCell sumCell = sumRow.getCell(0);
			sumCell.setCellStyle(style);
			sumCell.setCellValue("合计");
		}
		return wb;
	}

	/*
	 * @Author wong
	 * @Description //TODO 导出 输出Excel表
	 * @Date  
	 * @Param 
	 * @return  
	 * @throws 
	 **/
	public static void writeExcel(HttpServletResponse response, String fileName, XSSFWorkbook wb) throws IOException {
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-disposition", "attachment; filename=" + fileName);
		OutputStream ouputStream = null;
		try {
			ouputStream = response.getOutputStream();
			wb.write(ouputStream);
		} finally {
			ouputStream.close();
		}
	}

	// 表头样式设置
	public static XSSFCellStyle getCellStyle(XSSFWorkbook wb) {
		XSSFCellStyle style = wb.createCellStyle();
		Font font = wb.createFont();
		font.setFontName("宋体");
		font.setFontHeightInPoints((short)12);// 设置字体大小

//        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);// 字体加粗
		font.setBold(true);//字体加粗

		style.setFillForegroundColor(HSSFColor.LIME.index);// 设置背景色

//        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);//设置图案样式
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);//设置图案样式

//        style.setAlignment(HSSFCellStyle.SOLID_FOREGROUND);// 让单元格居中

//        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中
		style.setAlignment(HorizontalAlignment.CENTER);//左右居中

//        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上下居中
		style.setVerticalAlignment(VerticalAlignment.CENTER);// 上下居中
		style.setWrapText(true);// 设置自动换行
		style.setFont(font);
		return style;
	}

	public static void main(String[] args) throws FileFormatException, FileNotFoundException {

	}
}
