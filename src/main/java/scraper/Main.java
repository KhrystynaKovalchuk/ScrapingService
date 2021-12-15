package scraper;

public class Main {
    public static void main(String[] args) {
        String url = "https://www.newhomesource.com/plan/montclair-windsor-built-homes-hendersonville-nc/1920804";
//        String url = "localhost";
        Scraper defaultScraper = new CacheScraper();
        Home home = defaultScraper.scrape(url);
        System.out.println(home);
    }
}