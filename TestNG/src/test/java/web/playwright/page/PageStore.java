package web.playwright.page;

public class PageStore {

    public static LandingPage landingPage;
    public static SearchResultPage searchResultPage;

    public static void initializePages() {
        landingPage = new LandingPage();
    }
}
