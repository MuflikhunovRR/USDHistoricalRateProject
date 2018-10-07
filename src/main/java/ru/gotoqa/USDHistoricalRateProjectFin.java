package ru.gotoqa;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 * @author Muflikhunov Roman
 */

public class USDHistoricalRateProjectFin {
    static final String INSERT_QUERY = "INSERT INTO exchangerates ( id, data_cur, timestamp, AED, ANG, ARS, AUD, AWG, BBD, BDT, BGN, BHD, BIF, BMD, BND, BOB, BRL, BSD, BTN, BWP, BZD, CAD, CHF, CLP, CNY, COP, CRC, CVE, CYP, CZK, DJF, DKK, DOP, DZD, EEK, EGP, ETB, EUR, FJD, FKP, GBP, GIP, GMD, GNF, GTQ, GYD, HKD, HNL, HRK, HTG, HUF, IDR, IEP, ILS, INR, IQD, IRR, ISK, JMD, JOD, JPY, KES, KHR, KMF, KPW, KRW, KWD, KZT, LAK, LBP, LKR, LSL, LTL, LVL, LYD, MAD, MMK, MNT, MOP, MRO, MTL, MUR, MVR, MWK, MXN, MYR, NAD, NGN, NIO, NOK, NPR, NZD, OMR, PAB, PEN, PGK, PHP, PKR, PLN, PYG, QAR, RON, RUB, SAR, SBD, SCR, SEK, SGD, SHP, SIT, SKK, SLL, SOS, SVC, SYP, SZL, THB, TND, TOP, TRY, TTD, TWD, TZS, UAH, UGX, USD, VEF, VND, VUV, WST, XAF, XCD, XDR, XOF, XPF, ZAR, ZMK, ZWD) VALUES( :id, :data_cur, :timestamp, :aed, :ang, :ars, :aud, :awg, :bbd, :bdt, :bgn, :bhd, :bif, :bmd, :bnd, :bob, :brl, :bsd, :btn, :bwp, :bzd, :cad, :chf, :clp, :cny, :cop, :crc, :cve, :cyp, :czk, :djf, :dkk, :dop, :dzd, :eek, :egp, :etb, :eur, :fjd, :fkp, :gbp, :gip, :gmd, :gnf, :gtq, :gyd, :hkd, :hnl, :hrk, :htg, :huf, :idr, :iep, :ils, :inr, :iqd, :irr, :isk, :jmd, :jod, :jpy, :kes, :khr, :kmf, :kpw, :krw, :kwd, :kzt, :lak, :lbp, :lkr, :lsl, :ltl, :lvl, :lyd, :mad, :mmk, :mnt, :mop, :mro, :mtl, :mur, :mvr, :mwk, :mxn, :myr, :nad, :ngn, :nio, :nok, :npr, :nzd, :omr, :pab, :pen, :pgk, :php, :pkr, :pln, :pyg, :qar, :ron, :rub, :sar, :sbd, :scr, :sek, :sgd, :shp, :sit, :skk, :sll, :sos, :svc, :syp, :szl, :thb, :tnd, :top, :try, :ttd, :twd, :tzs, :uah, :ugx, :usd, :vef, :vnd, :vuv, :wst, :xaf, :xcd, :xdr, :xof, :xpf, :zar, :zmk, :zwd);";
    private static String APIKEY = "a7bb84eb800d4ea78dfa3b44fa085d4f";

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext contextdb = new ClassPathXmlApplicationContext("db.xml");
        NamedParameterJdbcTemplate nqu = new NamedParameterJdbcTemplate(contextdb.getBean(DataSource.class));
        int i = 0;
        try(BufferedReader br = new BufferedReader(new FileReader("D:\\JAVA\\Java_SRC\\USDHistoricalRateProject\\src\\main\\resources\\data.txt"))) {
            for(String line; (line = br.readLine()) != null; ) {
                RestTemplate restTemplate = new RestTemplate();
                String fooResourceUrl
                        = "https://openexchangerates.org/api/historical/"+line+".json?app_id=" +APIKEY;
                i++;
                ClassRates forObject = restTemplate.getForObject(fooResourceUrl, ClassRates.class);

                // Creating map with all required params
                Map<String, Object> paramMap = new HashMap<String, Object>();
                paramMap.put("id", i);
                paramMap.put("data_cur", line);
                paramMap.put("timestamp", forObject.getTimestamp());
                paramMap.put("aed", forObject.getRates().getAED());
                paramMap.put("ang", forObject.getRates().getANG());
                paramMap.put("ars", forObject.getRates().getARS());
                paramMap.put("aud", forObject.getRates().getAUD());
                paramMap.put("awg", forObject.getRates().getAWG());
                paramMap.put("bbd", forObject.getRates().getBBD());
                paramMap.put("bdt", forObject.getRates().getBDT());
                paramMap.put("bgn", forObject.getRates().getBGN());
                paramMap.put("bhd", forObject.getRates().getBHD());
                paramMap.put("bif", forObject.getRates().getBIF());
                paramMap.put("bmd", forObject.getRates().getBMD());
                paramMap.put("bnd", forObject.getRates().getBND());
                paramMap.put("bob", forObject.getRates().getBOB());
                paramMap.put("brl", forObject.getRates().getBRL());
                paramMap.put("bsd", forObject.getRates().getBSD());
                paramMap.put("btn", forObject.getRates().getBTN());
                paramMap.put("bwp", forObject.getRates().getBWP());
                paramMap.put("bzd", forObject.getRates().getBZD());
                paramMap.put("cad", forObject.getRates().getCAD());
                paramMap.put("chf", forObject.getRates().getCHF());
                paramMap.put("clp", forObject.getRates().getCLP());
                paramMap.put("cny", forObject.getRates().getCNY());
                paramMap.put("cop", forObject.getRates().getCOP());
                paramMap.put("crc", forObject.getRates().getCRC());
                paramMap.put("cve", forObject.getRates().getCVE());
                paramMap.put("cyp", forObject.getRates().getCYP());
                paramMap.put("czk", forObject.getRates().getCZK());
                paramMap.put("djf", forObject.getRates().getDJF());
                paramMap.put("dkk", forObject.getRates().getDKK());
                paramMap.put("dop", forObject.getRates().getDOP());
                paramMap.put("dzd", forObject.getRates().getDZD());
                paramMap.put("eek", forObject.getRates().getEEK());
                paramMap.put("egp", forObject.getRates().getEGP());
                paramMap.put("etb", forObject.getRates().getETB());
                paramMap.put("eur", forObject.getRates().getEUR());
                paramMap.put("fjd", forObject.getRates().getFJD());
                paramMap.put("fkp", forObject.getRates().getFKP());
                paramMap.put("gbp", forObject.getRates().getGBP());
                paramMap.put("gip", forObject.getRates().getGIP());
                paramMap.put("gmd", forObject.getRates().getGMD());
                paramMap.put("gnf", forObject.getRates().getGNF());
                paramMap.put("gtq", forObject.getRates().getGTQ());
                paramMap.put("gyd", forObject.getRates().getGYD());
                paramMap.put("hkd", forObject.getRates().getHKD());
                paramMap.put("hnl", forObject.getRates().getHNL());
                paramMap.put("hrk", forObject.getRates().getHRK());
                paramMap.put("htg", forObject.getRates().getHTG());
                paramMap.put("huf", forObject.getRates().getHUF());
                paramMap.put("idr", forObject.getRates().getIDR());
                paramMap.put("iep", forObject.getRates().getIEP());
                paramMap.put("ils", forObject.getRates().getILS());
                paramMap.put("inr", forObject.getRates().getINR());
                paramMap.put("iqd", forObject.getRates().getIQD());
                paramMap.put("irr", forObject.getRates().getIRR());
                paramMap.put("isk", forObject.getRates().getISK());
                paramMap.put("jmd", forObject.getRates().getJMD());
                paramMap.put("jod", forObject.getRates().getJOD());
                paramMap.put("jpy", forObject.getRates().getJPY());
                paramMap.put("kes", forObject.getRates().getKES());
                paramMap.put("khr", forObject.getRates().getKHR());
                paramMap.put("kmf", forObject.getRates().getKMF());
                paramMap.put("kpw", forObject.getRates().getKPW());
                paramMap.put("krw", forObject.getRates().getKRW());
                paramMap.put("kwd", forObject.getRates().getKWD());
                paramMap.put("kzt", forObject.getRates().getKZT());
                paramMap.put("lak", forObject.getRates().getLAK());
                paramMap.put("lbp", forObject.getRates().getLBP());
                paramMap.put("lkr", forObject.getRates().getLKR());
                paramMap.put("lsl", forObject.getRates().getLSL());
                paramMap.put("ltl", forObject.getRates().getLTL());
                paramMap.put("lvl", forObject.getRates().getLVL());
                paramMap.put("lyd", forObject.getRates().getLYD());
                paramMap.put("mad", forObject.getRates().getMAD());
                paramMap.put("mmk", forObject.getRates().getMMK());
                paramMap.put("mnt", forObject.getRates().getMNT());
                paramMap.put("mop", forObject.getRates().getMOP());
                paramMap.put("mro", forObject.getRates().getMRO());
                paramMap.put("mtl", forObject.getRates().getMTL());
                paramMap.put("mur", forObject.getRates().getMUR());
                paramMap.put("mvr", forObject.getRates().getMVR());
                paramMap.put("mwk", forObject.getRates().getMWK());
                paramMap.put("mxn", forObject.getRates().getMXN());
                paramMap.put("myr", forObject.getRates().getMYR());
                paramMap.put("nad", forObject.getRates().getNAD());
                paramMap.put("ngn", forObject.getRates().getNGN());
                paramMap.put("nio", forObject.getRates().getNIO());
                paramMap.put("nok", forObject.getRates().getNOK());
                paramMap.put("npr", forObject.getRates().getNPR());
                paramMap.put("nzd", forObject.getRates().getNZD());
                paramMap.put("omr", forObject.getRates().getOMR());
                paramMap.put("pab", forObject.getRates().getPAB());
                paramMap.put("pen", forObject.getRates().getPEN());
                paramMap.put("pgk", forObject.getRates().getPGK());
                paramMap.put("php", forObject.getRates().getPHP());
                paramMap.put("pkr", forObject.getRates().getPKR());
                paramMap.put("pln", forObject.getRates().getPLN());
                paramMap.put("pyg", forObject.getRates().getPYG());
                paramMap.put("qar", forObject.getRates().getQAR());
                paramMap.put("ron", forObject.getRates().getRON());
                paramMap.put("rub", forObject.getRates().getRUB());
                paramMap.put("sar", forObject.getRates().getSAR());
                paramMap.put("sbd", forObject.getRates().getSBD());
                paramMap.put("scr", forObject.getRates().getSCR());
                paramMap.put("sek", forObject.getRates().getSEK());
                paramMap.put("sgd", forObject.getRates().getSGD());
                paramMap.put("shp", forObject.getRates().getSHP());
                paramMap.put("sit", forObject.getRates().getSIT());
                paramMap.put("skk", forObject.getRates().getSKK());
                paramMap.put("sll", forObject.getRates().getSLL());
                paramMap.put("sos", forObject.getRates().getSOS());
                paramMap.put("svc", forObject.getRates().getSVC());
                paramMap.put("syp", forObject.getRates().getSYP());
                paramMap.put("szl", forObject.getRates().getSZL());
                paramMap.put("thb", forObject.getRates().getTHB());
                paramMap.put("tnd", forObject.getRates().getTND());
                paramMap.put("top", forObject.getRates().getTOP());
                paramMap.put("try", forObject.getRates().getTRY());
                paramMap.put("ttd", forObject.getRates().getTTD());
                paramMap.put("twd", forObject.getRates().getTWD());
                paramMap.put("tzs", forObject.getRates().getTZS());
                paramMap.put("uah", forObject.getRates().getUAH());
                paramMap.put("ugx", forObject.getRates().getUGX());
                paramMap.put("usd", forObject.getRates().getUSD());
                paramMap.put("vef", forObject.getRates().getVEF());
                paramMap.put("vnd", forObject.getRates().getVND());
                paramMap.put("vuv", forObject.getRates().getVUV());
                paramMap.put("wst", forObject.getRates().getWST());
                paramMap.put("xaf", forObject.getRates().getXAF());
                paramMap.put("xcd", forObject.getRates().getXCD());
                paramMap.put("xdr", forObject.getRates().getXDR());
                paramMap.put("xof", forObject.getRates().getXOF());
                paramMap.put("xpf", forObject.getRates().getXPF());
                paramMap.put("zar", forObject.getRates().getZAR());
                paramMap.put("zmk", forObject.getRates().getZMK());
                paramMap.put("zwd", forObject.getRates().getZWD());

                nqu.update(INSERT_QUERY, paramMap);

            }
        }


    }
}
