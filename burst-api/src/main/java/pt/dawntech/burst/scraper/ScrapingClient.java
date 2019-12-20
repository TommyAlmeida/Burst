package pt.dawntech.burst.scraper;

public interface ScrapingClient<T> {

    void init(String driverPath);

    T getNativeDriver();

}
