package scraper;

import lombok.SneakyThrows;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.print.Doc;

public class DefaultScraper implements Scraper{
    private static final String PRICE_SELECTOR = ".detail__info-xlrg";
    private static final String BED_SELECTOR = ".nhs_BedsInfo";
    private static final String BATH_SELECTOR = ".nhs_BathsInfo";
    private static final String GARAGE_SELECTOR = ".nhs_GarageInfo";

    @Override @SneakyThrows
    public Home scrape(String url) {
        Document doc = Jsoup.connect(url).get();

        int price = getPrice(doc);
        double beds = getBeds(doc);
        double bathes = getBathes(doc);
        double garages = getGarages(doc);


        return new Home(price, beds, bathes, garages);
    }

    private int getPrice(Document doc) {
        String price = doc.select(PRICE_SELECTOR).text().replaceAll("[^0-9]", "");
        return Integer.parseInt(price);
    }

    private double getBeds(Document doc) {
        String beds = doc.select(BED_SELECTOR).text().replaceAll("[^0-9.]", "");
        return Double.parseDouble(beds);
    }

    private double getBathes(Document doc) {
        String bathes = doc.select(BATH_SELECTOR).text().replaceAll("[^0-9.]", "");
        return Double.parseDouble(bathes);
    }

    private double getGarages(Document doc) {
        String garages = doc.select(GARAGE_SELECTOR).text().replaceAll("[^0-9.]", "");
        return Double.parseDouble(garages);
    }
}
