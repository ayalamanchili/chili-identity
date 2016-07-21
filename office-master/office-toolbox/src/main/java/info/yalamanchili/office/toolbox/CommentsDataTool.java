/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.toolbox;

import static info.chili.docs.ExcelUtils.getCellNumericValue;
import static info.chili.docs.ExcelUtils.getCellStringValue;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dao.ext.CommentDao;
import info.yalamanchili.office.dao.profile.ClientInformationDao;
import info.yalamanchili.office.entity.profile.ClientInformation;
import info.yalamanchili.office.toolbox.types.CommentsRecord;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Madhu.Badiginchala
 */
@Component("commentsDataTool")
@Transactional
public class CommentsDataTool {

    private static final Log log = LogFactory.getLog(CommentsDataTool.class);

    public static void main(String... args) {
        CommentsDataTool tool = new CommentsDataTool();
        tool.bisCommentsMigration();
    }

    @Autowired
    protected ClientInformationDao clientInformationDao;

    public void bisCommentsMigration() {
        InputStream inp;
        XSSFWorkbook workbook;
        try {
            inp = new FileInputStream(getDataFileUrl());
            workbook = new XSSFWorkbook(inp);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        XSSFSheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()) {
            Row record = rowIterator.next();
            if (record.getRowNum() == 0) {
                continue;
            }
            String commentD = "";
            ClientInformation clientInfo = new ClientInformation();
            CommentsRecord cr = new CommentsRecord();
            String clientInfoId = getCellNumericValue(record, 2);
            if (clientInfoId != null) {
                cr.setClientInfoId(new Long(convertDcimalToWhole(getCellNumericValue(record, 2))));
                clientInfo = clientInformationDao.instance().findById(cr.getClientInfoId());
            } else {
                continue;
            }
            System.out.println("CommentsData : ClientID >>>>>>>>>>>>>>>><<<<<<<<<<<<<<: " + clientInfoId);
            cr.setUpdatedDate(convertToDate(getCellNumericValue(record, 6)));
            cr.setUpdatedBy(getCellStringValue(record, 5));
            cr.setComment(getCellStringValue(record, 4));
            if (cr.getComment() != null) {
                commentD = cr.getComment();
            }
            String FromDate = "";
            FromDate = getCellNumericValue(record, 7);
            cr.setFromDate(convertToDate(getCellNumericValue(record, 7)));
            if ((FromDate != null) && cr.getFromDate()!=null) {
                commentD = commentD + " From: " + FromDate;
            }
            String ToDate = "";
            cr.setToDate(convertToDate(getCellNumericValue(record, 8)));
            ToDate = getCellNumericValue(record, 8);
            if ((ToDate != null) && cr.getToDate()!= null) {
                commentD = commentD + " To: " + ToDate;
            }
            if (commentD != null) {
                CommentDao.instance().addComment(commentD, clientInfo, cr.getUpdatedBy(), cr.getUpdatedDate());
            }
        }
    }

    protected String getDataFileUrl() {
        return OfficeServiceConfiguration.instance().getContentManagementLocationRoot() + "BIS_CommentsMapping.xlsx";
    }

    protected String convertDcimalToWhole(String id) {
        if (StringUtils.isNotEmpty(id) && id.contains(".")) {
            return id.substring(0, id.indexOf("."));
        } else {
            return id;
        }
    }

    protected Enum convertEnum(Class enumClass, String value) {
        try {
            if (StringUtils.isNotBlank(value)) {
                return Enum.valueOf(enumClass, value.toUpperCase().replace("-", "_"));
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    protected Date convertToDate(String dte) {
        if (dte != null) {
            Date date = null;
            try {
                date = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).parse(dte);
                return date;
            } catch (ParseException ex) {
                System.out.println("date parsing error" + dte);
            }
        }
        return null;
    }

    public static CommentsDataTool instance() {
        return SpringContext.getBean(CommentsDataTool.class);
    }

}
