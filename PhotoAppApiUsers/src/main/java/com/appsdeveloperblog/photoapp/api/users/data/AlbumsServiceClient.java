package com.appsdeveloperblog.photoapp.api.users.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.appsdeveloperblog.photoapp.api.users.ui.model.AlbumResponseModel;

@FeignClient(name = "albums-ws", fallback = AlbumsFallback.class)
public interface AlbumsServiceClient {

	@GetMapping("/users/{id}/albumss")
	public List<AlbumResponseModel> getAlbums(@PathVariable("id") String id);
}

@Component
class AlbumsFallback implements AlbumsServiceClient {

	@Override
	public List<AlbumResponseModel> getAlbums(String id) {
		return new ArrayList<>();
	}	
	
}