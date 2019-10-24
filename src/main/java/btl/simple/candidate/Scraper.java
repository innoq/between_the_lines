package btl.simple.candidate;

import org.jsoup.Jsoup;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Scraper {

  String getText(String url) throws IOException {
    return Jsoup.connect(url).get().text();
  }
}
