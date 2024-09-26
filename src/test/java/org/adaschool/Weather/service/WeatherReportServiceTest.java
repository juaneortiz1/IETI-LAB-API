package org.adaschool.Weather.service;

import org.adaschool.Weather.data.WeatherApiResponse;
import org.adaschool.Weather.data.WeatherReport;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class WeatherReportServiceTest {

    @Test
    public void testGetWeatherReport() {
        RestTemplate restTemplate = Mockito.mock(RestTemplate.class);
        WeatherReportService service = new WeatherReportService();

        WeatherApiResponse response = new WeatherApiResponse();
        WeatherApiResponse.Main main = new WeatherApiResponse.Main();
        main.setTemperature(25.0);
        main.setHumidity(60);
        response.setMain(main);

        when(restTemplate.getForObject(anyString(), Mockito.eq(WeatherApiResponse.class))).thenReturn(response);

        WeatherReport report = service.getWeatherReport(10.0, 20.0);

        assertEquals(0.0, report.getTemperature());
        assertEquals(94, report.getHumidity());
    }
}
