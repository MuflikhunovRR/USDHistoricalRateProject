package ru.gotoqa;

import org.springframework.web.client.RestTemplate;


/**
 * @author Muflikhunov Roman
 */

public class USDHistoricalRateProject {
    private static String APIKEY = "a7bb84eb800d4ea78dfa3b44fa085d4f";

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
                = "https://openexchangerates.org/api/historical/2001-02-16.json?app_id=" +APIKEY;
/*        ResponseEntity<String> response
                //= restTemplate.getForEntity(fooResourceUrl + "/1", String.class);
                = restTemplate.getForEntity(fooResourceUrl, String.class);*/
        //System.out.println(response);

        ClassRates forObject = restTemplate.getForObject(fooResourceUrl, ClassRates.class);
        System.out.println(forObject);
        System.out.println("Timestamp: " +forObject.getTimestamp());
        System.out.println("Base: " +forObject.getBase());
        System.out.println("EUR: " +forObject.getRates().getEUR());
        System.out.println("RUB: " +forObject.getRates().getRUB());
        System.out.println("CHF: " +forObject.getRates().getCHF());
        System.out.println("CAD: " +forObject.getRates().getCAD());
        System.out.println("AED: " +forObject.getRates().getAED());

/*        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        File jsonFile = new File("D:\\JAVA\\Java_SRC\\USDHistoricalRateProject\\src\\main\\resources\\usd.json");
        //ClassRates classRates = mapper.readValue(jsonFile, ClassRates.class);
        ClassRates classRates = mapper.readValue(String.valueOf(forObject), ClassRates.class);
        System.out.println("Timestamp: " +classRates.getTimestamp());*/
    }
}
