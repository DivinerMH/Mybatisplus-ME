package com.menghuan.testcase;

import java.beans.PropertyEditorSupport;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: menghuan
 * @Date: 2021/6/28 14:56
 */
public class CustomSqlDateEditor extends PropertyEditorSupport {

    private DateFormat formatter;

    public CustomSqlDateEditor(String dateFormat) {
        this.formatter = new SimpleDateFormat(dateFormat);
    }

    /**
     * 对象转sql.Date
     */
    @Override
    public void setValue(Object o) {
        if (o instanceof java.util.Date) {
            super.setValue(new Date(((java.util.Date) o).getTime()));
        } else if (o instanceof String) {
            setAsText((String) o);
        } else if (o instanceof Long) {
            super.setValue(new Date((Long) o));
        } else if (o instanceof Calendar) {
            super.setValue(new Date(((Calendar) o).getTimeInMillis()));
        } else {
            super.setValue(o);
        }
    }

    /**
     * 字符串转sql.Date
     */
    @Override
    public void setAsText(String dateStr) {
        if (dateStr != null) {
            try {
                super.setValue(new Date(formatter.parse(dateStr).getTime()));
            } catch (ParseException e) {
                throw new IllegalArgumentException("Could not parse date: " + e.getMessage());
            }
        } else {
            setValue(null);
        }
    }

    /**
     * sql.Date转字符串
     */
    public String getAsText() {
        Object v = this.getValue();
        return v == null ? "" : formatter.format((Date) v);
    }

}
