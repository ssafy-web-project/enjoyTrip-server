package com.ssafy.trip.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.trip.dto.Spot;
import com.ssafy.trip.model.mapper.SpotMapper;

@Service
public class SpotServiceImpl implements SpotService {

    private SpotMapper spotMapper;

    @Autowired
    public SpotServiceImpl(SpotMapper spotMapper) {
        this.spotMapper = spotMapper;
    }
	
	@Override
	public List<Spot> getHotSpotList(String contentTypeId, int sidoId) throws Exception {
	    return null;
	}
	
	@Override
	public List<Spot> getSpotList(Map<String, Integer> map) throws Exception {
	    return spotMapper.getSpotList(map);
	}
	
	@Override
	public Spot getSpot(int contentId) throws Exception {
	    return spotMapper.getSpot(contentId);
	}
	
	@Override
	public List<String[]> getSidoList() throws Exception {
	    return spotMapper.getSidoList();
	}
	
	@Override
	public List<String[]> getGugunList(int sidoId) throws Exception {
	    return spotMapper.getGugunList(sidoId);
	}
	
	@Override
	public int countSpot() throws Exception {
	    return 0;
	}
	
	@Override
	public List<Spot> searchSpot(String keyword) throws Exception {
	    return spotMapper.searchSpot(keyword);
	}
	
	@Override
	public Spot getThemeTopSpot(String contentTypeId) throws Exception {
	    return spotMapper.getThemeTopSpot(contentTypeId);
	}
}