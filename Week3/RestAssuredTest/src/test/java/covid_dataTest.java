import static io.restassured.RestAssured.baseURI;
import static org.hamcrest.CoreMatchers.equalTo;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import com.sun.org.glassfish.gmbal.Description;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
public class covid_dataTest
{
    private RequestSpecification requestSpecification;

    @Before
    public void setUp(){
        RestAssured.baseURI="https://covid-19-data.p.rapidapi.com/country";
        requestSpecification = RestAssured.given();
        requestSpecification.
                header("x-rapidapi-key","8eaa2f30aemshc8be3e9caf069f6p184990jsnef7418712718").param("code","tr");
    }

    @Test
    @Description("Status 200(Success) kontrolü")
    public void testForStatusCode(){
        requestSpecification.
                when().get(baseURI+"/code").then().statusCode(HttpStatus.SC_OK);
    }

    @Test
    //ülkelerin code idleri kullanılarak verilerinin kontrolü
    public void LatestCountrybyCode(){
        requestSpecification
                .when().get(baseURI+"/code").then().body("[0].code",equalTo("TR"));

    }

    @Test
    //ülkelerin isimleri kullanılarak verilerinin kontrolü
    public void LatestCountrybyName(){

        requestSpecification.param("name","Turkey")
                .when().get(baseURI).then().body("[0].country",equalTo("Turkey"));
    }
    @Test
    //Total değerin kontrolü
    public void total(){
        RestAssured.baseURI="https://covid-19-data.p.rapidapi.com/totals";
        requestSpecification = RestAssured.given();
        requestSpecification.header("x-rapidapi-key","8eaa2f30aemshc8be3e9caf069f6p184990jsnef7418712718").when().get(baseURI).then().body("[0].confirmed",equalTo(275549944));

    }
    @Test
    //Tarih kontrolü
    public void date(){
        RestAssured.baseURI="https://covid-19-data.p.rapidapi.com/report/totals";
        requestSpecification = RestAssured.given();
        requestSpecification.header("x-rapidapi-key","8eaa2f30aemshc8be3e9caf069f6p184990jsnef7418712718").
                param("date","2020-07-21").when().get(baseURI).then().body("[0].date",equalTo("2020-07-21"));

    }

}