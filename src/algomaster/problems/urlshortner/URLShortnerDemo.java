package algomaster.problems.urlshortner;

import algomaster.problems.urlshortner.shorteningStrategy.UUIDShorteningStrategy;

public class URLShortnerDemo {

    public static void main(String[] args) {
        URLShortner urlShortner = new URLShortner(new UUIDShorteningStrategy());

        // Shorten Long URLs
        String shortURL1 = urlShortner.getShortURL("https://google.com", "google", null);
        System.out.println(shortURL1);

        String shortURL2 = urlShortner.getShortURL("https://facebook.com", "facebook", null);
        System.out.println(shortURL2);

        String shortURL3 = urlShortner.getShortURL("https://instagram.com", "instagram", null);
        System.out.println(shortURL3);

        try {
            urlShortner.getShortURL("https://whatsapp.com", "google", null);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }

        String shortURL4 = urlShortner.getShortURL("https://whatsapp.com", "whatsapp", null);
        System.out.println(shortURL4);

        String shortURL5 = urlShortner.getShortURL("https://telegram.com", null, null);
        System.out.println(shortURL5);

        String shortURL6 = urlShortner.getShortURL("https://telegram.com", null, null);
        System.out.println(shortURL6);

        String shortURLUsingLongURL = urlShortner.getShortURLUsingLongURL("https://telegram.com");
        System.out.println(shortURLUsingLongURL);

        String longURL1 = urlShortner.getLongURLUsingShortURL(shortURL1);
        System.out.println(longURL1);

        String longURL2 = urlShortner.getLongURLUsingShortURL(shortURL2);
        System.out.println(longURL2);

        String longURL3 = urlShortner.getLongURLUsingShortURL(shortURL3);
        System.out.println(longURL3);

        String longURL4 = urlShortner.getLongURLUsingShortURL(shortURL4);
        System.out.println(longURL4);

        String longURL5 = urlShortner.getLongURLUsingShortURL(shortURL5);
        System.out.println(longURL5);

        System.out.println(urlShortner.getVisitCount(shortURL5));

    }
}
