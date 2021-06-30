package com.test.codeTest_2021_06;

import java.beans.PropertyEditorSupport;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: menghuan
 * @Date: 2021/6/28 14:55
 */

public class CustomDateEditor extends PropertyEditorSupport {

    private DateFormat formatter;

    public CustomDateEditor(String dateFormat) {
        this.formatter = new SimpleDateFormat(dateFormat);
    }

    /**
     * <pre>
     * 对象转日期
     * java.sql.Date -> java.util.Date
     * String -> java.util.Date
     * Long -> java.util.Date
     * Calandar -> java.util.Date
     * </pre>
     */
    @Override
    public void setValue(Object o) {
        if (o instanceof java.sql.Date) {
            super.setValue(new Date(((java.sql.Date) o).getTime()));
        } else if (o instanceof String) {
            setAsText((String) o);
        } else if (o instanceof Long) {
            super.setValue(new Date((Long) o));
        } else if (o instanceof Calendar) {
            super.setValue(((Calendar) o).getTime());
        } else {
            super.setValue(o);
        }
    }

    /**
     * 字符串转日期
     */
    @Override
    public void setAsText(String dateStr) {
        if (dateStr != null) {
            try {
                super.setValue(formatter.parse(dateStr));
            } catch (ParseException e) {
                throw new IllegalArgumentException("Could not parse date: " + e.getMessage());
            }
        } else {
            super.setValue(null);
        }
    }

    /**
     * 日期转字符串
     */
    public String getAsText() {
        Object v = this.getValue();
        return v == null ? "" : formatter.format((Date) v);
    }

}
