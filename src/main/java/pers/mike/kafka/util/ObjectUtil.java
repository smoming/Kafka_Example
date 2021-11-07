package pers.mike.kafka.util;

import java.math.BigDecimal;
import java.sql.Date;

public class ObjectUtil {
  public static Boolean isNull(Object obj) {
    return obj == null;
  }

  public static Boolean isNotNull(Object obj) {
    return !isNull(obj);
  }

  public static String converToString(Object obj) {
    if (isNull(obj)) {
      return "";
    }
    return obj.toString();
  }

  public static Integer converToInt(Object obj) {
    if (isNull(obj)) {
      return null;
    }
    return Integer.parseInt(converToString(obj));
  }

  public static BigDecimal converToBigDecimal(Object obj) {
    if (isNull(obj)) {
      return null;
    }
    return (BigDecimal) obj;
  }

  public static Date converToSqlDate(Object obj) {
    if (isNull(obj)) {
      return null;
    }

    if (obj instanceof java.util.Date) {
      java.util.Date dt = (java.util.Date) obj;
      return new Date(dt.getTime());
    }

    return (Date) obj;
  }
}
