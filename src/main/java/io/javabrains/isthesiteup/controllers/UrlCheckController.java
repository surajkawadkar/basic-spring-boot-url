package io.javabrains.isthesiteup.controllers;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// import the rest controller
@RestController
public class UrlCheckController {
    private final String SITE_UP ="site is up!";
    private final String SITE_DOWN ="site is down!";
    private final String INCORRECT_URL ="URL is incorrect!";
    @GetMapping("/check")   //because we are checking the url is up or down

    public String getUrlStatusMessage(@RequestParam String url){
        String returnMessage="";
        try {
            URL urlObj= new URL(url);
            HttpURLConnection conn = (HttpURLConnection)urlObj.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            
            
            if (conn.getResponseCode()==404) {
                returnMessage= "404 ";
            // else if (conn.getResponseCode()==403){
            //     returnMessage= "403 ";
            // }

            }
            else{
                returnMessage=SITE_UP;
            }
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            returnMessage = INCORRECT_URL;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            returnMessage= SITE_DOWN;
        }

        return returnMessage;
 //make http reuest

    }
}
/*
1 crete a url 
2 send it to http to check
*/