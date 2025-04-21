package org.example;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateTypeAdapter extends TypeAdapter<Date> {
    private final SimpleDateFormat dateFormat;

    public DateTypeAdapter() {
        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS'Z'", Locale.US);
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    @Override
    public void write(JsonWriter out, Date value) throws IOException {
        if (value == null) {
            out.nullValue();
        } else {
            out.value(dateFormat.format(value));
        }
    }

    @Override
    public Date read(JsonReader in) throws IOException {
        try {
            String dateString = in.nextString();
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            throw new IOException("Failed to parse date", e);
        }
    }
}