package kongqichuang;

import java.util.ArrayList;
import java.util.List;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-11-03
 **/
public class parseCSV {
    public String parseCSV(String str) {
        List<String> res = new ArrayList<>();
        boolean inQuote = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (inQuote) {
                if (c == '\"') {
                    if (i < str.length() - 1 && str.charAt(i + 1) == '\"') {
                        sb.append("\"");
                        i++;
                    } else { //这里不能add到res里，他并不是分割标志(e.g Ab"cd"Mm,"san"),遇到cd后的"还要继续加的. 在inQuote = false 遇到时候再加，
                        inQuote = false;
                    }
                } else {
                    sb.append(c);
                }
            } else {
                if (str.charAt(i) == '\"') {
                    inQuote = true;
                } else if (c == ',') {//分割
                    res.add(sb.toString());
                    sb.setLength(0);
                } else {
                    sb.append(c);
                }
            }
        }
        if (sb.length() > 0) {
            res.add(sb.toString());
        }
        return String.join("|", res); //!!! 学习了
    }
}
