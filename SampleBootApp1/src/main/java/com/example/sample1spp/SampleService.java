package com.example.sample1app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SampleService {
	public Post getPost() {
		return new Post(0, 0, "Dummy", "This is sample.");
	}
	private String baseUrl = "https://jsonplaceholder.typicode.com/posts";
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	PostRepository repository;
	public Post[] getAllPosts() {
		return restTemplate.getForObject(baseUrl, Post[].class);
	}
	public Post getPost(int id) {
		return restTemplate.getForObject(baseUrl + "/" + id, Post.class);
	}
	public Object[] getLocalPosts() {
		return repository.findAll().toArray();
	}
	public Post getAndSavePost(int id) {
		Post  post = restTemplate.getForObject(baseUrl + "/" + id, Post.class);
		repository.save(post);
		return post;
	}
	//
	/**/
}
