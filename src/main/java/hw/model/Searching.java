package hw.model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Searching {
    private String str;
    private String info;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;

    }

    public String getInfor() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream("C://Users//Лилия//IdeaProjects//SpringHW//output//outputfile.txt"), Charset.forName("UTF-8")));
            String line;
            while ((line = reader.readLine()) != null) {
                return line;
            }
        } catch (IOException e) {
            // log error
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    // log warning
                }
            }
        }
        return " ";
    }
    public static ArrayList<String> getEntryByText(String info, String str) {
        ArrayList<String> result = new ArrayList<String>();
        String regex = "\\{([^\\}]*?" + str + ".*?)\\}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(info);
        while (matcher.find()) {
            result.add(matcher.group(1));
        }
        return result;
    }

    public String searchInfor(){
        String searchString = getStr();
        ArrayList<String> searchResult = getEntryByText(getInfor(), searchString);
        for (String entry : searchResult) {
            return entry;//System.out.println(entry);
        }
        return "";
    }
}
