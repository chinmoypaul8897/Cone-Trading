package com.cone.trading.service;

import com.cone.trading.model.Coin;
import com.cone.trading.repository.CoinRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.ParameterResolutionDelegate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class CoinServiceImpl implements CoinService {

    @Autowired
    private CoinRepository coinRepository;

    @Autowired
    private ObjectMapper objectMapper;


    @Override
    public List<Coin> getCoinList(int page) throws Exception {

        String url = "https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&per_page=10&page="+page;

        RestTemplate restTemplate = new RestTemplate();


        try{
            HttpHeaders headers = new HttpHeaders();

            HttpEntity<String> entity = new HttpEntity<String>("parameters",headers);

            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,entity , String.class);

            List<Coin> coinList = objectMapper.readValue(response.getBody(),
                    new TypeReference<List<Coin>>() {
                    });

        }
        catch (HttpClientErrorException | HttpServerErrorException e )
        {
            throw new Exception(e.getMessage());
        }
        return List.of();
    }

    @Override
    public String getMarketChart(String coinId, int days) {
        return null;
    }

    @Override
    public String getCoinDetails(String coinId) {
        return null;
    }

    @Override
    public Coin findById(String coinId) {
        return null;
    }

    @Override
    public String searchCoin(String keyword) {
        return null;
    }

    @Override
    public String getTop50CoinsByMarketCapRank() {
        return null;
    }

    @Override
    public String GetTradingCoins() {
        return null;
    }
}
