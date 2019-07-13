package com.book.bo;

import cn.hutool.core.date.DateTime;
import com.book.mapper.BookCategoryMapper;
import com.book.mapper.BookInfoMapper;
import com.book.model.BookCategory;
import com.book.model.BookInfo;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据导入器
 */
public class MyDataLoader {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyDataLoader.class);
    @Autowired
    private BookInfoMapper bookInfoMapper;
    @Autowired
    private BookCategoryMapper categoryMapper;

    public void load() {
        String path = "C:\\Users\\lenovo\\Desktop\\小说.xlsx";
        int i = 0;
        try {
            File excel = new File(path);
            Workbook workbook = new XSSFWorkbook(excel);
            Sheet sheet = workbook.getSheetAt(0);
            int firstRowIndex = sheet.getFirstRowNum() + 1;   // 第一行是列名，所以不读
            int lastRowIndex = sheet.getLastRowNum();
            LOGGER.info("firstRowIndex: "+ firstRowIndex);
            LOGGER.info("lastRowIndex: "+ lastRowIndex);
            List<CateTmp> parentList = new ArrayList<>();
            List<CateTmp> childList = new ArrayList<>();
            for (int rIndex = firstRowIndex; rIndex <= lastRowIndex; rIndex++) {
                Row row = sheet.getRow(rIndex);
                if (row != null && rIndex < 4943) {
                    String parent = row.getCell(14).toString();
                    String child = row.getCell(15).toString();
                    int parentIndex = isInclude(parent, parentList);
                    if (parentIndex < 0) {
                        BookCategory bookCategory = new BookCategory();
                        bookCategory.setName(parent);
                        bookCategory.setIsParent(new Byte("1"));
                        bookCategory.setParentId(0);
                        bookCategory.setStatus("1");
                        bookCategory.setSortOrder(1);
                        bookCategory.setCreated(new DateTime());
                        categoryMapper.insert(bookCategory);
                        parentList.add(new CateTmp(parent, bookCategory.getId()));
                        parentIndex = parentList.size() - 1;
                    }
                    int childIndex = isInclude(child, childList);
                    if (childIndex < 0) {
                        BookCategory category = new BookCategory();
                        category.setName(child);
                        category.setIsParent(new Byte("0"));
                        category.setParentId(parentList.get(parentIndex).id);
                        category.setStatus("1");
                        category.setSortOrder(1);
                        category.setCreated(new DateTime());
                        categoryMapper.insert(category);
                        childList.add(new CateTmp(child, category.getId()));
                        childIndex = childList.size() - 1;
                    }
                    BookInfo bookInfo = new BookInfo();
                    bookInfo.setBookCategoryId(childList.get(childIndex).id);
                    bookInfo.setStoreId(1);
                    bookInfo.setName(getItem(row, 0));
                    bookInfo.setAuthor(getItem(row, 1));
                    bookInfo.setPublishDate(getItem(row, 2));
                    bookInfo.setPress(getItem(row, 3));
                    bookInfo.setPrice(getPrice(row.getCell(4).toString()));
                    bookInfo.setMarketPrice(getPrice(row.getCell(5).toString()));
                    bookInfo.setOutline(getItem(row, 7));
                    bookInfo.setImageUrl(getItem(row, 8));
                    bookInfo.setSize(getItem(row, 9));
                    bookInfo.setPackStyle(getItem(row, 11));
                    bookInfo.setIsbn(getItem(row, 13));
                    bookInfoMapper.insert(bookInfo);
                    i++;
                    LOGGER.info("已读取：" + (((double)i / 4942)) * 100 + "%");
                }
            }
        } catch (Exception e) {
            LOGGER.info("出大问题：" + e.toString() + " 等" + i + "行");
        }
        LOGGER.info("###########  数据导入完成  #############");
    }

    private BigDecimal getPrice(String temp) {
        try {
            return new BigDecimal(temp);
        } catch (Exception e) {
            LOGGER.info("格式转换出错 ：" + e.getMessage());
            return new BigDecimal("50");
        }
    }

    private String getItem(Row row, int index) {
        try {
            String item = row.getCell(index).toString();
            if (item == null || item.equals("")) {
                return "暂无";
            } else {
                return item;
            }
        } catch (Exception e) {
            LOGGER.info("字符检查出错 ：" + e.getMessage());
            return "暂无";
        }
    }

    private int isInclude(String value, List<CateTmp> list) {
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                String name = list.get(i).name;
                if (name.equals(value)) {
                    return i;
                }
            }
        }
        return -1;
    }

    class CateTmp {
        public String name;
        public int id;

        public CateTmp(String name, int id) {
            this.name = name;
            this.id = id;
        }
    }
}
