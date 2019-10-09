package sample;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class CipherManager {

    private CipherManager() { }

    // all methods should be static

    public static String rot13(String text) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if       (c >= 'a' && c <= 'm') c += 13;
            else if  (c >= 'A' && c <= 'M') c += 13;
            else if  (c >= 'n' && c <= 'z') c -= 13;
            else if  (c >= 'N' && c <= 'Z') c -= 13;
            sb.append(c);
        }
        return sb.toString();
    }

    public static String md5(String text) throws NoSuchAlgorithmException {

        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hashInBytes = md.digest(text.getBytes(StandardCharsets.UTF_8));

        StringBuilder sb = new StringBuilder();
        for (byte b : hashInBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public static String md5Decode(String hash){
        String hash_type = "md5";
        String api_email = "nejji143@gmail.com";
        String api_code = "9930b85f8e36ee68";

        String urla = "https://md5decrypt.net/en/Api/api.php?hash=" + hash + "&hash_type=" + hash_type + "&email=" + api_email + "&code=" + api_code;

        String contentType;
        StringBuffer content;
        try{
            URL url = new URL(urla);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            contentType = con.getHeaderField("Content-Type");

            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);

            int status = con.getResponseCode();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            con.disconnect();

            return content.toString();
        }catch (Exception e){
            return  "Exception error";
        }
    }
}
