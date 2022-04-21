package eem.util



import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.DataFormatter
import org.apache.poi.ss.usermodel.DateUtil
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.ss.usermodel.WorkbookFactory
import org.apache.poi.ss.util.CellRangeAddress
import org.apache.poi.xssf.usermodel.XSSFRow
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook

import org.apache.poi.ss.usermodel.CellType.*


import io.vavr.CheckedFunction0
import io.vavr.control.Try
import org.apache.commons.lang3.StringUtils
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import java.util.ArrayList


fun main() {
    // List<List<String>> list = read(new FileInputStream("d:/j2ee/a.xlsx"), 0);
    // System.out.println(list);
    // write(new FileOutputStream("D:\\tmp\\g.xlsx"),
    // Arrays.asList(Arrays.asList("1a", "2b", "3c"), Arrays.asList("1", "2", "3")));
    val wb = XSSFWorkbook()
    val sheet: XSSFSheet = wb.createSheet()
    sheet.addMergedRegion(CellRangeAddress(0, 3, 0, 0))
    sheet.addMergedRegion(CellRangeAddress(0, 3, 3, 3))
    sheet.addMergedRegion(CellRangeAddress(0, 3, 4, 4))
    // 第一行数据

    var row = sheet.createRow(0)
  //  row.createCell(0).setCellValue("工作站")
    row.createCell(1).setCellValue("位置")
    row.createCell(2).setCellValue("序号")
    row.createCell(3).setCellValue("订单号")
    row.createCell(4).setCellValue("成品号/型号")


    row = sheet.createRow(1);
    row.createCell(0).setCellValue("工作站000");//因为和上面的行合并了，所以不用再次 赋值了
    row.createCell(1).setCellValue("位置");
    row.createCell(2).setCellValue("序号");

    wb.write(FileOutputStream("D:\\tmp\\91.xlsx"))
    wb.close()
    println("OK")
}

object ExcelUtil {
    const val SAMPLE_XLSX_FILE_PATH = "d:/j2ee/a.xlsx"



    fun write(out: OutputStream?, dataList: List<List<String?>>) {
        try {
            val workbook = XSSFWorkbook()
            val sheet: XSSFSheet = workbook.createSheet()
            var rowCount = 0
            for (rowData in dataList) {
                val row: Row = sheet.createRow(rowCount)
                rowCount++
                var columnCount = 0
                for (field in rowData) {
                    val cell: Cell = row.createCell(columnCount)
                    cell.setCellValue(field)
                    columnCount++
                }
            }
            workbook.write(out)
            workbook.close()
        } catch (e: Exception) {
            throw RuntimeException(e.message, e)
        }
    }

    private fun createWorkBook(`in`: InputStream): Workbook {
        var workbook: Try<Workbook> = Try.of<Workbook> { XSSFWorkbook(`in`) }
        if (workbook.isFailure()) {
            workbook = Try.of(CheckedFunction0 { WorkbookFactory.create(`in`) })
        }
        if (workbook.isFailure()) {
            throw Exception("Excel 版本不兼容", workbook.getCause())
        }
        return workbook.get()
    }

    fun read(`in`: InputStream, sheetIndex: Int): List<List<String?>> {
        return try {
            val workbook: Workbook = createWorkBook(`in`) // WorkbookFactory.create(in);
            val sheet: Sheet = workbook.getSheetAt(sheetIndex)
            val dataFormatter = DataFormatter()
            val datas: MutableList<List<String?>> = ArrayList()
            val rowNum: Int = sheet.getLastRowNum() + 1
            if (rowNum == 0) {
                return datas
            }
            val noOfColumns: Int = sheet.getRow(0).getLastCellNum() + 1
            for (i in 0 until rowNum) {
                val row: Row = sheet.getRow(i)
                val dataRow: MutableList<String?> = ArrayList()
                if (row == null) {
                    for (j in 0 until noOfColumns) {
                        dataRow.add(null)
                    }
                } else {
                    for (j in 0 until noOfColumns) {
                        val cell: Cell = row.getCell(j)
                        val cellValue: String? = if (cell == null) null else dataFormatter.formatCellValue(cell)
                        dataRow.add(StringUtils.trim(cellValue))
                    }
                }
                datas.add(dataRow)
            }
            workbook.close()
            datas
        } catch (e: Exception) {
            e.printStackTrace()
            throw RuntimeException(e.message, e)
        }
    }

    private fun printCellValue(cell: Cell) {
        when (cell.getCellTypeEnum()) {
            BOOLEAN -> System.out.print(cell.getBooleanCellValue())
            STRING -> System.out.print(cell.getRichStringCellValue().getString())
            NUMERIC -> if (DateUtil.isCellDateFormatted(cell)) {
                System.out.print(cell.getDateCellValue())
            } else {
                System.out.print(cell.getNumericCellValue())
            }
            FORMULA -> System.out.print(cell.getCellFormula())
            BLANK -> print("")
            else -> print("")
        }
        print("\t")
    }
}