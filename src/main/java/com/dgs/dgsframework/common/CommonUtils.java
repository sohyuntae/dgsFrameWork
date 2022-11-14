package com.dgs.dgsframework.common;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 */
public class CommonUtils
{

    public static Timestamp convertStringToTimestamp(String dateTime, String format)
    {
        if (dateTime == null) return null;

        try
        {
            Date date = new SimpleDateFormat(format).parse(dateTime);
            return new Timestamp(date.getTime());
        }
        catch (Exception e)
        {
            return null;
        }
    }

    public static <K, C> Map<K, List<C>> listGroupBy(List<C> list, Function<? super C, ? extends K> keyMapper)
    {
        Map<K, List<C>> map = new HashMap<>();
        if (list == null) return map;

        map = list
            .stream()
            .filter(x -> keyMapper.apply(x) != null)
            .collect(Collectors.groupingBy(keyMapper));

        return map;
    }
}
